package BinaryTrees;

import LeetCode.TreeNode;

/**
 * 101. Symmetric Tree
 * 
 * Given a binary tree, check whether it is a mirror of itself 
 * (ie, symmetric around its center).
 * 
 * Solution: http://stackoverflow.com/a/8437158
 * 
 * @author Rudolf
 *
 */
public class SymmetricTree_101 {
	
	public boolean isSymmetric(TreeNode root) {
        
        if (root == null) return true;
        
        return mirror(root.left, root.right);
    }
    
    public boolean mirror(TreeNode left, TreeNode right) {
        
        if (left == null || right == null) return left == right;
        
        return left.val == right.val && mirror(left.left, right.right) && mirror(left.right, right.left);   
    }
}
