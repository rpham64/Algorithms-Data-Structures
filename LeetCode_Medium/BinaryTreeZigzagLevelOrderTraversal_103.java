package LeetCode_Medium;

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
 * @author Rudolf
 *
 */
public class BinaryTreeZigzagLevelOrderTraversal_103 {

	/**
     * Idea: Using BFS and depth, iterate left-to-right for even depths and right-to-left for odd depths.
     *      Store each level's values into a list, then add that list to the final list<list<>>
     * 
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        
        List<List<Integer>> result = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        int depth = 0;
        
        // Null Check
        if (root == null) return result;
        
        queue.offer(root);
        
        while (!queue.isEmpty()) {
            
            List<Integer> rowValues = new LinkedList<>();
            int rowSize = queue.size();
            
            // Even depth => Add to back
            // Odd depth => Add to front
            for (int i = 0; i < rowSize; ++i) {
                
                TreeNode currentNode = queue.poll();
                
                // Add node value to rowValues
                if (depth % 2 == 0) {
                    rowValues.add(currentNode.val);
                } else {
                    rowValues.add(0, currentNode.val);
                }
                
                // Add node's children to queue, if they exist
                if (currentNode.left != null) queue.offer(currentNode.left);
                if (currentNode.right != null) queue.offer(currentNode.right);
            }
            
            depth++;
            result.add(rowValues);
        }
        
        return result;
    }
}
