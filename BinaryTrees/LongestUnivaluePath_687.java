package BinaryTrees;

/**
 * Given a binary tree, find the length of the longest path where each node 
 * in the path has the same value. This path may or may not pass through the root.
	
	Note: The length of path between two nodes is represented by the number of edges between them.
	
	Example 1:
	
	Input:
	
	              5
	             / \
	            4   5
	           / \   \
	          1   1   5
	          
	Output: 2
	
	Example 2:
	
	Input:
	
	              1
	             / \
	            4   5
	           / \   \
	          4   4   5
	          
	Output: 2
	
	Note: The given binary tree has not more than 10000 nodes. 
	The height of the tree is not more than 1000.
 * 
 * @author Rudolf
 *
 */
public class LongestUnivaluePath_687 {

	public int longestUnivaluePath(TreeNode root) {
        
        // Base Case: Longest path is 0 if root is null.
        if (root == null) return 0;
        
        // Cases 1 and 2: Longest univalue path can be in either left or right subtrees.
        int longestPathInChildren = Math.max(longestUnivaluePath(root.left), longestUnivaluePath(root.right));
        
        // Case 3: Longest univalue path can be both left and right combined.
        return Math.max(longestPathInChildren, helper(root.left, root.val) + helper(root.right, root.val));
    }
    
    private int helper(TreeNode node, int val) {
        
        // Base Case: If node is null OR node's val does not equal val, return 0.
        if (node == null || node.val != val) return 0;
        
        // Recursive Case: Call helper on left and right, then compare the two and add one (for this current node).
        return 1 + Math.max(helper(node.left, val), helper(node.right, val));
    }
}
