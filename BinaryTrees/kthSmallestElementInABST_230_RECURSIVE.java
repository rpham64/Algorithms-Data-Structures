
/**
 * Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.
	
	Note: 
	You may assume k is always valid, 1 <= k <= BST's total elements.
	
	Follow up:
	
	What if the BST is modified (insert/delete operations) often and you need to find the kth smallest frequently? 
	How would you optimize the kthSmallest routine?
 * 
 * @author rpham
 *
 */
public class kthSmallestElementInABST_230_RECURSIVE {

	private int counter = 0;
    private int result = 0;  // kth smallest value.
    
    /**
    *   Solutions:
    *       1) Inorder Traversal + Ranking via counter
    *           - Time: O(n) where n is the number of nodes in the BST.
    *           - Space: O(h) = O(n) where h is the max height of the tree.
    *       2) Inorder Traversal (recursion)
    *           - Time: O(n) where n is the number of nodes in the BST.
    *           - Space: O(n) where n is the max number of function calls in the call stack. Also number of nodes.
    */
    public int kthSmallest(TreeNode root, int k) {
        inorder(root, k);
        return result;
    }
    
    private void inorder(TreeNode root, int k) {
        if (root == null) return;
        
        inorder(root.left, k);
        if (++counter == k) result = root.val;
        inorder(root.right, k);
    }
}
