public class MatrixBlockSum {
    public static void main(String[] args){
        int[][] mat = {{1,2,3},{4,5,6},{7,8,9}};
        int k = 1;
        for(int i = 0 ; i < mat.length ; i++){
            System.out.println();
            for(int j = 0 ; j < mat[0].length ; j++){
                System.out.print(" "+mat[i][j]);
            }
        }
        int[][] answer = blockSum(mat,k);
        for(int i = 0 ; i < mat.length ; i++){
            System.out.println();
            for(int j = 0 ; j < mat[0].length ; j++){
                System.out.print(" "+answer[i][j]);
            }
        }
    }
    public static int[][] blockSum(int[][] mat,int k){
        int[][] ans = new int[mat.length][mat[0].length];
        for(int i = 0 ; i < mat.length ; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                int sum = 0;
                for(int r = Math.max(i - k,0) ; r <= Math.min(mat.length-1,i + k) ; r++) {
                    for (int c = Math.max(j - k,0) ; c <= Math.min(mat[0].length -1,j + k); c++) {
                        sum = sum + mat[r][c];
                    }
                }
                ans[i][j] = sum;
            }
        }
        return ans;
    }
}
