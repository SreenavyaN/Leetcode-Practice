import java.util.Scanner;

import static java.lang.Math.pow;

class reverseInteger {
    public static void main(String args[]){
        int num;
        Scanner sc = new Scanner(System.in);
        num = sc.nextInt();
        System.out.println("Input "+num);
        System.out.println("Reversed as : "+revInt(num));
        //char ch1 = IntToChar(num);
        //System.out.println("Converted to char"+ch1);
        //System.out.println("Converted to char"+CharToInt(ch1));
        //char ch2 = sc.next().charAt(0);
        //int num2 = CharToInt(ch2);
        //System.out.println("Char to Int "+num2);
        //System.out.println("Int to char "+IntToChar(num2));
    }
    public static int revInt(int num){
        String result = new String();
        int sub;
        try {
            if ((num >= (pow(2, 31) - 1)) || (num <= (-1) * pow(2, 31)) || num == 0)
                return 0;
            if (num < 0) {
                sub = -1;
                num = num * sub;
            } else
                sub = 1;
            while (num != 0) {
                int last = num % 10;
                num = num / 10;
                result = result.concat(String.valueOf(IntToChar(last)));
            }
            System.out.println("After compute " + result);
            //if (result.length() >= 10)
            //  return 0;
            int temp = Integer.parseInt(result);
            return temp * sub;
        }
        catch(Exception e)
        {
            return 0;
        }
    }
    public static char IntToChar(int num){
        int temp = num + '0';
        char ch = (char) temp;
        return ch;
    }
    public static int CharToInt(char ch){
        int n = (int) ch;
        return n;
    }
}
