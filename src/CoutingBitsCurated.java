import java.util.Arrays;

public class CoutingBitsCurated {
    public static void main(String[] args){
        int n = 5;
        System.out.println("Array of numberof 1's in each number from 0 to n : "+ Arrays.toString(countBits(n)));
    }
    public static int[] countBits(int n){
        int[] numOnesArray = new int[n+1];
        for(int i = 0 ; i <= n ; i++){
            numOnesArray[i] = hammingWeight(i);
        }
        return numOnesArray;
    }
    public static int hammingWeight(int n){
        int count = 0;
        String s = Integer.toBinaryString(n);
        for(int i = 0 ; i < s.length() ; i++){
            if(s.charAt(i) == '1')
                count++;
        }
        return count;
    }
}
