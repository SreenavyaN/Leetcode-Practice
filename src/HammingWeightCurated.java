public class HammingWeightCurated {
    public static void main(String[] args){
        int n = -3;
        System.out.println("Number of 1's : "+hammingWeight(n));
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
