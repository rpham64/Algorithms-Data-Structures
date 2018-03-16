package BinaryTrees;

/**
 * Given two binary trees and imagine that when you put one of them 
 * to cover the other, some nodes of the two trees are overlapped 
 * while the others are not.
	
	You need to merge them into a new binary tree. 
	The merge rule is that if two nodes overlap, then sum node values up 
	as the new value of the merged node. Otherwise, the NOT null node will 
	be used as the node of new tree.
	
	Example 1:
	
	Input: 
		Tree 1                     Tree 2                  
	          1                         2                             
	         / \                       / \                            
	        3   2                     1   3                        
	       /                           \   \                      
	      5                             4   7              
	          
	Output: 
	
	Merged tree:
		     3
		    / \
		   4   5
		  / \   \ 
		 5   4   7
		 
	Note: The merging process must start from the root nodes of both trees.
 * 
 * Source: https://leetcode.com/problems/merge-two-binary-trees/description/
 * 
 * @author Rudolf
 *
 */
public class MergeTwoBinaryTrees_617 {

    /**
    * Cases:
    *       1) Both t1 and t2 are null (Return null)
    *       2) Either t1 or t2 is null (Return the non-null tree)
    *       3) Both t1 and t2 are non-null (Merge them)
    *
    * Algorithm (case 3):
    *       Create a new node using summed values of t1 and t2.
    *       Call mergeTrees recursively on t1.left and t2.left, then store the result as new node's left.
    *       Call mergeTrees recursively on t1.right and t2.right, then store the result as new node's right.
    *       Return root node.
    */
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        // Case 1
        if (t1 == null && t2 == null) return null;
        
        // Case 2
        if (t1 == null) return t2;
        if (t2 == null) return t1;
        
        // Case 3
        TreeNode root = new TreeNode(t1.val + t2.val);
        root.left = mergeTrees(t1.left, t2.left);
        root.right = mergeTrees(t1.right, t2.right);
        
        return root;
    }
}
