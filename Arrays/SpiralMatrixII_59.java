package Arrays;

/**
 * Given an integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.
	
	For example,
	Given n = 3,
	
	You should return the following matrix:
	
	[
	 [ 1, 2, 3 ],
	 [ 8, 9, 4 ],
	 [ 7, 6, 5 ]
	]
 * 
 * @author Rudolf
 *
 */
public class SpiralMatrixII_59 {

	public int[][] generateMatrix(int n) {
        
        int[][] matrix = new int[n][n];
        
        if (n <= 0) return matrix;
        
        int num = 0;
        int max = n*n;
        
        int colStart = 0;
        int colEnd = n-1;
        int rowStart = 0;
        int rowEnd = n-1;
        
        while (colStart <= colEnd && rowStart <= rowEnd && num != max) {
            
            // Right
            for (int i = colStart; i <= colEnd && num != max; ++i) {
                matrix[rowStart][i] = ++num;
            }
            ++rowStart;
            
            // Down
            for (int i = rowStart; i <= rowEnd && num != max; ++i) {
                matrix[i][colEnd] = ++num;
            }
            --colEnd;
            
            // Left
            for (int i = colEnd; i >= colStart && num != max; --i) {
                matrix[rowEnd][i] = ++num;
            }
            --rowEnd;
            
            // Up
            for (int i = rowEnd; i >= rowStart && num != max; --i) {
                matrix[i][colStart] = ++num;
            }
            ++colStart;
            
        }
        
        return matrix;
    }
}
