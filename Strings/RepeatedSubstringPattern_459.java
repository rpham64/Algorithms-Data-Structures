package Strings;

/**
 * Given a non-empty string check if it can be constructed by taking a 
 * substring of it and appending multiple copies of the substring together. 
 * You may assume the given string consists of lowercase English letters 
 * only and its length will not exceed 10000.
 * 
	Example 1:
	
	Input: "abab"
	Output: True
	
	Explanation: It's the substring "ab" twice.
	
	Example 2:
	
	Input: "aba"
	Output: False
	
	Example 3:
	
	Input: "abcabcabcabc"
	Output: True
	
	Explanation: It's the substring "abc" four times. (And the substring "abcabc" twice.)
 * 
 * @author Rudolf
 *
 */
public class RepeatedSubstringPattern_459 {

	public boolean repeatedSubstringPattern(String s) {
        
        if (s == null || s.length() == 0) return false;
        
        for (int len = 1; len <= s.length() / 2; ++len) {
            if (s.length() % len != 0) continue;  // Not a divisor of s.length()
            
            String sub = s.substring(0, len);
            StringBuilder builder = new StringBuilder();
            while (builder.length() < s.length()) builder.append(sub);
            
            if (builder.toString().equals(s)) return true;
        }
        
        return false;
    }
}
