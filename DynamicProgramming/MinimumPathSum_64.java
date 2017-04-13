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
	
	/**
	 * In-place Solution
	 * 
	 * Time: O(mn) where m is number of rows, n is number of cols
	 * Space: O(1)
	 * 
     * Variables:
     *      int rows = grid.length      (num of rows)
     *      int cols = grid[0].length   (num of cols)
     * 
     * Algorithm:
     *      1)  Fill top row (row = 0) with sums:
     *              For each int in top row, add current int with previous
     *      2)  Fill leftmost column (col = 0) with sums:
     *              For each int in leftmost column, iterate down and add current int with previous 
     *      3)  Fill rest of grid by adding current int with minimum of int above (row - 1) or int left (col - 1)
     *      4)  Return bottom right int as the answer (grid[m-1][n-1] where m is number of rows, n is number of columns)
     * 
     * Cases:
     *      1)  Empty OR null grid (return 0)
     *      2)  1x1 grid (return grid[0][0])
     *      3)  mxn grid (see algorithm above)
     */
    public int minPathSum(int[][] grid) {
        
        // Case 1
        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        
        // Case 2
        if (grid.length == 1 && grid[0].length == 1) return grid[0][0];
        
        // Case 3
        int rows = grid.length;
        int cols = grid[0].length;
        
        // Step 1
        for (int n = 1; n < cols; ++n) {
            grid[0][n] += grid[0][n-1];
        }
        
        // Step 2
        for (int m = 1; m < rows; ++m) {
            grid[m][0] += grid[m-1][0];
        }
        
        // Step 3
        for (int m = 1; m < rows; ++m) {
            for (int n = 1; n < cols; ++n) {
                grid[m][n] += Math.min(grid[m-1][n], grid[m][n-1]);
            }
        }
        
        // Step 4
        return grid[rows-1][cols-1];
    }

    /**
     * Solution using Space
     * 
     * Time: O(mn)
     * Space: O(mn)
     * 
     * Cases:
     *      1) Empty grid (return 0)
     *      2) 1 element (return element val)
     *      3) 2+ elements
     *          - Note: can only move right or down
     *              => Move in direction of lower sum
     * 
     *                  0  1  2  3  4
     * 
     *  5 1 2 4 5       5  6  8  12  17     0
     *  2 1 0 4 4   =>  7  7  7  11  15     1
     *  3 1 1 1 2       10 8  8  9   11     2
     * 
     *  Min sum = 11
     * 
     * Return: sum[rows - 1][cols - 1]
     */
    public int minPathSum2(int[][] grid) {
        
        // Case 1
        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        
        // Case 2
        if (grid.length == 1 && grid[0].length == 1) return grid[0][0];
        
        // Case 3
        int rows = grid.length;
        int cols = grid[0].length;
        
        int[][] sums = new int[rows][cols];
        
        // DON'T FORGET TO INITIALIZE 
        sums[0][0] = grid[0][0];
        
        // Fill row 0 and col 0 with sums
        for (int i = 1; i < rows; ++i) {
            sums[i][0] = sums[i-1][0] + grid[i][0];
        }
        for (int j = 1; j < cols; ++j) {
            sums[0][j] = sums[0][j-1] + grid[0][j];
        }
        
        // Fill rest of grid by comparing current cell's top and left sums
        for (int i = 1; i < rows; ++i) {
            for (int j = 1; j < cols; ++j) {
                sums[i][j] = grid[i][j] + Math.min(sums[i-1][j], sums[i][j-1]);
            }
        }
        
        return sums[rows-1][cols-1];
    }
}
