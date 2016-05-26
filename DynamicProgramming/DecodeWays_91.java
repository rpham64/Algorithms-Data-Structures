package DynamicProgramming;

/**
 * A message containing letters from A-Z is being encoded to 
 * numbers using the following mapping:

	'A' -> 1
	'B' -> 2
	...
	'Z' -> 26
	
	Given an encoded message containing digits, 
	determine the total number of ways to decode it.
	
	For example,
	Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).
	
	The number of ways decoding "12" is 2.
 * 
 * Solution: https://leetcode.com/discuss/83547/java-clean-dp-solution-with-explanation
 * 
 * @author Rudolf
 *
 */
public class DecodeWays_91 {

	public int numDecodings(String s) {
        
        // Input Check: empty string
        if ("".equals(s) || s.length() == 0) return 0;
        
        int n = s.length();
        int[] dp = new int[n + 1];		// Each index i represents number of ways to decode
        								// string of length i
        
        dp[0] = 1;                              // 1 way to decode string of length 0
        dp[1] = s.charAt(0) != '0' ? 1 : 0;     // 1 way to decode string of length 1 if nonzero
        
        for (int i = 2; i <= n; ++i) {
            
            // Check single and double digits
            int singleDigit = Integer.valueOf(s.substring(i-1, i));
            int doubleDigit = Integer.valueOf(s.substring(i-2, i));
            
            if (singleDigit >= 1 && singleDigit <= 9) {
                dp[i] += dp[i-1];
            }
            if (doubleDigit >= 10 && doubleDigit <= 26) {
                dp[i] += dp[i-2];
            }
        }
        
        return dp[n];
    }
}
