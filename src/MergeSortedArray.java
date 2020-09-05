import java.util.Arrays;

public class MergeSortedArray {
    public static void main(String[] args){
        int[] arr1 = {-1,0,0,3,3,3,0,0,0};
        int m = 6;
        int[] arr2 = {1,2,2};
        int n = 3;
        merge(arr1,arr2,m,n);
    }
    public static void merge(int[] arr1,int[] arr2, int m, int n) {
        int j = 0,i = 0;
        if(n == 0){
            System.out.println(Arrays.toString(arr1));
            return;
        }
        else if (m == 0){
            i = 0;
            while(i < n){
                arr1[i] = arr2[i];
                i++;
            }
            System.out.println(Arrays.toString(arr2));
            return;
        }
        else if(arr1[m-1] < arr2[0])
        {
            i = m;j = 0;
            while( i < m+n && j < n){
                arr1[i] = arr2[j];
                i++;
                j++;
            }
            System.out.println(Arrays.toString(arr1));
        }
        else if(arr1[0] > arr2[n-1]) {
            int temp = n;
            while (temp != 0){
                arr1 = moveBack(arr1, 0, m, n);
                temp --;
            }
            for(j = 0 ; j < n ;j++)
                arr1[j] = arr2[j];
            System.out.println(Arrays.toString(arr1));
        }
        else {
            while (i < m + n && j < n) {
                System.out.println("Check between : " + arr1[i] + " and " + arr2[j]);
                if (arr1[i] == arr2[j]) {
                    arr1 = moveBack(arr1, i, m, n);
                    arr1[i] = arr2[j];
                    System.out.println("After moving to : " + Arrays.toString(arr1));
                    i++;
                    j++;
                }
                if (arr1[i] > arr2[j]) {
                    arr1 = moveBack(arr1, i, m, n);
                    arr1[i] = arr2[j];
                    System.out.println("After moving to : " + Arrays.toString(arr1));
                    j++;
                }
                else if (arr1[i] < arr2[j] && i == m) {
                    //while(j < n) {
                    arr1[i] = arr2[j];
                    j++;
                    //}
                    // break;
                }
                else if (arr1[i] < arr2[j] && arr1[i] == 0) {
                    //while(j < n) {
                    arr1[i] = arr2[j];
                    j++;
                    //}
                    // break;
                }

                i++;
            }
            System.out.println(Arrays.toString(arr1));
        }

    }
    public static int[] moveBack(int[] arr1,int i,int m , int n){

            for (int k = (m + n) - 1; k > i; k--) {
                arr1[k] = arr1[k - 1];
            }
            arr1[i] = 0;
        return arr1;
    }
}