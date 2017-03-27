package LeetCode_Medium;

public class LongestPalindromicSubstring_5 {

	private int start;          // Starting index of longest palindrome
    private int maxLength;      // Length of longest palindrome
    
    /**
     * Examples:
     *      1) "babba"          s = "bab"
     *      2) "babad"          s = "aba" or "bab"
     *      3) "a"              s = "a"
     *      4) "abccbad"        s = "abccba"
     *      5) "aaaabcaaaaa"    s = "aaaaa"
     * 
     * Idea: For each character in s, check if that character is the middle of a palindromic substring.
     *      In other words, from that character, iterate left and right and compare the two characters. 
     *      If it's a match, extend left and right until they are no longer the same. This is then the current palindromic substring.
     *      If this substring's length is longer than the stored "maxLength", increment the "start" index and store the new maxLength.
     * 
     * Cases:
     *      1) Null string OR length 0 (return s)
     *      2) Length of 1 (return s, by default)
     *      3) Length 2 or more (apply idea above and return new palindromic substring from s)
     */
    public String longestPalindrome(String s) {
        
        // Case 1
        if ("".equals(s) || s.length() == 0) return s;
        
        // Case 2
        if (s.length() == 1) return s;
        
        // Case 3
        start = 0;
        maxLength = 0;
        
        for (int i = 0; i < s.length() - 1; ++i) {
            getPalindrome(s, i, i);     // Odd length (only 1 char in middle)
            getPalindrome(s, i, i+1);   // Even length (2 chars in middle)
        }
        
        return s.substring(start, start + maxLength);
    }
    
    private void getPalindrome(String s, int left, int right) {
        
        // Compare char at left and right
        // If equal, decrement left and increment right
        // Continue until left or right is out of bounds, or both chars are not equal
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        
        // Two cases:
        //      1) Left/Right is out of bounds (or both)
        //      2) Left and right are the ends of our palindrome
        //
        // Examples:
        //      1) index 0..4   =>  left = -1, right = 5    =>  length = 5 (right - left - 1)
        //      2) index 0..3   =>  left = -1, right = 4    =>  length = 4 (right - left - 1)
        if (maxLength < right - left - 1) {
            start = left + 1;
            maxLength = right - left - 1;
        }
    }
}
