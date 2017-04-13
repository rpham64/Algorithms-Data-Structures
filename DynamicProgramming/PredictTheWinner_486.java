package DynamicProgramming;

/**
 * Given an array of scores that are non-negative integers. 
 * Player 1 picks one of the numbers from either end of the array followed by 
 * the player 2 and then player 1 and so on. Each time a player picks a number, 
 * that number will not be available for the next player. This continues until all 
 * the scores have been chosen. The player with the maximum score wins.

	Given an array of scores, predict whether player 1 is the winner. 
	You can assume each player plays to maximize his score.
	
	Example 1:
	
	Input: [1, 5, 2]
	Output: False
	
	Explanation: Initially, player 1 can choose between 1 and 2. 
	If he chooses 2 (or 1), then player 2 can choose from 1 (or 2) and 5. 
	If player 2 chooses 5, then player 1 will be left with 1 (or 2). 
	So, final score of player 1 is 1 + 2 = 3, and player 2 is 5. 
	Hence, player 1 will never be the winner and you need to return False.
	
	Example 2:
	
	Input: [1, 5, 233, 7]
	Output: True
	
	Explanation: Player 1 first chooses 1. Then player 2 have to choose between 5 and 7. 
	No matter which number player 2 choose, player 1 can choose 233.
	Finally, player 1 has more score (234) than player 2 (12), so you need to 
	return True representing player1 can win.
	
	Note:
	
	1 <= length of the array <= 20.
	Any scores in the given array are non-negative integers and will not exceed 10,000,000.
	If the scores of both players are equal, then player 1 is still the winner.
 * 
 * @author Rudolf
 *
 */
public class PredictTheWinner_486 {

	/**
	 * Time: 71 ms
	 * Time Complexity: O(2^n) ???
	 * 
     * Idea: Each player wants to win by always making the optimal move.
     *      For player 1 to win, his sum must be greater than player 2's.
     *      Think of each number that player 1 picks as a GAIN (+) and each
     *      number that player 2 picks as a LOSS (-).
     * 
     * Algorithm:
     *      1)  Apply recursion on the array, tightening the bound on each move:
     *              Using a helper function with int start, int end, and int[] nums as parameters:
     *                  If start == end, return nums[end]
     *                  Else,
     *                      return max(nums[end] - helper(nums, start, end-1), nums[start] - helper(num, start+1, end))
     * 
     * Note:
     *      1)  nums[end] - helper(nums, start, end-1) refers to if player 1 picks from end, leaving start...end-1 to player 2
     *      2)  nums[start] - helper(nums, start+1, end) refers to if player 1 picks from start, leaving start+1...end to player 2
     */
    public boolean PredictTheWinner(int[] nums) {
        return helper(nums, 0, nums.length - 1) >= 0;
    }
    
    private int helper(int[] nums, int start, int end) {
        if (start == end) {
            return nums[end];
        } else {
            return Math.max(nums[end] - helper(nums, start, end-1), nums[start] - helper(nums, start+1, end));
        }
    }
    
    /**
     * Solution using Cache (memoization)
     * 
     * Time: 6 ms
     * Time Complexity: O(n)
     * 
     * @param nums
     * @return
     */
    
    public boolean PredictTheWinner_CACHE(int[] nums) {
        return helper_CACHE(nums, 0, nums.length - 1, new Integer[nums.length][nums.length]) >= 0;
    }
    
    private int helper_CACHE(int[] nums, int start, int end, Integer[][] cache) {
        if (cache[start][end] == null) {
            if (start == end) {
                cache[start][end] = nums[end];
            } else {
                cache[start][end] = Math.max(nums[end] - helper_CACHE(nums, start, end-1, cache), nums[start] - helper_CACHE(nums, start+1, end, cache));
            }
        }
        return cache[start][end];
    }
}
