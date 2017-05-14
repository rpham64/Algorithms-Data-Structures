package Arrays;

import java.util.Arrays;

/**
 * Given an array S of n integers, find three integers in S such that the sum is closest 
 * to a given number, target. Return the sum of the three integers. 
 * You may assume that each input would have exactly one solution.

    For example, given array S = {-1 2 1 -4}, and target = 1.

    The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 * 
 * @author Rudolf
 *
 */
public class ThreeSum_Closest_16 {

	public int threeSumClosest(int[] nums, int target) {
        
        int n = nums.length;
        int result = nums[0] + nums[1] + nums[n-1];     	// Initial sum
        int minDifference = Math.abs(target - result);		// Range: 0 to ...
        
        Arrays.sort(nums);
        
        for (int i = 0; i <= n - 3; ++i) {
            
            int low = i + 1;
            int high = n - 1;
            
            while (low < high) {
                
                int sum = nums[i] + nums[low] + nums[high];
                
                if (sum == target) {
                    return sum;
                } else if (sum > target) {
                    high--;
                } else {
                    low++;
                }
                
                if (Math.abs(sum - target) < minDifference) {
                    minDifference = Math.abs(sum - target);
                    result = sum;
                }
            }
        }
        
        return result;
    }
}
