
/**
 * Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.
	
	An example is the root-to-leaf path 1->2->3 which represents the number 123.
	
	Find the total sum of all root-to-leaf numbers.
	
	Note: A leaf is a node with no children.
	
	Example:
	
	Input: [1,2,3]
	
	    1
	   / \
	  2   3
	  
	Output: 25
	
	Explanation:
	
	The root-to-leaf path 1->2 represents the number 12.
	The root-to-leaf path 1->3 represents the number 13.
	Therefore, sum = 12 + 13 = 25.
	
	Example 2:
	
	Input: [4,9,0,5,1]
	
	    4
	   / \
	  9   0
	 / \
	5   1
	
	Output: 1026
	
	Explanation:
	
	The root-to-leaf path 4->9->5 represents the number 495.
	The root-to-leaf path 4->9->1 represents the number 491.
	The root-to-leaf path 4->0 represents the number 40.
	Therefore, sum = 495 + 491 + 40 = 1026.

 * 
 * Source: https://leetcode.com/problems/sum-root-to-leaf-numbers/description/
 * 
 * @author rpham
 * Date: 5/2/18
 *
 */
public class SumRootToLeafNumbers_129 {
	
	/**
	 * Simple DFS Algorithm
	 * 
	 * Time: O(n) where n is the number of nodes in the tree.
	 * Space: O(n) [worst-case] if we're doing dfs on a linear tree.
	 * 		  O(h) [average] where h is the maximum height of the tree, or longest path.
	 * 
	 * @param root
	 * @return
	 */
	public int sumNumbers(TreeNode root) {
        return sum(root, 0);
    }
    
    private int sum(TreeNode root, int currentSum) {
        if (root == null) return 0;
        
        // Add current node to currentSum.
        currentSum = currentSum * 10 + root.val;
        
        // If root is leaf, return currentSum.
        // Else, return sum of root.left and root.right recursively.
        if (isLeaf(root)) return currentSum;
        
        // Add sum from left and right subtrees.
        return sum(root.left, currentSum) + sum(root.right, currentSum);
    }
    
    private boolean isLeaf(TreeNode node) {
        return node.left == null && node.right == null;
    }
}
