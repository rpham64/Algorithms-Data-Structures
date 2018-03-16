package DynamicProgramming;

/**
 * On a staircase, the i-th step has some non-negative cost cost[i] assigned (0 indexed).
	
	Once you pay the cost, you can either climb one or two steps. 
	You need to find minimum cost to reach the top of the floor, and you can either 
	start from the step with index 0, or the step with index 1.
	
	Example 1:
	
	Input: cost = [10, 15, 20]
	Output: 15
	
	Explanation: Cheapest is start on cost[1], pay that cost and go to the top.
	
	Example 2:
	
	Input: cost = [1, 100, 1, 1, 1, 100, 1, 1, 100, 1]
	Output: 6
	
	Explanation: Cheapest is start on cost[0], and only step on 1s, skipping cost[3].
	
	Note:
	cost will have a length in the range [2, 1000].
	Every cost[i] will be an integer in the range [0, 999].
 * 
 * @author Rudolf
 *
 */
public class MinCostClimbingStairs_746 {

    public int minCostClimbingStairs(int[] cost) {
        int[] minCosts = new int[cost.length + 1];  // Extra slot for the top step.
        
        // Initial Values
        minCosts[0] = cost[0];
        minCosts[1] = cost[1];
        
        for (int step = 2; step <= cost.length; ++step) {
            int currentCost = (step == cost.length) ? 0 : cost[step];  // If top step, set cost to 0.
            minCosts[step] = Math.min(minCosts[step - 2] + currentCost, minCosts[step - 1] + currentCost);
        }
        
        return minCosts[minCosts.length - 1];
    }
}
