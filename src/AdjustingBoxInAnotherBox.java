import java.util.Arrays;

public class AdjustingBoxInAnotherBox {
    public static void main(String[] args) {
        int[] arr = {2, 3, 6, 7, 8, 9, 4, 2};
        int[] sortedArr = sort(arr);
        System.out.println(Arrays.toString(sortedArr));
        //int minimumBoxes = adjust(sortedArr);
        //System.out.println("Minimum number of boxes after adjusting a box in another that is twice the size of it is : " + minimumBoxes);
    }

    public static int adjust(int[] arr) {
        int count = arr.length;
        int i = 0;
        int j = arr.length - 1;
        while (2 * arr[i] <= arr[j]) {
            i++;
        }
        i--;

        while (i > 0 && j > i) {
            if (2 * arr[i] <= arr[j]) {
                count--;
                j--;
            }
            i--;
        }
        return count;
    }

    public static int[] sort(int[] unsorted) {
        int start = 0;
        int end = unsorted.length;
        return mergeSort(unsorted, start, end);
    }

    public static int[] mergeSort(int[] arr, int begin, int end) {
        int mid = (begin + end) / 2;
        System.out.println("mid is "+mid);
        int[] left = new int[mid - begin];
        int[] right = new int[end - mid + 1];
        if(begin < end) {
            left = mergeSort(arr, begin, mid);
            System.out.println(Arrays.toString(left));
            right = mergeSort(arr, mid + 1, end);
            System.out.println(Arrays.toString(right));
        }
        System.out.println(Arrays.toString(left));
        System.out.println(Arrays.toString(right));
        if (left.length == 1)
            return left;
        if (right.length == 1)
            return right;
        else if (left.length > 1) {
            for (int i = 0; i < left.length; i++) {
                if (left[i] > left[i + 1]) {
                    int buff = left[i + 1];
                    left[i + 1] = left[i];
                    left[i] = buff;
                }
            }
        }
        if (right.length > 1) {
            for (int i = 0; i < right.length; i++) {
                if (right[i] > right[i + 1]) {
                    int buff = right[i + 1];
                    right[i + 1] = right[i];
                    right[i] = buff;
                }
            }
        }
        System.out.println(Arrays.toString(left));
        System.out.println(Arrays.toString(right));
        return merge(left, right);
    }
    public static int[] merge(int[] left , int[] right){
        int[] sorted = new int[left.length + right.length];
        int l = 0, r = 0;
        for(int i = 0 ; i < sorted.length ; i++){
            if(left[l] <= right[r]) {
                sorted[i] = left[l];
                l++;
            }
            else{
                sorted[i] = right[r];
                r++;
            }
        }
        return sorted;
    }
}
