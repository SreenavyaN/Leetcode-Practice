import java.io.IOException;
import java.util.Scanner;

public class longSubstringNoRep {
    public static void main(String args[]) {
        String str = "";
        Scanner sc = new Scanner(System.in);
        str = sc.nextLine();
        System.out.println("String is "+str);
        char[] arr = str.toCharArray();
        int maxSub = longSubstring(arr);
        System.out.println("Length of longest sub string is"+maxSub);
    }
    public static int longSubstring(char[] arr1){
        int max = 0,len = 0;
        String arr2 = String.valueOf(arr1[0]);
        for(int i = 1; i < arr1.length ; i++) {
            System.out.println("In i "+i);
                if ((arr2.indexOf(arr1[i]) != -1) || i == arr1.length -1 )
                {
                    System.out.println("In if");
                    len = arr2.length();
                    i = arr2.indexOf(arr1[i]) - 1;
                    if (max < len)
                        max = len;
                   break;
                }
                else {
                    System.out.println("In else");
                    arr2 = arr2.concat(String.valueOf(arr1[i]));
                    System.out.println("string is" +arr2);
                }
            }
        return max;
    }
}
