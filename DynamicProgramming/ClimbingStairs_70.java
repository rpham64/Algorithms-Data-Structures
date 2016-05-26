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

	public int climbStairs(int n) {
        
        // Base Case
        if (n == 0 || n == 1 || n == 2) return n;
        
        int num = 0;
        int a = 2;
        int b = 1;
        
        // Iterative Case (num = a + b)
        for (int i = 3; i <= n; ++i) {
            
            num = a + b;
            b = a;
            a = num;
            
        }
        
        return num;
    }
	
}
