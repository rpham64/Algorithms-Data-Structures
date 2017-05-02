package LeetCode;

import java.util.Stack;

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
	 * Solution #1 - Recursive
	 * 
	 * @param root
	 * @return
	 */
	public int sumOfLeftLeaves(TreeNode root) {
        
        // Null check
        if (root == null) return 0;
        
        int sum = 0;
        
        if (root.left != null) {
            
            // Left child is a leaf
            if (root.left.left == null && root.left.right == null) sum += root.left.val;
            else sum += sumOfLeftLeaves(root.left);
            
        }
        
        if (root.right != null) sum += sumOfLeftLeaves(root.right);
        
        return sum;
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
