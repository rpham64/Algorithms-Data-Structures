package Strings;

/**
 * Method 1 ( Brute Force ) 
 * 
	The simple approach is to check each substring whether the substring is a palindrome or not. 
	We can run three loops, the outer two loops pick all substrings one by one by fixing the corner 
	characters, the inner loop checks whether the picked substring is palindrome or not.
	
	Time complexity: O ( n^3 )
	Auxiliary complexity: O ( 1 )
 * 
 * Taken from: http://www.geeksforgeeks.org/longest-palindrome-substring-set-1/
 * 
 * @author Rudolf
 *
 */
public class LongestPalindromicSubstring_5_BRUTE_FORCE {

	/**
     * BRUTE FORCE SOLUTION (untested)
     * 
     * Idea: Check every possible substring and check if it's a palindrome. If so, store it. If another palindromic substring comes up
     *      and is longer, store the new one.
     * 
     * Initialize String result
     * Loop for i from 0...end
     *      Loop for j from end...0
     *          Create substring s(i...j)
     *          If s(i...j) is palindrome, store the string as result
     * Return result
     * 
     * Cases:
     *      1) Null string OR length 0 (return s)
     *      2) Length 1 (return s, by default)
     *      3) Length 2+
     */
    public String longestPalindrome(String s) {
        
        // Case 1
        if (s == null || "".equals(s) || s.length() == 0) return s;
        
        // Case 2
        if (s.length() == 1) return s;
        
        // Case 3
        String result = "";
        
        for (int i = 0; i < s.length(); ++i) {
            for (int j = s.length(); j >= i; --j) {      // Exclusive in substring()
                
                String sub = s.substring(i, j);
                
                if (isPalindrome(sub) && sub.length() > result.length()) result = sub;
            }
        }
        
        return result;
    }
    
    /**
     * Idea: From start and end of string, compare the two characters.
     *      If equal, increment start and decrement end. Else, return false (not palindromic).
     *      Return true if start and end are at the middle of s.
     */
    private boolean isPalindrome(String s) {
        
        int left = 0;
        int right = s.length() - 1;
        
        while (left <= right) {
            if (s.charAt(left) == s.charAt(right)) {
                left++;
                right--;
            } else {
                return false;       // Not palindrome
            }
        }
        
        return true;
    }
}
