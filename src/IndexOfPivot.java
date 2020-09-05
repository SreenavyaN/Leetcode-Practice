public class IndexOfPivot {
    public static void main(String args[]){
      int[] arr = {-1,-1,-1,0,1,1};
      System.out.println(findPivot(arr));
    }
    public static int findPivot(int[] arr){
        if(arr.length <= 2)
            return -1;
        for(int i = 0 ; i  < arr.length ; i++){
            //System.out.println("I is "+i+ " pivot elem is "+arr[i]);
            if( sum(arr,0,i) == sum(arr,i+1,arr.length))
                return i;
        }
        return -1;
    }
    public static int sum(int[] arr, int begin ,int end){
        int total = 0;
        for( int i = begin ; i < end ; i++){
            total = total + arr[i];
        }
        System.out.println("total returning : "+total);
        return total;
    }
}
