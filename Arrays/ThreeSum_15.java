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
     * 
     * Variables:
     *      List<List<Integer>> result
     * 
     * Algorithm:
     *      Sort nums[]
     *      Loop for int i from 0 to n - 3
     *          If i > 0 AND nums[i] == nums[i-1] continue      (skip duplicates)
     *          Set low := i + 1
     *              high := n - 1
     *          Loop while low < high
     *              Set sum := nums[low] + nums[high]
     *              If sum == -nums[i]
     *                  Create new ArrayList and add nums[i], nums[low], nums[high]
     *                  Add arrayList to result list
     *                  Skip duplicates: 
     *                      Loop while low < high and nums[low] == nums[low + 1]
     *                          Increment low
     *                      Loop while low < high and nums[high] == nums[high - 1]
     *                          Decrement high
 *                  Else if sum > -nums[i]
 *                      Decrement high
 *                  Else
 *                      Increment low
 *          Return result
     * 
     * Cases:
     *      1)  Null or length < 3 (return empty list)
     *      2)  Length 3+ (see algo)
     * 
     */
    public List<List<Integer>> threeSum(int[] nums) {
    	
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        
        for (int i = 0; i < nums.length; ++i) {
            
            if (i > 0 && nums[i] == nums[i-1]) continue;
            
            int low = i + 1;
            int high = nums.length - 1;
            int complement = nums[i] * -1;
            
            while (low < high) {
                
                int sum = nums[low] + nums[high];
                
                if (sum == complement) {
                    
                    result.add(Arrays.asList(nums[i], nums[low], nums[high]));
                    
                    // Skip duplicates
                    while (low < high && nums[low] == nums[low+1]) {
                        low++;
                    }
                    while (low < high && nums[high] == nums[high-1]) {
                        high--;
                    }
                    low++;
                    high--;
                    
                } else if (sum > complement) {
                    high--;
                } else {
                    low++;
                }
            }
        }
        
        return result;
    }
}
