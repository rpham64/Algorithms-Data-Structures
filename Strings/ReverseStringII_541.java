package Strings;

/**
 * Given a string and an integer k, you need to reverse the first k characters 
 * for every 2k characters counting from the start of the string. 
 * If there are less than k characters left, reverse all of them. 
 * If there are less than 2k but greater than or equal to k characters, 
 * then reverse the first k characters and left the other as original.
 * 
	Example:
	
	Input: s = "abcdefg", k = 2
	Output: "bacdfeg"
	
	Restrictions:
	The string consists of lower English letters only.
	Length of the given string and k will in the range [1, 10000]
 * 
 * @author Rudolf
 *
 */
public class ReverseStringII_541 {

	/**
     * Idea: For every 2k characters, swap the first k characters using two pointers: start, end.
     *      Start index starts at 0 and increments by 2k, and end index is either start+k-1 or n-1 (less than k chars left).
     *      Reverse operation is simply swapping start and end chars and moving inwards until start >= end.
     */
    public String reverseStr(String s, int k) {
        
        char[] letters = s.toCharArray();
        int n = s.length();
        
        for (int start = 0; start < n; start += 2*k) {
            int end = Math.min(start + k - 1, n - 1);
            swap(letters, start, end);
        }
        
        return String.valueOf(letters);
    }
    
    private void swap(char[] letters, int start, int end) {
        while (start < end) {
            char temp = letters[start];
            letters[start] = letters[end];
            letters[end] = temp;
            
            start++;
            end--;
        }
    }
}
