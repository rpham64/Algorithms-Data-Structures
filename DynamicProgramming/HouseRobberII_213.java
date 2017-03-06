package DynamicProgramming;

/**
 * Note: This is an extension of House Robber.

	After robbing those houses on that street, the thief has found himself a new place for his 
	thievery so that he will not get too much attention. 
	This time, all houses at this place are arranged in a circle. 
	That means the first house is the neighbor of the last one. 
	Meanwhile, the security system for these houses remain the same as 
	for those in the previous street.
	
	Given a list of non-negative integers representing the amount of money of each house, 
	determine the maximum amount of money you can rob tonight without alerting the police.
 * 
 * Solution: http://www.programcreek.com/2014/05/leetcode-house-robber-ii-java/
 * 
 * @author Rudolf
 *
 */
public class HouseRobberII_213 {

	/**
     * Cases involving first and last houses:
     *      1) Include first, exclude last
     *          - Range: 0 to nums.length - 2
     *      2) Exclude first, include last  => Can include second
     *          - Range: 1 to nums.length - 1
     *      3) Exclude both                 => Can include second
     *          - Range: 1 to nums.length - 2
     *              => Same as House Robber I
     *              => Overlapped by cases 1 and 2 above
     * 
     * Normal Cases:
     *      1) Empty array
     *      2) 1 house
     *      3) 2 houses (wat)
     *      4) 3+ houses
     */
    public int rob(int[] nums) {
        
        // Case 1 & 3
        if (nums == null || nums.length == 0) return 0;
        
        // Case 2
        if (nums.length == 1) return nums[0];
        
        // Case 3
        if (nums.length == 2) return Math.max(nums[0], nums[1]);
    
        // Case 4
        return Math.max(rob(nums, 0, nums.length - 2), rob(nums, 1, nums.length - 1));
    }
    
    /**
     * Helper function for robbing a range of houses (from House Robber I)
     */
    private int rob(int[] nums, int low, int high) {
        
        if (low == high) return nums[low];
        
        int[] profit = new int[nums.length];
        
        profit[low] = nums[low];
        profit[low + 1] = Math.max(nums[low + 1], profit[low]);
        
        for (int i = low + 2; i <= high; ++i) {
            profit[i] = Math.max(profit[i-1], profit[i-2] + nums[i]);
        }
        
        return profit[high];    // Max profit for robbing houses low to high
    }
}
