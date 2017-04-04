package Search;

/**
 * You have a total of n coins that you want to form in a staircase shape, 
 * where every k-th row must have exactly k coins.

	Given n, find the total number of full staircase rows that can be formed.
	
	n is a non-negative integer and fits within the range of a 32-bit signed integer.
	
	Example 1:
	
	n = 5
	
	The coins can form the following rows:
	
	*
	* *
	* *
	
	Because the 3rd row is incomplete, we return 2.
	
	Example 2:
	
	n = 8
	
	The coins can form the following rows:
	
	*
	* *
	* * *
	* *
	
	Because the 4th row is incomplete, we return 3.
 * 
 * @author Rudolf
 *
 */
public class ArrangingCoins_441 {

	/**
     * Idea: Given n, we want to find k such that n = k(k+1) / 2 (sum consecutives formula)
     * 
     * Proof: k^2 + k - 2n = 0      =>      k = (-1 + sqrt(1+8n)) / 2 where k > 0
     * 
     * Time Complexity: O(1)
     * Space Complexity: O(1)
     */
    public int arrangeCoins(int n) {
        return (int)(-1 + Math.sqrt(8 * (long)n + 1)) / 2;
    }
    
    /**
     * Idea: Loop from k = 0, sum the amount of coins and compare to n. 
     *      If sum is less than n, increment k.
     *      If sum is equal to n, return k.
     *      If sum is greater than n, return k-1.   (sum went over at k, so k-1 is the total amount of complete rows)
     *      
     * Rows (k => currentSum):
     * 		0	=>	0
     * 		1	=>	1
     * 		2	=>	3
     * 		3	=>	6
     * 
     * Time Complexity: O(k) where k is the number of rows
     * Space Complexity: O(1)
     */
    public int arrangeCoins2(int n) {
        
        long sum = (long) n;        // In case of integer overflow
        int k = 0;
        long currentSum = 0;
        
        while (currentSum < sum) {
            currentSum += ++k;
        }
        
        // Sum should be at n or greater
        return currentSum == sum ? k : k-1;
    }
    
    /**
     * Idea: Apply binary search to find k using the consecutive sum formula (n = k(k+1) / 2)
     * 
     * Initialize:
     *      int k
     *      int start = 0       - Left range of k
     *      int end = 0         - Right range of k
     * 
     * Loop while start <= end
     *      Set k = start + (end - start) / 2
     *      If k(k+1)/2 <= n
     *          Set start = k + 1
     *      Else
     *          Set end = k - 1
     * 
     * Start and end will converge around the correct "k" value, so return start - 1
     * 
     * Time Complexity: O(log n)
     * Space Complexity: O(1)
     */
    public int arrangeCoins3(int n) {
        
        // Convert to long to prevent Integer overflows
        long sum = (long) n;
        
        long start = 0;
        long end = n;
        
        long mid = 0;
        
        while (start <= end) {
            
            mid = (start + end) >>> 1;
            
            if (mid*(mid+1) / 2 <= sum) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
            
        }
        
        return (int) start - 1;
    }
}
