package BinaryTrees;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

/**
 * Given a binary search tree (BST) with duplicates, find all the mode(s) (the most frequently occurred element) 
 * in the given BST.
	
	Assume a BST is defined as follows:
	
	The left subtree of a node contains only nodes with keys less than or equal to the node's key.
	The right subtree of a node contains only nodes with keys greater than or equal to the node's key.
	Both the left and right subtrees must also be binary search trees.
	
	For example:
	
	Given BST [1,null,2,2],
	   1
	    \
	     2
	    /
	   2
	return [2].
	
	Note: If a tree has more than one mode, you can return them in any order.
	
	Follow up: Could you do that without using any extra space? 
	(Assume that the implicit stack space incurred due to recursion does not count).
 * 
 * @author Rudolf
 *
 */
public class FindModeInBST_501 {

	/**
     * Idea: Use DFS or BFS to check all nodes in tree. Increment frequency of visited node in hashmap and keep track of maxCount.
     *      Create int[] and check all keys in hashmap. If count equals maxCount, add to int[].
     *      
     * Time Complexity: O(n)
     * Time: 25 ms
     * Space Complexity: O(n)     
     */
    public int[] findMode(TreeNode root) {
        
        if (root == null) return new int[0];
        
        HashMap<Integer, Integer> count = new HashMap<>();
        int maxCount = 0;
        
        // DFS and update map and maxCount
        Stack<TreeNode> stack = new Stack<>();
        
        stack.push(root);
        
        while (!stack.empty()) {
            
            TreeNode current = stack.pop();
            
            if (count.containsKey(current.val)) {
                
                int newCount = count.get(current.val) + 1;
                count.put(current.val, newCount);
                
            } else {
                count.put(current.val, 1);
            }
            
            maxCount = Math.max(maxCount, count.get(current.val));
            
            if (current.right != null) stack.push(current.right);
            if (current.left != null) stack.push(current.left);
        }
        
        int[] result = new int[count.size()];
        int index = 0;
        
        for (Integer num : count.keySet()) {
            if (count.get(num) == maxCount) result[index++] = num;
        }
        
        return Arrays.copyOfRange(result, 0, index);
    }
}
