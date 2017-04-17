package DynamicProgramming;

/**
 * You are climbing a stair case. It takes n steps to reach to the top.

Each time you can either climb 1 or 2 steps. 
In how many distinct ways can you climb to the top?
 * 
 * @author Rudolf
 *
 */
public class ClimbingStairs_70 {

	/**
     * Solutions:
     *      1)  Dynamic Programming
     *          - Time Complexity: O(n)
     *          - Space Complexity: O(n+1)
     *      2)  Memoization
     *          - Time Complexity: O(n)
     *          - Space Complexity: O(n+1)
     *      3)  Brute Force
     *          - Time Complexity: O(n)
     *          - Space Complexity: O(1)        (Store and re-store only final result)
     *      4)	Top-down Recursion (Memoization w/o caching)
     *      	- Time Complexity: O(2^n)
     *      	- Space Complexity: O(1)
     * 
     * Variables:
     *      int result = 0      (Formula: result = a + b)
     *      int a = 2
     *      int b = 1
     * 
     * Algorithm:
     *      If n < 3, return n  (base cases)
     *      Initialize result, a, b
     *      Loop for int i from 3 to n
     *          result := a + b
     *          b := a
     *          a := result
     *      Return result
     * 
     * Cases:
     *  Bases:
     *      1)  n = 0 (return 0)
     *      2)  n = 1 (return 1)
     *      3)  n = 2 (return 2)
     *  Inductive:
     *      4)  n = 3 (return 3)
     *      5)  n = 4 (return 5)
     *      ....
     */
    public int climbStairs(int n) {
        
        if (n < 3) return n;
        
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        
        for (int i = 3; i <= n; ++i) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        
        return dp[n];
    }
    
    public int climbStairs2(int n) {
        int[] cache = new int[n+1];
        return climbStairs2(n, cache);
    }
    
    private int climbStairs2(int n, int[] cache) {
        
        // Check Cache
        if (cache[n] != 0) return cache[n];
        
        if (n < 3) {
            cache[n] = n;
        } else {
            cache[n] = climbStairs2(n-1, cache) + climbStairs2(n-2, cache);
        }
        
        return cache[n];
    }
    
    public int climbStairs3(int n) {
        
        if (n < 3) return n;
        
        int result = 0;
        int a = 2;
        int b = 1;
        
        for (int i = 3; i <= n; ++i) {
            result = a + b;
            b = a;
            a = result;
        }
        
        return result;
    }
    
    /**
     * Note: Time limit exceeded on LeetCode
     * 
     * @param n
     * @return
     */
    public int climbStairs4(int n) {
        
        // Base Case
        if (n < 3) return n;
        
        // Inductive Case
        return climbStairs(n-1) + climbStairs(n-2);
    }
}
