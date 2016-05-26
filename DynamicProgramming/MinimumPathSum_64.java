package DynamicProgramming;

/**
 * Given a m x n grid filled with non-negative numbers, 
 * find a path from top left to bottom right which minimizes 
 * the sum of all numbers along its path.

Note: You can only move either down or right at any point in time.
 * 
 * Reference: https://siddontang.gitbooks.io/leetcode-solution/content/dynamic_programming/unique_paths.html
 * 
 * @author Rudolf
 *
 */
public class MinimumPathSum_64 {

	/** Method used: Dynamic Programming */
	public int minPathSum(int[][] grid) {
        
        // Input Check: empty grid
        if (grid.length == 0 || grid[0].length == 0) return 0;
        
        int m = grid.length;
        int n = grid[0].length;
        
        int[][] sums = new int[m][n];
        
        // Base Case: 1x1 grid
        sums[0][0] = grid[0][0];
        
        // Iterative Case
        
        // First column of sums
        for (int i = 1; i < m; ++i) {
            sums[i][0] = sums[i-1][0] + grid[i][0];
        }
        
        // First row of sums
        for (int j = 1; j < n; ++j) {
            sums[0][j] = sums[0][j-1] + grid[0][j];
        }
        
        for (int i = 1; i < m; ++i) {
            for (int j = 1; j < n; ++j) {
                sums[i][j] = Math.min(sums[i-1][j], sums[i][j-1]) + grid[i][j];
            }
        }
        
        return sums[m-1][n-1];
    }
}
