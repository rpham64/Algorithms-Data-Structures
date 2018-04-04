import java.util.HashMap;

/**
 * Implementation of the Fibonacci sequence using brute force, dynamic programming, and memoization.
 * 
 * @author Rudolf
 * Date: 4/3/18
 *
 */
public class Fibonacci_Example {

	/**
	 * Fibonacci Sequence: 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, ...
	 * 
	 * Given some n:
	 * 
	n : F(n)=factorisation
	0 : 0
	1 : 1
	2 : 1
	3 : 2
	4 : 3
	5 : 5
	6 : 8 = 23
	7 : 13
	8 : 21 = 3 x 7
	9 : 34 = 2 x 17
	10 : 55 = 5 x 11
	11 : 89
	12 : 144 = 24 x 32
	13 : 233
	14 : 377 = 13 x 29
	15 : 610 = 2 x 5 x 61
	16 : 987 = 3 x 7 x 47
	17 : 1597
	18 : 2584 = 23 x 17 x 19
	19 : 4181 = 37 x 113
	20 : 6765 = 3 x 5 x 11 x 41
	 */
	
	/**
	 * Brute Force Implementation
	 * 
	 * Given some n, outputs the number at the n-th position in the fibonacci sequence.
	 * 
	 * @param n
	 * @return
	 */
	public int fib(int n) {
		if (n == 0) return 0;
		if (n == 1) return 1;
		return fib(n-1) + fib(n-2);  // For n > 1
	}
	
	/**
	 * Dynamic Programming Implementation
	 * 
	 * @param n
	 * @return
	 */
	public int fib_DP(int n) {
		if (n == 0) return 0;
		if (n == 1) return 1;
		
		int[] dp = new int[n+1];  // Since we want to return n-th element.
		dp[0] = 0;
		dp[1] = 1;
		
		// Build up the dp array.
		for (int i = 2; i <= n; ++i) {
			dp[i] = dp[i-1] + dp[i-2];
		}
		
		return dp[n];
	}
	
	/**
	 * Memoization Implementation
	 * 
	 * @param n
	 * @return
	 */
	public int fib_MEMOIZATION(int n) {
		if (n == 0) return 0;
		if (n == 1) return 1;
		
		// Create cache.
		HashMap<Integer, Integer> cache = new HashMap<>();
		
		// Store base cases.
		cache.put(0, 0);
		cache.put(1, 1);
		
		// Call helper function.
		return fib_MEMOIZATION(n, cache);
	}
	
	private int fib_MEMOIZATION(int n, HashMap<Integer, Integer> cache) {
		if (cache.containsKey(n)) return cache.get(n);
		
		// Compute fibonacci value for given n.
		int value = fib_MEMOIZATION(n-1, cache) + fib_MEMOIZATION(n-2, cache);
		
		// Store value and n into cache.
		cache.put(n, value);
		
		return value;
	}
}
