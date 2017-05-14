package LeetCode_Medium;

import java.util.HashMap;

/**
 * Given a string, find the length of the longest substring without repeating characters.

	Examples:
	
	Given "abcabcbb", the answer is "abc", which the length is 3.
	
	Given "bbbbb", the answer is "b", with the length of 1.
	
	Given "pwwkew", the answer is "wke", with the length of 3. 
	Note that the answer must be a substring, 
	"pwke" is a subsequence and not a substring.
 * 
 * Reference: https://leetcode.com/discuss/23883/11-line-simple-java-solution-o-n-with-explanation
 * 
 * @author Rudolf
 *
 */
public class LongestSubstringWithoutRepeatingChars_3 {

	public int lengthOfLongestSubstring(String s) {
        
        // Input Check: empty string
        if ("".equals(s) || s == null) return 0;
        
        // map: <char, index in string s>
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int maxLength = 0;	// Of substring
        
        for (int start = 0, end = 0; end < s.length(); ++end) {
            
            char c = s.charAt(end);
            
            if (map.containsKey(c)) {
                // If end is a duplicate character, 
            	// increment start to the previous character's index + 1
                start = Math.max(start, map.get(c) + 1);
            }
            map.put(c, end);
            maxLength = Math.max(maxLength, end - start + 1);
        }
        
        return maxLength;
    }
	
}
