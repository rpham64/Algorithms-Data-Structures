package BinaryTrees;

import java.util.ArrayList;
import java.util.List;

import LeetCode.TreeNode;

/**
 * 
 * 
 * Given a binary tree, return all root-to-leaf paths.

	For example, given the following binary tree:
	
	   1
	 /   \
	2     3
	 \
	  5
	All root-to-leaf paths are:
	
	["1->2->5", "1->3"]
 * 
 * 
 * Solution: http://www.arbrash1989.com/2016/01/07/257-Binary-Tree-Paths/
 * Solution2: http://www.cnblogs.com/yrbbest/p/5014959.html
 * 
 * @author Rudolf
 *
 */
public class BinaryTreePaths_257 {

	public List<String> binaryTreePaths(TreeNode root) {
        
        String path = "";
        List<String> paths = new ArrayList<>();
        
        // Input Check: if root is NOT null, call getPaths
        if (root != null) {
            getPaths(root, path, paths);
        }
        
        return paths;
    }
    
    private void getPaths(TreeNode root, String path, List<String> paths) {
    	
        // Base Case: if root is a leaf, append path + root.val to paths
        if (root.left == null && root.right == null) {
            paths.add(path + root.val);		// Add path to list
        }
        
        // Apply recursion on left and right nodes, if they exist
        if (root.left != null) {
            getPaths(root.left, path + root.val + "->", paths);
        }
        if (root.right != null) {
            getPaths(root.right, path + root.val + "->", paths);
        }
        
    }
	
    public static void main(String[] args) {
    	
    	BinaryTreePaths_257 test = new BinaryTreePaths_257();
    	
    	TreeNode root = new TreeNode(1);
    	root.left = new TreeNode(2);
    	root.right = new TreeNode(3);
    	root.left.right = new TreeNode(5);
    	
    	System.out.println("Solution: " + test.binaryTreePaths(root));
    }
}
