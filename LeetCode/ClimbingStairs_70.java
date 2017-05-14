package LeetCode;

/**
 * You are climbing a stair case. It takes n steps to reach to the top.
 * 
 * Each time you can either climb 1 or 2 steps. 
 * In how many distinct ways can you climb to the top?
 * 
 * Solution: http://www.shuatiblog.com/blog/2014/05/21/Climbing-Stairs/
 * 
 * @author Rudolf
 *
 */
public class ClimbingStairs_70 {

	/**
     * Fibonacci Sequence
     */
    public static int climbStairs(int n) {
        
        // Input Check: if n < 0, return -1
        if (n < 0) return -1;
        
        // Edge Case: if n == 0, return 0
        if (n == 0) return 0;
        
        // Base Case: if n == 1 or n == 2, return n
        if (n == 1 || n == 2) return n;
        
        // Iterative Case (non-recursive)
        int a = 2;
        int b = 1;
        int numOfSteps = 0;
        
        for (int i = 3; i <= n; i++) {
            numOfSteps = a + b;
            b = a;
            a = numOfSteps;
        }
        
        return numOfSteps;
    }
    
    public static void main(String[] args) {
    	
    	for (int i = 0; i < 10; i++) {
    		System.out.println(i + ": " + climbStairs(i));
    	}
    	
    }
	
}
