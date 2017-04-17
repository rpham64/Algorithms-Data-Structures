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
	
	/**
     * Solutions:
     *      1)  Brute Force: Compare every possible subarray of nums and store the largest sum.
     *              - Time Complexity: O(n^2)
     *              - Space Complexity: O(n^2)
     *      2)  Dynamic Programming
     * 
     * Variables:
     *      int n = nums.length
     *      int[][] sums        (size = n * n)
     *      int maxSum
     * 
     * Algorithm:
     *      Initialize n and sums[][]
     *      Fill sums[][] with sums from subarrays of length 1
     *          Check if current sum > maxSum
     *      Fill rest of sums[][] with sums from subarrays of length 2+
     *          Check if current sum > maxSum
     *      Return maxSum
     * 
     * Cases:
     *      1)  Default (given nums is not null nor empty)
     *      
     * Formula: sums(i, j) = sums(i, j-1) + nums(j)
     */
    public int maxSubArray(int[] nums) {
        
        int n = nums.length;
        int[][] sums = new int[n][n];
        int maxSum = Integer.MIN_VALUE;
        
        // Fill with subarrays of length 1
        for (int i = 0; i < n; ++i) {
            sums[i][i] = nums[i];
            maxSum = Math.max(maxSum, sums[i][i]);
        }
        
        // Fill with subarrays of length 2+
        for (int i = 0; i < n-1; ++i) {
            
            for (int j = i+1; j < n; ++j) {
                
                sums[i][j] = nums[j] + sums[i][j-1];
                maxSum = Math.max(maxSum, sums[i][j]);
                
            }
            
        }
        
        return maxSum;
    }

	/** Method Used: Kadane's Algorithm */
	public int maxSubArray2(int[] nums) {
        
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
