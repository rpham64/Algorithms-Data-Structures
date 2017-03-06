package LeetCode_Medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import LeetCode.TreeNode;

/**
 * Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.

For example:
Given the below binary tree and sum = 22,
              5
             / \
            4   8
           /   / \
          11  13  4
         /  \    / \
        7    2  5   1
        
return

[
   [5,4,11,2],
   [5,8,4,5]
]

 * 
 * @author Rudolf
 *
 */
public class PathSumII_113 {

	private List<List<Integer>> paths = new LinkedList<>();		// Because insertion and deletion take O(1) time
    
    /**
     * Idea: Use DFS to check every node in the tree. Add visited node to path.
     *      If node is a leaf and sum minus its value equals 0, add the path to the result.
     *      
     * Data Structure: Stack (push node when visited, pop when finished)
     * 
     * Cases:
     *      1) Empty tree (return null List)
     *      2) Root only OR is leaf
     *          - If sum - node.val == 0, add path stack to result
     *      3) 1 or 2 children (default case)
     *          - Subtract node's value from sum
     *          - Apply recursion on left and right children
     * 
     */
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        Stack<Integer> path = new Stack<>();
        buildPaths(root, sum, path);
        return paths;
    }
    
    private void buildPaths(TreeNode root, int sum, Stack<Integer> path) {
        
        // Case 1
        if (root == null) return;
        
        path.push(root.val);    // Visited
        
        // Case 2
        if (root.left == null && root.right == null && sum - root.val == 0) {
            paths.add(new ArrayList<>(path));
        }
        
        // Case 3
        sum -= root.val;
        
        if (root.left != null) buildPaths(root.left, sum, path);
        if (root.right != null) buildPaths(root.right, sum, path);
        
        path.pop();             // Finished
    }
}
