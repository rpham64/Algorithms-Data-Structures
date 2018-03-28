package BinaryTrees;

import java.util.Stack;

import LeetCode.TreeNode;

/**
 * 
 * Find the sum of all left leaves in a given binary tree.

Example:

    3
   / \
  9  20
    /  \
   15   7

There are two left leaves in the binary tree, with values 9 and 15 respectively. 
Return 24.
 * 
 * @author Rudolf
 *
 */
public class SumOfLeftLeaves_404 {

	/**
	 * Time: O(n) where n is the number of nodes in the tree.
	 * Space: O(1)
	 * 
	 * @param root
	 * @return
	 */
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) return 0;
        
        int sum = 0;
        
        // Add root's left val to sum if left leaf.
        if (root.left != null && root.left.left == null && root.left.right == null) {
            sum += root.left.val;
        }
        
        // Add sum at root 
        //				+ sum of left leaves in left subtree 
        //				+ sum of left leaves in right subtree
        return sum + sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);
    }
	
	/**
	 * Solution #2 - Iterative
	 * 
	 * @param root
	 * @return
	 */
	public int sumOfLeftLeaves_2(TreeNode root) {
        
        // Null check
        if (root == null) return 0;
        
        int sum = 0;
        Stack<TreeNode> stack = new Stack<>();
        
        stack.push(root);
        
        while (!stack.empty()) {
            
            TreeNode current = stack.pop();
            
            if (current.left != null) {
                // Two cases for left child:
                //  1) Left child is a leaf, so add its value to sum
                //  2) Left child is NOT a leaf, so add left child to stack
                if (current.left.left == null && current.left.right == null) sum += current.left.val;
                else stack.push(current.left);
            }
            
            if (current.right != null) stack.push(current.right);
        }
        
        return sum;
    }
    
    public static void main(String[] args) {
    	
    	SumOfLeftLeaves_404 test = new SumOfLeftLeaves_404();
    	
    	TreeNode root = new TreeNode(3);
    	root.left = new TreeNode(9);
    	root.right = new TreeNode(20);
    	root.right.left = new TreeNode(15);
    	root.right.right = new TreeNode(7);
    	
    	System.out.println("Sum total: " + test.sumOfLeftLeaves(root));
    }
}
