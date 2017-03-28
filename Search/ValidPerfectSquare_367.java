package Search;

/**
 * Given a positive integer num, write a function which returns True if num is a perfect square else False.

	Note: Do not use any built-in library function such as sqrt.
	
	Example 1:
	
	Input: 16
	Returns: True
	
	Example 2:
	
	Input: 14
	Returns: False
 * 
 * @author Rudolf
 *
 */
public class ValidPerfectSquare_367 {

	/**
     * Idea: For numbers 0 to num/2, use binary search and square the middle number.
     *      If the square is equal to num, return true.
     *      Else, if the square is less than num, raise the left index.
     *      Else, is the square is greater than num, lower the right index.
     *      Return false if no match found (not a perfect square).
     * 
     * Cases:
     *      1) num is 0 (return true, base case)
     *      2) num is 1 (return true, base case)
     *      3) num is 2 or more (use pseudocode)
     */
    public boolean isPerfectSquare(int num) {
        
        // Cases 1 and 2
        if (num < 2) return true;   // Base Case
        
        // Case 3
        long left = 0;
        long right = num/2;
        
        while (left <= right) {
            
            long mid = (left + right) / 2;
            long square = mid*mid;
            
            if (square == num) return true;
            
            if (square < num) {
                left = mid + 1;
            } else if (square > num) {
                right = mid - 1;
            }
        }
        
        return false;       // Not found
    }
}
