package BinaryTrees;

/**
 * Given a binary tree, find its minimum depth.
	
	The minimum depth is the number of nodes along the shortest path from 
	the root node down to the nearest leaf node.
 * 
 * Source: https://leetcode.com/problems/minimum-depth-of-binary-tree/description/
 * 
 * @author Rudolf
 *
 */
public class MinimumDepthOfBinaryTree_111 {

    /**
    * Cases:
    *       1) Null Root    =>  Depth = 0
    *       2) Root Only    =>  Depth = 1 (root-root has only root node on path)
    *       3) One child    =>  Depth = 2 (the only valid path would have 2 nodes for root-leaf)
    *       4) Two Children =>  Depth = Minimum depth of left and right subtrees
    */
    public int minDepth(TreeNode root) {
        // Case 1
        if (root == null) return 0;
        
        // Case 2
        if (root.left == null && root.right == null) return 1;
        
        int leftDepth = minDepth(root.left);
        int rightDepth = minDepth(root.right);
        
        // Case 3
        if (root.left == null || root.right == null) return 1 + Math.max(leftDepth, rightDepth);
        
        // Case 4
        return 1 + Math.min(leftDepth, rightDepth);
    }
}
