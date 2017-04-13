package LeetCode;

/**
 * Write a function that takes a string as input and reverse only the vowels of a string.

	Example 1:
	Given s = "hello", return "holle".
	
	Example 2:
	Given s = "leetcode", return "leotcede".
	
	Note:
	The vowels does not include the letter "y".
 * 
 * @author Rudolf
 *
 */
public class ReverseVowelsInAString_345_2 {

	/**
     * Solutions:
     *      1)  Using two points at start and end, swap chars if both are vowels. Stop when start >= end
     *          - Time: 9 ms
     *          - Time Complexity: O(n) where k is length of s
     *          - Space Complexity: O(n) for storing all chars into a stringbuilder   
     *      2)  Create a char array storing the vowels of s. 
     *          Create a new StringBuilder result.
     *          Iterate through s.
     *              If current char is a vowel, append vowel from back of vowel array to result
     *              Else, append current char to result
     *          Return result as string
     *              - Time Complexity: O(n) where n is length of s
     *              - Space Complexity: O(n) for storing all characters of s into a stringbuilder
     *  
     * Variables:
     *      StringBuilder result (since strings are immutable, you can't modify the chars without StringBuilder)
     * 
     * Algorithm:
     *      1)  Create two pointers: start (=0) and end (=s.length() - 1)
     *      2)  Create StringBuilder result with s
     *      3)  Loop through s while start < end
     *              Increment start until char at start is a vowel and start < end
     *              Decrement end until char at end is a vowel and start < end
     *              Swap start and end chars
     *      4)  Return StringBuilder as string
     * 
     * Cases:
     *      1)  Empty OR null string (return s)
     *      2)  Length 1 (return s)
     *      3)  Length 2+ (see algorithm)
     * 
     */
    public String reverseVowels(String s) {
        
        // Cases 1 and 2
        if (s == null || "".equals(s) || s.length() < 2) return s;
        
        // Case 3
        StringBuilder result = new StringBuilder(s);
        int start = 0;
        int end = s.length() - 1;
        
        while (start < end) {
            
            // Increment start until char is vowel
            while (!isVowel(s.charAt(start)) && start < end) {
                start++;
            }
            
            // Decrement end until char is vowel
            while (!isVowel(s.charAt(end)) && start < end) {
                end--;
            }
            
            // Swap start and end in result
            if (start < end) {
                char temp = result.charAt(start);
                result.setCharAt(start, result.charAt(end));
                result.setCharAt(end, temp);
                
                // Change values to prevent infinite loop
                start++;
                end--;
            }
        }
        
        return result.toString();
    }
    
    public String reverseVowels2(String s) {
        
        // Cases 1 and 2
        if (s == null || "".equals(s) || s.length() < 2) return s;
        
        // Case 3
        StringBuilder builder = new StringBuilder();
        char[] vowels = new char[s.length()];
        int vowelsIndex = 0;
        
        // Fill vowels[]
        for (char c : s.toCharArray()) {
            if (isVowel(c)) vowels[vowelsIndex++] = c;
        }
        
        // Iterate through s and build StringBuilder
        for (char c : s.toCharArray()) {
            
            if (isVowel(c)) {
                builder.append(vowels[--vowelsIndex]);
            } else {
                builder.append(c);
            }
            
        }
        
        return builder.toString();
    }
    
    private boolean isVowel(char c) {
        return "AEIOUaeiou".indexOf(c) >= 0;
    }
}
