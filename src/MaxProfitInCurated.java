public class MaxProfitInCurated {
    public static void main(String args[]){
        int[] arr = new int[]{7,1,5,3,6,4};
        System.out.println("Maximum Profit is : "+maxProfit(arr));
    }
    public static int maxProfit(int[] arr){
        int maxProfit = 0;
        for(int i = 0 ; i < arr.length ; i++){
            for(int j = i+1 ; j < arr.length ; j++){
                int profit = 0;
                if(arr[j] > arr[i])
                {
                    profit = arr[j] - arr[i];
                }
                if(maxProfit < profit)
                    maxProfit = profit;
            }
        }
        return maxProfit;
    }
}
