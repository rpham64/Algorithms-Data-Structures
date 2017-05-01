package Strings;

/**
 * Implement atoi to convert a string to an integer.
	
	Hint: Carefully consider all possible input cases. 
	If you want a challenge, please do not see below and ask yourself what are the possible input cases.
	
	Notes: It is intended for this problem to be specified vaguely (ie, no given input specs). 
	You are responsible to gather all the input requirements up front.
 * 
 * Requirements for atoi:
 * 
	The function first discards as many whitespace characters as necessary until the first 
	non-whitespace character is found. Then, starting from this character, takes an optional 
	initial plus or minus sign followed by as many numerical digits as possible, 
	and interprets them as a numerical value.
	
	The string can contain additional characters after those that form the integral number, 
	which are ignored and have no effect on the behavior of this function.
	
	If the first sequence of non-whitespace characters in str is not a valid integral number, 
	or if no such sequence exists because either str is empty or it contains only whitespace characters, 
	no conversion is performed.
	
	If no valid conversion could be performed, a zero value is returned. 
	If the correct value is out of the range of representable values, INT_MAX (2147483647) or 
	INT_MIN (-2147483648) is returned.
 * 
 * 
 * @author Rudolf
 *
 */
public class StringToInteger_atoi_8 {
	
	/**
     * Variables:
     *      double value = 0            (range = Integer.MIN_VALUE to Integer.MAX_VALUE)
     *      int sign = 1                (Either "+" or "-" if we run into one)
     *      int index = 0               (for iterating through str)
     * 
     * Types of Characters:
     *      1)  Alphabetical (a-z, A-Z)
     *      2)  Numerical (0-9)
     *      3)  Signs (+, -)
     *      4)  Non-alphanumerical (!@#$%^&*())
     *      5)  Whitespaces (' ')
     * 
     * Cases:
     *      1)  str is null or empty (return 0)
     *      2)  str is non-null and length 1+
     */
    public int myAtoi(String str) {
        
        // Case 1
        if (str == null || str.length() == 0) return 0;
        
        // Case 2
        double value = 0;
        int sign = 1;
        int index = 0;
        
        // 1) Remove whitespaces
        while (str.charAt(index) == ' ' && index < str.length()) {
            index++;
        }
        
        // 2) Check sign
        if (isSign(str.charAt(index)) && index < str.length()) {
            if (str.charAt(index) == '-') {
                sign = -1;
            }
            index++;
        }
        
        // 3) Convert and add numbers to value
        while (isNumerical(str.charAt(index)) && index < str.length()) {
            
            int num = str.charAt(index) - '0';
            value = value*10 + num;
            
            index++;
        }
        
        // 4) Handle int overflow/underflow
        value *= sign;
        
        if (value > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        } else if (value < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }
        
        return (int) value;
    }
    

	/**
	 * Naive Implementation
	 * 
     * Variables:
     *      long value = 0          (range = INT_MIN to INT_MAX)
     *      char sign = '+'         (Either "+" or "-" if we run into one)
     * 
     * Algorithm:
     *      Loop for index i from 0 to str.length - 1
     *          Set char c = str.charAt(i)
     *          If c is type 5, continue
     *          Else if c is type 2 or 3
     *              If c is '+' or '-' AND sign is null
     *                  Set sign = c
     *                  Increment index i
     *              If i >= str.length, break (out of bounds)
     *              Loop while str.charAt(i) is numerical   (build value)
     *                  int val = c - '0'
     *                  value = value*10 + val
     *                  Increment index i
     *                  If i >= str.length, break (out of bounds)
     *              break   (finished building)
     *          Else (type 1, 4)
     *              Return 0
     * 
     *      If sign == '-'
     *          value *= -1
     * 
     *      If value > MAX_VALUE
     *          return MAX_VALUE
     *      Else if value < MIN_VALUE
     *          return MIN_VALUE
     * 
     *      Return value
     * 
     * Types of Characters:
     *      1)  Alphabetical (a-z, A-Z)
     *      2)  Numerical (0-9)
     *      3)  Signs (+, -)
     *      4)  Non-alphanumerical (!@#$%^&*())
     *      5)  Whitespaces (' ')
     * 
     * Cases:
     *      1)  str is null or empty (return 0)
     *      2)  str is non-null and length 1+
     */
    public int myAtoi2(String str) {
        
        // Case 1
        if (str == null || str.length() == 0) return 0;
        
        // Case 2
        double value = 0;
        char sign = '+';
        
        for (int i = 0; i < str.length(); ++i) {
            
            char c = str.charAt(i);
            
            // Whitespace
            if (c == ' ') continue;      // Continue until first non-whitespace character
            
            if (isNumerical(c) || isSign(c)) {       // Found valid char, so build value and break loop when finished
                
                // Check if c starts with sign
                if (c == '+' || c == '-') {
                    sign = c;
                    i++;
                }
                
                if (i >= str.length()) break;
                
                // Build value
                while (str.charAt(i) >= '0' && str.charAt(i) <= '9') {
                    
                    value = value*10 + (str.charAt(i) - '0');
                    i++;
                    
                    if (i >= str.length()) break;
                }
                
                // Finished building value, so break out of for loop
                break;
                
            } else {        // Invalid char (alphabetical, non-alphanumerical)
                return 0;   // No conversion done
            }
        }
        
        if (sign == '-') value *= -1;
        
        if (value > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        } else if (value < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }
        
        return (int) value;
    }
    
    private boolean isNumerical(Character c) {
        return c >= '0' && c <= '9';
    }
    
    private boolean isSign(Character c) {
        return c == '-' || c == '+';
    }
}
