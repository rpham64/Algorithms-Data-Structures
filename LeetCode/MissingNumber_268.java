package LeetCode;

/**
 * Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, 
 * find the one that is missing from the array.

	For example,
	Given nums = [0, 1, 3] return 2.
	
	Note:
	Your algorithm should run in linear runtime complexity. 
	Could you implement it using only constant extra space complexity?
 *
 * @author Rudolf
 *
 */
public class MissingNumber_268 {

	/**
	 * Discrete Math solution
	 * 
	 * Time Complexity: O(n)
	 * Space Complexity: O(1)
	 * 
	 * @param nums
	 * @return
	 */
    public int missingNumber(int[] nums) {
        
        if (nums == null || nums.length == 0) return -1;
        
        int totalSum = 0;
        long actualSum = nums.length * (nums.length + 1) / 2;
        
        for (int num : nums) totalSum += num;
        
        return (int) actualSum - totalSum;
    }
}
