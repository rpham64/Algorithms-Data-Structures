package LeetCode;

/**
 * Given a binary tree, find the lowest common ancestor (LCA) 
 * of two given nodes in the binary tree.
 * 
 * According to the definition of LCA on Wikipedia: “Tthe lowest common ancestor 
 * is defined between two nodes v and w as the lowest node in T that has both 
 * v and w as descendants (where we allow a node to be a descendant of itself).
 * 
 * Solution: http://www.fusu.us/2013/06/p2-lowest-common-ancestor-in-binary-tree.html
 * 
 * @author Rudolf
 *
 */
public class LowestCommonAncestor_236 {
	
    /**
     * Cases:
     *      1) Null Tree (root is null)
     *      2) Either p or q is the root, therefore the LCA
     *      3) Root is LCA, by default (both p and q are in separate subtrees)
     *      4) Either p or q is the LCA
     *          - If p, then q is in either left or right subtree of p
     *          - If q, then p is in either left or right subtree of q
     *          - Else, root is default LCA
     * 
     * Steps:
     *      1) Starting at root, search for p and q  
     *      2) If one is found, determine if it's the LCA of the other
     *      3) If not, return root (default LCA)
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        // Case 1
        if (root == null) return root;
        
        // Case 2
        if (root == p || root == q) return root;
        
        // Case 3
        TreeNode leftLCA = lowestCommonAncestor(root.left, p, q);
        TreeNode rightLCA = lowestCommonAncestor(root.right, p, q);
        
        if (leftLCA != null && rightLCA != null) return root;       // Both p and q are in separate subtrees
        
        // Case 4
        return leftLCA != null ? leftLCA : rightLCA;
    }
}
