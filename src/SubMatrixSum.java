public class SubMatrixSum {
    public static void main(String[] args){
        int[][] mat = {{3,0,1,4,2},{5,6,3,2,1},{1,2,0,1,5},{4,1,0,1,7},{1,0,3,0,5}};
        System.out.println("Sum is : "+findSum(mat,2,1,4,3));
    }
    public static int findSum(int[][] mat, int startRow, int startCol, int endRow, int endCol){
        int sum = 0;
        for(int i = startRow ; i <= endRow ; i++){
            for(int j = startCol ; j <= endCol ; j++){
                sum = sum + mat[i][j];
            }
        }
        return sum;
    }
}
