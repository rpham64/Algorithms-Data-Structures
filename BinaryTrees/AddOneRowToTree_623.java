package BinaryTrees;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given the root of a binary tree, then value v and depth d, 
 * you need to add a row of nodes with value v at the given depth d. 
 * The root node is at depth 1.
	
	The adding rule is: given a positive integer depth d, for each NOT null tree nodes N in depth d-1, 
	create two tree nodes with value v as N's left subtree root and right subtree root. 
	And N's original left subtree should be the left subtree of the new left subtree root, 
	its original right subtree should be the right subtree of the new right subtree root. 
	If depth d is 1 that means there is no depth d-1 at all, then create a tree node with 
	value v as the new root of the whole original tree, and the original tree is the new root's left subtree.
	
	Example 1:
	
	Input: 
	
	A binary tree as following:
	       4
	     /   \
	    2     6
	   / \   / 
	  3   1 5   
	
	v = 1
	
	d = 2
	
	Output: 
	       4
	      / \
	     1   1
	    /     \
	   2       6
	  / \     / 
	 3   1   5   
	
	Example 2:
	
	Input: 
	
	A binary tree as following:
	      4
	     /   
	    2    
	   / \   
	  3   1    
	
	v = 1
	
	d = 3
	
	Output: 
	      4
	     /   
	    2
	   / \    
	  1   1
	 /     \  
	3       1
	
	Note:
	
	The given d is in range [1, maximum depth of the given tree + 1].
	The given binary tree has at least one tree node.

 * 
 * @author Rudolf
 *
 */
public class AddOneRowToTree_623 {

	/**
	 * Simple BFS solution
	 * 
	 * Time Complexity: O(n) where n is the number of TreeNodes in the tree
	 * Space Complexity: O(w) where w is the max width of the tree
	 * 
	 * @param root
	 * @param v
	 * @param d
	 * @return
	 */
	public TreeNode addOneRow(TreeNode root, int v, int d) {
        
        // Case 1: d == 1
        if (d == 1) {
            TreeNode node = new TreeNode(v);
            node.left = root;
            root = node;
            return root;
        }
        
        // Case n: d > 1
        // Apply BFS and add new nodes when level == d-1
        int level = 1;
        Queue<TreeNode> queue = new LinkedList<>();
        
        queue.offer(root);
        
        while (!queue.isEmpty()) {
            
            int size = queue.size();
            
            for (int i = 0; i < size; ++i) {
                
                TreeNode current = queue.poll();
                
                if (level == d - 1) {
                    
                    // Add new left and right nodes for current node
                    TreeNode left = new TreeNode(v);
                    left.left = current.left;
                    current.left = left;
                    
                    TreeNode right = new TreeNode(v);
                    right.right = current.right;
                    current.right = right;
                    
                } else {
                    
                    // Add children to queue, if they exist
                    if (current.left != null) queue.offer(current.left);
                    if (current.right != null) queue.offer(current.right);
                    
                }
            }
            
            if (level == d - 1) return root;    // Break loop early to save some time and memory
            
            level++;
        }
        
        return root;
    }
}
