import java.util.HashMap;
import java.util.Scanner;
public class romanToNumeral {
    public static void main (String args[])
    {
        String str;
        Scanner sc = new Scanner(System.in);
        str = sc.nextLine();
        System.out.println("Numeral value is : "+convertToNumeral(str));
    }
    public static int convertToNumeral(String s)
    {
        int x;
        int temp = conversionStore(s.charAt(0)),total = 0;
        if(s.length() == 1)
            return temp;
        for (int i = 1 ; i < s.length() ; i++)
        {
            x = conversionStore(s.charAt(i));
            if(temp == x)
                temp = temp + x;
            else if ( temp < x) {
                temp = x - temp;
            }
            else
            {
                total = total + temp;
                temp = x;
            }
        }
        System.out.println("Total is : "+total);
        System.out.println("Temp is : "+temp);
            return total+temp;
    }
    public static int conversionStore(char ch) {
        HashMap<Character,Integer> Store = new HashMap<Character, Integer>();
        Store.put('I',1);
        Store.put('V',5);
        Store.put('X',10);
        Store.put('L',50);
        Store.put('C',100);
        Store.put('D',500);
        Store.put('M',1000);
        int num = Store.get(ch);
        return num;
    }
}
