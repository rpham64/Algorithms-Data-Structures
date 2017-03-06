package LeetCode;

import java.util.Arrays;

/**
 * Given two strings s and t, write a function to determine if t is an anagram of s.
	
	For example,
	s = "anagram", t = "nagaram", return true.
	s = "rat", t = "car", return false.
	
	Note:
	You may assume the string contains only lowercase alphabets.
	
	Follow up:
	What if the inputs contain unicode characters? 
	How would you adapt your solution to such case?
 * 
 * @author Rudolf
 *
 */
public class ValidAnagram_242 {

	/** Method 1 - Using Arrays library */
	public boolean isAnagram(String s, String t) {
		
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        
        Arrays.sort(sChars);
        Arrays.sort(tChars);
        
        return Arrays.equals(sChars, tChars);
    }
	
	/** Method 2 - Using counting array */
	public boolean isAnagram2(String s, String t) {
        
        int[] count = new int[128];		// Number of ASCII characters
        
        for (char c : s.toCharArray()) {
            count[c - '0']++;
        }
        
        for (char c : t.toCharArray()) {
            count[c - '0']--;
        }
        
        for (int num : count) {
            if (num != 0) return false;
        }
        return true;
    }
	
}
