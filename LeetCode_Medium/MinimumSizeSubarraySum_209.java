package LeetCode_Medium;

/**
 * Given an array of n positive integers and a positive integer s, 
 * find the minimal length of a subarray of which the sum >= s. 
 * If there isn't one, return 0 instead.

	For example, given the array [2,3,1,2,4,3] and s = 7,
	the subarray [4,3] has the minimal length under the problem constraint.
 * 
 * @author Rudolf
 *
 */
public class MinimumSizeSubarraySum_209 {

	/** Running Time: O(n), Space: O(1) */
	public int minSubArrayLen(int s, int[] nums) {
        
        int start = 0;
        int end = 0;
        int length = Integer.MAX_VALUE;     // REQUIRED
        int sum = 0;
        
        while (end < nums.length) {
            
            sum += nums[end++];
            
            while (sum >= s) {
            	
                sum -= nums[start++];
                
                length = Math.min(length, end - start + 1);
                
            }
        }
        
        return length == Integer.MAX_VALUE ? 0 : length;
    }
}
