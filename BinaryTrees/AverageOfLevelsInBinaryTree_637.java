package BinaryTrees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given a non-empty binary tree, return the average value of the 
 * nodes on each level in the form of an array.
 * 
	Example 1:
	
	Input:
	    3
	   / \
	  9  20
	    /  \
	   15   7
	Output: [3, 14.5, 11]
	
	Explanation:
	The average value of nodes on level 0 is 3,  on level 1 is 14.5, and on level 2 is 11. 
	Hence return [3, 14.5, 11].
	
	Note:
	The range of node's value is in the range of 32-bit signed integer.
 * 
 * @author Rudolf
 *
 */
public class AverageOfLevelsInBinaryTree_637 {

    /**
    *   Idea: Use BFS. For every new level, take an average of the values (as Double) and add to result list.
    */
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> averages = new ArrayList<>();
        
        if (root == null) return averages;
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        
        while (queue.size() > 0) {
            
            double rowSize = (double) queue.size();
            double sum = 0;
            
            for (int i = 0; i < rowSize; ++i) {
                TreeNode current = queue.poll();
                sum += current.val;
                
                if (current.left != null) queue.offer(current.left);
                if (current.right != null) queue.offer(current.right);
            }
            
            averages.add(sum / rowSize);
        }
        
        return averages;
    }
}
