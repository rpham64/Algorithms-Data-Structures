package LeetCode;

import java.util.Arrays;

/**
 * Given an array of integers, every element appears twice except for one. 
 * Find that single one.
 * 
 * Source: https://leetcode.com/problems/single-number/description/
 * 
 * @author Rudolf
 *
 */
public class SingleNumber_136 {
	
	/**
    *   Solutions:
    *       1) HashSet + Iterator
    *           - For each num in nums[], add to HashSet. If set contains num, remove it from hashset. Only the unique num will be left.
    *           - Use iterator to print the unique num.
    *           - Time: O(n)
    *           - Space: O(n)
    *       2) Counting Array
    *           - Time: O(n) (requires two passes: one for creating the counting array, another for checking which has count 1.
    *           - Space: O(n) (n/2, which is still n)
    *       3) Bitwise XOR (optimal)
    *           - Note: True ^ True = False
    *                   True ^ False = True
    *                   False ^ True = True
    *                   False ^ False = False
    *           - Proof: 
    *           		N1 ^ N1 ^ N2 ^ N2 ^ ... ^ Nn ^ Nn ^ N 
    *           		= 0 ^ N 
    *           		= N
    */
    public int singleNumber(int[] nums) {
        int result = 0;
        
        for (int i = 0; i < nums.length; ++i) {
            result ^= nums[i];
        }
        
        return result;
    }

	/**
	 * Naive Implementation
	 * 
	 * Time: O(n log n) (due to array sorting)
	 * Space: O(n) (if using mergesort)
	 * 
	 * @param nums
	 * @return
	 */
	public int singleNumber2(int[] nums) {
        
        // Input Check: if nums is empty, return -1
        if (nums.length == 0) return -1;
        
        // Base Case: 1 element
        if (nums.length == 1) return nums[0];
        
        // Sort array
        Arrays.sort(nums);
        
        // Iterate through and check for element occuring once
        for (int i = 0; i < nums.length - 1; i++) {
            
            // Current and next are duplicates
            if (nums[i] == nums[i+1]) {
                i++;    // Increment i to skip next duplicate
            }
            else {
                // Found non-duplicate
                return nums[i];
            }
            
        }
        
        return nums[nums.length - 1];
    }
}
