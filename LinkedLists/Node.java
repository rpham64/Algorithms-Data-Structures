package LinkedLists;
/* My LinkedList Node Implementation
 * By: Rudolf
 * 
 */

/* Types of Linked Lists:
	1) Singly 
	2) Doubly
	3) Circular Singly
	4) Circular Doubly
*/

// Assumption: linked list is already created (with head)
public class Node {

	// Two components: data (element), and next (pointer)
	Object data;
	Node next;
	Node head = null;
	
	public Node(Object data) {
		this.data = data;
	}
	
	/**
	 * Given Object, add and re-assign to head of linked list. 
	 * 
	 * @param data
	 */
	public void addFirst(Object data) {
		
		// Create new Node with data
		Node node = new Node(data);
		
		// Re-assign head to this node
		node.next = head;
		head = node;
		
	}
	
	/**
	 * Given Object, adds new Node with Object to end of linked list
	 * 
	 * @param data
	 */
	public void addLast(Object data) {
		
		// Check: Empty linked list (head is null)
		if (head == null) addFirst(data);
		
		// Traverse linked list until next is null
		// Add new node with next pointing to null
		Node curr = head;
		
		while (curr.next != null) {
			curr = curr.next;
		}
		
		curr.next = new Node(data);
		
	}

	/**
	 * Given a Node key and Object data, traverses the linked list
	 * until key is reached, then creates a new Node with data after key.
	 * 
	 * @param key
	 * @param data
	 */
	public void insertAfter(Node key, Object data) {
		
		// Check: linked list is empty
		if (head == null) return;
		
		// Set curr to head
		Node curr = head;
		
		// While curr is not key, set curr to curr.next
		while (curr != key) {
			curr = curr.next;
		}
		
		// If key is found (curr not null)
		if (curr != null) {
			
			// Create new Node with data
			// Set curr.next to this new Node
			Node newNode = new Node(data);
			curr.next = newNode;
			
		}
		
	}
	
	/*	Inserts new node before specified node
	 * 	@param data (whose node we insert before)
	 * 	@param toInsert (new node to insert)
	 */
	
	/**
	 * Given Node key, inserts a new node with data before key.
	 * 
	 * @param data
	 * @param toInsert
	 */
	public void insertBefore(Node key, Object data) {
		
		// Check: linked list is empty
		if (head == null) return;
		
		Node prev = null;
		Node curr = head;
		
		// Traverse list until current node is key
		while (curr != key && curr != null) {
			prev = curr;
			curr = curr.next;
		}
		
		// Found key
		// Insert new node with data after prev and before curr
		if (curr != null) {
			
			Node node = new Node(data);
			
			node.next = curr;
			prev.next = node;
			
		}
		
		// Not found: return null
	}
	
	/**
	 * Given an Object, deletes the node containing the Object.
	 * 
	 * @param data
	 * @return
	 */
	public Node delete(Object data) {
		
		// Base Case: 0 elements
		if (head == null) return head;
		
		// Base Case: 1 node w/ data
		if (head.data == data) {
			Node temp = head;
			head = head.next;
			return temp;
		}
		
		// Iterative Step: head does not have data OR 2+ elements in list
		
		// Create prev and curr pointers
		Node prev = null;
		Node curr = head;
		
		// Traverse the list until data is found OR current node is null
		while (curr.data != data && curr != null) {
			prev = curr;
			curr = curr.next;
		}
		
		// If data is found and curr is not null 
		// 		Store curr as temp and delete curr
		// 		Return temp
		if (curr != null) {
			Node temp = curr;
			prev.next = curr.next;
			return temp;
		}
		
		return null;
	}
	
	
	
}
