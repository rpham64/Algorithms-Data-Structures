package Strings;


/**
 * Given a string, find the first non-repeating character in it and return it's index. 
 * If it doesn't exist, return -1.
	
	Examples:
	
	s = "leetcode"
	return 0.
	
	s = "loveleetcode",
	return 2.
	
	Note: You may assume the string contain only lowercase letters.
 * 
 * @author rpham
 *
 */
public class FirstUniqueCharacterInAString_387 {

	public int firstUniqChar(String s) {
        int[] chars = new int[26];
        
        // Count frequencies of each char in s
        for (char c : s.toCharArray()) {
            chars[c - 'a']++;
        }
        
        // Find first char in s with count 1
        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            if (chars[c - 'a'] == 1) return i;
        }
        
        return -1;
    }
}
