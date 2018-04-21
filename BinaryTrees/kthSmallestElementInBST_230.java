

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
    *   1) Traverse BST with size-restricted Priority Queue
    *       - Time: O(n log k)
    *       - Space: O(k + 1) = O(k)
    *   2) Inorder Traversal Iteratively while decrementing k. Return current key if --k == 0.
    *       - Time: O(n) where n is the number of nodes in the BST.
    *       - Space: O(1)
    */
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;
        
        // Iteratively push leftmost nodes to stack.
        while (current != null) {
            stack.push(current);
            current = current.left;
        }
        
        while (!stack.isEmpty()) {
            current = stack.pop();
            
            // Decrement k.
            // If k == 0, we found the kth smallest element in the BST.
            if (--k == 0) return current.val;
            
            if (current.right != null) {
                current = current.right;
                
                // Iteratively push leftmode nodes to stack.
                while (current != null) {
                    stack.push(current);
                    current = current.left;
                }
            }
        }
        
        return -1;  // Not found
    }
	
}
