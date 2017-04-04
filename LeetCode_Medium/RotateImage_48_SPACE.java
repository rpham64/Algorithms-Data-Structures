package LeetCode_Medium;

public class RotateImage_48_SPACE {

	/**
     * 1 2 3    =>  2 3 1
     * 3 2 1    =>  1 2 2
     * 2 1 3    =>  3 1 3
     * 
     *  ^    1 2 3
     *  |    3 2 1      Row: bottom-up
     *  |    2 1 3
     *      ------->    Column: left-right
     * 
     * Pseudocode:
     * 
     * Create new int[][] result
     * Loop for int col 0 to end
     *      Loop for int row end to 0
     *          Copy matrix[row][col] -> result[col][length(rows) - row - 1]
     * Copy result[][] back into matrix[][]
     * 
     * Cases:
     *      1) Empty 2D matrix OR n = 0(return; no change needed)
     *      2) n = 1 (return; no change needed)
     *      3) n = 2 or more (use pseudocode)
     */
    public void rotate(int[][] matrix) {
        
        // Case 1
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return;
        
        // Case 2
        if (matrix.length == 1 || matrix[0].length == 1) return;
        
        // Case 3
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] result = new int[rows][cols];
        
        for (int col = 0; col < cols; ++col) {
            for (int row = rows - 1; row >= 0; --row) {
                result[col][rows - row - 1] = matrix[row][col];
            }
        }
        
        // Copy result back into matrix
        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < cols; ++j) {
                matrix[i][j] = result[i][j];
            }
        }
    }
}
