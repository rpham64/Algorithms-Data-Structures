package Arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.
	
	For example,
	Given the following matrix:
	
	[
	 [ 1, 2, 3 ],
	 [ 4, 5, 6 ],
	 [ 7, 8, 9 ]
	]
	
	You should return [1,2,3,6,9,8,7,4,5].
 * 
 * @author Rudolf
 *
 */
public class SpiralMatrix_54 {

	public List<Integer> spiralOrder(int[][] matrix) {
        
        List<Integer> result = new ArrayList<>();
        
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return result;
        
        int m = matrix.length;
        int n = matrix[0].length;
        
        // Row and Col Indices
        int colStart = 0;
        int colEnd = n - 1;
        int rowStart = 0;
        int rowEnd = m - 1;
        
        while (colStart <= colEnd && rowStart <= rowEnd) {
            
            // Right
            // Depends on: rowStart
            for (int index = colStart; index <= colEnd; ++index) {
                result.add(matrix[rowStart][index]);
            }
            ++rowStart;
            
            // Down
            // Depends on: colEnd
            for (int index = rowStart; index <= rowEnd; ++index) {
                result.add(matrix[index][colEnd]);
            }
            --colEnd;
            
            if (result.size() == m*n) break;       // To stop before duplicates, I guess
            
            // Left
            // Depends on: rowEnd
            for (int index = colEnd; index >= colStart; --index) {
                result.add(matrix[rowEnd][index]);
            }
            --rowEnd;
            
            // Up
            // Depends on: colStart
            for (int index = rowEnd; index >= rowStart; --index) {
                result.add(matrix[index][colStart]);
            }
            ++colStart;
            
        }
        
        return result;
    }
}
