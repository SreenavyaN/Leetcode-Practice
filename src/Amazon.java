import java.util.HashMap;
import java.util.Map;

public class Amazon {
    public static void main(String[] args){
        String s1 = "aba";
        String s2 = "COW Man Cow";
        System.out.println("It is :"+checkSamePattern(s1,s2));
        //System.out.println("Gen pattern "+genPattern(s2));
    }
    public static boolean checkSamePattern(String s1, String s2){
        System.out.println(s2.split("\\s+").length);
        System.out.println(s1.length());
        String[] s2Arr = s2.split("\\s+");
        if(s1.length() != s2Arr.length)
            return false;

        Map<Character,String> match = new HashMap<>();
        for (int i = 0 ; i < s1.length() ; i++){
            System.out.println("first for");
                if(match.containsKey(s1.charAt(i))) {
                    System.out.println("if"+s1.charAt(i));
                    if(!match.get(s1.charAt(i)).equals(s2Arr[i])) {
                        System.out.println("in ! if"+match.get(s1.charAt(i))+" val is "+s2Arr[i]);
                        return false;
                    }
                }
                else{
                    match.put(s1.charAt(i),s2Arr[i]);
                    System.out.println("in put if"+s1.charAt(i)+" val is "+s2Arr[i]);
                }
            System.out.println(match);
        }
        return true;
    }
}
