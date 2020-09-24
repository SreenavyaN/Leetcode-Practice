import java.util.Arrays;

public class ProductArrayExceptCurrentIndexCurated {
    public static void main(String[] args){
        int[] arr = {1,2,3,4};
        System.out.println("Product array except indexes is : "+ Arrays.toString(productExceptIndex(arr)));
    }
    public static int[] productExceptIndex(int[] arr){
        int[] res = new int[arr.length];
        res[0] = 1;
        for(int i = 1 ; i < arr.length ; i++){
            res[i] = res[i-1] * arr[i-1];
        }
        int prod = 1;
        for(int i = arr.length - 1; i >= 0 ; i--){
            res[i] = prod * res[i];
            prod = prod * arr[i];
        }
        return res;
    }
}
