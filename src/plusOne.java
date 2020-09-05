public class plusOne {
    public static void main(String args[]) {
        int[] arr = {2,4,9,3,9};
        for (int i = 0; i < arr.length; i++)
            System.out.print(" " + arr[i]);
        int[] res = increment(arr);
        System.out.println( );
        for (int i = 0; i < res.length; i++)
            System.out.print(" " + res[i]);
    }

    public static int[] increment(int[] digits) {
        int[] result = new int[digits.length + 1];
        if (digits[digits.length - 1] != 9) {
            digits[digits.length - 1] = digits[digits.length - 1] + 1;
            return digits;
        } else {
            digits[digits.length - 1] = 0;
            int carry = 1;
            for (int i = digits.length - 2; i >= 0; i--) {
                if (digits[i] == 9 && carry == 1)
                    digits[i] = 0;
                else {
                    digits[i] = digits[i] + carry;
                    carry = 0;
                }
            }
            if (carry != 0) {
                for (int i = 1; i < digits.length + 1; i++) {
                    result[0] = carry;
                    result[i] = digits[i - 1];
                }
                return result;
            }
            return digits;
        }
    }
}
