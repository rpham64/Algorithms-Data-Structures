package Matrices;

/**
 * Given a non-empty 2D array grid of 0's and 1's, an island is a group of 1's (representing land) 
 * connected 4-directionally (horizontal or vertical.) You may assume all four edges of the grid are surrounded by water.
	
	Find the maximum area of an island in the given 2D array. (If there is no island, the maximum area is 0.)
	
	Example 1:
	
	[[0,0,1,0,0,0,0,1,0,0,0,0,0],
	 [0,0,0,0,0,0,0,1,1,1,0,0,0],
	 [0,1,1,0,1,0,0,0,0,0,0,0,0],
	 [0,1,0,0,1,1,0,0,1,0,1,0,0],
	 [0,1,0,0,1,1,0,0,1,1,1,0,0],
	 [0,0,0,0,0,0,0,0,0,0,1,0,0],
	 [0,0,0,0,0,0,0,1,1,1,0,0,0],
	 [0,0,0,0,0,0,0,1,1,0,0,0,0]]
	 
	Given the above grid, return 6. Note the answer is not 11, because the island must be connected 4-directionally.
	
	Example 2:
	
	[[0,0,0,0,0,0,0,0]]
	
	Given the above grid, return 0.
	
	Note: The length of each dimension in the given grid does not exceed 50.
 * 
 * Source: https://leetcode.com/problems/max-area-of-island/description/
 * 
 * @author rpham
 * Date: 5/2/18
 *
 */
public class MaxAreaOfIsland_695 {

	/**
	 * Simple Iteration + DFS Algorithm
	 * 
	 * Time: O(m * n) where m is the number of rows, n is the number of columns.
	 * Space: O(max(m, n)) since the recursion stacks can take up an entire row or column.
	 * 
	 * @param grid
	 * @return
	 */
	public int maxAreaOfIsland(int[][] grid) {
        
        int maxArea = 0;
        
        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid[0].length; ++j) {
                if (grid[i][j] == 1) {
                    int currentArea = getArea(grid, i, j);
                    maxArea = Math.max(maxArea, currentArea);
                }
            }
        }
        
        return maxArea;
    }
    
    private int getArea(int[][] grid, int row, int col) {
        // Out of Bounds OR current cell is 0   =>  Return 0
        if (row < 0 || col < 0 || row >= grid.length || col >= grid[0].length || grid[row][col] == 0) return 0;
        
        // Set current cell to 0 as we don't want to take into account visited areas.
        grid[row][col] = 0;
        
        return 1 + getArea(grid, row - 1, col) + getArea(grid, row + 1, col) + getArea(grid, row, col - 1) + getArea(grid, row, col + 1);
    }
}
