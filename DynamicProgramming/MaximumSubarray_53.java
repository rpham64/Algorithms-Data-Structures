package DynamicProgramming;

/**
 * Find the contiguous subarray within an array 
 * (containing at least one number) which has the largest sum.

	For example, given the array [-2,1,-3,4,-1,2,1,-5,4],
	the contiguous subarray [4,-1,2,1] has the largest sum = 6.
 * 
 * Reference: https://en.wikipedia.org/wiki/Maximum_subarray_problem
 * 
 * @author Rudolf
 *
 */
public class MaximumSubarray_53 {

	/** Method Used: Kadane's Algorithm */
	public int maxSubArray(int[] nums) {
        
        // Input Check: empty array
        if (nums.length == 0) return 0;
        
        int maxSumSoFar = nums[0];
        int maxSumEndingHere = nums[0];
        
        for (int i = 1; i < nums.length; ++i) {
            
            maxSumEndingHere = Math.max(nums[i], maxSumEndingHere + nums[i]);
            
            maxSumSoFar = Math.max(maxSumSoFar, maxSumEndingHere);
        }
        
        return maxSumSoFar;
    }
}
