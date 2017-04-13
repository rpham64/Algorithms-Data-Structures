package DynamicProgramming;

import java.util.HashMap;
import java.util.Map;

import LeetCode.TreeNode;

public class HouseRobberIII_337_dp_with_cache {

	/**
     * Dynamic Programming Solution (with cache)
     * 
     * Time: 9 ms
     * Time Complexity: O(n) where n is the number of nodes in the tree
     * Space Complexity: O(n)
     * 
     * Idea: Maximize profit by recursively robbing each node in the tree rooted by root.
     * 
     * Cases:
     *      1)  Root is null (return 0)
     *      2)  Root is non-null
     *          a) If we've visited root before, return its value from the hashmap
     *          b) Else, continue with the algorithm
     * 
     * Variables:
     *      int profit
     *      HashMap<TreeNode, Integer> (TreeNode => max profit at that node)
     * 
     * Algorithm:
     *      1)  If we rob root, then we must also add its grandchildren's profits to root's profit.
     *      2)  If not, we add only its left and right children's profits.
     * 
     */
    public int rob(TreeNode root) {
        return robSub(root, new HashMap<TreeNode, Integer>());
    }
    
    private int robSub(TreeNode root, Map<TreeNode, Integer> map) {
        
        // Case 1
        if (root == null) return 0;
        
        // Case 2
        // 2a
        if (map.containsKey(root)) return map.get(root);
        
        // 2b
        int profit = root.val;
        
        if (root.left != null) {
            profit += robSub(root.left.left, map) + robSub(root.left.right, map);
        }
        if (root.right != null) {
            profit += robSub(root.right.left, map) + robSub(root.right.right, map);
        }
        
        int val = Math.max(profit, robSub(root.left, map) + robSub(root.right, map));
        map.put(root, val);
        
        return val;
    }
}
