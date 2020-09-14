public class LengthMrepeatedKtimes {
    public static void main(String args[]){
        int[] arr = new int[]{1,3,1,3,1,3,1,3};
        int m = 1;
        int k = 2;
        System.out.println("Given array has the pattern : "+checkPattern(arr,m,k));
    }
    public static boolean checkPattern(int[] arr, int m, int k){
        int count = 0,j=0;
        for(int i = 0 ; i < arr.length - k*m+m; i++){
            for (j = 1 ; j < k ; j++) {
                if (arr[i] != arr[i + j * m]) {
                    count = 0;
                    break;
                }
            }
            if(j == k)
                count++;
            System.out.println(count);
            if(count == m)
                return true;
        }
        return false;
    }
}
