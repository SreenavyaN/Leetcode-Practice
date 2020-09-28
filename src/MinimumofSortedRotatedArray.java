public class MinimumofSortedRotatedArray {
    public static void main(String[] args){
        int[] arr = {4,6,1,2};
        System.out.println("min is : "+findMin(arr));
    }
    public static int findMin(int[] nums) {

       return findMini(nums, 0,nums.length-1);
    }
    public static int findMini(int[] nums,int begin, int end){
        int len = end - begin + 1;
        int res;
        if(len == 1 || (len == 2 && nums[begin] < nums[end]) || nums[begin] < nums[end])
            return nums[begin];
        else if(len == 2 && nums[begin] > nums[end])
            return nums[end];
        else{
            int mid = nums[(begin+end) / 2];
            if(mid > nums[begin]){
                res = findMini(nums,((begin+end)/2)+1,end);
            }else {
                res = findMini(nums, begin, (begin+end) / 2);
            }
        }
        return res;
    }
}
