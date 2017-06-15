package BinaryTrees;

import java.util.LinkedList;
import java.util.List;

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
public class FlattenBinaryTreeToLinkedList_114 {

	/**
	 * Time Complexity: O(n) where n is the number of nodes in the tree
	 * Space Complexity: O(n)
	 * 
     * Cases:
     *      1)  Empty or root only (return)
     *      2)  Non-null and non-empty tree (see algo)
     * 
     */
    public void flatten(TreeNode root) {
        
        if (root == null || (root.left == null && root.right == null)) return;
        
        List<Integer> list = new LinkedList<>();
        dfs(root, list);
        
        root.left = null;
        for (int i = 1; i < list.size(); ++i) {
            root.right = new TreeNode(list.get(i));
            root = root.right;
        }
    }
    
    private void dfs(TreeNode root, List<Integer> list) {
        if (root == null) return;
        list.add(root.val);
        dfs(root.left, list);
        dfs(root.right, list);
    }
}
