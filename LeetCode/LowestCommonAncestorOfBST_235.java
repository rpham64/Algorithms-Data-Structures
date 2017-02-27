package LeetCode;

/**
 * Given a binary search tree (BST), find the lowest common ancestor (LCA) 
 * of two given nodes in the BST.
 * 
 * According to the definition of LCA on Wikipedia: “The lowest common ancestor 
 * is defined between two nodes v and w as the lowest node in T that has both 
 * v and w as descendants (where we allow a node to be a descendant of itself).
 * 
 * Solution: http://www.fusu.us/2013/06/p2-lowest-common-ancestor-in-binary-tree.html
 * 
 * @author Rudolf
 *
 */
public class LowestCommonAncestorOfBST_235 {
	
    /**
     * Cases:
     *      1) If root.val is greater than p's and q's, apply recursion on root.left
     *      2) Else, if root.val is less than p's and q's, apply recursion on root.right
     *      3) Else,
     *          a) root.val equals p's or q's
     *              => root is LCA
     *          b) root.val < p's but root.val > q's, meaning both p and q are in separate subtrees
     *              => root is LCA
     *              
     *  
     * Time Complexity: O(log n)
     * Space Complexity: O(1)
     * 
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        // Null Check
        if (root == null) return root;
        
        // Case 1
        if (root.val > p.val && root.val > q.val) return lowestCommonAncestor(root.left, p, q);
        
        // Case 2
        if (root.val < p.val && root.val < q.val) return lowestCommonAncestor(root.right, p, q);
        
        // Case 3
        return root;
    }

    /**
     * This method is equivalent to searching for the LCA for a Binary Tree.
     * 
     * Time complexity: O(n)
     * Space Complexity: O(1)
     * 
     * @param root
     * @param p
     * @param q
     * @return
     */
	public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        
        // Check: Empty tree
        if (root == null) return null;
        
        // Check: root is p or q
        if (root == p || root == q) return root;
        
        TreeNode leftLCA = lowestCommonAncestor(root.left, p, q);
        TreeNode rightLCA = lowestCommonAncestor(root.right, p, q);
        
        // By default, nodes are on separate branches so LCA is the tree root
        if (leftLCA != null && rightLCA != null) return root;
        
        // Else, one is the LCA of the other (leftLCA or rightLCA will be null, other will be non-null)
        // return the LCA that is non-null
        //      Reason: the LCA that's null IS the LCA for the other
        return leftLCA != null ? leftLCA : rightLCA;
    }
	
}
