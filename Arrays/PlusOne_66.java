package Arrays;

/**
 * Given a non-negative number represented as an array of digits, 
 * plus one to the number.

	The digits are stored such that the most significant digit 
	is at the head of the list.
 * 
 * @author Rudolf
 *
 */
public class PlusOne_66 {

	/** Time: O(n), Space: O(1) if digits not all 9's, else O(n) */
	public int[] plusOne(int[] digits) {
        
        // Input Check: empty array
        if (digits == null || digits.length == 0) return digits;
        
        int n = digits.length;
        
        for (int i = n-1; i >= 0; --i) {
            
            // 0 to 8
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            
            // 9
            digits[i] = 0;
        }
        
        // New number
        int[] newNumber = new int[n + 1];
        newNumber[0] = 1;
        
        for (int i = 1; i < newNumber.length; ++i) {
            newNumber[i] = digits[i-1];
        }
        
        return newNumber;
    }
}
