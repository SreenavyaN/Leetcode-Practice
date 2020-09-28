public class MaxProductSubArrayCurated {
    public static void main(String[] args){
        int[] arr = {2,3,-2,4};
        System.out.println("Max contiguous product would be : "+maxProduct(arr));
    }
    public static int maxProduct(int[] arr){
        int maxProd = Integer.MIN_VALUE,prod;
        for(int i = 0 ; i < arr.length ; i++){
            prod = arr[i];
            if( maxProd < prod)
                maxProd = prod;
            System.out.println("Prod is: "+prod+" maxProd is : "+maxProd);
            int k = i;
            while(k != arr.length - 1){
                prod = prod * arr[k + 1];
                if( maxProd < prod )
                    maxProd = prod;
                k++;
            }
        }
        return maxProd;
    }
}
