package DynamicProgramming;

/**
 * You are a professional robber planning to rob houses along a street. 
 * Each house has a certain amount of money stashed, the only constraint 
 * stopping you from robbing each of them is that adjacent houses have 
 * security system connected and it will automatically contact the police 
 * if two adjacent houses were broken into on the same night.

Given a list of non-negative integers representing the amount of money 
of each house, determine the maximum amount of money you can rob tonight 
without alerting the police.
 * 
 * 
 * Solution: https://leetcode.com/discuss/99352/well-explained-java-dynamic-programming-style-good-beginners
 * 
 * @author Rudolf
 *
 */
public class HouseRobber_198 {

	public int rob(int[] nums) {
        
        // Input Check: empty array
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        
        int[] profit = new int[nums.length];
        
        // Base Case 1: current house (i=0)
        profit[0] = nums[0];
        
        // Base Case 2: compare previous and current house (i=1)
        profit[1] = Math.max(nums[0], nums[1]);
        
        // Iterative Case: compare profit[i-2] + nums[i] and profit[i-1]
        for (int i = 2; i < nums.length; ++i) {
            profit[i] = Math.max(profit[i-2] + nums[i], profit[i-1]);
        }
        
        return profit[nums.length - 1];     // Last entry contains max profit
    }
	
}
