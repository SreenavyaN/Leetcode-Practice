import java.util.Arrays;
import java.util.Scanner;

public class binarySum {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String a = sc.nextLine();
        String b = sc.nextLine();
        System.out.println("a is : "+a+" B is : "+b);
        String sum = sum(a, b);
        System.out.println("Sum is : " + sum);
    }

    public static String sum(String a, String b) {
        if (a.length( ) == 1 && a.charAt(a.length( ) - 1) == '0')
            return b;
        if (b.length( ) == 1 && b.charAt(b.length( ) - 1) == '0')
            return a;
        int max = Math.max(a.length( ), b.length( ));
        System.out.println("Max size is :"+max);
        char[] result = new char[max];
        int carry = 0;
        int i = a.length( ) - 1;
        int j = b.length( ) - 1;
        while (i >= 0 && j >= 0){
            System.out.println("a elem : "+a.charAt(i));
            System.out.println("b elem : "+b.charAt(j));
            if(a.charAt(i) == '1' && b.charAt(j) == '1' && carry == 1){
                result[max - 1] = '1';
                carry = 1;
            }
            else if (a.charAt(i) == '1' && b.charAt(j) == '1' && carry == 0) {
                result[max - 1] = '0';
                carry = 1;
            }
            else if ((a.charAt(i) == '1' && b.charAt(j) == '0') || (a.charAt(i) == '0' && b.charAt(j) == '1')) {
                if (carry != 0) {
                    result[max - 1] = '0';
                    carry = 1;
                }
                else
                {
                    result[max - 1] = '1';
                    carry = 0;
                }
            }
            else if(a.charAt(i) == '0' && b.charAt(j) == '0' && carry == 1){
                result[max - 1] = '1';
                carry = 0;
            }
            else if(a.charAt(i) == '0' && b.charAt(j) == '0' && carry == 0){
                result[max - 1] = '0';
                carry = 0;
            }
            i--;
            j--;
            max--;
        }
        System.out.println("Exited with i : " + i + " j : " + j + "and max : " + max+" and with a carry : "+carry);
        for(int z = 0 ; z < result.length ; z++)
            System.out.println("result : "+result[z]);
        if (i < 0 && j >= 0 && carry == 0) {
            for(int m = 0; m < max ; m++) {
                result[m] = b.charAt(m);
            }
        }
        else if (i >= 0 && j < 0 && carry == 0) {
            for(int m = 0; m < max ; m++) {
                result[m] = a.charAt(m);
                System.out.println("adding "+result[m]);
            }
        }
        if( i < 0 && j >= 0 && carry != 0 ) {
            for(int m = j ; m >= 0 ; m--){
                if(carry == 1 && b.charAt(m) == '1') {
                    result[max - 1] = '0';
                    carry = 1;
                }
                if(carry == 1 && b.charAt(m) == '0'){
                    result[max-1] = '1';
                    carry = 0;
                }
                else if(carry == 0){
                    result[max - 1] = b.charAt(m);
                }
                max--;
            }
            }
        else if( j < 0 && i >= 0 && carry != 0 ) {
            for(int m = i ; m >= 0 ; m--){
                if(carry == 1 && a.charAt(m) == '1') {
                    result[max - 1] = '0';
                    carry = 1;
                }
                else if(carry == 1 && a.charAt(m) == '0'){
                    result[max-1] = '1';
                    carry = 0;
                }
                else if(carry == 0){
                   result[max - 1] = a.charAt(m);
                }
                max--;
            }
        }
        if(carry == 1)
            return '1'+String.valueOf(result);
        return String.valueOf(result);
    }
}
