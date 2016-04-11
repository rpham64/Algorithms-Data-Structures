package LeetCode;

import java.math.BigInteger;

public class UniquePaths_62 {
	
	/**
     * Can only move down m-1 times and right n-1 times
     * 
     * "Move until robot reaches finish at bottom-right corner of grid" => From (0,0) -> (m-1, n-1)
     * 
     * Number of Steps = (m-1) + (n-1) = m + n - 2
     * Number of Unique Paths = (m + n - 2) choose (m - 1) = (m + n - 2)! / (m-1)!(n-1)!
     */
    public int uniquePaths(int m, int n) {
        return (int) (factorial(m+n-2) / (factorial(m-1)*factorial(n-1)));
    }
    
    private long factorial(int n) {
        
        long answer = 1;
        
        for (int i = 1; i <= n; i++) {
        	System.out.println("answer: " + answer);
            answer *= i;
        }
        
        System.out.println("n: " + n);
        System.out.println("answer: " + answer);
        
        return answer;
    }
    
    public static void main(String[] args) {
    	
    	UniquePaths_62 solution = new UniquePaths_62();
    	
    	System.out.println("Check: " + solution.uniquePaths(35, 7));
    }
}
