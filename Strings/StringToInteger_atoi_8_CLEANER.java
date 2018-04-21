/**
 * Implement atoi which converts a string to an integer.
	
	The function first discards as many whitespace characters as necessary until the first non-whitespace character is found. 
	Then, starting from this character, takes an optional initial plus or minus sign followed by as many numerical digits as 
	possible, and interprets them as a numerical value.
	
	The string can contain additional characters after those that form the integral number, which are ignored and have no effect 
	on the behavior of this function.
	
	If the first sequence of non-whitespace characters in str is not a valid integral number, or if no such sequence exists because 
	either str is empty or it contains only whitespace characters, no conversion is performed.
	
	If no valid conversion could be performed, a zero value is returned.
	
	Note:
	Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [-231,  231 - 1]. 
	If the numerical value is out of the range of representable values, INT_MAX (231 - 1) or INT_MIN (-231) is returned.
	
	Example 1:
	
	Input: "42"
	Output: 42
	Example 2:
	
	Input: "   -42"
	Output: -42
	Explanation: The first non-whitespace character is '-', which is the minus sign.
	             Then take as many numerical digits as possible, which gets 42.
	Example 3:
	
	Input: "4193 with words"
	Output: 4193
	Explanation: Conversion stops at digit '3' as the next character is not a numerical digit.
	Example 4:
	
	Input: "words and 987"
	Output: 0
	Explanation: The first non-whitespace character is 'w', which is not a numerical 
	             digit or a +/- sign. Therefore no valid conversion could be performed.
	Example 5:
	
	Input: "-91283472332"
	Output: -2147483648
	Explanation: The number "-91283472332" is out of the range of a 32-bit signed integer.
	             Thefore INT_MIN (-231) is returned.
 * 
 * Source: https://leetcode.com/problems/string-to-integer-atoi/description/
 * 
 * @author rpham
 * Date: 4/21/18
 *
 */
public class StringToInteger_atoi_8_CLEANER {

	/**
	    *   Cases:
	    *       1) Str is empty (return 0)
	    *       2) Str contains only whitespace characters (return 0)
	    *           - Trimming results in case 1 too.
	    *
	    *   Iteration Cases:
	    *       3) First character after trimming is not a +, -, or valid number (break loop)
	    *       4) Character is + or -
	    *           - If '+', continue
	    *           - If '-', set sign := -1 and change final result to negative.
	    *       5) Character is a digit
	    *           - Multiply current result by 10 and add the digit
	    *
	    *   Final Cases:
	    *       - Change result to negative if isNegative is true.
	    *
	    *       6) Result is greater than the max int (return INT_MAX)
	    *       7) Result is less than the min int (return INT_MIN)
	    *       8) Default: Cast result to int and return.
	    *       
	    * Time: O(n) where n is the number of characters in str.
	    * Space: O(n)
	    */
	    public int myAtoi(String str) {
	        // Case 1
	        if (str == null) return 0;
	        
	        str = str.trim();
	        
	        // Case 2
	        if (str.length() == 0) return 0;  // All whitespaces
	        
	        double sum = 0;
	        int sign = 1;
	        boolean hadSign = false;
	        
	        for (char c : str.toCharArray()) {
	            // Case 3
	            if (!isSign(c) && !isDigit(c)) {
	                break;
	            }
	            
	            // Case 4
	            if (isSign(c)) {
	                if (hadSign) {
	                    // Already got a sign, so c is invalid.
	                    break;
	                }
	                if (c == '-') {
	                    sign = -1;
	                }
	                hadSign = true;
	            }
	            
	            // Case 5
	            if (isDigit(c)) {
	                sum = sum * 10 + (c - '0');
	            }
	        }
	        
	        sum *= sign;
	        
	        // Case 6
	        if (sum > Integer.MAX_VALUE) return Integer.MAX_VALUE;
	        
	        // Case 7
	        if (sum < Integer.MIN_VALUE) return Integer.MIN_VALUE;
	        
	        // Case 8 (default)
	        return (int) sum;
	    }
	    
	    private boolean isSign(char c) {
	        return c == '+' || c == '-';
	    }
	    
	    private boolean isDigit(char c) {
	        return c >= '0' && c <= '9';
	    }
}
