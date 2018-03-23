package Strings;

import java.util.HashMap;

/**
 * Given a string S and a string T, find the minimum window in S which will 
 * contain all the characters in T in complexity O(n).
	
	For example,
	
	S = "ADOBECODEBANC"
	T = "ABC"
	
	Minimum window is "BANC".
	
	Note:
	If there is no such window in S that covers all characters in T, return the empty string "".
	
	If there are multiple such windows, you are guaranteed that there will always 
	be only one unique minimum window in S.
 * 
 * Solution: https://discuss.leetcode.com/topic/71783/sliding-window-algorithm-template-to-solve-all-the-leetcode-substring-search-problem
 * 
 * @author Rudolf
 *
 */
public class MinimumWindowSubstring_76 {

	/**
	 * Sliding Window Algorithm
	 * 
	 * Time: O(n)
	 * Space: O(k) where k is the number of unique characters in t (size of map)
	 * 
	 * @param s
	 * @param t
	 * @return
	 */
	public String minWindow(String s, String t) {
        
        if (t.length() > s.length()) return "";
        
        int start = 0;
        int end = 0;
        HashMap<Character, Integer> map = new HashMap<>();  // Letter -> Frequency
        int minStart = 0;
        int minLength = Integer.MAX_VALUE;
        
        // Fill hashmap with chars from t
        for (char c : t.toCharArray()) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }
        
        int counter = map.size();  // Number of unique chars. Using t.length() may result in duplicates.
        
        while (end < s.length()) {
            
            char charEnd = s.charAt(end);
            if (map.containsKey(charEnd)) {
                map.put(charEnd, map.get(charEnd) - 1);
                
                if (map.get(charEnd) == 0) counter--;
            }
            
            while (counter == 0) {
                
                // Found valid window
                if (end - start + 1 < minLength) {
                    minStart = start;
                    minLength = end - start + 1;
                }
                
                // Adjust start to tighten the window
                char charStart = s.charAt(start);
                if (map.containsKey(charStart)) {
                    map.put(charStart, map.get(charStart) + 1);
                    
                    if (map.get(charStart) > 0) counter++;
                }
                
                start++;
            }
            
            end++;
        }
        
        // If minLength is unchanged, return ""
        if (minLength == Integer.MAX_VALUE) return "";
        
        return s.substring(minStart, minStart + minLength);
    }
}
