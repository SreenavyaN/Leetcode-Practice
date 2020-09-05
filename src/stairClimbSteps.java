public class stairClimbSteps {
    public static void main(String args[]) {
        int num = 6;
        System.out.println("No of steps : " + climbStairsDP(num));
        System.out.println("No of steps : " + climbStairsRECURSION(num));
    }

    public static int climbStairsDP(int num) {
        int[] ways = new int[num];
        ways[0] = 1;
        ways[1] = 2;
        for (int i = 2 ; i < num ; i++)
            ways[i] = ways[i-1]+ways[i-2];
        return ways[num - 1];
    }
    public  static int climbStairsRECURSION(int num){
        if(num == 1)
            return 1;
        if(num == 2)
            return 2;
        return climbStairsRECURSION(num - 1) + climbStairsRECURSION(num-2);
    }
}
