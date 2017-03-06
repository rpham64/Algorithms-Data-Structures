package LeetCode;

/**
 * You are given a map in form of a two-dimensional integer grid where 1 represents land 
 * and 0 represents water. Grid cells are connected horizontally/vertically (not diagonally). 
 * The grid is completely surrounded by water, and there is exactly one island 
 * (i.e., one or more connected land cells). 
 * The island doesn't have "lakes" (water inside that isn't connected to the water around the island). 
 * One cell is a square with side length 1. The grid is rectangular, width and height don't exceed 100. 
 * Determine the perimeter of the island.

	Example:
	
	[[0,1,0,0],
	 [1,1,1,0],
	 [0,1,0,0],
	 [1,1,0,0]]
	
	Answer: 16
	Explanation: The perimeter is the 16 yellow stripes in the image below:
	
 * 
 * Source: https://leetcode.com/problems/island-perimeter/?tab=Description
 * 
 * @author Rudolf
 *
 */
public class IslandPerimeter_463 {

	/**
     * Idea: Each land tile has 4 sides, so perimeter is 4. 
     *      If its adjacent "visited" tile is a land tile, subtract 2 (1 for itself, 1 for its neighbor).
     */
    public int islandPerimeter(int[][] grid) {
        
        // Case 1
        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        
        // Case 2
        int total = 0;
        int numRows = grid.length;
        int numColumns = grid[0].length;
        
        for (int m = 0; m < numRows; ++m) {
            for (int n = 0; n < numColumns; ++n) {
                
                // Check: land tile
                if (grid[m][n] == 1) {
                                
                    int perimeter = 4;
                
                    if (m > 0 && grid[m-1][n] == 1) perimeter -= 2;
                    if (n > 0 && grid[m][n-1] == 1) perimeter -= 2;
                    
                    total += perimeter;
                }
            }
        }
        
        return total;
    }
}
