package LeetCode;

public class RepeatedSubstringPattern_459 {

	/**
     * Idea: Given a string s of length n, only substrings whose length is a divisor of n can be a repeating pattern.
     *      In other words, for s of length 10, only substrings of length 1, 2, 5 can be repeating.
     *      So, for all substrings from length i = 1 to n/2, repeat that substring n/i times and compare the final
     *      result with string s. If equal, return true.
     * 
     * Cases:
     *      1) Null string OR length < 2 (return false, by default)
     *      2) Length 2+
     */
    public boolean repeatedSubstringPattern(String s) {
        
        // Case 1
        if (s == null || "".equals(s) || s.length() < 2) return false;
        
        // Case 2
        int lengthOfString = s.length();     // Length of s
        
        for (int lengthOfSub = 1; lengthOfSub <= lengthOfString / 2; ++lengthOfSub) {      // Length of substring
            
            // Check if i is a divisor of n (cuts out majority of lengths that would automatically return false)
            if (lengthOfString % lengthOfSub == 0) {
                
                String sub = s.substring(0, lengthOfSub);     // Substring to match
                StringBuilder builder = new StringBuilder();
                int repeatCount = lengthOfString/lengthOfSub;
                
                for (int j = 0; j < repeatCount; ++j) {
                    builder.append(sub);
                }
                
                // Check if built string matches s
                if (builder.toString().equals(s)) return true;
            }
            
        }
        
        return false;       // No repeating pattern
    }
}
