package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? 
 * Find all unique triplets in the array which gives the sum of zero.
	
	Note: The solution set must not contain duplicate triplets.
	
	For example, given array S = [-1, 0, 1, 2, -1, -4],
	
	A solution set is:
	
	[
	  [-1, 0, 1],
	  [-1, -1, 2]
	]
 * 
 * @author Rudolf
 *
 */
public class ThreeSum_15 {

	/**
     * Iteration + Two-Sum Solution
     * 
     * - Time Complexity: O(n^2)
     * - Space Complexity: C(n, 3) = O(n^3)
     * 
     * Idea: Iterate through each num in nums and apply Two Sum (review question) on rest of array.
     *      Using the two sum result, determine if it equals the compliment of the current num (ie. sum = -current).
     *      If so, the sum of all three numbers is 0, hence add them to the result.
     */
	public List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length < 3) return new ArrayList<>();
        
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        
        for (int i = 0; i <= nums.length - 3; ++i) {
            if (i > 0 && nums[i] == nums[i-1]) continue;
            
            int current = nums[i];
            int left = i + 1;
            int right = nums.length - 1;
            
            while (left < right) {
                int sum = current + nums[left] + nums[right];
                
                if (sum == 0) {
                    // Found a solution set
                    result.add(Arrays.asList(current, nums[left], nums[right]));
                    
                    // Move left and right pointers
                    left++;
                    right--;
                    
                    // Skip duplicates from left and right, if they exist
                    while (left < right && nums[left] == nums[left - 1]) left++;
                    while (left < right && nums[right] == nums[right + 1]) right--;
                    
                } else if (sum > 0) {
                    // Too big, so move right pointer.
                    right--;
                } else {
                    // Too small, so move left pointer.
                    left++;
                }
            }
        }
        
        return result;
    }
}
