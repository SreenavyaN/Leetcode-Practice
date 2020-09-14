public class HauntedMatrixElementSum {
    public static void main(String args[]) {
        int[][] mat = new int[][]{{4, 4, 5, 5}, {1, 5, 3, 1}, {2, 1, 3, 1}};
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                System.out.print(mat[i][j]);
            }
            System.out.println();
        }
        System.out.println("Sum is : " + findTotal(mat));
    }

    public static int findTotal(int[][] mat) {
        int total = 0;
        for (int j = 0; j < mat[0].length; j++) {
            boolean flag = false;
            for (int i = 0; i < mat.length; i++) {
                if (mat[i][j] == 0)
                    flag = true;
                if (flag)
                    mat[i][j] = 0;
            }
        }
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                System.out.print(mat[i][j]);
            }
            System.out.println();
        }
        for (int j = 0; j < mat[0].length; j++) {
            int sum = 0;
            for (int i = 0; i < mat.length; i++) {
                sum = sum + mat[i][j];
            }
            total = total + sum;
        }
        return total;
    }
}
