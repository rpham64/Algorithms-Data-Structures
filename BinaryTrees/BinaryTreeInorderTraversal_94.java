package BinaryTrees;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import LeetCode.TreeNode;

/**
 * Given a binary tree, return the inorder traversal of its nodes' values.

	For example:
	Given binary tree {1,#,2,3},
	   1
	    \
	     2
	    /
	   3
	return [1,3,2].
	
	Note: Recursive solution is trivial, could you do it iteratively?
 * 
 * Reference: http://www.geeksforgeeks.org/inorder-tree-traversal-without-recursion/
 * 
 * @author Rudolf
 *
 */
public class BinaryTreeInorderTraversal_94 {
	
	/**
	 * Recursive Version 1 - Using List#addAll
	 * 
	 * @param root
	 * @return
	 */
	public List<Integer> inorderTraversal(TreeNode root) {
        
        List<Integer> nodes = new ArrayList<Integer>();
        
        // Input Check: empty tree
        if (root == null) return nodes;
        
        nodes.addAll(inorderTraversal(root.left));
        nodes.add(root.val);
        nodes.addAll(inorderTraversal(root.right));
        
        return nodes;
    }
	
	/**
	 * Recursive Version 2 - Using List#add and loops
	 * 
	 * @param root
	 * @return
	 */
	public List<Integer> inorderTraversal_recursive(TreeNode root) {
        
        List<Integer> nodes = new ArrayList<Integer>();
        
        // Input Check: empty tree
        if (root == null) return nodes;
        
        List<Integer> leftNodes = new ArrayList<Integer>();
        List<Integer> rightNodes = new ArrayList<Integer>();
        
        if (root.left != null) {
            leftNodes = inorderTraversal(root.left);
        }
        if (root.right != null) {
            rightNodes = inorderTraversal(root.right);
        }
        
        // Add node values from leftNodes, then root, then rightNodes into nodes list
        for (int val : leftNodes) {
            nodes.add(val);
        }
        
        nodes.add(root.val);
        
        for (int val : rightNodes) {
            nodes.add(val);
        }
        
        return nodes;
    }

	/**
	 * Iterative Version
	 * 
	 * @param root
	 * @return
	 */
	public List<Integer> inorderTraversal_ITERATIVE(TreeNode root) {
        
        List<Integer> nodes = new ArrayList<Integer>();
        
        // Input Check: empty tree
        if (root == null) return nodes;
        
        TreeNode current = root;
        Stack<TreeNode> stack = new Stack<TreeNode>();

        // Repeatedly push leftmost nodes to stack
        while (current != null) {
            stack.push(current);
            current = current.left;
        }
        
        while (!stack.empty()) {
            
            current = stack.pop();
            
            // Add current to nodes list
            nodes.add(current.val);
            
            // If current's right node exists, set current to that node.
            if (current.right != null) {
                
                current = current.right;
                
                // Repeatedly push leftmost nodes to stack
                while (current != null) {
                    stack.push(current);
                    current = current.left;
                }
                
            }
        }
        
        return nodes;
    }
	
}
