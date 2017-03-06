package LeetCode_Medium;

import java.util.LinkedList;
import java.util.Queue;

import LeetCode.TreeNode;

/**
 * Given a binary tree, find the leftmost value in the last row of the tree.

	Example 1:
	
	Input:
	
	    2
	   / \
	  1   3
	
	Output:
	1
	
	Example 2: 
	
	Input:
	
	        1
	       / \
	      2   3
	     /   / \
	    4   5   6
	       /
	      7
	
	Output:
	7
	
	Note: You may assume the tree (i.e., the given root node) is not NULL.
 * 
 * @author Rudolf
 *
 */
public class FindBottomLeftTreeValue_513 {

	/**
     * Idea: Use BFS and keep track of the first element on each row.
     */
    public int findBottomLeftValue(TreeNode root) {
        
        // No need for null check (given)
        
        Queue<TreeNode> queue = new LinkedList<>();
        int leftValue = root.val;
        
        queue.offer(root);
        
        while (!queue.isEmpty()) {
            
            int rowSize = queue.size();
            
            for (int i = 0; i < rowSize; ++i) {
                
                TreeNode current = queue.poll();
                
                if (i == 0) leftValue = current.val;    // Leftmost of current level
                
                // Add next-level children
                if (current.left != null) queue.offer(current.left);
                if (current.right != null) queue.offer(current.right);
            }
        }
        
        return leftValue;   // Not found
    }
}
