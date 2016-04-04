package LeetCode;

/**
 * Given a binary tree, find the lowest common ancestor (LCA) 
 * of two given nodes in the binary tree.
 * 
 * According to the definition of LCA on Wikipedia: “The lowest common ancestor 
 * is defined between two nodes v and w as the lowest node in T that has both 
 * v and w as descendants (where we allow a node to be a descendant of itself).”
 * 
 * Solution: http://www.fusu.us/2013/06/p2-lowest-common-ancestor-in-binary-tree.html
 * 
 * @author Rudolf
 *
 */
public class LowestCommonAncestor_236 {
	
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
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
