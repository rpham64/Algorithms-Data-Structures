package LeetCode_Hard;

import java.util.ArrayList;
import java.util.List;

import LeetCode.TreeNode;

/**
 * 
 * 
 * @author Rudolf
 *
 */
public class BinaryTreePostorderTraversal_145 {

	/** Recursive Version */
	public List<Integer> postorderTraversal(TreeNode root) {
        
        List<Integer> nodes = new ArrayList<Integer>();
        
        // Input Check: empty tree
        if (root == null) return nodes;
        
        List<Integer> leftNodes = new ArrayList<Integer>();
        List<Integer> rightNodes = new ArrayList<Integer>();
        
        if (root.left != null) {
            leftNodes = postorderTraversal(root.left);
        }
        if (root.right != null) {
            rightNodes = postorderTraversal(root.right);
        }
        
        // Add to nodes from leftNodes, then rightNodes, then the root
        for (int val : leftNodes) {
            nodes.add(val);
        }
        for (int val : rightNodes) {
            nodes.add(val);
        }
        nodes.add(root.val);
        
        return nodes;
    }
	
}
