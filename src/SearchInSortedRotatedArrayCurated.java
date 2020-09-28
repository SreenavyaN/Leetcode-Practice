public class SearchInSortedRotatedArrayCurated {
    public static void main(String[] args){
        //int[] arr = {4,6,7,8,9,0,1,2};
        //int[] arr = {5,1,2,3,4};
        int[] arr = {4,5,6,7,0,1,2};
        int target = 0;
        System.out.println("Found target : "+target+" at :"+search(arr,target));
        System.out.println("Efficiently Found target : "+target+" at :"+searchEff(arr,target));
    }
    public static int search(int[] nums, int target){
        return findIndex(nums,0,nums.length,target);
    }
    public static int searchEff(int[] nums, int target){
        return findIndexEff(nums,0,nums.length,target);
    }
    public static int findIndexEff(int[] nums,int begin, int end, int target){
        int res = -1;
        int len = end - begin + 1;
        if(len == 1) {
            if (nums[begin] == target)
                return begin;
            else
                return -1;
        }
        else {
            if (nums[begin] == target)
                return begin;
            else if (nums[end - 1] == target)
                return end - 1;
            int midIndex = (begin + end - 1) / 2;
            int midElem = nums[(begin + end - 1) / 2];

            if (midElem == target)
                return midIndex;
            if (target > midElem && target < nums[end - 1]) {
                System.out.println("begin :" + (midIndex + 1) + " end is " + end);
                res = findIndexEff(nums, midIndex + 1, end, target);
            }
            else if( target < midElem && target > nums[end - 1] && target < nums[begin]){
                System.out.println("nothing begin :"+(midIndex + 1)+" end is "+end);
                res = -1;
            }else if (target < midElem && target > nums[end - 1]) {
                System.out.println("begin :" + begin + " end is " + midIndex);
                res = findIndexEff(nums, begin, midIndex, target);
            }
            else if( target < midElem && target < nums[end - 1] && target < nums[begin]){
                System.out.println("begin :"+(midIndex + 1)+" end is "+end);
                res = findIndexEff(nums, midIndex, end , target);
            }

            else if (target < midElem && target < nums[begin]) {
                System.out.println("begin :" + begin + " end is " + midIndex);
                res = findIndexEff(nums, midIndex+1, end, target);
            }
            else if( target < midElem && target < nums[end - 1]){
                System.out.println("begin :"+(midIndex + 1)+" end is "+end);
                res = findIndexEff(nums, midIndex + 1, end, target);
            }

        }
        return res;
    }


    public static int findIndex(int[] nums,int begin, int end, int target){
        if(nums.length == 1 && nums[begin] == target)
            return begin;
        else if (nums.length == 1)
            return -1;
        if(nums[begin] == target)
            return begin;
        else if(nums[end - 1] == target)
            return end - 1;
        int midIndex = (begin+end-1)/2;
        int midElem = nums[(begin+end-1)/2];
        int res = 0;
        if( midElem == target)
            return midIndex;
        else if( begin+1 < nums.length && end-1 < nums.length)
            return findIndex(nums,begin + 1, end - 1, target);
        return -1;
    }
}
