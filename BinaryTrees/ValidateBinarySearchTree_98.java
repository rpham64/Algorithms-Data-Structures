package BinaryTrees;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a binary tree, determine if it is a valid binary search tree (BST).
	
	Assume a BST is defined as follows:
	
	The left subtree of a node contains only nodes with keys less than the node's key.
	The right subtree of a node contains only nodes with keys greater than the node's key.
	Both the left and right subtrees must also be binary search trees.
	
	Example 1:
	    2
	   / \
	  1   3
	  
	Binary tree [2,1,3], return true.
	
	Example 2:
	    1
	   / \
	  2   3
	  
	Binary tree [1,2,3], return false.
 * 
 * @author Rudolf
 *
 */
public class ValidateBinarySearchTree_98 {

	/**
	 * Optimal Solution
	 * 
	 * Time Complexity: O(n)
	 * Space Complexity: O(1)
	 * 
	 * @param root
	 * @return
	 */
	public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);        // Case of Integer overflow...
    }
    
    /**
     * Ranges:
     *      Root => [minVal, maxVal]
     *      Left => [minVal, root.val]
     *      Right => [root.val, maxVal]
     */
    private boolean isValidBST(TreeNode root, long minValue, long maxValue) {
        
        if (root == null) return true;
        
        if (root.val <= minValue || root.val >= maxValue) return false;
        
        return isValidBST(root.left, minValue, root.val) && isValidBST(root.right, root.val, maxValue);
    }
	
	/**
	 * Time Complexity: O(n) including recursive stacks
	 * Space Complexity: O(n)
	 * 
	 * Cases:
	 * 		1)	Empty tree (return true)
	 * 		2)	Root only (return true)
	 * 		3)	1 or 2 children
	 * 			- Apply inorder traversal and build a List<Integer>
	 * 			- Since list is in increasing order, compare current int and next int
	 * 				- If >=, return false (smaller int in right BST)
	 * 			- Return true (valid BST)
	 * 
	 * @param root
	 * @return
	 */
	public boolean isValidBST2(TreeNode root) {
        
        // Case 1
        if (root == null) return true;
        
        // Case 2
        if (root.left == null && root.right == null) return true;
        
        // Case 3
        List<Integer> values = getInorder(root);
        
        for (int i = 0; i < values.size() - 1; ++i) {
            if (values.get(i) >= values.get(i+1)) return false;
        }
        
        return true;
    }
    
    private List<Integer> getInorder(TreeNode root) {
        
        List<Integer> values = new ArrayList<>();
        
        if (root == null) return values;
        
        values.addAll(getInorder(root.left));
        values.add(root.val);
        values.addAll(getInorder(root.right));
        
        return values;
    }
}
