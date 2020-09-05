import java.io.*;
import java.util.HashMap;

class Solution1 {
    public static void main(String[] args){
        int[] result;
        int arr[] = {3,2,2};
        int t = 5;
        result = twoSum(arr,t);
        System.out.println("The indices are"+result[0]+" and "+result[1]);
        int[] resultHashed = twoSumWithHash(arr,t);
        System.out.println("The indices with hashing are "+resultHashed[0]+" and "+resultHashed[1]);
    }

    public static int[] twoSum(int[] nums, int target) {
        int[] result=new int[2];
        for(int i=0;i<nums.length-1;i++)
        {
                for (int j= i + 1; j < nums.length; j++)
                {
                    if (nums[i]+nums[j] == target) {
                        System.out.println(i);
                        System.out.println(j);
                        result[0] = i;
                        result[1] = j;
                        break;
                    }
                }
        }
        return result;
    }
    public static int[] twoSumWithHash(int[] nums, int target)
    {
        final int[] elem = new int[1];
        int[] resultHashed = new int[2];
        HashMap temp = new HashMap();
        for(int i=0;i<nums.length;i++)
        {
            temp.put(nums[i],i);
        }
        temp.forEach((K,V) -> {
                    elem[0] = (int) K;
                    if (temp.containsKey(elem[0] - target)) {
                        resultHashed[0] = (int) temp.get( elem[0] - target );
                        resultHashed[1] = (int) temp.get(elem[0]);
                    }
                });
      return resultHashed;
    }
}
