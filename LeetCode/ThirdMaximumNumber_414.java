package LeetCode;

public class ThirdMaximumNumber_414 {

	/**
	 * Note: int can't be null, but Integer CAN.
	 * 		Use "equals" for comparing Integers.
	 * 
     * Idea: Keep track of three maximums (1st, 2nd and 3rd maximum). Iterate through nums.
     *      If num is equal to 1st, 2nd or 3rd max, continue (no duplicates allowed)
     *      If num is greater than 1st max,
     *          Set 3rd max to 2nd max
     *          Set 2nd max to 1st max
     *          Set 1st max to this num
     *      If num is greater than 2nd max
     *          Set 3rd max to 2nd max
     *          Set 2nd max to this num
     *      If num is greater than 3rd max
     *          Set 3rd max to this num
     *      
     */
    public int thirdMax(int[] nums) {
        
        Integer max1 = null;
        Integer max2 = null;
        Integer max3 = null;
        
        for (Integer num : nums) {
            
            if (num.equals(max1) || num.equals(max2) || num.equals(max3)) continue;    // No duplicates allowed
            
            if (max1 == null || num > max1) {
                max3 = max2;
                max2 = max1;
                max1 = num;
            }
            else if (max2 == null || num > max2) {
                max3 = max2;
                max2 = num;
            }
            else if (max3 == null || num > max3) {
                max3 = num;
            }
        }
        
        // max3 could be null (example 2) or the right num
        // If null, return max1
        // Else, return max3
        return max3 == null ? max1 : max3;
    }
}
