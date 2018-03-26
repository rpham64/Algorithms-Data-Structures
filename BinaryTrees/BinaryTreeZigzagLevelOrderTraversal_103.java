package BinaryTrees;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import LeetCode.TreeNode;

/**
 * Given a binary tree, return the zigzag level order traversal of its nodes' values. 
 * (ie, from left to right, then right to left for the next level and alternate between).
	
	For example:
	
	Given binary tree [3,9,20,null,null,15,7],
	    3
	   / \
	  9  20
	    /  \
	   15   7
	   
	return its zigzag level order traversal as:
	
	[
	  [3],
	  [20,9],
	  [15,7]
	]

 * 
 * Source: https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/description/
 * 
 * @author Rudolf
 *
 */
public class BinaryTreeZigzagLevelOrderTraversal_103 {

	/**
    *   Idea: BFS but use list#add(object) or list#add(index, object) depending on level #.
    *       - Even Level: Use list#add(object)
    *       - Odd Level: Use list#add(index, object)
    *
    *   Time: O(n) where n is the number of nodes in the tree.
    *   Space: O(w) where w is the maximum width (number of nodes in level) of the tree. In this case, size of levelList.
    */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        
        int level = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        
        while (queue.size() > 0) {
            
            int levelSize = queue.size();
            List<Integer> levelList = new ArrayList<>();
            
            for (int i = 0; i < levelSize; ++i) {
                
                TreeNode current = queue.poll();
                
                if (level % 2 == 0) {
                    // Even Level
                    levelList.add(current.val);
                } else {
                    // Odd Level
                    levelList.add(0, current.val);
                }
                
                if (current.left != null) queue.offer(current.left);
                if (current.right != null) queue.offer(current.right);
            }
            
            result.add(levelList);
            level++;
        }
        
        return result;
    }
}
