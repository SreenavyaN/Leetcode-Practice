import java.util.ArrayList;
import java.util.List;

public class numberOfIslands {
    public static void main(String[] args) {
        char[][] grid = {
                {'0', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'},
                {'0', '1', '0', '0', '1'}
        };
        System.out.println(islands(grid));
    }

    public static int islands(char[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    count = count + exploreNeighbors(grid, i, j);
                }
            }
        }
        return count;
    }

    public static int exploreNeighbors(char[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == '0')
            return 0;
        grid[i][j] = '0';
        return exploreNeighbors(grid, i + 1, j) + exploreNeighbors(grid, i, j + 1) + exploreNeighbors(grid, i - 1, j) + exploreNeighbors(grid, i, j - 1);
    }
}