import java.util.Arrays;

public class removeDuplicatesFromSortedArray {
    public static void main(String args[]){
        int[] arr = {0,0,1,1,1,2,2,3,3,4};
        int len = removeDuplicates(arr);
        for (int i = 0 ; i < len ; i++) {
            System.out.print(arr[i]);
        }
    }
    public static int removeDuplicates(int[] arr){
        if(arr.length <= 1)
            return arr.length;
        int temp = arr[0];
        int count = 0;
        int i  = 1 ;
        do
        {
           if(temp == arr[i]) {
               arr = remove(arr, i,count);
               count++;
           }
           else {
               temp = arr[i];
               i++;
           }
        }while(i < arr.length - count );
        return arr.length - count;
    }
    public static int[] remove(int[] arr,int i,int count){
        System.out.println("Index to remove is : "+i);
        if(arr.length-count == 0)
            return null;
        else if(i > arr.length-count)
            return arr;
        else{
            while(i < arr.length -count- 1) {
                arr[i] = arr[i + 1];
                i++;
            }

        }
        return arr;
    }
}
