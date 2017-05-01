package Strings;

public class LongestPalindromicSubstring_Local_5 {

	public String longestPalindrome(String s) {
        
        if (s == null || s.length() < 2) return s;
        
        String longestSub = "";
        
        for (int i = 0; i < s.length() - 1; ++i) {
            String s1 = getPalindrome(s, i, i);     // Odd Length
            String s2 = getPalindrome(s, i, i+1);   // Even Length
            
            if (s1.length() > longestSub.length()) longestSub = s1;
            if (s2.length() > longestSub.length()) longestSub = s2;
        }
        
        return longestSub;
    }
    
    private String getPalindrome(String s, int left, int right) {
        while (left >= 0 && right <= s.length() - 1 && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        
        return s.substring(left+1, right);
    }
}
