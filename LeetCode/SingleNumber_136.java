package LeetCode;

import java.util.Arrays;

/**
 * Given an array of integers, every element appears 
 * twice except for one. Find that single one.
 * 
 * @author Rudolf
 *
 */
public class SingleNumber_136 {

	public int singleNumber(int[] nums) {
        
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
