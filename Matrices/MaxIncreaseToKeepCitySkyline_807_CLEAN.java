package Matrices;

public class MaxIncreaseToKeepCitySkyline_807_CLEAN {

	/**
	 * Time: O(m * n)
	 * Space: O(m + n)
	 * 
	 * @param grid
	 * @return
	 */
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[] rowHeights = new int[m];
        int[] colHeights = new int[n];
        
        // Calculate max height in each row and col in one run.
        for (int row = 0; row < m; ++row) {
            for (int col = 0; col < n; ++col) {
                rowHeights[row] = Math.max(rowHeights[row], grid[row][col]);
                colHeights[col] = Math.max(colHeights[col], grid[row][col]);
            }
        }
        
        // Calculate total sum in another run.
        return getTotalSum(grid, rowHeights, colHeights);
    }
    
    private int getTotalSum(int[][] grid, int[] rowHeights, int[] colHeights) {
        int sum = 0;
        for (int i = 0; i < rowHeights.length; ++i) {
            for (int j = 0; j < colHeights.length; ++j) {
                sum += (Math.min(rowHeights[i], colHeights[j]) - grid[i][j]);
            }
        }
        return sum;
    }
}
