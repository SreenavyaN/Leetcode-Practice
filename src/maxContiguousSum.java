import java.math.BigInteger;

public class maxContiguousSum {
    public static void main(String args[]) {
        int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println("Mx is :" + maxSum(arr));
        System.out.println("Optimal Mx is :" + optMaxSum(arr));
    }

    public static int maxSum(int[] arr) {
        int max = Integer.MIN_VALUE;
        if (arr.length == 0)
            return max;
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                sum = seqSum(arr, i, j);
                if (sum > max)
                    max = sum;
            }
        }
        return max;
    }

    public static int seqSum(int[] arr, int i, int j) {
        int sum = 0;
        for (int n = i; n <= j; n++) {
            sum = sum + arr[n];
        }
        return sum;
    }

    public static int optMaxSum(int[] arr) {
        int max = arr[0], sum = arr[0];
        for (int i = 0; i < arr.length ; i++) {
            sum = arr[i];
            if (sum > max)
                max = sum;
            System.out.println("i is :" + i);
            System.out.println("max is  : " + max);
            int k = i;
            while (sum > 0 && k != arr.length - 1) {
                System.out.println("max is  : " + max);
                System.out.println("sum is  :" + sum);
                System.out.println("" + sum + " + " + arr[k + 1]);
                sum = sum + arr[k + 1];
                if (sum > max)
                    max = sum;
                System.out.println("Sum for next elems :" + sum);
                k++;
            }
            }
            return max;
        }
}
