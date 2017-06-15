package BinaryTrees;

import java.util.ArrayList;
import java.util.List;

public class MinimumAbsoluteDifferenceInBST_530 {

	private int minDifference = Integer.MAX_VALUE;
    private TreeNode prev = null;
    
    /**
     * Solution #1: Inorder traversal with O(1) space and global variables
     * 
     * @param root
     * @return
     */
    public int getMinimumDifference(TreeNode root) {
        
        if (root == null) return minDifference;
        
        getMinimumDifference(root.left);
        
        if (prev != null) {
            minDifference = Math.min(minDifference, root.val - prev.val);
        }
        
        prev = root;
        
        getMinimumDifference(root.right);
        
        return minDifference;
    }
	
    /**
     * Solution #2: Inorder traversal with O(n) space 
     * 
     * @param root
     * @return
     */
	public int getMinimumDifference2(TreeNode root) {
        
        int minDifference = Integer.MAX_VALUE;
        List<Integer> values = new ArrayList<>();
        
        inOrder(root, values);
        
        for (int i = 1; i < values.size(); ++i) {
            minDifference = Math.min(minDifference, Math.abs(values.get(i) - values.get(i-1)));
        }
        
        return minDifference;
    }
    
    private void inOrder(TreeNode root, List<Integer> values) {
        if (root == null) return;
        inOrder(root.left, values);
        values.add(root.val);
        inOrder(root.right, values);
    }
}
