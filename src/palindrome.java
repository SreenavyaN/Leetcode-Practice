import java.util.ArrayList;
import java.util.Scanner;

public class palindrome {
    public static void main(String args[])
    {
        int x;
        Scanner sc = new Scanner(System.in);
        x = sc.nextInt();
        System.out.println(isPalindrome(x));
    }
        public static boolean isPalindrome ( int x){
            ArrayList<Integer> arr = new ArrayList<Integer>();
            int rem;
            if(x == 0 || (x > 0 && x < 9))
                return true;
            if (x < 0)
                return false;
            else {
                while (x != 0) {
                    rem = x % 10;
                    x = x / 10;
                    arr.add(rem);
                }
            }
                    System.out.println("formed string is :" + arr);
            int k = arr.size() - 1 ;
            for (int j = 0 ; j < arr.size() ; j++)
            {
                System.out.println("j is : "+j+" k is : "+k);
                if (arr.get(j) != arr.get(k))
                    return false;
                else {
                    if (j > k)
                        return true;
                    else
                        k--;
                }
            }
            return false;
        }
    public static char intToChar(int num)
    {
        char ch;
        ch = (char) (num + '0');
        return ch;
    }
}
