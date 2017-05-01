package Strings;

/**
 * Given a string, you need to reverse the order of characters in each word 
 * within a sentence while still preserving whitespace and initial word order.

	Example 1:
	
	Input: "Let's take LeetCode contest"
	Output: "s'teL ekat edoCteeL tsetnoc"
	
	Note: In the string, each word is separated by single space and there will not be any extra space in the string.
 * 
 * @author Rudolf
 *
 */
public class ReverseWordsInAStringIII_557 {

	/**
     * Solutions:
     *      1)  Split string by whitespaces. Then, iterate through the string array and reverse each string by char.
     *          Create stringbuilder and append each string with whitespace. Return result.
     *              - Time Complexity: O(n) + O(len(array)*k) + O(n) = O(n + len(array)*k) where k is number of chars, n is num of strings
     *              - Space Complexity: O(len(s))
     *      2)  Split string by whitespaces. Iterate through string and reverse entire strings using StringBuilder#reverse.
     *          Create new StringBuilder and append each string with whitespace.
     *              - Time and Space same as #1
     *      3)  Create new StringBuilder. Find index of whitespace. Then, from index i = start to whitespaceIndex, append char of string
     *          to StringBuilder. Repeat until index of whitespace is null (we reached last string). Append char of last string from
     *          length of whole string to last whitespace. Return result.
     *              - Time: O(k) where k is the number of chars in s
     *              - Space: O(k)
     * 
     * Variables:
     *      String[] strings = s.split()
     *      StringBuilder reversed (returns reversed form of current string) 
     *      StringBuilder result (returns s with reversed strings)
     * 
     * Algorithm (sol #2):
     *      1)  Create variables String[] strings and StringBuilder result
     *      2)  Split s and store into strings[]
     *      3)  Create StringBuilder reversed for first string and add to result
     *      4)  Loop for index i = 1 to end of strings[]
     *              Append whitespace to result
     *              Create StringBuilder reversed and append to result
     *      5)  Return result as string
     * 
     * Cases:
     *      1)  Empty or null string (return s)
     *      2)  Length 1 (return s)
     *      3)  Length 2+ (follow algorithm above)
     */
    public String reverseWords(String s) {
        
        // Cases 1 and 2
        if (s == null || "".equals(s) || s.length() < 2) return s;
        
        // Case 3
        String[] strings = s.split(" ");
        String reversedFirst = new StringBuilder(strings[0]).reverse().toString();
        StringBuilder result = new StringBuilder(reversedFirst);
        
        for (int i = 1; i < strings.length; ++i) {
            String reversed = new StringBuilder(strings[i]).reverse().toString();
            result.append(" ").append(reversed);
        }
        
        return result.toString();
    }
    
    /*
     * Two Pointers: Using pointer start and end, increment end until end reaches s.length.
    *                      If char at end is a whitespace or end is at s.length
    *                          Reverse subtring from start to end-1.
    *                          Set start := end + 1
    *                      Increment end
    *        - Time Complexity: O(n)
    *        - Space Complexity: O(n)
    */
    public String reverseWords2(String s) {
        
        // Case 1
        if (s == null || s.length() < 2) return s;
        
        // Case 2
        char[] letters = s.toCharArray();
        int start = 0;
        int end = 0;
        
        while (end < s.length()) {
            
            if (letters[end] == ' ') {
                reverse(letters, start, end-1);
                start = end + 1;
            }
            
            end++;
        }
        
        // Reverse last string (not covered in while loop)
        reverse(letters, start, end - 1);
        
        return String.valueOf(letters);
    }
    
    private void reverse(char[] letters, int start, int end) {
        while (start < end) {
            char temp = letters[start];
            letters[start] = letters[end];
            letters[end] = temp;
            
            start++;
            end--;
        }
    }
}
