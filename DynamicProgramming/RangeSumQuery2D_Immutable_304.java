package DynamicProgramming;

public class RangeSumQuery2D_Immutable_304 {

	public class NumMatrix {

	    int[][] sums;

	    public NumMatrix(int[][] matrix) {
	        
	        sums = matrix;
	        
	        for (int row = 0; row < matrix.length; ++row) {
	            for (int col = 1; col < matrix[0].length; ++col) {
	                sums[row][col] += sums[row][col - 1];
	            }
	        }
	        
	    }
	    
	    /**
	     * sums = [
	          [3, 3, 4, 5, 7],
	          [5, 11, 14, 16, 17],
	          [1, 3, 3, 4, 9],
	          [4, 5, 5, 6, 13],
	          [1, 1, 4, 4, 9]
	        ]
	     * 
	     */
	    public int sumRegion(int row1, int col1, int row2, int col2) {
	        
	        int sum = 0;
	        
	        if (col1 == 0) {
	        	
	            for (int row = row1; row <= row2; ++row) {
	                sum += sums[row][col2];
	            }
	            
	        } else {
	        	
	            for (int row = row1; row <= row2; ++row) {
	                sum += sums[row][col2] - sums[row][col1 - 1];
	            }
	            
	        }
	        
	        return sum;
	    }
	}


	// Your NumMatrix object will be instantiated and called as such:
	// NumMatrix numMatrix = new NumMatrix(matrix);
	// numMatrix.sumRegion(0, 1, 2, 3);
	// numMatrix.sumRegion(1, 2, 3, 4);
	
}
