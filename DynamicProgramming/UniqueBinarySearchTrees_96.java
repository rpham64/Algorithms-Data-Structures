package DynamicProgramming;

/**
 * Given n, how many structurally unique BST's (binary search trees) that store values 1...n?

	For example,
	Given n = 3, there are a total of 5 unique BST's.
	
	   1         3     3      2      1
	    \       /     /      / \      \
	     3     2     1      1   3      2
	    /     /       \                 \
	   2     1         2                 3
 * 
 * Solution & Explanation: https://discuss.leetcode.com/topic/8398/dp-solution-in-6-lines-with-explanation-f-i-n-g-i-1-g-n-i
 * 
 * @author Rudolf
 *
 */
public class UniqueBinarySearchTrees_96 {

	/**
     * Idea: Let G(n) be the number of ways to represent a BST with length n,
     *          F(i, n) be the number of ways to represent a BST with i as the root and values from 1 to n.
     * 
     *      For i from 1 to n, note that each value of i takes turns to be the root of the BST.
     *      If i is 3 and n is 7 for example, the left subtree will contain (1, 2) and right will contain (4, 5, 6, 7),
     *      both in some kind of order. 
     * 
     *      We can then sum up the number of combinations of this as F(3, 7) = G(2) * G(4) using a Cartesian product.
     * 
     *      In general:
     * 
     *          F(i, n) = G(i - 1) * G(n - i)
     * 
     *      Since G(n) = F(1, n) + F(2, n) + ... + F(n, n), we now know that
     * 
     *          G(n) = G(0)*G(n-1) + G(1)*G(n-2) + ... + G(n-1)*G(0).
     * 
     *      Using the base case that G(0) = 1 and G(1) = 1, we can use a bottom-up dp approach to find G(n).
     *      
     */
	public int numTrees(int n) {
        
        int[] num = new int[n+1];
        num[0] = 1;
        num[1] = 1;
        
        // Base Case
        if (n == 0 || n == 1) return num[n];
        
        // Iterative Case
        for (int i = 2; i <= n; ++i) {
            for (int j = 1; j <= i; ++j) {
                num[i] += num[j-1] * num[i-j];
            }
        }
        
        return num[n];
    }
}
