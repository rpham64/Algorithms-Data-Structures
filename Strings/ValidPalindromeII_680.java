/**
 * Given a non-empty string s, you may delete at most one character. 
 * Judge whether you can make it a palindrome.
	
	Example 1:
	
	Input: "aba"
	Output: True
	
	Example 2:
	
	Input: "abca"
	Output: True
	
	Explanation: You could delete the character 'c'.
	
	Note:
	The string will only contain lowercase characters a-z. The maximum length of the string is 50000.
 * 
 * @author Rudolf
 *
 */
public class ValidPalindromeII_680 {

	/**
    * Cases
    *       abcdba  => Iteration stops on 'c' and 'd' 
    *               => Check "d" and "c" to see if one or both are palindromes 
    *               => Return true
    *
    *       bcdba   => Iteration stops on 'b' and 'a' 
    *               => Check "cdba" and "bcdb" to see if one or both are palindromes 
    *               => Return false
    */
    public boolean validPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        
        while (left <= right) {
            if (s.charAt(left) != s.charAt(right)) {
                // Skip left char and check if the rest of the string is a palindrome.
                // Then, skip right char and check if the new string is a palindrome.
                // If either result is true, then the original String s is a valid palindrome.
                return isPalindrome(s, left + 1, right) || isPalindrome(s, left, right - 1);
            }
            left++;
            right--;
        }
        
        return true;  // Valid palindrome
    }
    
    private boolean isPalindrome(String s, int start, int end) {
        while (start <= end) {
            if (s.charAt(start) != s.charAt(end)) return false;
            start++;
            end--;
        }
        
        return true;
    }
}
