package BinaryTrees;

public class BinaryTrees {

	private TreeNode root;	// Root node pointer. Null for empty tree
	
	/**
	 * Creates an empty binary tree -- null root pointer
	 */
	public void BinaryTree() {
		root = null;
	}
	
	/**
	 * Recursive lookup -- given a node, recur down tree
	 * searching for the given data.
	 * 
	 * @param data
	 * @return true if data is found, else false
	 */
	public boolean lookup(int data) {
		return lookup(root, data);
	}
	
	public boolean lookup(TreeNode node, int data) {
		
		// Input Check: root is null
		if (node == null) return false;
		
		// Base Case: if root has data, return true
		if (node.val == data) return true;
		
		return lookup(node.left, data) || lookup(node.right, data);
	}
	
	/**
	 * Recursive insert -- given a node, recurs down the tree
	 * and inserts the given data into the tree as a leaf.
	 * 
	 * @param data
	 */
	public void insert(int data) {
		insert(root, data);
	}
	
	public TreeNode insert(TreeNode node, int data) {
		
		// Input Check: if node is null, create new node with data
		if (node == null) {
			node = new TreeNode(data);
		}
		
		else {
			
			// TO BE COMPLETED
			
		}
		
		return node;
	}
	
	/**
	 * Returns the number of nodes in the tree.
	 * Uses a recursive helper that recurs down the
	 * tree and counts the nodes.
	 * 
	 * @return
	 */
	public int size() {
		return size(root);
	}
	
	public int size(TreeNode root) {
		
		// Input Check: if node is null, return 0
		if (root == null) return 0;
		
		// Total size = 
		//		size of left subtree + root + size of right subtree
		return size(root.left) + 1 + size(root.right);	
	}
	
	/**
	 * Returns the max root-to-leaf depth of the tree.
	 * Uses a recursive helper that recurs down to find the
	 * max depth.
	 * 
	 * @return
	 */
	public int maxDepth() {
		return maxDepth(root);
	}
	
	public int maxDepth(TreeNode root) {
		
		// Input Check: if node is null, return 0
		if (root == null) return 0;
		
		int leftDepth = maxDepth(root.left);
		int rightDepth = maxDepth(root.right);
		
		return 1 + Math.max(leftDepth, rightDepth);
	}
	
	/**
	 * Returns the min value of a non-empty binary search tree.
	 * Uses a helper method that iterates to the left to
	 * find the min value.
	 * 
	 * @return
	 */
	public int minValue() {
		return minValue(root);
	}
	
	public int minValue(TreeNode node) {
		
		TreeNode current = node;
		
		while (current.left != null) {
			current = current.left;
		}
		
		return current.val;
	}
	
	/**
	 * Returns the max value of a non-empty BST
	 * 
	 * @return
	 */
	public int maxValue() {
		return maxValue(root);
	}
	
	public int maxValue(TreeNode root) {
		
		TreeNode current = root;
		
		while (current.right != null) {
			current = current.right;
		}
		
		return current.val;
	}
	
	/**
	 * Inorder Tree Traversal
	 * 
	 * Prints node values in the "inorder" order.
	 * Uses recursive helper to do the traversal.
	 */
	public void printInOrder() {
		printInOrder(root);
	}
	
	public void printInOrder(TreeNode node) {
		
		// Input Check: if node is null, return
		if (node == null) return;
		
		// Print left subtree, then root, then right subtree
		printInOrder(node.left);
		System.out.print(node.val + " ");
		printInOrder(node.right);
	}
	
	/**
	 * PreOrder Tree Traversal
	 * 
	 * Prints node values in the "postorder" order.
	 * Uses recursive helper to do the traversal.
	 */
	public void printPreOrder() {
		printPreOrder(root);
	}
	
	public void printPreOrder(TreeNode node) {
		
		// Input Check: if node is null, return
		if (node == null) return;
		
		// Print root, then left subtree, then right subtree
		System.out.print(node.val + " ");
		printPostOrder(node.left);
		printPostOrder(node.right);
	}
	
	/**
	 * PostOrder Tree Traversal
	 * 
	 * Prints node values in the "postorder" order.
	 * Uses recursive helper to do the traversal.
	 */
	public void printPostOrder() {
		printPostOrder(root);
	}
	
	public void printPostOrder(TreeNode node) {
		
		// Input Check: if node is null, return
		if (node == null) return;
		
		// Print left subtree, then right subtree, then root
		printPostOrder(node.left);
		printPostOrder(node.right);
		System.out.print(node.val + " ");
	}
	
	/**
	 * Given a tree and sum, returns true if there is a path
	 * from the root down to a leaf such that adding up all 
	 * values along the path equals the given sum.
	 * 
	 * Strategy: while recurring down the tree, subtract the current
	 * node's value from the sum. Check to see if the sum is 0
	 * by the time you reach a leaf.
	 * 
	 * @param sum
	 * @return
	 */
	public boolean hasPathSum(int sum) {
		return hasPathSum(root, sum);
	}
	
	public boolean hasPathSum(TreeNode node, int sum) {
		
		// Input Check: if node is null, check if sum is 0
		if (node == null) return sum == 0;
		
		// Subtract node's value from sum
		sum -= node.val;
		
		return hasPathSum(node.left, sum) || hasPathSum(node.right, sum);
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
