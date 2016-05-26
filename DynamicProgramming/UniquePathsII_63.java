package DynamicProgramming;

/**
 * Problem: https://leetcode.com/problems/unique-paths-ii/
 * 
 * Reference: https://siddontang.gitbooks.io/leetcode-solution/content/dynamic_programming/unique_paths.html
 * 
 * @author Rudolf
 *
 */
public class UniquePathsII_63 {

	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        
        // Input Check: empty grid
        if (obstacleGrid.length == 0 || obstacleGrid[0].length == 0) return 0;
        
        int rows = obstacleGrid.length;
        int cols = obstacleGrid[0].length;
        
        int[][] paths = new int[rows][cols];
        
        // Base Case
        if (obstacleGrid[0][0] == 0) {
            paths[0][0] = 1;
        } else {
            paths[0][0] = 0;
        }
        
        // Fill first column with 1's
        for (int i = 1; i < rows; ++i) {
            
            // Case: 1 0 1 in first column
            if (obstacleGrid[i][0] == 0 && paths[i-1][0] == 1) {
                paths[i][0] = 1;
            } else {
                paths[i][0] = 0;
            }
            
        }
        
        // Fill first row with 1's
        for (int j = 1; j < cols; ++j) {
            
            // Case: 1 0 1 in first row
            if (obstacleGrid[0][j] == 0 && paths[0][j-1] == 1) {
                paths[0][j] = 1;
            } else {
                paths[0][j] = 0;
            }
            
        }
        
        // Iterate from top-left corner to bottom-right corner
        for (int i = 1; i < rows; ++i) {
            for (int j = 1; j < cols; ++j) {
                
                // Obstacle Check
                if (obstacleGrid[i][j] == 0) {
                    paths[i][j] = paths[i-1][j] + paths[i][j-1];    // No paths run through this space
                }
                else {
                    paths[i][j] = 0;
                }
                
            }
        }
        
        return paths[rows-1][cols-1];
    }
}
