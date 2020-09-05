import java.util.Scanner;

public class countAndSay {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt( );
        System.out.println("String is main : " + countAndSaySequence(n));
    }

    public static String countAndSaySequence(int n) {
        if( n == 0)
            return "0";
        if( n == 1)
            return "1";
        String str;
        str = "1";
        String str1 = "";
        for (int i = 1; i < n; i++) {
            int j = 0;
            int count = 1;
            str1 = "";
            while (j < str.length()) {
                char x = str.charAt(j);
                j++;
                if (j < str.length( ) && x == str.charAt(j)) {
                    count++;
                } else {
                    str1 = str1 + count + x;
                    count = 1;
                }
            }
            str = str1;
        }
        return str;
    }
}

