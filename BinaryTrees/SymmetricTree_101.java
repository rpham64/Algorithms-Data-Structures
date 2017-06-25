package BinaryTrees;

import java.util.LinkedList;
import java.util.Queue;

import LeetCode.TreeNode;

/**
 * 101. Symmetric Tree
 * 
 * Given a binary tree, check whether it is a mirror of itself 
 * (ie, symmetric around its center).
 * 
 * Solution: http://stackoverflow.com/a/8437158
 * 
 * @author Rudolf
 *
 */
public class SymmetricTree_101 {
	
	/**
	 * Time Complexity (both): O(n) where n is the number of TreeNodes in the tree
	 * Space Complexity (both): O(n)
	 * 		- Recursion: Due to the number of recursive calls
	 * 		- Iterative: Size of queue goes up to n in the worst case
	 * 
	 * @param root
	 * @return
	 */
	public boolean isSymmetric(TreeNode root) {
        
        if (root == null) return true;
        
        return mirror(root.left, root.right);
    }
    
    public boolean mirror(TreeNode left, TreeNode right) {
        
        if (left == null || right == null) return left == right;
        
        return left.val == right.val && mirror(left.left, right.right) && mirror(left.right, right.left);   
    }
    
    public boolean isSymmetric_ITERATIVE(TreeNode root) {
        
        if (root == null) return true;
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root.left);
        queue.offer(root.right);
        
        // Every two consecutive nodes in queue must be equal, else return false
        while (!queue.isEmpty()) {
            
            TreeNode node1 = queue.poll();
            TreeNode node2 = queue.poll();
            
            if (node1 == null && node2 == null) continue;
            if (node1 == null || node2 == null) return false;
            if (node1.val != node2.val) return false;
            
            queue.offer(node1.left);
            queue.offer(node2.right);
            queue.offer(node1.right);
            queue.offer(node2.left);
        }
        
        return true;
    }
}
