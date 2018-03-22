package BinaryTrees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * A compilation of common algorithms and properties of binary trees.
 * 
 * Definitions
 * 
 * Source: https://en.wikipedia.org/wiki/Tree_%28data_structure%29
 * 
 * Root
 * The top node in a tree.
 * 
 * Child
 * A node directly connected to another node when moving away from the Root.
 * 
 * Parent
 * The converse notion of a child.
 * 
 * Siblings
 * A group of nodes with the same parent.
 * 
 * Descendant
 * A node reachable by repeated proceeding from parent to child.
 * 
 * Ancestor
 * A node reachable by repeated proceeding from child to parent.
 * 
 * Leaf
 * (less commonly called External node)
 * A node with no children.
 * 
 * Branch
 * 
 * Internal node
 * A node with at least one child.
 * 
 * Degree
 * The number of subtrees of a node.
 * 
 * Edge
 * The connection between one node and another.
 * 
 * Path
 * A sequence of nodes and edges connecting a node with a descendant.
 * 
 * Level
 * The level of a node is defined by 1 + (the number of connections between the node and the root).
 * 
 * Height of node
 * The height of a node is the number of edges on the longest path between that node and a leaf.
 * 
 * Height of tree
 * The height of a tree is the height of its root node.
 * 
 * Depth
 * The depth of a node is the number of edges from the tree's root node to the node.
 * 
 * Forest
 * A forest is a set of n >= 0 disjoint trees.
 * 
 * @author Rudolf
 *
 */
public class BinaryTrees {
	
	/**
	 * Terminology:
	 * 		- Root nodes have depth 0
	 * 		- Leaf nodes have height 0
	 * 		- Tree with only one node (root only) has depth and height 0
	 * 		- Empty tree has height and depth -1 (depends, since some like Leetcode require empty to be 0)
	 * 
	 */

	private TreeNode root;	// Root node pointer. Null for empty tree
	
	/**
	 * Creates an empty binary tree -- null root pointer
	 */
	public void BinaryTree() {
		root = null;
	}
	
	public void BinaryTree(int value) {
		root = new TreeNode(value);
	}
	
	public TreeNode getRoot() {
		return root;
	}

	public void setRoot(TreeNode root) {
		this.root = root;
	}

	public static void main(String[] args) {
		
		/**
		 * Source: https://stackoverflow.com/a/2603707
		 * 
		 * Definitions (for a node)
		 * 		- Depth: Number of edges from node to root node.
		 * 		- Height: Number of edges on the LONGEST PATH from node to a leaf node.
		 * 
		 * Simple way to think about depth and height:
		 * 		- Depth goes DOWN from root to node.
		 * 		- Height goes UP from leaf to node.
		 * 
		 * Tree Example:
		 * 				8			- Depth 0, Height 3
		 * 			   / \
		 * 			  3  10			- Depth 1, Height 2 (height of 3 is 2)
		 *           / \   \
		 *          1   6   14      - Depth 2, Height 1	(height of 1 is 0)
		 *             / \  /
		 *            4  7 13		- Depth 3, Height 0
		 *            
		 *	Height (max) = 3
		 *	Depth (max) = 3
		 * 	Root only => depth = 1
		 */
		
		BinaryTrees test = new BinaryTrees();
		TreeNode root = new TreeNode(8);
//		root.left = new TreeNode(3);
//		root.right = new TreeNode(10);
//		root.left.left = new TreeNode(1);
//		root.left.right = new TreeNode(6);
//		root.right.right = new TreeNode(14);
//		root.left.right.left = new TreeNode(4);
//		root.left.right.right = new TreeNode(7);
//		root.right.right.left = new TreeNode(13);
		test.setRoot(root);
		
		test.insert(3);
		test.insert(10);
		test.insert(1);
		test.insert(6);
		test.insert(14);
		test.insert(4);
		test.insert(7);
		test.insert(13);
		
		/** Methods */
//		test.DFS(root);
		test.BFS(root);
//		
//		test.printInOrder();
//		test.printPreOrder();
//		test.printPostOrder();
//		
//		System.out.println("Size: " + test.size());
//		System.out.println("Height: " + test.height());
//		System.out.println("Depth: " + test.depth());
//		test.hasPathSum(21);
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
	
	public void insert(TreeNode node, int data) {
		
		// Input Check: if node is null, create new node with data
		if (node == null) return;
		
		// Since insertion is BFS-based and you want to keep a complete binary tree,
		// apply recursion on node.left, then node.right
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(node);
		
		/**
		 * Cases:
		 * 		1)	Node.left
		 * 			- Null => Create new node and return
		 * 			- Non-null => Add to queue
		 * 		2)	Node.right
		 * 			- Null => Create new node and return
		 * 			- Non-null => Add to queue
		 */
		while (!queue.isEmpty()) {
			
			TreeNode current = queue.poll();
			
			if (current.left == null) {
				current.left = new TreeNode(data);
				return;
			}
			if (current.right == null) {
				current.right = new TreeNode(data);
				return;
			}
			
			queue.offer(current.left);
			queue.offer(current.right);
		}
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
	 * Number of EDGES on the LONGEST PATH from a node to a leaf
	 * 
	 * Note: The height of a TREE is the height of its root node (max height)
	 * 
	 * Cases:
	 * 		1)	Empty tree (return -1)
	 * 		2)	Root only (return 0)
	 * 		3)	1 or 2 children
	 * 
	 * @return
	 */
	public int height() {
		return height(root);
	}
	
	public int height(TreeNode root) {
		
		// Case 1
		if (root == null) return -1;
		
		// Case 2
		if (root.left == null && root.right == null) return 0;
		
		return 1 + Math.max(height(root.left), height(root.right));
	}
	
    /**
     * Number of EDGES from node to root
     * 
     * Cases:
     *      1) Null tree (depth = 0)
     *      2) Root only (depth = 1)
     *      3) 1 or 2 children
     *          - Return 1 + max(left depth, right depth)
     * 
     */
	private int depth() {
		return depth(root);
	}
	
    private int depth(TreeNode node) {
        
        // Case 1
        if (node == null) return 0;
        
        // Case 2
        if (node.left == null && node.right == null) return 0;
        
        // Case 3
        return 1 + Math.max(depth(node.left), depth(node.right));
    }
	
	/**
	 * Given a binary tree, find its minimum depth.
	 * 
	 * The minimum depth is the number of nodes along the shortest path 
	 * from the root node down to the nearest leaf node.
	 * 
	 * @param root
	 * @return
	 */
	public int minDepth(TreeNode root) {
		
	    // Case 1: Null tree
	    if (root == null) return 0;
	    
	    // Case 2: Only root in tree
	    if (root.left == null && root.right == null) return 0;
	    
	    // Case 3: Only one child
	    if ((root.left != null && root.right == null) || (root.left == null && root.right != null)) {
	        return 1 + Math.max(minDepth(root.left), minDepth(root.right));
	    }
	    
	    // Case 4: compare left and right subtrees
	    return 1 + Math.min(minDepth(root.left), minDepth(root.right));
		
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
	
	public int maxDepth_iterative(TreeNode root) {
		
        // Case 1
        if (root == null) return 0;
        
        // Case 2
        if (root.left == null && root.right == null) return 1;
        
        // Case 3: Using BFS, or level order traversal
        int depth = 0;      // Initial depth
        Queue<TreeNode> queue = new LinkedList<>();
        
        queue.offer(root);
        
        while (!queue.isEmpty()) {
            
            int rowSize = queue.size();
            
            for (int i = 0; i < rowSize; ++i) {
                
                TreeNode currentNode = queue.poll();
                
                if (currentNode.left != null) queue.offer(currentNode.left);
                if (currentNode.right != null) queue.offer(currentNode.right);
                
            }
            
            depth++;
        }
        
        return depth;
		
	}
	
	/**
     * Breadth-First Search/Traversal
     * 
     * Time Complexity: O(n) where n is the number of TreeNodes
     * Space Complexity: O(w) where w is the maximum width of the tree
     * 
     * @param root
     * @return
     */
    public TreeNode BFS(TreeNode root) {
    	
    	// Null Check: root is null
    	if (root == null) return root;
    	
    	Queue<TreeNode> queue = new LinkedList<>();		// Since Queue is abstract and cannot be instantiated
    	
    	queue.offer(root);
    	
    	while (!queue.isEmpty()) {
    		
    		int levelSize = queue.size();		// Number of nodes in current level
    		
    		for (int i = 0; i < levelSize; ++i) {
    			
    			TreeNode current = queue.poll();
    			
    			// Do something with current
    			System.out.println("Current: " + current.val);
    			
    			// Add current's children
    			if (current.left != null) queue.offer(current.left);
    			if (current.right != null) queue.offer(current.right);
    		}
    	}
    	
    	return root;
    }
	
	/**
	 * Depth First Search/Traversal
	 * 
	 * Three choices: Preorder, Inorder, Postorder
	 * 
	 * Time Complexity: O(n) where n is the number of TreeNodes
	 * Space Complexity: O(h) where h is the height of the tree
	 * 
	 * @param root
	 * @return
	 */
    public TreeNode DFS(TreeNode root) {
    	
    	// Null Check: root is null
    	if (root == null) return root;
    	
    	Stack<TreeNode> stack = new Stack<>();
    	
    	stack.push(root);
    	
    	while (!stack.isEmpty()) {
    		
    		TreeNode current = stack.pop();
    		
    		// Do something with current
    		System.out.println("Current: " + current.val);
    		
    		// Add current's children
    		// If left-to-right, push right, then left
    		// If right-to-left, push left, then right
    		if (current.right != null) stack.push(current.right);
    		if (current.left != null) stack.push(current.left);
    	}
    	
    	return root;
    }
		
	/**
	 * Inorder Tree Traversal
	 * 
	 * Prints node values in the "inorder" order.
	 * Uses recursive helper to do the traversal.
	 */
	public void printInOrder() {
		System.out.print("In order: ");
		printInOrder(root);
		System.out.println("");
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
		System.out.print("Pre Order: ");
		printPreOrder(root);
		System.out.println("");
	}
	
	public void printPreOrder(TreeNode node) {
		
		// Input Check: if node is null, return
		if (node == null) return;
		
		// Print root, then left subtree, then right subtree
		System.out.print(node.val + " ");
		printPreOrder(node.left);
		printPreOrder(node.right);
	}
	
	/**
	 * PostOrder Tree Traversal
	 * 
	 * Prints node values in the "postorder" order.
	 * Uses recursive helper to do the traversal.
	 */
	public void printPostOrder() {
		System.out.print("Post Order: ");
		printPostOrder(root);
		System.out.println("");
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
	 * Cases:
     * 		1) Null tree (sum does not exist)
     *          - Return false
     *      2) Current node is a leaf and path has the correct sum
     *          - If so, return true
     *          - Else, apply recursion on left and right children
	 * 
	 * @param sum
	 * @return
	 */
	public boolean hasPathSum(int sum) {
		return hasPathSum_RECURSIVE(root, sum);
	}
	
	public boolean hasPathSum_RECURSIVE(TreeNode root, int sum) {
		
        // Case 1
        if (root == null) return false;
        
        // Case 2
        sum -= root.val;
        
        System.out.println("Sum at node " + root.val + ": " + sum);
        
        if (root.left == null && root.right == null && sum == 0) return true;
        
        return hasPathSum_RECURSIVE(root.left, sum) || hasPathSum_RECURSIVE(root.right, sum);
	}
	
	public boolean hasPathSum_ITERATIVE(TreeNode root, int sum) {
        
        if (root == null) return false;
        
        // Keep two stacks: one for TreeNodes, one for current sum
        Stack<TreeNode> nodes = new Stack<>();
        Stack<Integer> sums = new Stack<>();
        
        nodes.push(root);
        sums.push(sum);
        
        while (!nodes.empty()) {
            
            TreeNode currentNode = nodes.pop();
            int currentSum = sums.pop();
            
            currentSum -= currentNode.val;
            
            // If leaf and sum is 0, we found the path
            if (currentNode.left == null && currentNode.right == null && currentSum == 0) return true;
            
            if (currentNode.right != null) {
                nodes.push(currentNode.right);
                sums.push(currentSum);
            }
            if (currentNode.left != null) {
                nodes.push(currentNode.left);
                sums.push(currentSum);
            }
        }
        
        return false;
    }
	
	/**
	 * Inverts a binary tree.
	 * 
	 * Example:

		     4
		   /   \
		  2     7
		 / \   / \
		1   3 6   9
		
		to
		
		     4
		   /   \
		  7     2
		 / \   / \
		9   6 3   1
	 * 
	 * Strategy: For each visited node, swap its children. An easy solution is to use DFS or BFS
	 * 			since they visit every node.
	 * 
	 * @param root
	 * @return
	 */
    public TreeNode invertTree(TreeNode root) {
        
        // Null Check: tree is null
        if (root == null) return root;
        
        // Swap children
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        
        // Call invertTree on left and right
        invertTree(root.left);
        invertTree(root.right);
        
        return root;
    }
    
    public TreeNode invertTree_DFS(TreeNode root) {
        
        // Null Check: tree is null
        if (root == null) return root;
        
        Stack<TreeNode> stack = new Stack<>();
        
        stack.push(root);
        
        while (!stack.isEmpty()) {
            
            TreeNode currentNode = stack.pop();
            
            swapChildren(currentNode);
            
            if (currentNode.left != null) stack.push(currentNode.left);
            if (currentNode.right != null) stack.push(currentNode.right);
            
        }
        
        return root;
    }
    
    public TreeNode invertTree_BFS(TreeNode root) {
        
        // Null Check: tree is null
        if (root == null) return root;
        
        Queue<TreeNode> queue = new LinkedList<>();
        
        queue.offer(root);
        
        while (!queue.isEmpty()) {
            
            TreeNode currentNode = queue.poll();
            
            swapChildren(currentNode);
            
            if (currentNode.left != null) queue.offer(currentNode.left);
            if (currentNode.right != null) queue.offer(currentNode.right);
            
        }
        
        return root;
    }
    
    private void swapChildren(TreeNode current) {
        TreeNode temp = current.left;
        current.left = current.right;
        current.right = temp;
    }
    
    /**
     * Given a binary tree, determine if it is height-balanced.
     * 
     * For this problem, a height-balanced binary tree is defined as a binary tree 
     * in which the depth of the two subtrees of every node never differ by more than 1.
     * 
     */
    
    /**
     * Similar to max and min depth of binary tree, except taking difference in depths of left and right subtrees
     * 
     * Time Complexity: O(n log n) average, O(n^2) worst
     * Space Complexity: O(1)
     * 
     * Cases:
     *      1) Empty tree
     *          - Depth = 0     =>      True
     *      2) 0 children, only root    
     *          - Depth = 1     =>      True
     *      3) 1 or 2 children
     *          - Apply recursion to both left and right
     *          - Check if both are balanced and difference in depth is not more than 1
     */
    public boolean isBalanced(TreeNode root) {
        
        // Case 1
        if (root == null) return true;
        
        // Case 2
        if (root.left == null && root.right == null) return true;
        
        // Case 3
        int leftDepth = depth(root.left);
        int rightDepth = depth(root.right);
        int diff = Math.abs(leftDepth - rightDepth);
        
        return diff <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }
    
    /**
     * LeetCode 100. Same Tree
     * 
     * Given two binary trees, write a function to check if they are equal or not.
     * 
     * Two binary trees are considered equal if they are structurally identical 
     * and the nodes have the same value.
     * 
     * 
     * 
     * Idea: Recurse down both trees, comparing nodes.
     * 
     * Cases:
     *      1) Both null (true)
     *      2) p or q is null, but not both (false)
     *      3) p and q are non-null
     *          - True if every node's values in both trees are equal
     *          - Else, false
     * 
     * 
     * @param p
     * @param q
     * @return
     */
    public boolean isSameTree(TreeNode p, TreeNode q) {
        
        // Case 1
        if (p == null && q == null) return true;
        
        // Case 2
        if (p == null || q == null) return false;
        
        // Case 3
        return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
