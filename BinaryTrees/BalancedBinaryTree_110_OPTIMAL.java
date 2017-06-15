package BinaryTrees;

/**
 * Given a binary tree, determine if it is height-balanced.
	
	For this problem, a height-balanced binary tree is defined as a binary tree in which the 
	depth of the two subtrees of every node never differ by more than 1.
 * 
 * Solution: Bottom-up Approach using a global boolean variable
 * 
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 * 
 * Idea: Instead of checking heights of both left and right subtrees then recursively calling isBalanced on
 * 		left and right children, check if the heights are balanced while traversing the tree in the first call
 * 		height(root). If not balanced, there's no need to continue searching, so break early.
 * 
 * @author Rudolf
 *
 */
public class BalancedBinaryTree_110_OPTIMAL {

    private boolean isBalanced = true;
    
    public boolean isBalanced(TreeNode root) {
        height(root);
        return isBalanced;
    }
    
    private int height(TreeNode root) {
        
        if (!isBalanced) return -1;    // No need to check if already unbalanced
        
        if (root == null) return -1;
        if (root.left == null && root.right == null) return 0;
        
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        int diff = Math.abs(leftHeight - rightHeight);
        
        if (diff > 1) isBalanced = false;
        
        return 1 + Math.max(leftHeight, rightHeight);
    }
}
