package Strings;

/**
 * Given a string, your task is to count how many palindromic substrings in this string.
	
	The substrings with different start indexes or end indexes are counted as different 
	substrings even they consist of same characters.
	
	Example 1:
	
	Input: "abc"
	Output: 3
	
	Explanation: Three palindromic strings: "a", "b", "c".
	
	Example 2:
	
	Input: "aaa"
	Output: 6
	
	Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".
	
	Note: The input string length won't exceed 1000.
 * 
 * Source: https://leetcode.com/problems/palindromic-substrings/description/
 * 
 * @author Rudolf
 *
 */
public class PalindromicSubstrings_647 {
	
	private int count = 0;
    
	/**
	 * Brute Force solution.
	 * 
	 * Time: O(n^2)
	 * Space: O(1)
	 * 
	 * Iterate through each character of s and, using the current character as the
	 * "middle of a palindrome", increment count and extend the palindrome.
	 * 
	 * @param s
	 * @return
	 */
    public int countSubstrings(String s) {
        if (s == null || s.length() == 0) return 0;
        
        for (int i = 0; i < s.length(); ++i) {
            extendPalindrome(s, i, i);  // Odd length
            extendPalindrome(s, i, i+1);  // Even length
        }
        
        return count;
    }
    
    private void extendPalindrome(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            count++;
            left--;
            right++;
        }
    }
}
