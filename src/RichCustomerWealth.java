public class RichCustomerWealth {
    public static void main(String[] args){
       int[][] accounts = {{100,200,300},{500,600,800}};
       System.out.println("Max Wealth is: "+maximumWealth(accounts));
    }
    public static int maximumWealth(int[][] a){
        int maxWealth = 0;
        for(int i = 0 ; i < a.length ; i++){
            int sum = 0;
            for(int j = 0 ; j < a[0].length ; j++){
                sum = sum + a[i][j];
            }
            if(maxWealth < sum)
                maxWealth = sum;
        }
        return maxWealth;
    }
}
