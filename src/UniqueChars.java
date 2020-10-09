import java.util.Scanner;
public class UniqueChars {
    public static void main(String[] args) {
        String[] team = new String[5];
        Scanner input = new Scanner(System.in);
        int i = 0;
        while (i < 5) {
            team[i] = input.nextLine();
            i++;
        }
        System.out.println(findLead(team));
    }
    public static String findLead(String[] team){
        String lead = "";
        int max = 0;
        for(int i = 0 ; i < 5; i++){
            int uniques = countUnique(team[i]);
            if(max < uniques)
                lead = team[i];
        }
        return lead;

    }
    public static int countUnique(String s1){
        String s2 = s1.toLowerCase();
        StringBuffer sb = new StringBuffer(s2);
        int l = sb.length();
        int count = 0;
        for (int i = 0; i < l; i++) {
            count = 0;
            for (int j = i + 1; j < l; j++) {
                if (sb.charAt(i) == sb.charAt(j)) {
                    sb.deleteCharAt(j);
                    count++;
                    j--;
                    l--;
                }
            }
            if (count > 0) {
                sb.deleteCharAt(i);
                i--;
                l--;
            }
        }
        if (sb.length() == 0)
            return -1;
         return sb.length();
    }
}