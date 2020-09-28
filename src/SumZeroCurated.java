import java.util.*;

public class SumZeroCurated {
    public static void main(String[] args){
        //int[] arr = {-1,0,1,2,-1,-4};
        //int[] arr = {3,-2,1,0};
        //int[] arr = {-2,0,1,1,2};
        //int[] arr ={-2,0,0,2,2};
        int[] arr = {-1,0,1,2,-1,-4,-2,-3,3,0,4};
        System.out.println("List of triplets :"+threeSum(arr));
        System.out.println("List of triplets :"+sumThree(arr));
    }
    public static List<List<Integer>> threeSum(int[] nums) {
        if (nums.length < 3) return new ArrayList<>(); // if nums less than 3 element
        Arrays.sort(nums); // sort array
        Set<List<Integer>> set = new HashSet<>();
        for (int i = 0; i < nums.length - 2; i++) {
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == 0) set.add(Arrays.asList(nums[i], nums[j++], nums[k--]));
                else if (sum > 0) k--;
                else if (sum < 0) j++;
            }

        }

        return new ArrayList<>(set);
    }
    public static List<List<Integer>> sumThree(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Set<List<Integer>> noDups = new HashSet<>();
        if(nums.length < 3)
            return result;
        else {
            for (int i = 0; i < nums.length; i++) {
                for (int j = i + 1; j < nums.length; j++) {
                    for (int k = j + 1; k < nums.length; k++) {
                        if (nums[i] + nums[j] + nums[k] == 0) {
                            List<Integer> temp = new ArrayList<>( );
                            temp.add(nums[i]);
                            temp.add(nums[j]);
                            temp.add(nums[k]);
                            Collections.sort(temp);
                            noDups.add(temp);
                        }
                    }
                }
            }
        }
        result.addAll(noDups);
        return result;
    }
}
