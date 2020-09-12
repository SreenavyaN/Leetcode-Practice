import java.util.Scanner;

public class replaceQuestionMarkNoRepetitionChars {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println("Given string modified as :"+replaceQuestionMarks(str));
    }
    public static String replaceQuestionMarks(String str){
        if(str == null)
            return null;
        if(str.length() == 1 && str.charAt(0) == '?')
            return "a";
        char[] arr = str.toCharArray();
        if(arr[0] == '?' && arr[1] != 'a')
            arr[0] = 'a';
        else if(arr[0] == '?' && arr[1] == 'a')
            arr[0] = 'b';
        for(int i = 1 ; i <= arr.length - 2 ; i++){
            if(arr[i] == '?') {
                if (arr[i - 1] != 'a' && arr[i + 1] != 'a') {
                    arr[i] = 'a';
                    System.out.println("in  2nd else if  " + arr[i]);
                } else if (arr[i - 1] != 'b' && arr[i + 1] != 'b') {
                    arr[i] = 'b';
                    System.out.println("in third else if  : " + arr[i]);
                } else if (arr[i - 1] != 'c' && arr[i + 1] != 'c') {
                    arr[i] = 'c';
                    System.out.println("in fourth else if  : " + arr[i]);
                }
            }
        }

        if (arr[arr.length - 1] == '?' && arr[arr.length - 2] != 'a') {
            arr[arr.length-1] = 'a';
        }
        else if (arr[arr.length - 1] == '?' && arr[arr.length - 2] == 'a')
            arr[arr.length-1] = 'b';
        return String.valueOf(arr);
    }
}
