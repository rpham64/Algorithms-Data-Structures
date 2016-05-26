package DynamicProgramming;

/**
 * Problem & Solution: http://articles.leetcode.com/unique-paths/
 * 
 * Reference: https://siddontang.gitbooks.io/leetcode-solution/content/dynamic_programming/unique_paths.html
 *	
 * @author Rudolf
 *
 */
public class UniquePaths_62 {

	/**
     * Total # of possible steps = (m-1) + (n-1) = m + n - 2
     * Choose m-1 steps down, n-1 steps right
     * 
     * # of unique paths (nCk) = ((m-1) + (n-1))C(m-1) = ((m-1)+(n-1))C(n-1)
     * 
     * For 3x7 grid above, total # of possible steps is 8 and we choose 2 steps down or 6 steps right.
     * # of unique paths = 8 choose 2 = 8 choose 6 = 28
     * 
     */
	
	/** Method Used: Dynamic Programming */
    public int uniquePaths(int m, int n) {
        
        // Input Check: (m,n) = (0,0)
        if (m == 0 || n == 0) return 0;
        
        int[][] paths = new int[m][n];
        
        // Fill first row with 1's
        for (int i = 0; i < m; ++i) {
            paths[i][0] = 1;
        }
        
        // Fill first column with 1's
        for (int j = 0; j < n; ++j) {
            paths[0][j] = 1;
        }
        
        // Iterate to (m-1, n-1)
        for (int i = 1; i < m; ++i) {
            for (int j = 1; j < n; ++j) {
                paths[i][j] = paths[i-1][j] + paths[i][j-1];
            }
        }
        
        return paths[m-1][n-1];
    }
}
