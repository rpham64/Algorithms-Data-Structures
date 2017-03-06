package LeetCode;

import java.util.HashMap;

/**
 * Given an array of integers, return indices of the two numbers 
 * such that they add up to a specific target.

	You may assume that each input would have exactly one solution.
	
	Example:
	Given nums = [2, 7, 11, 15], target = 9,
	
	Because nums[0] + nums[1] = 2 + 7 = 9,
	return [0, 1].
 * 
 * @author Rudolf
 *
 */
public class TwoSum_1 {
	
	/**
	 * Scenarios:
     *      1) Compare every pair in nums (Time: O(n^2), Space: O(1))
     *      2) Iterate through nums, use binary search to find complement (Time: O(n log n), Space: O(1))
     *      3) If sorted array, iterate from start and end, comparing each pair of nums.
     *          If sum is too low, iterate right from start.
     *          If sum is too high, iterate left from end.
     *          If sum is equal, return the two indices.
     *              - Time: O(n)
     *              - Space: O(1)
     *      4) If unsorted or not sure, iterate through nums and use a hash table to keep track of visited numbers.
     *          If hash table contains current number's complement, return their indices.
     *              - Time: O(n)
     *              - Space: O(n)
     * 
	 */

	/** Data Structure used: HashTable. Time: O(n), Space: O(n) */
	public int[] twoSum(int[] nums, int target) {
        
        // Input Check: empty array
        if (nums.length == 0 || nums.length == 1) return nums;
        
        HashMap<Integer, Integer> map = new HashMap<>();    // <num, index>
        int[] answer = new int[2];
        
        // Check for both numbers, if they exist
        for (int i = 0; i < nums.length; ++i) {
            
            int otherNum = target - nums[i];
            
            if (map.containsKey(otherNum)) {
                
                // Store indices of both numbers
                answer[1] = i;
                answer[0] = map.get(otherNum);
                
                return answer;
            }
            
            map.put(nums[i], i);
        }
        
        return answer;
    }
}
