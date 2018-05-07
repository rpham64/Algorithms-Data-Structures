package Math;

import java.util.HashSet;

/**
 * Write an algorithm to determine if a number is "happy".
	
	A happy number is a number defined by the following process: Starting with any 
	positive integer, replace the number by the sum of the squares of its digits, and 
	repeat the process until the number equals 1 (where it will stay), or it loops 
	endlessly in a cycle which does not include 1. Those numbers for which this 
	process ends in 1 are happy numbers.
	
	Example: 19 is a happy number
	
	12 + 92 = 82
	82 + 22 = 68
	62 + 82 = 100
	12 + 02 + 02 = 1

 * 
 * @author Rudolf
 *
 */
public class HappyNumber_202 {

	/**
	 * HashSet + Calculations Algorithm
	 * 
	 * Time: O(n) (???)
	 * Space: O(n) (???????????????)
	 * 
	 * @param n
	 * @return
	 */
	public boolean isHappy(int n) {
        if (n < 1) return false;  // Out of range.
        
        HashSet<Integer> visited = new HashSet<>();
        
        while (n != 1) {
            if (visited.contains(n)) return false;
            
            visited.add(n);
            n = getSum(n);
        }
        
        return true;  // n is a happy number.
    }
    
    // % 10 = last digit
    // / 10 = kicks out last digit
    private int getSum(int n) {
        int sum = 0;
        while (n > 0) {
            int lastDigit = n % 10;
            sum += (lastDigit * lastDigit);
            n /= 10;
        }
        return sum;
    }
}
