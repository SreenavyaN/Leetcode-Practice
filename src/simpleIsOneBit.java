public class simpleIsOneBit {
    public static void main(String[] args){
        int[] bits = {0,1,0};
        System.out.println("Ends with one bit  char : "+isOneBitCharecter(bits));
    }
    public static boolean isOneBitCharecter(int[] bits) {
        if (bits.length == 0)
            return false;
        int i = 0;
       while(i < bits.length - 1){
           if(bits[i] == 0)
               i++;
           else
               i= i+2;
       }
        return i == bits.length - 1;
    }
}
