public class SumWithoutOperatorsCurated {
    public static void main(String[] args) {
        int a = 2;
        int b = 1;
        System.out.println("Sum is simple : " + simpleSum(a, b));
        System.out.println("Sum is : " + getSum(a, b));
    }

    public static int getSum(int a, int b) {
        int carry = 0;
        String s1 = Integer.toBinaryString(a);
        String s2 = Integer.toBinaryString(b);
        System.out.println("S1 is: "+s1);
        System.out.println("S2 is: "+s2);
        int max = Math.max(s1.length( ), s2.length( ));
        if(s1.length() < max){
            while(s1.length() < max) {
                String form = "%0"+ Integer.toString(max - s1.length()) + "d";
                System.out.println(form);
                String.format(form, s1);
            }
        }
        if(s2.length() < max){
            while(s2.length() < max) {
                String form = "%0"+ Integer.toString(max - s2.length()) + "d";
                System.out.println(form);
                String.format(form, s1);
            }
        }
        System.out.println("S1 is: "+s1);
        System.out.println("S2 is: "+s2);
        int[] res = new int[max+1];
        for (int i = 0; i < max; i++) {
            if (s1.charAt(i) == '0' && s2.charAt(i) == '0' && carry == 0) {
                res[i] = 0;
            } else if ((s1.charAt(i) == '0' && s2.charAt(i) == '0' && carry == 1) || (s1.charAt(i) == '1' && s2.charAt(i) == '0' && carry == 0) || (s1.charAt(i) == '0' && s2.charAt(i) == '1' && carry == 0)) {
                res[i] = 1;
            } else if ((s1.charAt(i) == '1' && s2.charAt(i) == '1' && carry == 0) || (s1.charAt(i) == '1' && s2.charAt(i) == '1' && carry == 1)) {
                res[i] = 1;
                carry = 1;
            } else if ((s1.charAt(i) == '1' && s2.charAt(i) == '0' && carry == 1) || (s1.charAt(i) == '0' && s2.charAt(i) == '1' && carry == 1)) {
                res[i] = 1;
                carry = 0;
            }
        }
        //return Integer.parseInt(Arrays.toString(res));
        return toNum(res);
    }
    public static int toNum(int[] arr){
        int len = arr.length,sum = 0;
        for(int i = 0 ; i < len - 1 ; i++){
            if(arr[i] == 1){
                int power = (len - 1) - i;
                sum = (int) (sum + Math.pow(2,power));
            }
        }
        return sum;
    }
    public static int simpleSum(int a,int b){
        while(b != 0) {
            int carry = a & b;
            a = a ^ b;
            b = carry << 1;
        }
        return a;
    }
}

