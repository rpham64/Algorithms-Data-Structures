package Strings;

/**
 * Time Complexity: O(nm * 4^(length of word))
 * Space Complexity: O(1)
 * 
 * Reason: For each cell, we check the four adjacent cells. So for each cell, we do four function calls.
 * 			This becomes 4 * 4 * ... * 4 until we find the word we're looking for. 
 * 			In mathematical terms, we have to search for four cells per character of the word
 * 				=> O(4 ^ (length of word)) for the recursive helper function
 * 			Since we're checking each cell in the main function, that time complexity is simply O(nm).
 * 				=> O(nm * 4^(length of word))
 * 
 * Source: https://discuss.leetcode.com/topic/37162/what-is-the-time-complexity-for-the-dfs-solution/2
 * 
 * @author Rudolf
 *
 */
public class WordSearch_79_CONST_SPACE {

	public boolean exist(char[][] board, String word) {
        
        if (board == null || board.length == 0 || board[0].length == 0 || word == null) return false;
        
        int m = board.length;
        int n = board[0].length;
        
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (exist(board, word, 0, i, j)) return true;
            }
        }
        
        return false;
    }
    
    private boolean exist(char[][] board, String word, int index, int row, int col) {
        
        if (index == word.length()) {
            return true;
        } else if (row < 0 || col < 0 || row >= board.length || col >= board[0].length || board[row][col] == '*' || board[row][col] != word.charAt(index)) {
            return false;
        } else {
            
        	// Save old char before changing to '*'
            char temp = board[row][col];
            
            board[row][col] = '*';		// Means visited/checked
            
            boolean result = exist(board, word, index + 1, row - 1, col) 
                        || exist(board, word, index + 1, row + 1, col) 
                        || exist(board, word, index + 1, row, col - 1)
                        || exist(board, word, index + 1, row, col + 1);
                        
            board[row][col] = temp;
            
            return result;
        }
        
    }
}
