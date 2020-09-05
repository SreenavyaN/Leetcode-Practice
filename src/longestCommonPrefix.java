import java.util.Scanner;
public class longestCommonPrefix {
    public static void main(String args[]) {
        String[] arr = {"aa", "a"};
        System.out.println("The longest common prefix is:" + longPrefix(arr));
    }

    public static String longPrefix(String[] strs) {
        if (strs.length == 0)
            return "";
        else if (strs.length == 1)
            return strs[0];
        else {
            strs = sortArray(strs);
            String str = "";
            char ch;
            for (int i = 0; i < strs[0].length( ); i++) {
                ch = strs[0].charAt(i);
                for (int j = 1; j < strs.length; j++) {
                    if (ch != strs[j].charAt(i))
                        return str;
                }
                str = str.concat(String.valueOf(ch));
            }
            return str;
        }
    }

    public static String[] sortArray(String[] arr) {
        String[] sorted;
        for (int i = 0; i < arr.length; i++) {
            if (arr[0].length( ) > arr[i].length( )) {
                String temp = arr[0];
                arr[0] = arr[i];
                arr[i] = temp;
            }
        }
        return arr;
    }
}
