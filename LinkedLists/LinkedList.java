package LinkedLists;

import LinkedList.LinkedListInterface;
import LinkedList.Node;

/**
 * Linked List Implementation
 * 
 * Types of Linked Lists:
 * 		1) Singly
 * 		2) Doubly
 * 		3) Circular Singly
 * 		4) Circular Doubly
 * 
 * @author Rudolf
 *
 */
public class LinkedList implements LinkedListInterface {

	// Member Variables
	private Node head;		// Head node of list
	
	// Default Constructor (empty list)
	public LinkedList() {
		head = new Node(null);
	}
	
	/**
	 * Returns the size of the linked list.
	 * 
	 * Idea: Traverse the linked list and increment a counter.
	 * 
	 * @return
	 */
	@Override
	public int size() {
		
		int count = 0;
		
		Node curr = head;
		
		// While curr is not null
		//		Re-assign the curr pointer
		//		Increment count
		while (curr != null) {
			curr = curr.next;
			count++;
		}
		
		return count;
	}
	
	/**
	 * Returns a string representation of the linked list
	 */
	@Override
	public String toString() {
		return "";
	}
	
	/**
	 * Returns true if the list is empty, else false.
	 * 
	 * @return
	 */
	@Override
	public boolean isEmpty() {
		return size() == 0;
	}

	/**
	 * Adds new node with data at the head of the list
	 * 
	 * Idea: Replace head with new node containing data
	 * 
	 * @param data
	 */
	@Override
	public void addFirst(Object data) {
		
		// Create new node with data
		Node newNode = new Node(data);
		
		// node.next := head
		newNode.next = head;
		
		// Re-assign head to node
		head = newNode;
		
	}

	/**
	 * Adds new node with data at the tail of the list
	 * 
	 * Idea: Traverse the list until current node is the last node.
	 * Create a new node containing data and insert it after the last node.
	 * 
	 * @param data
	 */
	@Override
	public void addLast(Object data) {

		// Check: empty list
		if (head == null) addFirst(data);
		
		// Create current node pointer
		Node curr = head;
		
		// while curr.next != null
		//		curr := curr.next
		while (curr.next != null) {
			curr = curr.next;
		}
		
		// Reached last node in list
		// Create new node with data
		// newNode.next := curr.next
		// curr.next := newNode
		Node newNode = new Node(data);
		newNode.next = curr.next;
		curr.next = newNode;
		
	}

	/**
	 * Adds new node with data after the specified node
	 * 
	 * @param key
	 * @param data
	 */
	@Override
	public void add(Node key, Object data) {
		
		// Check: key is null
		if (key == null) return;
		
		// Check: list is empty
		if (head == null) return;
		
		// Create current node pointer. Assign to head.
		Node curr = head;
		
		// while curr != key
		//		curr := curr.next
		while (curr != key) {
			curr = curr.next;
		}
		
		// If curr != null
		// 		Create new node with data
		// 		newNode.next := curr.next
		// 		curr.next := newNode
		if (curr != null) {
			Node newNode = new Node(data);
			newNode.next = curr.next;
			curr.next = newNode;
		}
		
	}

	/**
	 * Adds new node with data at the specified index
	 * 
	 * @param data
	 * @param index
	 */
	@Override
	public void add(int index, Object data) {

		// Check: empty list
		if (head == null) return;
		
		// Check: index is out of bounds
		if (index <= 0 || index >= size()) return;
		
		// Create counter = 1, current pointer := head
		int counter = 1;
		Node curr = head;
		
		// while counter != index AND curr != null
		//		curr := curr.next
		//		counter++
		while (counter != index && curr != null) {
			curr = curr.next;
			counter++;
		}
		
		// If curr != null
		//		Create new node with data
		//		newNode.next := curr.next
		//		curr.next := newNode
		if (curr != null) {
			Node newNode = new Node(data);
			newNode.next = curr.next;
			curr.next = newNode;
		}
		
	}

	/**
	 * Returns the node at the specified index
	 * 
	 * @param index
	 * @return
	 */
	@Override
	public Node get(int index) {

		// Check: index out of bounds
		if (index <= 0 || index >= size()) {
			throw new IndexOutOfBoundsException("Index is out of bounds.");
		}
		
		// Create counter = 1, current pointer := head
		int counter = 1;
		Node curr = head;
		
		// while counter != index AND curr != null
		//		curr := curr.next
		//		counter++
		while (counter != index && curr != null) {
			curr = curr.next;
			counter++;
		}
		
		// Counter reaches index
		// if curr is not null, return curr
		if (curr != null) return curr;
		
		// Index not reached
		return null;
	}

	/**
	 * Removes the node with data
	 * 
	 * @param Node
	 * @return
	 */
	@Override
	public Node remove(Object data) {

		// Current and previous pointers
		Node curr = head;
		Node prev = null;
		
		// Traverse the list and search for Node with data
		while (curr != null) {
			
			// Check: current node has data
			if (curr.data.equals(data)) {
				
				Node temp = curr;
				
				// Check: current node is head
				if (curr == head) {
					head = head.next;		// Remove head
				}
				else {
					prev.next = curr.next;	// Remove current node
				}
				
				return temp;
				
			}
			else {
				prev = curr;
				curr = curr.next;
			}
			
		}
		
		// Not found. curr is null.
		return curr;
	}

	/**
	 * Removes the head node of the list
	 * 
	 */
	@Override
	public Node removeHead() {
		
		// Check: empty list
		if (isEmpty()) return null;
		
		Node temp = head;
		head = head.next;
		
		return temp;
	}

	/**
	 * Removes the tail/last node of the list
	 * 
	 */
	@Override
	public Node removeTail() {

		// Check: empty list
		if (isEmpty()) return null;
		
		// Current and previous pointers
		Node curr = head;
		Node prev = null;
		
		// Traverse list until curr.next == null
		while (curr.next != null) {
			prev = curr;
			curr = curr.next;
		}
		
		// Remove tail node
		Node tail = curr;
		prev.next = curr.next;
		
		return tail;
	}
	
	/**
	 * Removes the node at the specified index
	 * 
	 * @param index
	 * @return
	 */
	@Override
	public Node remove(int index) {

		// Check: Index is out of bounds
		if (index <= 0 || index >= size()) {
			throw new IndexOutOfBoundsException("Index is out of bounds.");
		}
		
		// Check: index is 1 (head)
		if (index == 1) {
			
		}
		
		// Current and previous pointers
		Node curr = head;
		Node prev = null;
		
		// Index Counter
		int counter = 1;	// Head starts at index 1
		
		// Traverse list until counter == index
		while (curr != null) {
			
			Node temp = curr;
			
			// Check: Index is 1 (head)
			if (index == 1) {
				head = head.next;
			}
			else {
				
				// Check: Counter == index
				if (counter == index) {
					prev.next = curr.next;
				}
				
			}
			
			// 
			prev = curr;
			curr = curr.next;
			
		}
		
		return curr;
	}

	/**
	 * Reverses a singly linked list
	 * 
	 * @param head
	 * @return
	 */
	public Node reverseList(Node head) {
		
		// Check: empty list or 1 element only (head)
		if (head == null || head.next == null) return head;
		
		Node prev = head;
		Node curr = head.next;
		
		head.next = null;
		
		while (curr != null) {
			
			Node next = curr.next;
			curr.next = prev;
			prev = curr;
			
			if (next != null) {
				curr = next;
			} else {
				break;
			}
			
		}
		
		// prev is now the last Node
		head = prev;
		
		return curr;
	}
	
	
	
}
