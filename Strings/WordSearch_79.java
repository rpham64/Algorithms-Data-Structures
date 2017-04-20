package Strings;

/**
 * Given a 2D board and a word, find if the word exists in the grid.

	The word can be constructed from letters of sequentially adjacent cell, 
	where "adjacent" cells are those horizontally or vertically neighboring. 
	The same letter cell may not be used more than once.
	
	For example,
	
	Given board =
	
	[
	  ['A','B','C','E'],
	  ['S','F','C','S'],
	  ['A','D','E','E']
	]
	
	word = "ABCCED", -> returns true,
	word = "SEE", -> returns true,
	word = "ABCB", -> returns false.

 * 
 * @author Rudolf
 *
 */
public class WordSearch_79 {

	/**
	 * Time Complexity: O(nm) where n is number of rows, m is number of columns
	 * Space Complexity: O(nm) since we created a checked[][]
	 * 
     * Idea: Scan board for first char of word. Then, check its four adjacent cells for the next char.
     *      If next char exists, recursively apply helper method on next char. Continue until entire word is found and return true.
     *      
     * Variables:
     *      int rows = board.length
     *      int cols = board[0].length
     *      boolean[][] checked             (size = rows*cols)(true if cell is already visited/checked)
     *      char firstChar
     * 
     * Algorithm:
     *      Loop for int m from 0 to board.length
     *          Loop for int n from 0 to board[0].length
     *              If first char is found, call helper method on first char
     *                  If helper returns true, return true as final result
     *      Return false (does not exist)
     * 
     * Helper Function:
     *      1)  exist(char[][] board, String word, int index, int row, int col, boolean[][] checked)
     * 
     * Helper Algorithm:
     *      - See helper cases
     * 
     * Helper Cases:
     *      1)  Out of Bounds (row, col)            (return false)
     *      2)  Index == s.length()                 (finished scanning word. Return true)
     *      3)  Current cell is already checked     (return false)
     *      4)  Current cell's char is not the right char (return false)
     *      5)  Found correct char:
     *              Set checked[row][col] := true
     *              Recursively call helper on four adjacent cells and store boolean result
     *              Reset checked[row][col] := false    (In case we found current char but wrong path)
     *          Return result
     * 
     * Cases:
     *      1)  Null or empty board (return false)
     *      2)  Word is null or empty (return false)
     *      3)  word.length > board.length * board[0].length (word is too long, so return false)
     *      4)  Non-null and nonempty word and board (see algorithm)
     * 
     */
    public boolean exist(char[][] board, String word) {
        
        // Case 1
        if (board == null || board.length == 0 || board[0].length == 0) return false;
        
        // Case 2
        if (word == null || word.length() == 0) return false;
        
        // Case 3
        int rows = board.length;
        int cols = board[0].length;
        
        if (word.length() > rows * cols) return false;
        
        // Case 4
        boolean[][] checked = new boolean[rows][cols];
        
        // Search for first char
        for (int m = 0; m < rows; ++m) {
            for (int n = 0; n < cols; ++n) {
                if (exist(board, word, 0, m, n, checked)) return true;
            }
        }
        
        return false;
    }
    
    private boolean exist(char[][] board, String word, int index, int row, int col, boolean[][] checked) {
        
        // Case 2
        if (index == word.length()) return true;
        
        // Case 1
        if (row < 0 || row >= board.length) return false;
        if (col < 0 || col >= board[0].length) return false;
        
        // Case 3
        if (checked[row][col]) return false;
        
        // Case 4
        if (board[row][col] != word.charAt(index)) return false;
        
        // Case 5
        // Assume char has been found
        checked[row][col] = true;
        
        boolean result = exist(board, word, index+1, row-1, col, checked) ||
                        exist(board, word, index+1, row+1, col, checked) ||
                        exist(board, word, index+1, row, col-1, checked) ||
                        exist(board, word, index+1, row, col+1, checked);
                    
        checked[row][col] = false;      // In case we found right char but path doesn't finish word (like 'ABC' and 'ABE')
        
        return result;       // Char not found
    }
}
