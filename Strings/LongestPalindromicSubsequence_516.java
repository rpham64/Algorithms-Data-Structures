package Strings;

/**
 * Given a string s, find the longest palindromic subsequence's length in s. 
 * You may assume that the maximum length of s is 1000.

Example 1:

Input: "bbbab"
Output: 4

One possible longest palindromic subsequence is "bbbb".

Example 2:

Input: "cbbd"
Output: 2

One possible longest palindromic subsequence is "bb".
 * 
 * @author Rudolf
 *
 */
public class LongestPalindromicSubsequence_516 {

	/**
     * Solutions:
     *      1)  Brute Force: Create every palindromic subsequence possible in s and return the longest length.
     *          - Time Complexity: O(nm) + O(m) + O(n^2) = O(isSubsequence) + O(isPalindrome) + O(iterating through s)?
     *          - Space Complexity: O(n) where n is the length of s 
     *      2)  Dynamic Programming: Create int[][] storing the longest palindromic subsequence length from index i to j. 
     *          - Time Complexity: O(n^2)
     *          - Space Complexity: O(n^2)
     *      3)	Memoization
     *      	- Time Complexity: O(n^2)
     *      	- Space Complexity: O(n^2)
     * 
     * Variables:
     *      int n = s.length()
     *      int[][] length      (size = n x n)
     * 
     * Algorithm:
     *      1)  Initialize variables
     *      2)  Loop for index i from n - 1 to 0
     *              Set length[i][i] = 1 (subsequences of length 1 automatically palindromic)
     *              Loop for index j from i+1 to n - 1
     *                  If char(i) == char(j)
     *                      Set length[i][j] = length[i+1][j-1] + 2
     *                  Else
     *                      Set length[i][j] = max(length[i+1][j], length[i][j-1])
     *      3)  Return length[0][n - 1]
     * 
     * Notes:
     *      1)  length[i][j] = length[i+1][j-1] + 2 if char(i) == char(j)
     *      2)  length[i][j] = max(length[i+1][j], length[i][j-1]) if char(i) != char(j)
     *      3)  To calculate value at i, we need i+1, so start at i+1 and work backwards (s.length()-1 to 0)
     *      4)  To calculate value at j, we need j-1, so start at j-1 and work upwards (from i+1 to s.length() - 1)
     * 
     * Cases:
     *      1)  Null or empty string (return 0)
     *      2)  Length 1 (return 1)
     *      3)  Length 2 (return 2 if char at i and i+1 are equal, else 0)
     *      4)  Length 3+ (see algorithm)
     * 
     */
    public int longestPalindromeSubseq2(String s) {
        
        // Case 1
        if (s == null || "".equals(s)) return 0;
        
        // Cases 2, 3 and 4
        int n = s.length();
        int[][] length = new int[n][n];
        
        for (int i = n-1; i >= 0; --i) {
            
            length[i][i] = 1;
            
            for (int j = i+1; j < n; ++j) {
                
                if (s.charAt(i) == s.charAt(j)) {
                    length[i][j] = length[i+1][j-1] + 2;        // 2 because both ends are equal
                } else {
                    length[i][j] = Math.max(length[i+1][j], length[i][j-1]);
                }
                
            }
        }
        
        return length[0][n-1];
    }
    
    public int longestPalindromeSubseq3(String s) {
        
        // Case 1
        if (s == null || "".equals(s)) return 0;
        
        // Cases 2, 3 and 4
        int n = s.length();
        int[][] cache = new int[n][n];
        
        return getLength(s, 0, n-1, cache);
    }
    
    private int getLength(String s, int start, int end, int[][] cache) {
        
        // Step 1
        if (start == end) return 1;
        
        // Step 2
        if (start > end) return 0;
        
        // Step 3
        if (cache[start][end] != 0) return cache[start][end];
        
        // Step 4
        if (s.charAt(start) == s.charAt(end)) {
            cache[start][end] = getLength(s, start+1, end-1, cache) + 2;
        } else {
            cache[start][end] = Math.max(getLength(s, start+1, end, cache), getLength(s, start, end-1, cache)); 
        }
        
        return cache[start][end];
    }
}
