package LeetCode_Medium;

/**
 * You are given an n x n 2D matrix representing an image.

	Rotate the image by 90 degrees (clockwise).
	
	Follow up:
	Could you do this in-place?
 * 
 * @author Rudolf
 *
 */
public class RotateImage_48 {

	private int[][] matrix;
    
    /**
     *  1 2 3   =>  7 4 1
     *  4 5 6   =>  8 5 2
     *  7 8 9   =>  9 6 3
     * 
     *  Transpose, Swap columns:
     * 
     *  1 2 3   =>  1 4 7   =>  7 4 1
     *  4 5 6   =>  2 5 8   =>  8 5 2
     *  7 8 9   =>  3 6 9   =>  9 6 3
     * 
     *  Swap rows, Transpose:
     * 
     *  1 2 3   =>  7 8 9   =>  7 4 1
     *  4 5 6   =>  4 5 6   =>  8 5 2
     *  7 8 9   =>  1 2 3   =>  9 6 3
     * 
     *  Transpose: swap(matrix[i][j], matrix[j][i])
     *  Swap columns: swap(matrix[i][j], matrix[i][matrix[0].length - 1 - j])       Note: i is consistent for both
     *  Swap rows: swap(matrix[i][j], matrix[matrix.length - 1 - i][j])             Note: j is consistent for both
     */
    public void rotate(int[][] matrix) {
        
        this.matrix = matrix;
        
        transpose();
        swapColumns();
    }
    
    private void transpose() {
        for (int i = 0; i < matrix.length; ++i) {
            for (int j = i; j < matrix[0].length; ++j) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }
    
    private void swapColumns() {
        for (int j = 0; j < matrix[0].length / 2; ++j) {
            for (int i = 0; i < matrix.length; ++i) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][matrix[0].length - 1 - j];
                matrix[i][matrix[0].length - 1 - j] = temp;
            }
        }
    }
    
    private void swapRows() {
        for (int i = 0; i < matrix.length / 2; ++i) {
            for (int j = 0; j < matrix[0].length; ++j) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[matrix.length - 1 - i][j];
                matrix[matrix.length - 1 - i][j] = temp;
            }
        }
    }
}
