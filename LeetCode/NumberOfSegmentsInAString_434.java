package LeetCode;

/**
 * Count the number of segments in a string, where a segment is defined to be a 
 * contiguous sequence of non-space characters.

	Please note that the string does not contain any non-printable characters.
	
	Example:
	
	Input: "Hello, my name is John"
	Output: 5
 * 
 * @author Rudolf
 *
 */
public class NumberOfSegmentsInAString_434 {

	/**
     * Pseudocode:
     * 
     * Initialize int counter to 0, boolean isSpace to true
     * If isSpace is true and current char is not space
     *      Set isSpace to false
     *      Increment counter
     * Else if isSpace is false and current char is a space
     *      Set isSpace to true
     * Return counter
     * 
     * Cases:
     *      1) Empty string (return 0)
     *      2) String only contains spaces (return 0)
     *      3) String only contains non-spaces (return 1)
     *      4) String contains BOTH spaces and non-spaces
     *          a) If i = 0
     *              - Current is non-space (increment counter)
     *          b) If i > 0
     *              - Current is non-space but prev is space (increment counter)
     *              - Current is non-space but prev is non-space (do nothing)
     *              - Current is space (do nothing)
     */
    public int countSegments(String s) {
        
        // Case 1
        if (s == null || "".equals(s) || s.length() == 0) return 0;
        
        // Cases 2, 3 and 4
        int counter = 0;
        boolean isSpace = true;
        
        for (char c : s.toCharArray()) {
            
            if (isSpace && c != ' ') {
                isSpace = false;
                counter++;
            } else if (!isSpace && c == ' ') {
                isSpace = true;
            }
            
        }
        
        return counter;
    }
    
    public int countSegments2(String s) {
        
        // Case 1
        if (s == null || "".equals(s) || s.length() == 0) return 0;
        
        // Cases 2, 3, 4
        int counter = 0;
        
        for (int i = 0; i < s.length(); ++i) {
            
            if (s.charAt(i) != ' ') {
                
                // Case 4a
                if (i == 0) counter++;
                
                // Case 4b
                else if (s.charAt(i-1) == ' ') counter++;
            }
        }
        
        return counter;
    }
}
