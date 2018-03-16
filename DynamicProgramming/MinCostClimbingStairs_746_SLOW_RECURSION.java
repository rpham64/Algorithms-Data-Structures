package DynamicProgramming;

/**
 * On a staircase, the i-th step has some non-negative cost cost[i] assigned (0 indexed).
	
	Once you pay the cost, you can either climb one or two steps. 
	You need to find minimum cost to reach the top of the floor, and you can either start 
	from the step with index 0, or the step with index 1.
	
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
 * Source: https://leetcode.com/problems/min-cost-climbing-stairs/description/
 * @author Rudolf
 *
 */
public class MinCostClimbingStairs_746_SLOW_RECURSION {

    /**
    * Algorithm:
    *       Pay cost of current step (index i)
    *       Compare the costs of steps i+1 and i+2
    *           If i+1 or i+2 is out of bounds, set that step's cost to 0
    *       Set i to step with minimum cost.
    *       Break loop if i is out of bounds.
    */
    public int minCostClimbingStairs(int[] cost) {
        int costAtIndexZero = getCost(cost, 0);
        int costAtIndexOne = getCost(cost, 1);
        return Math.min(costAtIndexZero, costAtIndexOne);
    }
    
    private int getCost(int[] cost, int startIndex) {
        if (startIndex >= cost.length) return 0;
        
        int costInOneStep = getCost(cost, startIndex + 1);
        int costInTwoSteps = getCost(cost, startIndex + 2);
        return cost[startIndex] + Math.min(costInOneStep, costInTwoSteps);
    }
}
