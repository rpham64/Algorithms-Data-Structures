package Matrices;

/**
 * Asked by: Snapchat
 * 
 * According to the Wikipedia's article: "The Game of Life, 
 * also known simply as Life, is a cellular automaton devised 
 * by the British mathematician John Horton Conway in 1970."
 * 
 * Given a board with m by n cells, each cell has an initial 
 * state live (1) or dead (0). Each cell interacts with its 
 * eight neighbors (horizontal, vertical, diagonal) using the 
 * following four rules (taken from the above Wikipedia article):
 * 
 * 1) Any live cell with fewer than two live neighbors dies, 
 * as if caused by under-population.
 * 
 * 2) Any live cell with two or three live neighbors lives 
 * on to the next generation.
 * 
 * 3) Any live cell with more than three live neighbors dies, 
 * as if by over-population..
 * 
 * 4) Any dead cell with exactly three live neighbors becomes 
 * a live cell, as if by reproduction.
 * 
 * Write a function to compute the next state (after one update) 
 * of the board given its current state.
 * 
 * Follow up: 
 * 
 * - Could you solve it in-place? Remember that the board needs 
 * to be updated at the same time: You cannot update some cells 
 * first and then use their updated values to update other cells.
 * 
 * - In this question, we represent the board using a 2D array. 
 * In principle, the board is infinite, which would cause problems 
 * when the active area encroaches the border of the array. How would 
 * you address these problems?
 * 
 * Solution: http://xiaoyaoworm.com/blog/2015/11/28/leetcode289-game-of-life/
 * 
 * @author Rudolf
 *
 */
public class GameOfLife_289 {

	public void gameOfLife(int[][] board) {
        
        // Input Check: if board is null, return
        if (board == null) return;
        
        int m = board.length;
        int n = board[0].length;
        
        // New board for storing results
        int[][] result = new int[m][n];
        
        // Base Case: board is 1x1
        if ((m == 1 && n == 1) && board[0][0] == 1) {
            result[0][0] = 0;
        }
        
        // Iterative Case: Check each board entry and its neighbors
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                
                int numOfAliveNeighbors = getLiveNumber(board, i, j);
                
                // Check conditions
                if (board[i][j] == 1 && 
                		(numOfAliveNeighbors == 2 || numOfAliveNeighbors == 3)) {
                    result[i][j] = 1;
                }
                else if (board[i][j] == 0 && numOfAliveNeighbors == 3) {
                    result[i][j] = 1;
                } 
                else {
                    result[i][j] = 0;
                }
                
            }
        }
        
        // Copy entries from result into board
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = result[i][j];
            }
        }
    }
    
    private int getLiveNumber(int[][] board, int x, int y) {
        
        int m = board.length;
        int n = board[0].length;
        int numAlive = 0;
        
        /**
         * NOTE: Checks the 1-unit offsets from current cell
         * 
         * 
         * (x-1, y-1)	|	(x, y-1)	|	(x+1, y-1)
         * --------------------------------------------
         * (x-1, y)		|  current cell |	(x+1, y)
         * --------------------------------------------
         * (x-1, y+1)	|	(x, y+1)	|	(x+1, y+1)
         * 
         */
        for (int i = x-1; i <= x+1; i++) {
            for (int j = y-1; j <= y+1; j++) {
                
                // Input Check: see if i or j are out of bounds or board[i][j] is the original cell
                if (i < 0 || i > m-1 || j < 0 || j > n-1 || (i == x && j == y)) continue;
                
                // Check live or not
                if (board[i][j] == 1) numAlive++;
                
            }
        }
        
        return numAlive;   
    }
	
}
