package BinaryTrees;

/**
 * You are given a binary tree in which each node contains an integer value.
	
	Find the number of paths that sum to a given value.
	
	The path does not need to start or end at the root or a leaf, but it must go downwards 
	(traveling only from parent nodes to child nodes).
	
	The tree has no more than 1,000 nodes and the values are in the range -1,000,000 to 1,000,000.
	
	Example:
	
	root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8
	
	      10
	     /  \
	    5   -3
	   / \    \
	  3   2   11
	 / \   \
	3  -2   1
	
	Return 3. The paths that sum to 8 are:
	
	1.  5 -> 3
	2.  5 -> 2 -> 1
	3. -3 -> 11
 * 
 * @author Rudolf
 *
 */
public class PathSumIII_437_GLOBAL_COUNT {

	/**
	 * Time Complexity: O(n*logn) for balanced binary tree (average), O(n^2) for worst-case
	 * Space Complexity: O(1)
	 */
	private int count = 0;
    
    public int pathSum(TreeNode root, int sum) {
        
        if (root == null) return count;
        
        getPaths(root, sum);
        pathSum(root.left, sum);
        pathSum(root.right, sum);
        
        return count;
    }
    
    private void getPaths(TreeNode node, int sum) {
        
        if (node == null) return;
        
        sum -= node.val;
        
        if (sum == 0) count++;
        
        getPaths(node.left, sum);
        getPaths(node.right, sum);
    }
}
