package LeetCode_Medium;

public class SetMatrixZeroes_73 {

	/**
     * Cases:
     *      1) Empty
     *      2) 1 element
     *      3) Multiple elements
     * 
     * Ex: 
     *      1   |   2   |   0               0   |   0   |   0
     *  -------------------------       ------------------------
     *      2   |   0   |   1       =>      0   |   0   |   0
     *  -------------------------       ------------------------
     *      1   |   1   |   1               1   |   0   |   0
     * 
     *  Idea: iterate through the 2D matrix, checking if current cell is a 0.
     *      If so, mark its current row and column as having a 0.
     *      Re-iterate through the matrix and change every marked row and column to 0's.
     * 
     * 
     *  0 0 0 5         0 0 0 0
     *  4 3 1 4         0 0 0 4
     *  0 1 1 4     =>  0 0 0 0
     *  1 2 1 3         0 0 0 3
     *  0 0 1 1         0 0 0 0
     *  
     *  
     *  Time: O(nm)
     *  Space: O(n + m)
     */
    public void setZeroes(int[][] matrix) {
        
        // Case 1
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return;
        
        // Case 2 and 3
        int rows = matrix.length;
        int cols = matrix[0].length;
        
        // Keeps track of which rows and columns have 0's (true if yes, false if no).
        boolean[] rowZeroes = new boolean[rows];
        boolean[] colZeroes = new boolean[cols];
        
        // Iterate through matrix, marking rows and cols as true if they contain a 0
        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < cols; ++j) {
                
                // Mark true if 0
                // If not 0 OR already marked, continue
                if (matrix[i][j] != 0) {
                    continue;
                } else if (matrix[i][j] == 0 && (rowZeroes[i] == false || colZeroes[j] == false)){
                    rowZeroes[i] = true;
                    colZeroes[j] = true;
                }
            }
        }
        
        // Re-iterate through matrix, changing all rows and cols with a 0
        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < cols; ++j) {
                
                if (rowZeroes[i] == true || colZeroes[j] == true) matrix[i][j] = 0;
                
            }
        }
    }
    
    /**
     * Constant Space Solution
     *      
     * Time: O(nm)
     * Space: O(1)
     */
    public void setZeroes2(int[][] matrix) {
        
        // Case 1
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return;
        
        // Cases 2 and 3
        int rows = matrix.length;
        int cols = matrix[0].length;
        boolean firstRow = false;
        boolean firstCol = false;
        
        // Iterate through rest of matrix and mark the respective rows and columns.
        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < cols; ++j) {
                
                if (matrix[i][j] == 0) {
                    
                    // Check: cell is on row 0 or col 0
                    if (i == 0) firstRow = true;
                    if (j == 0) firstCol = true;
                    
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
                
            }
        }
        
        // Re-iterate and set cells to 0, if row or col are marked
        for (int i = 1; i < rows; ++i) {
            for (int j = 1; j < cols; ++j) {
                
                if (matrix[0][j] == 0 || matrix[i][0] == 0 && matrix[i][j] != 0) matrix[i][j] = 0;
                
            }
        }
        
        // Finally, set all cells in 0th row and 0th col if firstRow and firstCol are true.
        if (firstRow) {
            for (int j = 0; j < cols; ++j) {
                matrix[0][j] = 0;
            }
        }
        if (firstCol) {
            for (int i = 0; i < rows; ++i) {
                matrix[i][0] = 0;
            }
        }
    }
}
