package DynamicProgramming;

import LeetCode.TreeNode;

public class HouseRobberIII_337_dp {

	/**
     * Dynamic Programming Solution (without cache)
     * 
     * Time: 1050 ms
     * Time Complexity: O(6^n) since you're making six recursive calls for each node, which is repeated constantly
     * 
     * Idea: Maximize profit by recursively robbing each node in the tree rooted by root.
     * 
     * Cases:
     *      1)  Root is null (return 0)
     *      2)  Root is non-null
     * 
     * Variables:
     *      int profit
     * 
     * Algorithm:
     *      1)  If we rob root, then we must also add its grandchildren's profits to root's profit.
     *      2)  If not, we add only its left and right children's profits.
     * 
     */
    public int rob_dp(TreeNode root) {
        
        // Case 1
        if (root == null) return 0;
        
        // Case 2
        int profit = root.val;
        
        if (root.left != null) {
            profit += rob_dp(root.left.left) + rob_dp(root.left.right);
        }
        if (root.right != null) {
            profit += rob_dp(root.right.left) + rob_dp(root.right.right);
        }
        
        return Math.max(profit, rob_dp(root.left) + rob_dp(root.right));
    }
}
