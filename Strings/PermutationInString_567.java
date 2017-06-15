package Strings;

/**
 * Given two strings s1 and s2, write a function to return true if s2 contains the permutation of s1. 
 * In other words, one of the first string's permutations is the substring of the second string.
	
	Example 1:
	
	Input:s1 = "ab" s2 = "eidbaooo"
	Output:True
	
	Explanation: s2 contains one permutation of s1 ("ba").
	
	Example 2:
	
	Input:s1= "ab" s2 = "eidboaoo"
	Output: False
	
	Note:
	The input strings only contain lower case letters.
	The length of both given strings is in range [1, 10,000].
 * 
 * @author Rudolf
 *
 */
public class PermutationInString_567 {

	/**
	 * Sliding Window Algorithm
	 * 
	 * Time Complexity: O(n + m) where n is length of s1, m is length of s2
	 * Space Complexity: O(1)
	 * 
	 * @param s1
	 * @param s2
	 * @return
	 */
	public boolean checkInclusion(String s1, String s2) {
        
        int[] count = new int[128];
        int counter = 0;
        int start = 0;
        int end = 0;
        int len = s1.length();
        
        for (char c : s1.toCharArray()) count[c]++;
        
        while (end < s2.length()) {
            
            char charEnd = s2.charAt(end);
            
            if (--count[charEnd] >= 0) counter++;
            end++;
            
            // Window has right amount of valid chars but varying length
            while (counter == len) {
                
                // Valid window with right length = true
                if (end - start == len) return true;
                
                char charStart = s2.charAt(start);
                
                if (++count[charStart] >= 1) counter--;
                start++;
            }
        }
        
        return false;
    }
	
	/**
     * Brute Force
     * 
     * Time Complexity: O(nm)
     * Space Complexity: O(n) where n is number of chars in s1
     * 
     * Cases:
     *      1)  s1 null (return true)
     *      2)  s2 null (return s1 == s2)
     *      3)  s1 length > s2 length (return false)
     *      4)  s1 length <= s2 length (algo)
     * 
     */
    public boolean checkInclusion2(String s1, String s2) {
        
        for (int i = 0; i <= s2.length() - s1.length(); ++i) {
            if (isPermutation(s1, s2.substring(i, i + s1.length()))) return true;
        }
        
        return false;
    }
    
    private boolean isPermutation(String s1, String s2) {
        int[] count = new int[26];
        for (char c : s1.toCharArray()) count[c - 'a']++;
        for (char c : s2.toCharArray()) count[c - 'a']--;
        
        for (int num : count) {
            if (num != 0) return false;
        }
        
        return true;
    }
}
