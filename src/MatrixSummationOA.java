public class MatrixSummationOA {
    public static void main(String[] args){
        int[][] after = {{2,1},{5,4}};
        for(int i = 0 ; i < after.length ; i++) {
            System.out.println();
            for (int j = 0; j < after[0].length; j++) {
                System.out.print(" " +after[i][j]);
            }
        }
        int[][] before = giveBefore(after);
        for(int i = 0 ; i < after.length ; i++) {
            System.out.println();
            for (int j = 0; j < after[0].length; j++) {
                System.out.print(" " +before[i][j]);
            }
        }
    }
    public static int[][] giveBefore(int[][] after){
        int[][] before = new int[after.length][after[0].length];
        //before[0][0] = after[0][0];
        for(int i = after.length - 1; i >= 0 ; i--){
            for(int j = after[0].length - 1 ; j >= 0  ; j--){
                if( i == 0 && j == 0)
                    before[i][j] = after[i][j];
                else if( i == 0 )
                    before[i][j] = after[i][j] - after[i][j-1] ;
                else if( j == 0 )
                    before[i][j] = after[i][j] - after[i-1][j] ;
                else
                    before[i][j] = after[i][j] - after[i-1][j] - after[i][j-1] + after[i-1][j-1];
            }
        }
        return before;
    }
}
