package Strings;

public class LongestPalindromicSubstring_5_DP {

	/**
     * Dynamic Programming Solution
     * 
     * Time: 
     * Time Complexity: 
     * Space Complexity: O(n^2)
     * 
     * Variables:
     *      int n = s.length()
     *      boolean[][] isPalindrome            (boolean[i][j] means whether s from index i to j is a palindrome)
     *      int minStart = 0                    (starting index of longest palindromic substring)
     *      int maxLength = Integer.MIN_VALUE   (max length of palindromic substring)
     * 
     * Algorithm:
     *      1)  Create isPalindrome[][] with size n x n 
     *      2)  Fill all entries with length 1 as true
     *      3)  Fill all entries with length 2:
     *              If char at i and i+1 are equal, set isPalindrome[i][i+1] := true
     *                  Else, set false
     *      4)  Loop for length from 3 to n
     *              Loop for start from 0 to n - length + 1
     *                  Set end := start + length - 1
     *                  If char(start) == char(end) AND isPalindrome[start+1][end-1] is true,
     *                      Set isPalindrome[start][end] := true
     *                      If length > maxLength
     *                          Set minStart := start
     *                          Set maxLength := length
     *                  Else, 
     *                      Set isPalindrome[start][end] := false
     *      5)  Return s.substring(minStart, minStart + maxLength)
     * 
     * Cases:
     *      1)  Empty OR null (return null)
     *      2)  Length 1 (return s)(always palindrome)
     *      3)  Length 2+ (see algorithm)
     */
    public String longestPalindrome(String s) {
        
        // Case 1
        if (s == null || "".equals(s) || s.length() == 0) return null;
        
        // Case 2
        if (s.length() == 1) return s;
        
        // Case 3
        // Step 1
        int n = s.length();
        boolean[][] isPalindrome = new boolean[n][n];
        int minStart = 0;
        int maxLength = 1;
        
        // Step 2
        for (int i = 0; i < n; ++i) {
            isPalindrome[i][i] = true;
        }
        
        // Step 3
        for (int i = 0; i < n-1; ++i) {
            
            if (s.charAt(i) == s.charAt(i+1)) {
                isPalindrome[i][i+1] = true;
                minStart = i;
                maxLength = 2;
            }
            
        }
        
        // Step 4
        for (int length = 3; length <= n; ++length) {
            
            for (int start = 0; start < n - length + 1; ++start) {
                
                int end = start + length - 1;
                
                if (s.charAt(start) == s.charAt(end) && isPalindrome[start+1][end-1]) {
                    
                    isPalindrome[start][end] = true;
                    
                    if (length > maxLength) {
                        minStart = start;
                        maxLength = length;
                    }
                    
                } else {
                    isPalindrome[start][end] = false;
                }
            }
            
        }
        
        // Step 5
        return s.substring(minStart, minStart + maxLength);
    }
}
