import java.util.*;

public class AllLongestStrings {
    public static void main(String args[]){
        String[] input = new String[]{"aba","vcd","ad"};
        System.out.println(Arrays.toString(allLongStrings(input)));
    }
    public static String[] allLongStrings(String[] input){
        String[] res = new String[input.length];
        SortedMap<Integer,List<String>> lengthMap= new TreeMap<Integer, List<String>>(new Comparator<>( ) {
            @Override
            public int compare(Integer t1, Integer t2) {
                return t2.compareTo(t1);
            }
        });
        for(int i = 0 ; i < input.length ; i++){
            if(lengthMap.containsKey(input[i].length())) {
                lengthMap.get(input[i].length()).add(input[i]);
            }
            else {
                List<String> temp = new ArrayList<String>();
                temp.add(input[i]);
                lengthMap.put(input[i].length( ), temp);
            }
        }
         int highestLength = lengthMap.firstKey();
        System.out.println("highest : "+highestLength);
        System.out.println("highest : "+lengthMap);
        // get an iterator
        //Set setOfEntries = lengthMap.entrySet();
        //Iterator iterator = setOfEntries.iterator();
        res = lengthMap.get(highestLength).toArray(new String[0]);
        return res;
    }
}
