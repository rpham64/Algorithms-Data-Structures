package LeetCode_Medium;

import java.util.HashSet;

/**
 * Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules.

	The Sudoku board could be partially filled, where empty cells are filled with the character '.'.
	
	
	A partially filled sudoku which is valid.
	
	Note:
	
	A valid Sudoku board (partially filled) is not necessarily solvable. 
	Only the filled cells need to be validated.
 * 
 * @author Rudolf
 *
 */
public class ValidSudoku_36 {

	/**
     * Idea: For each cell in the board, check if it's valid by comparing it to the other cells in the 
     *      same row, column, and 3x3 grid.
     * 
     * First grid:
     * 
     *  (0, 0)  |   (0, 1)  |   (0, 2)              (0, 3)  |   (0, 4)  |   (0, 5)
     * --------------------------------           ----------------------------------
     *  (1, 0)  |   (1, 1)  |   (1, 2)      ==>     (1, 3)  |   (1, 4)  |   (1, 5)
     * --------------------------------           ----------------------------------
     *  (2, 0)  |   (2, 1)  |   (2, 2)              (2, 3)  |   (2, 4)  |   (2, 5)
     * 
     *  To go HORIZONTAL: translate 0, 3, 6 =>  3*(i%3)
     *  To go VERTICAL: translate 0, 3, 6   =>  3*(i/3)
     * 
     *  Iterating HORIZONTAL (var j):
     *      0, 1, 2     =>  0, 1, 2
     *      3, 4, 5     =>  0, 1, 2         =>  j % 3
     *      6, 7, 8     =>  0, 1, 2
     * 
     *  Iterating VERTICAL (var j):
     *      0, 1, 2     =>  0, 0, 0
     *      3, 4, 5     =>  1, 1, 1         =>  j / 3
     *      6, 7, 8     =>  2, 2, 2
     * 
     *  To compare cell and current GRID, use:
     *      - Row = j / 3 + 3*(i/3)
     *      - Col = j % 3 + 3*(i%3)
     */
    public boolean isValidSudoku(char[][] board) {
        
        // Null Check
        if (board == null || board.length == 0 || board[0].length == 0) return false;
        
        // Let i be the index for each grid, j be the index for each cell
        for (int i = 0; i < board.length; ++i) {
            
            HashSet<Character> row = new HashSet<>();
            HashSet<Character> column = new HashSet<>();
            HashSet<Character> grid = new HashSet<>();
            
            for (int j = 0; j < board[0].length; ++j) {
                
                // Column
                if (board[i][j] != '.' && column.contains(board[i][j])) return false;       // Duplicated in column
                
                // Row
                if (board[j][i] != '.' && row.contains(board[j][i])) return false;    // Duplicated in row
                
                // Grid
                if (board[j/3 + 3*(i/3)][j%3 + 3*(i%3)] != '.' && grid.contains(board[j/3 + 3*(i/3)][j%3 + 3*(i%3)])) return false;
                
                column.add(board[i][j]);
                row.add(board[j][i]);
                grid.add(board[j/3 + 3*(i/3)][j%3 + 3*(i%3)]);
            }
        }
        
        return true;
    }
}
