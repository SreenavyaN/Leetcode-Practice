public class searchInsertPosition {
    public static void main(String args[]){
        int[] nums = {-2,-3,-4,-6};
        int target = 5;
        System.out.println("Index is : "+searchPosition(nums,target));
    }
    public static int searchPosition(int[] nums, int target){
        int index = -1;
        if(nums.length == 0)
            return index;
        else {
            for (int i = 0 ; i < nums.length ; i++){
                if(nums[i] == target)
                    return i;
                else if(nums[i] > target && i == 0)
                    return i;
                else if(nums[i] < target && i == nums.length-1)
                    return i + 1;
                else if(nums[i] > target)
                    return i;
            }
        }

        return index;
    }
}
