package LeetCode_Medium;

import java.util.ArrayList;
import java.util.List;

import LeetCode.TreeNode;

/**
 * Given a binary tree, return the preorder traversal of its nodes' values.

	For example:
	Given binary tree {1,#,2,3},
	   1
	    \
	     2
	    /
	   3
	return [1,2,3].
	
	Note: Recursive solution is trivial, could you do it iteratively?
 * 
 * @author Rudolf
 *
 */
public class BinaryTreePreorderTraversal_144 {

	public List<Integer> preorderTraversal(TreeNode root) {
        
        List<Integer> nodes = new ArrayList<Integer>();
        
        // Input Check: empty tree
        if (root == null) return nodes;
        
        // Base Case: add root to nodes
        nodes.add(root.val);
        
        // Inductive Case: Apply recursion on left subtree, then right subtree
        List<Integer> leftNodes = new ArrayList<Integer>();
        List<Integer> rightNodes = new ArrayList<Integer>();
        
        if (root.left != null) {
            leftNodes = preorderTraversal(root.left);
        }
        if (root.right != null) {
            rightNodes = preorderTraversal(root.right);    
        }
        
        for (int leftVal : leftNodes) {
            nodes.add(leftVal);
        }
        for (int rightVal : rightNodes) {
            nodes.add(rightVal);
        }
        
        return nodes;
    }
	
}
