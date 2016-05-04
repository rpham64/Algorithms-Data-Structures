package LeetCode_Medium;

import java.util.Stack;

import LeetCode.TreeNode;

/**
 * Given a binary search tree, write a function kthSmallest to 
 * find the kth smallest element in it.

	Note: 
	You may assume k is always valid, 1 <= k <= BST's total elements.
	
	Follow up:
	What if the BST is modified (insert/delete operations) often 
	and you need to find the kth smallest frequently? 
	How would you optimize the kthSmallest routine?
	
	Hint:
	
	Try to utilize the property of a BST.
	What if you could modify the BST node's structure?
	The optimal runtime complexity is O(height of BST).
 * 
 * @author Rudolf
 *
 */
public class kthSmallestElementInBST_230 {

	/**
	 * Idea: Use inorder tree traversal and keep a counter.
	 * 		Inorder tree traversal for BST returns the values in sorted order.
	 * 		When counter == k, return the current node's value.
	 * 
	 * @param root
	 * @param k
	 * @return
	 */
	public int kthSmallest(TreeNode root, int k) {
        
        Stack<TreeNode> stack = new Stack<TreeNode>();
        
        // Input Check: empty tree
        if (root == null) return -1;
        
        int counter = 0;    // smallest = 1, 2nd smallest = 2, etc.
        
        TreeNode current = root;
        
        // Add leftmost nodes to stack
        while (current != null) {
            stack.push(current);
            current = current.left;
        }
        
        while (!stack.empty()) {
            
            current = stack.pop();
            
            // Increment and check counter
            if (++counter == k) return current.val;
            
            if (current.right != null) {
                
                current = current.right;
                
                while (current != null) {
                    stack.push(current);
                    current = current.left;
                }
                
            }
            
        }
        
        return -1;  // Not found
    }
	
}
