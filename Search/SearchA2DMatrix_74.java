package Search;

/**
 * Write an efficient algorithm that searches for a value in an m x n matrix. 
 * This matrix has the following properties:
	
	Integers in each row are sorted from left to right.
	The first integer of each row is greater than the last integer of the previous row.
	
	For example,
	
	Consider the following matrix:
	
	[
	  [1,   3,  5,  7],
	  [10, 11, 16, 20],
	  [23, 30, 34, 50]
	]
	
	Given target = 3, return true.
 * 
 * @author Rudolf
 *
 */
public class SearchA2DMatrix_74 {

	/**
	 * Efficient Search Algorithm for a 2D matrix
	 * 
	 * Time Complexity: O(n)
	 * 
	 * @param matrix
	 * @param target
	 * @return
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
