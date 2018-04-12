package DynamicProgramming;

/**
 * Say you have an array for which the ith element is the 
 * price of a given stock on day i.

If you were only permitted to complete at most one transaction 
(ie, buy one and sell one share of the stock), design an algorithm 
to find the maximum profit.
 * 
 * Reference: http://stackoverflow.com/a/7086577
 * 
 * @author Rudolf
 *
 */
public class BestTimeToBuyAndSellStock_121 {

	/**
	 * Dyanmic Programming Solution
	 * 
	 * Time: O(n) where n is the number of prices in prices[].
	 * Space: O(1) for the ints maxProfit and min.
	 * 
	 * @param prices
	 * @return
	 */
	public int maxProfit(int[] prices) {
        
        // Input Check: empty array
        if (prices.length == 0) return 0;
        
        // Base Case: buy/sell pair occurs at i=0
        int maxProfit = 0;  // Global Max Profit
        int min = prices[0];  // Running Minimum
        
        // Iterative Case
        for (int i = 1; i < prices.length; ++i) {
            
            maxProfit = Math.max(prices[i] - min, maxProfit);
            min = Math.min(prices[i], min);
            
        }
        
        return maxProfit;
    }
}
