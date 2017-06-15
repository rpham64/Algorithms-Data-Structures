package Matrices;

/**
 * Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. 
 * An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. 
 * You may assume all four edges of the grid are all surrounded by water.
	
	Example 1:
	
	11110
	11010
	11000
	00000
	
	Answer: 1
	
	Example 2:
	
	11000
	11000
	00100
	00011
	
	Answer: 3
 * 
 * @author Rudolf
 *
 */
public class NumberOfIslands_200 {

	/**
     * Idea: Iterate through grid. If cell contains a 1, do BFS in all four directions and set cell to 0 if it's a 1.
     *      Increment count for each BFS done.
     */
    public int numIslands(char[][] grid) {
        
        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        
        int count = 0;
        int rows = grid.length;
        int cols = grid[0].length;
        
        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < cols; ++j) {
                
                if (grid[i][j] == '1') {
                    count++;
                    BFS(grid, i, j);
                }
                
            }
        }
        
        return count;
    }
    
    private void BFS(char[][] grid, int i, int j) {
        
        // Check out of bounds OR (i, j) is 0
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == '0') return;
        
        // If (i, j) is 1, change to 0
        if (grid[i][j] == '1') grid[i][j] = '0';
        
        BFS(grid, i+1, j);
        BFS(grid, i-1, j);
        BFS(grid, i, j+1);
        BFS(grid, i, j-1);
    }
}
