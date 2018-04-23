package DynamicProgramming;

/**
 * You are given coins of different denominations and a total amount of money amount. 
 * Write a function to compute the fewest number of coins that you need to make up that amount. 
 * If that amount of money cannot be made up by any combination of the coins, return -1.
	
	Example 1:
	
	coins = [1, 2, 5], amount = 11
	return 3 (11 = 5 + 5 + 1)
	
	Example 2:
	
	coins = [2], amount = 3
	return -1.
	
	Note:
	You may assume that you have an infinite number of each kind of coin.
 * 
 * Source: https://leetcode.com/problems/coin-change/description/
 * Solution: https://leetcode.com/problems/coin-change/solution/
 * 
 * @author rpham
 * Date: 4/23/18
 *
 */
public class CoinChange_322 {

    /**
     * Easier to Understand Solution from GeeksForGeeks.
     * Source: https://www.geeksforgeeks.org/find-minimum-number-of-coins-that-make-a-change/
     * 
     * Dynamic Programming (Bottom-up Tabulation)
     * 
     * Time: O(amount * n) where n is the number of coins in coins[].
     * Space: O(amount) since we're storing the counts for all amounts from 0 up to the given amount.
     * 
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange(int[] coins, int amount) {
        if (amount < 1) return 0;
        
        int[] count = new int[amount + 1];
        
        // Base Case: Count for amount 0 is simply 0.
        count[0] = 0;
        
        // Initialize all count values from 1 to end to be infinite.
        // Just like Dijkstra's, we don't know these counts and, since we want the minimum
        // counts, we'll initially set them to infinite and set them to smaller counts as we go.
        for (int i = 1; i < count.length; ++i) count[i] = Integer.MAX_VALUE;
        
        // Compute minimum count of coins for all amounts from 1 up to the input amount.
        for (int sum = 1; sum <= amount; ++sum) {
            // Iterate through all coins and get the smallest count.
            for (int coin : coins) {
                if (coin > sum) continue;  // Current coin is too big.
                
                int otherCount = count[sum - coin];  // Stored count after subtracting current coin from current amount, if it exists.
                
                // Check if new count (1 + otherCount) is smaller than the stored count for the given sum.
                // If so, store it as count[sum].
                if (otherCount != Integer.MAX_VALUE && 1 + otherCount < count[sum]) {  
                    count[sum] = 1 + otherCount;
                }
            }
        }
        
        return count[amount] == Integer.MAX_VALUE ? -1 : count[amount];
    }
    
    
    
    
    
	
	/**
    *   DP Algorithm (bottom-up)
    *
    *   Idea: Number of Coins = 1 + min(helper(amount - coin1), helper(amount - coin2), ..., helper(amount - coin n))
    *   
    *   Time: O(S*n) where S is the amount and n is the denomination count.
    *   Space: O(S) where S is the amount that's used to initialize the counts[].
    */
    public int coinChange2(int[] coins, int amount) {
        if (amount < 1) return 0;
        return getCount(coins, amount, new int[amount + 1]);  // 3rd parameter is the cache for num counts of amounts 0 ... amount.
    }
    
    private int getCount(int[] coins, int remainder, int[] counts) {
        if (remainder < 0) return -1;  // No possible combinations, so return -1.
        if (remainder == 0) return 0;  // Remainder is already 0, so we have nothing to do here. Return 0.
        if (counts[remainder] != 0) return counts[remainder];  // Return cached result if visited.
        
        int minCount = Integer.MAX_VALUE;
        
        // Calculate minCount.
        for (int coin : coins) {
            int otherCount = getCount(coins, remainder - coin, counts);  // Num Coins to Get Amount After Subtracting Current Coin
            if (otherCount >= 0 && otherCount < minCount) {  // otherCount >= 0 means that the combination is possible to add up to amount.
                minCount = 1 + otherCount;  // Current Coin + Num Coins After Current Coin
            }
        }
        
        counts[remainder] = minCount == Integer.MAX_VALUE ? -1 : minCount;
        return counts[remainder];
    }
}
