import java.math.BigInteger;

public class root {
    public static void main(String args[]){
        int num = 2147483647;
        System.out.println(mySqrt(144));
    }
    public static int mySqrt(int num) {
        if(num == 0)
            return 0;
        if(num == 1 || num == 2 || num == 3)
            return 1;
        long i;
        if(num < 8) {
            for ( i = 0; i < num ; i++) {
                if (i * i == num)
                    break;
                if (i * i > num)
                {
                    i = i - 1;
                    break;
                }
            }
           }
        else {
            for (i = 0; i < num/3; i++) {
                if (i * i == num)
                    break;
                if (i * i > num) {
                    i = i - 1;
                    break;
                }
            }
        }
        return (int) i;
    }
}





//iif(num == 0)
//            return 0;
//        if(num == 1 || num == 2 || num == 3)
//            return 1;
//        long i;
//        for ( i = 0; i < num ; i++) {
//            if (i * i == num)
//                break;
//            if (i * i > num)
//            {
//                i = i - 1;
//                break;
//            }
//        }
//        return (int) i;