public class ReverseBitsCurated {
    public static void main(String[] args){
        int n = 5;
        System.out.println("Reversed int in Bits is :"+reverseBits(n));
    }
    public static int reverseBits(int n){
        String s1 = Integer.toBinaryString(n);
        String s2 = "";
        for(int i = s1.length() - 1 ; i >= 0 ; i--){
            s2 = s2+(s1.charAt(i));
        }
        System.out.println(s2);
        int count = s1.length();
        int itr = 0;
        while(itr < count){
            n = n << 32;
            itr++;
        }
        return Integer.reverse(n);
    }
}
