
public class Atheer {

	import java.util.ArrayList;
	import java.util.List;

	/*

	Given a binary tree of integers, write code to store the tree into a list of integers and recreate the original tree from a list of integers. 

	Here's what your method signatures should look like (in Java): 

	List<Integer> store(Node root) 
	Node restore(List<Integer> list) 

	Example Tree: 

	    5 
	   / \ 
	  3   2 
	 /   / \ 
	1   6   1

	class Node {
	  Node left;
	  Node right;
	  int val;
	}

	Inorder: 1 3 null 5 6 2 1
	Preorder: 5 3 1 2 6 1
	BFS: 5 3 2 1 null 6 1

	    5
	   / \
	  3   2
	 / \ / \
	1null 6 1

	*/
	
	class Node {
		int val;
		
	}

	private List<Integer> nodes = new ArrayList<>();

	public List<Integer> store(Node root) {
	    dfs(root);
	    return nodes;
	}

	private void dfs(Node root) {
	    dfs(root.left)
	    if (root == null) {
	        nodes.add(null);
	    } else {
	        nodes.add(root.val);
	    }
	    dfs(root.right);
	}

	public Node restore(List<Integer> list) {
	    return helper(list, 0, list.size() - 1);
	}

	private Node helper(List<Integer> list, int left, int right) {

	    int mid = left + (right - left) / 2;
	    int midValue = list.get(mid);
	    
	    if (midValue == null) return null;
	    Node root = new Node(midValue);
	    
	    root.left = helper(list, left, mid - 1);
	    root.right = helper(list, mid + 1, right);
	    
	    return root;
	}
}
