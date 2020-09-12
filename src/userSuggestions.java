import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.json.simple.parser.ParseException;

import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class userSuggestions {
    public class ContentData{
        String title;
        String brand;
        String[] availability;
        //OffsetDateTime availableDate;
        String availableDate;
        int popularityScore;
        String contentType;
        ContentData(){ }
        public OffsetDateTime getAvailableDate(){
            DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSX");
            return OffsetDateTime.parse(this.availableDate, DATE_TIME_FORMATTER);
        }
        public String toString(){
           StringBuilder sb = new StringBuilder();
           sb.append("{");
           sb.append("title" +" : "+title+",");
           sb.append("brand" +" : "+brand+",");
           sb.append("availability" +" : "+ Arrays.toString(availability)+",");
           sb.append("availableDate" +" : "+availableDate+",");
           sb.append("popularityScore" +" : "+popularityScore+",");
           sb.append("contentType" +" : "+contentType);
           sb.append("}");
           return sb.toString();
        }
    }
    public static void main(String[] args) throws ParseException, java.text.ParseException {
       String contentData = "[{\"title\":\"Toy Story 3\",\"brand\":\"Pixar\",\"availability\":[ \"CA\",\"FR\",\"US\"],\"availableDate\":\"2019-11-12T05:00:00.000Z\",\"popularityScore\":98,\"contentType\":\"movie\"},{\"title\":\"Frozen 2\",\"brand\":\"Disney\",\"availability\":[ \"CA\",\"FR\",\"US\"],\"availableDate\":\"2019-11-11T05:00:00.000Z\",\"popularityScore\":78,\"contentType\":\"movie\"}]";
       //System.out.println("Content data before "+contentData);
       List<ContentData> contentList = convertContentDataList(contentData);
       System.out.println("Content data after " + contentList.toString());
       String brandPrefs = "{\"Star Wars\":\"love\",\"Disney\":\"like\",\"Marvel\":\"dislike\",\"Pixar\":\"dislike\"}";
       //System.out.println("Brand Prefs before "+brandPrefs);
       HashMap<String,String> brand = convertPrefs(brandPrefs);
       System.out.println("Brand Prefs after "+brand);

        String contentPrefs = "{\"movie\":\"love\",\"series\":\"like\",\"short\":\"dislike\"}";
        //System.out.println("content Prefs before "+contentPrefs);
        HashMap<String,String> content = convertPrefs(contentPrefs);
        System.out.println("content Prefs after "+content);
        List<String> topTitles = getTopTitles(contentList,brand,content);
        System.out.println("list "+topTitles);
    }
    public static List<ContentData> convertContentDataList(String jsonString){
        return new Gson().fromJson(jsonString, new TypeToken<List<ContentData>>(){}.getType());
    }
    public static HashMap convertPrefs(String jsonString){
        return new Gson().fromJson(jsonString, HashMap.class);
    }


    public static List<String> getTopTitles(List<ContentData> contentList, Map<String,String> brandPref, Map<String,String> contentPref) throws java.text.ParseException {
        List<String> topTitles = new ArrayList<>();
        Map<String,Integer> contentAndScore = new HashMap<String, Integer>( );
            Iterator<ContentData> itr = contentList.iterator();
        DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSX");
        OffsetDateTime tempDate = OffsetDateTime.parse("2020-01-01T00:00:00.000Z", DATE_TIME_FORMATTER);
        System.out.println("Formed date "+tempDate);
        while(itr.hasNext()){
            ContentData temp = itr.next();
            if(temp.getAvailableDate().isBefore(tempDate) && Arrays.toString(temp.availability).contains("US")) {
                contentAndScore.put(temp.title, temp.popularityScore);
                String userPref = brandPref.get(temp.brand);
                if (userPref == null)
                    userPref = "indifferent";
                if (userPref.equals("dislike"))
                    contentAndScore.put(temp.title, contentAndScore.get(temp.title) - 20);
                if (userPref.equals("like"))
                    contentAndScore.put(temp.title, contentAndScore.get(temp.title) + 10);
                if (userPref.equals("adore"))
                    contentAndScore.put(temp.title, contentAndScore.get(temp.title) + 20);
                if (userPref.equals("love"))
                    contentAndScore.put(temp.title, contentAndScore.get(temp.title) + 50);
                String userCPref = contentPref.get(temp.contentType);
                if (userCPref == null)
                    userCPref = "indifferent";
                if (userCPref.equals("dislike"))
                    contentAndScore.put(temp.title, contentAndScore.get(temp.title) - 20);
                if (userCPref.equals("like"))
                    contentAndScore.put(temp.title, contentAndScore.get(temp.title) + 10);
                if (userCPref.equals("adore"))
                    contentAndScore.put(temp.title, contentAndScore.get(temp.title) + 20);
                if (userCPref.equals("love"))
                    contentAndScore.put(temp.title, contentAndScore.get(temp.title) + 50);
            }
        }
        System.out.println(contentAndScore);
        Set<Map.Entry<String,Integer>> sorted = new TreeSet<Map.Entry<String,Integer>>(new Comparator<Map.Entry<String,Integer>>() {
            @Override
            public int compare(Map.Entry<String,Integer> o1, Map.Entry<String,Integer> o2) {
                if(o1.getValue() > o2.getValue())
                    return -1;
                if(o1.getValue() == o2.getValue())
                    return o1.getKey().compareTo(o2.getKey());
                //if(o1.getValue() < o2.getValue())
                    return 1;
            }
        });
        sorted.addAll(contentAndScore.entrySet());
        //Map<String,Integer> contentAndScoreSorted = new HashMap<String, Integer>( );
       // contentAndScore.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).limit(5).forEachOrdered(x -> topTitles.add(x.getKey()));
        sorted.stream().limit(5).forEachOrdered(x -> topTitles.add(x.getKey()));
        return topTitles;
    }

}
