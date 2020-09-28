public class ContainerWithMostWaterCurated {
    public static void main(String[] args){
        int[] arr = {1,8,6,2,5,4,8,3,7};
        System.out.println("Most Water volume : "+maxArea(arr));
    }
    public static int maxArea(int[] arr){
        int maxVol = 0;
        for(int i = 0 ; i < arr.length ; i++){
            for(int j = arr.length - 1 ; j >= i+1 ; j--){
                int vol = Math.min(arr[i],arr[j]) * (j - i);
                if( maxVol < vol )
                    maxVol = vol;
            }
        }
        return maxVol;
    }
}
