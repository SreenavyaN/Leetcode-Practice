import java.util.*;

public class ContainsDuplicateCurated {
    public static void main(String args[]) {
        int[] arr = new int[]{1,2,1,2, 3, 4};
        System.out.println(containsDups(arr));
        System.out.println(containDupsOpt(arr));

    }

    public static List<Integer> containsDups(int[] arr) {
        List<Integer> dups = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++){
                if (arr[i] == arr[j])
                    dups.add(arr[i]);
            }
        }
    return dups;
    }
    public static List<Integer> containDupsOpt(int[] arr){
        List<Integer> dups = new ArrayList<>();
        Map<Integer,Integer> buff = new HashMap<>();
        for(int i = 0 ; i < arr.length ; i++){
            if(buff.containsKey(arr[i]))
                dups.add(arr[i]);
            else
                buff.put(arr[i],i);
        }
        return dups;
    }
}
