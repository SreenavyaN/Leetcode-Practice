import java.util.*;

public class ContainsDuplicateCurated {
    public static void main(String args[]) {
        int[] arr = new int[]{1,2,1,2, 3, 4};
        System.out.println(containsDups(arr));
        System.out.println(containDupsOpt(arr));

    }

    public static boolean containsDups(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++){
                if (arr[i] == arr[j])
                    return true;
            }
        }
    return false;
    }
    public static boolean containDupsOpt(int[] arr){
        Map<Integer,Integer> buff = new HashMap<>();
        for(int i = 0 ; i < arr.length ; i++){
            if(buff.containsKey(arr[i]))
                return true;
            else
                buff.put(arr[i],i);
        }
        return false;
    }
}
