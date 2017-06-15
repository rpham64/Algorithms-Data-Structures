package BinaryTrees;

/**
 * Given a binary tree, flatten it to a linked list in-place.
	
	For example,
	Given
	
	         1
	        / \
	       2   5
	      / \   \
	     3   4   6
	     
	The flattened tree should look like:
	
	   1
	    \
	     2
	      \
	       3
	        \
	         4
	          \
	           5
	            \
	             6
 * 
 * @author Rudolf
 *
 */
public class FlattenBinaryTreeToLinkedList_114_IN_PLACE {

	/**
	 * Idea: Reverse postorder traversal
	 * Source: https://discuss.leetcode.com/topic/11444/my-short-post-order-traversal-java-solution-for-share
	 * 
	 * Time Complexity: O(n)
	 * Space Complexity: O(1)
	 */
    private TreeNode prev = null;
    
    public void flatten(TreeNode root) {
        
        if (root == null) return;
        
        flatten(root.right);
        flatten(root.left);
        
        root.right = prev;
        root.left = null;
        prev = root;
    }
}
