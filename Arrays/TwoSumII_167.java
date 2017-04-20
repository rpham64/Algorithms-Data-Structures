package Arrays;

/**
 * Given an array of integers that is already sorted in ascending order, 
 * find two numbers such that they add up to a specific target number.

	The function twoSum should return indices of the two numbers such that they add up to the target, 
	where index1 must be less than index2. 
	Please note that your returned answers (both index1 and index2) are not zero-based.
	
	You may assume that each input would have exactly one solution and you may not use the same element twice.
	
	Input: numbers={2, 7, 11, 15}, target=9
	Output: index1=1, index2=2
 * 
 * @author Rudolf
 *
 */
public class TwoSumII_167 {

	/**
     * Solutions:
     *      1)  Brute Force: Iterate through numbers and compare every other number. Sum both numbers and determine if equal to target.
     *          - Time Complexity: O(n^2)
     *          - Space Complexity: O(1)
     *      2)  Binary Search: Iterate through numbers[] and use binary search on rest of numbers[]. 
     *                          If complement exists, add current index and complement index to int[] and return.
     *          - Time Complexity: O(n log n)
     *          - Space Complexity: O(1)
     *      3)  Two pointers: Check leftmost and right most int and sum. If sum is too low, raise the left. Else, lower the right.
     *                      Continue until left >= right or correct sum is found. 
     *          - Time Complexity: O(n)
     *          - Space Complexity: O(1)
     * 
     * Variables:
     *      int[] result = new int[2]
     *      int left = 0
     *      int right = numbers.length - 1
     * 
     * Algorithm:
     * 
     * Cases:
     *      1)  Numbers is null or empty (return {0, 0})
     *      2)  Length is 1 (return {0, 0} since can't be same element twice)
     *      3)  Length is 2+ (see algorithm)
     */
    public int[] twoSum(int[] numbers, int target) {
        
        // Cases 1 and 2
        if (numbers.length < 2) return new int[2];
        
        // Case 3
        int[] result = new int[2];
        int left = 0;
        int right = numbers.length - 1;
        
        while (left < right) {
            
            int sum = numbers[left] + numbers[right];
            
            if (sum == target) {
                result[0] = left + 1;
                result[1] = right + 1;
                return result;
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
            
        }
        
        return result;
    }
}
