package DynamicProgramming;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import LeetCode.TreeNode;

/**
 * The thief has found himself a new place for his thievery again. 
 * There is only one entrance to this area, called the "root." 
 * Besides the root, each house has one and only one parent house. 
 * After a tour, the smart thief realized that "all houses in this place forms a binary tree". 
 * It will automatically contact the police if two directly-linked houses were broken into on the same night.

	Determine the maximum amount of money the thief can rob tonight without alerting the police.
	
	Example 1:
	     3
	    / \
	   2   3
	    \   \ 
	     3   1
	     
	Maximum amount of money the thief can rob = 3 + 3 + 1 = 7.
	
	Example 2:
	     3
	    / \
	   4   5
	  / \   \ 
	 1   3   1
	 
	Maximum amount of money the thief can rob = 4 + 5 = 9.
 * 
 * @author Rudolf
 *
 */
public class HouseRobberIII_337 {

	/**
	 * DFS Solution
	 * 
	 * Time: 2ms
	 * Time Complexity: O(n) where n is the number of nodes in the tree
	 * Space Complexity: O(1)
	 * 
     * Idea: Apply DFS and determine whether robbing the current node or not yields higher profit.
     * 
     * Cases:
     *      1)  Empty tree (return 0)
     *      2)  Root only (return root.val)
     *      3)  1 or 2 children (see algorithm)
     * 
     * DFS Cases:
     *      1) Rob root
     *          - Profit = root.val + left.val (not robbed) + right.val (not robbed)
     *      2) Don't rob root
     *          - Profit = max of left.val (rob) and left.val (not robbed) + max of right.val (rob) + right.val (not robbed)
     * 
     * Variables:
     *      int[] profit (size = 2 where profit[0] = profit if we ROB this node, profit[1] = profit if we DON'T ROB this node)
     * 
     * Algorithm:
     *      1) Initialize int[] profit to helper method dfs(root)
     *      2) Return max(profit[0], profit[1])
     * 
     * Helper DFS:
     *      1)  If root is null, return empty int[2]
     *      2)  Initialize int[2] profit
     *      3)  Recursively apply dfs to left and right
     *      4)  Set profit[0] = root.val + leftProfit[1] + rightProfit[1]
     *      5)  Set profit[1] = max(leftProfit[0], leftProfit[1]) + max(rightProfit[0], rightProfit[1])
     *      6)  Return profit[]
     */
    public int rob(TreeNode root) {
        
        // Case 1
        if (root == null) return 0;
        
        // Case 2
        if (root.left == null && root.right == null) return root.val;
        
        // Case 3
        int[] profit = dfs(root);
        return Math.max(profit[0], profit[1]);
    }
    
    private int[] dfs(TreeNode root) {
        
        // Step 1
        if (root == null) return new int[2];
        
        // Step 2
        int[] profit = new int[2];
        
        // Step 3
        int[] leftProfit = dfs(root.left);
        int[] rightProfit = dfs(root.right);
        
        // Step 4
        profit[0] = root.val + leftProfit[1] + rightProfit[1];
        
        // Step 5
        profit[1] = Math.max(leftProfit[0], leftProfit[1]) + Math.max(rightProfit[0], rightProfit[1]);
        
        // Step 6
        return profit;
    }
}
