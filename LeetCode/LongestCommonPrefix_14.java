package LeetCode;

/**
 * Write a function to find the longest common prefix 
 * string amongst an array of strings.
 * 
 * Reference: http://codereview.stackexchange.com/a/46967
 * 
 * @author Rudolf
 *
 */
public class LongestCommonPrefix_14 {

	public String longestCommonPrefix(String[] strs) {
        
        // Input Check: if strs is empty, return ""
        if (strs.length == 0) return "";    // or NULL
        
        // Check prefix characters using first string in strs
        for (int prefixLength = 0; prefixLength < strs[0].length(); prefixLength++) {
            
            // Letter to compare to
            char c = strs[0].charAt(prefixLength);
            
            for (int i = 1; i < strs.length; i++) {
            	
            	String currentString = strs[i];
                
                if (prefixLength >= currentString.length() || 
                		currentString.charAt(prefixLength) != c) {
                	
                	// Mismatch found
                    return strs[0].substring(0, prefixLength);
                }
                
            }
            
        }
        
        // Default: common prefix is whole string
        return strs[0];
    }
	
}
