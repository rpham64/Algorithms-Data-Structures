package Matrices;

public class GameOfLife_289_2 {
	
	/**
     * Cases:
     *      1) Alive
     *          - 0, 1      =>      Dead
     *          - 2, 3      =>      Alive
     *          - 4+        =>      Dead
     *      2) Dead
     *          - 3         =>      Alive
     * 
     * Idea: Iterate through board, checking the number of alive neighbors of each cell.
     *      Store the result of each cell into a new 2D board.
     *      Finally, copy the new board into the old board.
     * 
     * Board cases:
     *      1) Empty
     *      2) 1 cell
     *      3) Multiple cells
     * 
     * Time: O(n^2)?
     * Space: O(n^2)
     */
    public void gameOfLife(int[][] board) {
        
        // Board Case 1
        if (board == null || board.length == 0 || board[0].length == 0) return;
        
        // Board Cases 2 and 3
        int rows = board.length;
        int cols = board[0].length;
        int[][] result = new int[rows][cols];
        
        for (int m = 0; m < rows; ++m) {
            for (int n = 0; n < cols; ++n) {
                
                int numOfNeighbors = getCount(board, m, n);
                int current = board[m][n];
                
                // Alive
                if (current == 1) {
                    
                    switch(numOfNeighbors) {
                        
                        case 0:
                        case 1:
                            result[m][n] = 0;
                            break;
                        case 2:
                        case 3:
                            result[m][n] = 1;
                            break;
                        default:
                            result[m][n] = 0;
                            break;
                        
                    }
                    
                } else {    // Dead
                    
                    if (numOfNeighbors == 3) result[m][n] = 1;
                    
                }
            }
        }
        
        // Copy result back into input board
        for (int m = 0; m < rows; ++m) {
            for (int n = 0; n < cols; ++n) {
                board[m][n] = result[m][n];
            }
        }
    }
    
    /**
     * Counts the number of live neighbors surrounding cell at m, n.
     * 
     * Range: 0 to 8
     * 
     *  (m-1, n-1)  |   (m-1, n)    |   (m-1, n+1)
     * --------------------------------------------
     *  (m, n-1)    |   (m, n)      |   (m, n+1)
     * --------------------------------------------
     *  (m+1, n-1)  |   (m+1, n)    |   (m+1, n+1)
     * 
     * Cases:
     *      1) Self (skip)
     *      2) Out of Bounds (skip)
     *      3) Alive (increment count)
     *      4) Dead (skip)
     */
    private int getCount(int[][] board, int m, int n) {
        
        int numAlive = 0;
        
        for (int i = m-1; i <= m+1; ++i) {
            for (int j = n-1; j <= n+1; ++j) {
                
                // Out of Bounds OR self    =>  continue
                if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || (i==m && j==n)) continue;
                
                if (board[i][j] == 1) numAlive++;
                
            }
        }
        
        return numAlive;
    }
}
