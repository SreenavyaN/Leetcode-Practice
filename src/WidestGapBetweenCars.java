import java.util.Arrays;

public class WidestGapBetweenCars {
    public static void main(String args[]){
        int n = 10;
        int[] start = {1,3,5,7};
        int[] finish = {10,4,6,9};
        System.out.println(" int is : "+wideGap(n,start,finish));
        //Interval inter = new Interval();
    }
    private static int wideGap(int l, int[] start, int[] finish) {
        int[][] cars = new int[start.length][2];
        for(int i=0;i<start.length;i++) {
            cars[i][0] = start[i];
            cars[i][1] = finish[i];
        }
        Arrays.sort(cars, (a, b)->a[0] - b[0]);
        for(int i = 0 ; i < cars.length ; i++)
            System.out.println(Arrays.toString(cars[i]));
        int[] first = cars[0];
        //int res = first[0] - 1;
        int res = 0;
        for(int i=1;i<cars.length;i++) {
            int[] cur = cars[i];
            if(Math.max(cur[0],  first[0]) < Math.min(cur[1], first[1])) {
                first[1] = Math.max(first[1], cur[1]);
            }else {
                res = Math.max(res, cur[0] - first[1] - 1);
                first = cur;
            }
        }
        if(first[1] < l) {
            res = Math.max(res, l - first[1]);
        }
        return res;
    }
}
