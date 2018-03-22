package BinaryTrees;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

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
	
	/**
	 * Recursive Version 1
	 * 
	 * @param root
	 * @return
	 */
	public List<Integer> preorderTraversal(TreeNode root) {
        
        List<Integer> nodes = new ArrayList<Integer>();
        
        // Input Check: empty tree
        if (root == null) return nodes;
        
        nodes.add(root.val);
        nodes.addAll(preorderTraversal(root.left));
        nodes.addAll(preorderTraversal(root.right));
        
        return nodes;
    }

	/**
	 * Recursive Version 2
	 * 
	 * @param root
	 * @return
	 */
	public List<Integer> preorderTraversal_recursive(TreeNode root) {
        
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
	
	/**
	 * Iterative Version
	 * 
	 * @param root
	 * @return
	 */
	public List<Integer> preorderTraversal_ITERATIVE(TreeNode root) {
        
        List<Integer> nodes = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        
        // Input Check: empty tree
        if (root == null) return nodes;
        
        stack.push(root);
        
        while (!stack.empty()) {
            
            TreeNode current = stack.pop();
            
            nodes.add(current.val);
            
            if (current.right != null) {
                stack.push(current.right);
            }
            
            if (current.left != null) {
                stack.push(current.left);
            }
            
        }
        
        return nodes;
    }
	
}
