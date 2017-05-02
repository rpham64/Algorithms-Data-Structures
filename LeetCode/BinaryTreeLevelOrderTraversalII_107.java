package LeetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 
 * Given a binary tree, return the bottom-up level order traversal of its nodes' values. 
 * (ie, from left to right, level by level from leaf to root).

For example:

Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
   
return its bottom-up level order traversal as:

[
  [15,7],
  [9,20],
  [3]
]

 *
 * Solution: https://discuss.leetcode.com/topic/28537/java-solution-using-queue
 * 
 * @author Rudolf
 *
 */
public class BinaryTreeLevelOrderTraversalII_107 {

	/**
     * Idea: reversed BFS w/ new list on each level. Add new list to head of original list.
     * 
     * Create List<List<Integer>> and Queue<TreeNode>
     * If root is null, return List<List<Integer>>
     * Add root to Queue
     * 
     * While Queue is not empty:
     *      Create List<Integer> for each level
     *      For each element in the Queue (level elements)
     *          Poll first element
     *          Add polled element's val to List<Integer>
     *          if its left child exists, add to Queue
     *          if its right child exists, add to Queue
     *      Add List<Integer> to List<List<Integer>>
     * Return List<List<Integer>>
     * 
     */
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        
        List<List<Integer>> result = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        
        if (root == null) return result;
        
        queue.offer(root);
        
        while (!queue.isEmpty()) {
            
            List<Integer> rowValues = new ArrayList<>();
            
            int rowSize = queue.size();
            
            for (int i = 0; i < rowSize; ++i) {
                
                TreeNode current = queue.poll();
                rowValues.add(current.val);
                
                if (current.left != null) queue.offer(current.left);
                if (current.right != null) queue.offer(current.right);
                
            }
            
            result.add(0, rowValues);
        }
        
        return result;
    }
	
}
