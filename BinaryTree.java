/*	My Binary Tree Implementation
 * 	By: Rudolf Pham
 *
 */

/*Components of a tree:
 * 
 * Initial: root
 * 
 * class: Node
 * 
 * Default constructor
 * 
 * Methods: Lookup, Insert
 * */

public class BinaryTree {

	private TreeNode root;
	
	// Creates an empty binary tree -- a null root pointer
	public BinaryTree() {
		this.root = null;
	}

	/**
	 * Returns true if the given data is in the binary tree.
	 * Uses a recursive helper.
	 * 
	 * @param data
	 * @return
	 */
	
	public boolean lookup(int data) {
		return lookup(root, data);
	}
	
	/**
	 * Recursive lookup -- given a node, recur down
	 * searching for the given data
	 * 
	 * @param node
	 * @param data
	 * @return
	 */
	
	public boolean lookup(TreeNode node, int data) {
		
		// Base Case: 0 elements
		if (root == null) return false;
		
		// Base Case: 1 element (root)
		if (node.getData() == data) return true;
		
		// Iterative Step: 2+ elements. Root doesn't contain data.
		else if (data <= node.getData()) {
			return lookup(node.getLeft(), data);
		}
		else {
			return lookup(node.getRight(), data);
		}
		
	}
	
	/**
	 * Returns true if the given data was inserted into
	 * the binary tree.
	 * Uses a recursive helper.
	 * 
	 * @param data
	 * @return
	 */
	
	public TreeNode insert(int data) {
		return insert(root, data);
	}
	
	/**
	 * Recursive insert -- given a node, recurs down
	 * and creates a new node with the given data 
	 * into the tree.
	 * 
	 * @param node
	 * @param data
	 * @return new inserted node
	 */
	
	public TreeNode insert(TreeNode node, int data) {
		
		// Base Case: Node does not exist
		if (node == null) {
			node = new TreeNode(data);
		}
		
		// Else, if data is less than node's data
		//		call insert on node's left
		// Else, (if data is greater than node's data)
		//		call insert on node's right
		else if (data <= node.getData()) {
			return insert(node.getLeft(), data);
		}
		else {
			return insert(node.getRight(), data);
		}
		
		return node;
	}
	
	/**
	 * Builds a binary search tree with 2 (root), 1 (left) and 3 (right)
	 * 
	 */
	
	public void build123() {
		
		// Method 1 -- Call new Node three times and use three pointer variables
/*		root = new TreeNode(2);
		
		TreeNode leftChild = new TreeNode(1);
		TreeNode rightChild = new TreeNode(3);
		
		root.setLeft(leftChild);
		root.setRight(rightChild);*/
		
		// Method 2 -- Call new Node three times and use only one pointer variable
/*		root = new Node(2);
		TreeNode leftChild = root.setLeft(new TreeNode(1));
		TreeNode rightChild = root.setRight(new TreeNode(3));*/
		
		// Method 3 -- Call insert() three times, passing it the root pointer
		root = insert(2);
		root.setLeft(insert(1));
		root.setRight(insert(3));
		
	}
	
	/**
	 * Counts the number of nodes in the binary tree.
	 * Uses a recursive helper to recur down the tree
	 * and count the nodes
	 * 
	 * @return number of nodes
	 */
	
	public int size() {
		
		return size(root);
	}
	
	/**
	 * Recursive count -- given a TreeNode node, recurs down the
	 * binary tree and counts the nodes
	 * 
	 * @param node
	 * @return
	 */
	
	public int size(TreeNode node) {
		
		// Base Case: 0 elements
		if (node == null) return 0;
		
		// Iterative Step: 1+ elements
		// Counts root + left child subtree (recursion) + right child subtree (recursion)
		return 1 + size(node.getLeft()) + size(node.getRight());
	}
	
	
	
}