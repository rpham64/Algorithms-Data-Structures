package LeetCode;

/**
 * Given a string, determine if it is a palindrome, 
 * considering only alphanumeric characters and ignoring cases.

For example,
"A man, a plan, a canal: Panama" is a palindrome.
"race a car" is not a palindrome.

Note:
Have you consider that the string might be empty? 
This is a good question to ask during an interview.

For the purpose of this problem, we define empty string as valid palindrome.
 * 
 * @author Rudolf
 *
 */
public class ValidPalindrome_125 {

	public boolean isPalindrome(String s) {
        
        // Input Check: if s is null, return true
        if (s == null) return true;
        
        // Iterative Case: Assume string length is 1 or more
        int left = 0;
        int right = s.length() - 1;
        s = s.toLowerCase();
        
        while (left < right) {
            
            // Case 1: Check if left character is a valid character
            if (!isValidChar(s.charAt(left))) {
                left++;
            }
            
            // Case 2: Check if right character is a valid character
            else if (!isValidChar(s.charAt(right))) {
                right--;
            }
            
            // Case 3: Check if left and right characters are equal
            else {
                if (s.charAt(left) != s.charAt(right)) {
                    return false;
                }
                
                // If equal, increment left and decrement right
                left++;
                right--;
            }
            
        }
        
        return true;
    }
    
    private boolean isValidChar(char c) {
        boolean isLetter = (c >= 'a' && c <= 'z');
        boolean isNumber = (c >= '0' && c <= '9');
        
        return isLetter || isNumber;
    }
	
	
}
