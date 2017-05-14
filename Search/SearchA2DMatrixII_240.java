package Search;

/**
 * Write an efficient algorithm that searches for a value in an m x n matrix. 
 * This matrix has the following properties:
	
	Integers in each row are sorted in ascending from left to right.
	Integers in each column are sorted in ascending from top to bottom.
	For example,
	
	Consider the following matrix:
	
	[
	  [1,   4,  7, 11, 15],
	  [2,   5,  8, 12, 19],
	  [3,   6,  9, 16, 22],
	  [10, 13, 14, 17, 24],
	  [18, 21, 23, 26, 30]
	]
	
	Given target = 5, return true.
	
	Given target = 20, return false.
 * 
 * @author Rudolf
 *
 */
public class SearchA2DMatrixII_240 {

	/*
	 * Literally the same as "Search A 2D Matrix 74" 
	 */
	public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;
        
        int m = matrix.length;
        int n = matrix[0].length;
        
        // Search algorithm: Start in top-right corner of matrix[][]
        // Move left or down depending on if current < or > target
        // If out of bounds, target does not exist in matrix, so return false
        for (int row = 0, col = n - 1; row < m && col >= 0; ) {
            
            int current = matrix[row][col];
            
            if (current == target) {
                return true;
            } else if (current < target) {
                row++;      // Move down
            } else {
                col--;      // Move left
            }
        }
        
        return false;       // Out of bounds, so target not in matrix
    }
}
