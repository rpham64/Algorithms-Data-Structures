package BinaryTrees;

import java.util.Stack;

/**
 * Given two non-empty binary trees s and t, check whether tree t has exactly the 
 * same structure and node values with a subtree of s. 
 * A subtree of s is a tree consists of a node in s and all of this node's descendants. 
 * The tree s could also be considered as a subtree of itself.
	
	Example 1:
	
	Given tree s:
	
	     3
	    / \
	   4   5
	  / \
	 1   2
	 
	Given tree t:
	
	   4 
	  / \
	 1   2
	 
	Return true, because t has the same structure and node values with a subtree of s.
	
	Example 2:
	
	Given tree s:
	
	     3
	    / \
	   4   5
	  / \
	 1   2
	    /
	   0
	   
	Given tree t:
	
	   4
	  / \
	 1   2
	 
	Return false.
 * 
 * @author Rudolf
 *
 */
public class SubtreeOfAnotherTree_572 {

	/**
     * Idea: Use DFS to find t in s. If found, compare both s and t's nodes. 
     */
    public boolean isSubtree(TreeNode s, TreeNode t) {
        return dfs(s, t);
    }
    
    private boolean dfs(TreeNode s, TreeNode t) {
        
        Stack<TreeNode> stack = new Stack<>();
        
        stack.push(s);
        
        // Traverse tree s, searching for t. If it exists, return isSameTree, else return false.
        while (!stack.empty()) {
            
            TreeNode current = stack.pop();
            
            if (current.val == t.val) {
                
                // Check if is subtree
                // If so, return true. Else, keep searching
            	// Also handles duplicates
                if (isSameTree(current, t)) return true;
            }
            
            if (current.right != null) stack.push(current.right);
            if (current.left != null) stack.push(current.left);
        }
        
        return false;   // t not found in s
    }
    
    private boolean isSameTree(TreeNode nodeS, TreeNode nodeT) {
    	
    	// Case 1: Both null
        if (nodeS == null && nodeT == null) return true;
        
        // Cases 2 and 3: Either S or T is null
        if (nodeS == null || nodeT == null) return false;
        
        // Case 4: Both are non-null
        return nodeS.val == nodeT.val && isSameTree(nodeS.left, nodeT.left) && isSameTree(nodeS.right, nodeT.right);
    }
}
