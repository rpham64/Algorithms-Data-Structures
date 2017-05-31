package BinaryTrees;

public class BinarySearchTrees {

	private final TreeNode root;
	
	public BinarySearchTrees() {
		root = null;
	}

	public BinarySearchTrees(int value) {
		root = new TreeNode(value);
	}
	
	/**
	 * Returns the node with minimum value
	 * 
	 * @param root
	 * @return
	 */
	public TreeNode minNode(TreeNode root) {
		
		TreeNode current = root;
		
		while (current.left != null) {
			current = current.left;
		}
		
		return current;
	}
	
	/**
	 * Returns the node with maximum value
	 * 
	 * @param root
	 * @return
	 */
	public TreeNode maxNode(TreeNode root) {
		
		TreeNode current = root;
		
		while (current.right != null) {
			current = current.right;
		}
		
		return current;
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
	 * Cases:
	 * 		1) If node.right is NOT null, successor is the min value in its right subtree
	 * 		2) Else, start search from root.
	 * 			- While root is not null
	 * 				- If node's val is less than root's val, set root as successor and root = root.left
	 * 				- If node's val is greater than root's val, set root = root.right
	 * 				- Else (node's val = root's val), 
	 * 					- Break loop (found successor)
	 * 
	 * @param root
	 * @param node
	 * @return
	 */
	public TreeNode getSuccessor(TreeNode root, TreeNode node) {
		
		// Null Check
		if (root == null || node == null) return null;
		
		// Case 1
		if (node.right != null) return minNode(node.right);
		
		// Case 2
		TreeNode successor = root;
		
		while (root != null) {
			
			if (node.val < root.val) {
				successor = root;
				root = root.left;
			} else if (node.val > root.val) {
				root = root.right;
			} else {
				break;		// Root = Node. Also found successor.
			}
			
		}
		
		return successor;
	}
	
	Q1: Binary search tree, implement insert()

	Public void insert(Node root, int val) {

		// Null or empty tree
		If (root == null) root = new Node(val);

		// If missing child, insert in correct place
		If (val > root.val) {
			If (root.right == null) {
		Root.right = new Node(val);
	} else {
		insert(root.right, val);
	}
	} else if (val < root.val) {
		If (root.left == null) {
			Root.left = new Node(val);
	} else {
		insert(root.left, val);
	}
	}
	}

	// return root of the tree
	Public Node insert(Node root, int val) {

		If (root == null) {
			Node newNode = new Node(val);
			Root = newNode;
			Return newNode;
	}

		Node current = root;
		Node newNode = null;

		While (newNode == null) {
			
			If (val == current.val) return null;

			If (val > current.val) {
				If (current.right == null) {
					newNode = new Node(val);
					current.right = newNode;
	} else {
		Current = current.right;
	}
	} else if (val < current.val) {
		If (current.left == null) {
	newNode = new Node(val);
	current.left = newNode;		
	} else {
		current= current.left;
	}
	}

	}

	Return oldRoot;
	}

}
