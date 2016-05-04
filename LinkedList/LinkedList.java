package LinkedList;

public class LinkedList {

	Node head;

	/** Constructors */
	public LinkedList() {
		head = null;
	}
	
	public LinkedList(int data) {
		Node node = new Node(data);
		head = node;
	}
	
	/**
	 * Given int data, inserts new Node with data at head of list
	 * 
	 * @param data
	 */
	public void insert(int data) {
		Node node = new Node(data);
		node.next = head;
		head = node;
	}
	
	/**
	 * Inserts new node with data after the given node
	 * 
	 * @param node
	 * @param data
	 */
	public void insertAfter(Node node, int data) {
		
		// Input Check: if node is null, throw new IllegalArgumentException
		if (node == null) {
			
			// Two options
			// 1) Throw an exception
			// 2) Print error message
			throw new IllegalArgumentException("Error. Given node does not exist");
		}
		
		Node newNode = new Node(data);
		newNode.next = node.next;
		node.next = newNode;
	}
	
	/**
	 * Given int data, create new node and add to end of linked list
	 * 
	 * @param data
	 */
	public void insertLast(int data) {
		
		// Input Check: if head is null, add data to head
		if (head == null) {
			insert(data);
			return;
		}
		
		Node newNode = new Node(data);
		
		// Traverse list until current node's next is null
		Node lastNode = head;
		
		while (lastNode.next != null) {
			lastNode = lastNode.next;
		}
		
		newNode.next = null;
		lastNode.next = newNode;
	}
	
	/**
	 * Given int data, delete the first occurrence of data in the list
	 * 
	 * @param data
	 */
	public void delete(int data) {
		
		// Base Case: head contains data
		if (head.val == data && head != null) {
			head = head.next;
			return;
		}
		
		Node currentNode = head;
		Node prevNode = null;
		
		// Traverse list and find node with data
		while (currentNode.val != data && currentNode != null) {
			prevNode = currentNode;
			currentNode = currentNode.next;
		}
		
		// Check: currentNode is null or contains data
		if (currentNode == null) return;
		
		// Delete currentNode
		prevNode.next = currentNode.next;
	}
	
	/**
	 * Prints node in middle of linked list
	 */
	public void printMiddle() {
		
		// Base Case 1: list is empty
		if (head == null) return;
		
		// Base Case 2: if list has 1 element, print that element
		if (head.next == null) {
			System.out.println("Only 1 element in list: " + head.val);
			return;
		}
		
		Node slowPointer = head;
		Node fastPointer = head;
		
		while (fastPointer != null && fastPointer.next != null) {
			slowPointer = slowPointer.next;
			fastPointer = fastPointer.next.next;
		}
		
		// fastPointer or fastPointer.next now null
		// slowPointer has reached middle node
		System.out.println("Middle node: " + slowPointer.val);
	}
	
	/**
	 * Given linked list, prints the nth node from the end of list
	 * 
	 * Example:
	 * 
	 *    Given linked list: 1->2->3->4->5, and n = 2.
	 *    
	 *    After removing the second node from the end, 
	 *    the linked list becomes 1->2->3->5.
	 * 
	 * @param n
	 */
	public void printNthFromEnd(int n) {
		
		// Input Check: if n is 0, return
		if (n == 0) return;
		
		// Base Case: empty list
		if (head == null) return;
		
		Node prevNode = head;
		Node currentNode = head;
		
		// Give currentNode n nodes head-start
		for (int i = 0; i < n; i++) {
			
			currentNode = currentNode.next;
			
			// Check: currentNode is null => n is length of linked list
			if (currentNode == null) {
				// Print head
				System.out.println("n is length of linked list. Print head");
				System.out.println(n + "th from end: " + head.val);
				return;
			}
		}
		
		// Traverse linked list with prev and curr pointers
		while (currentNode.next != null) {
			prevNode = prevNode.next;
			currentNode = currentNode.next;
		}
		
		// prevNode.next is now nth from end => print prevNode.next
		System.out.println("n = " + n + " => node = " + prevNode.next.val);
	}
	
	/**
	 * Prints linked list in string representation
	 */
	public void printList() {
		
		Node currentNode = head;
		
		while (currentNode != null) {
			System.out.print(currentNode.val + " ");
			currentNode = currentNode.next;
		}
		System.out.println();
	}
	
	/**
	 * Example: 
	 * 		Input: 1 -> 2 -> 3 -> 4 -> NULL
	 * 		Output: 1 -> 3 -> 2 -> 4 -> NULL
	 */
	public void merge() {
		
		// Input Check: empty list
		if (head == null) return;
		
		// Find midpoint using "runner" technique
		Node p1 = head;
		Node p2 = head;
		
		while (p1 != null) {
			p1 = p1.next.next;
			p2 = p2.next;
		}
		
		p1 = head;
		
		// p2 now at midpoint and p1 at head
		
		// Weaving
		while (p2 != null) {
			Node p1_next = p1.next;
			Node p2_next = p2.next;
			
			p2.next = p1_next;
			p1.next = p2;
			
			p1 = p1_next;
			p2 = p2_next;
		}
		
		// Stuck in infinite loop
	}
	
	public static void main(String[] args) {
		
/*		LinkedList list = new LinkedList();
		
		*//**
		 * Test #1 - Insertion
		 *//*
		
		list.insert(1);
		list.insert(4);
		list.insert(6);
		list.insert(7);
		list.insert(9);
		list.insertAfter(list.head, 3);
		list.insertLast(10);
		
		System.out.println("Linked List: ");
		list.printList();
		list.printMiddle();
		
		*//**
		 * Test #2 - Deletion
		 *//*
		
		list.delete(3);
		list.delete(10);
		
		System.out.println("\nAfter deleting 3 and 10: ");
		list.printList();
		list.printMiddle();
		
		*//**
		 * Test #3 - Print nth from end
		 *//*
		
		System.out.println();
		list.printNthFromEnd(0);
		list.printNthFromEnd(1);
		list.printNthFromEnd(2);
		list.printNthFromEnd(3);
		list.printNthFromEnd(4);
		list.printNthFromEnd(5);*/
		
		LinkedList sortedList = new LinkedList();
		
		sortedList.insertLast(1);
		sortedList.insertLast(2);
		sortedList.insertLast(3);
		sortedList.insertLast(4);
		sortedList.insertLast(5);
		sortedList.insertLast(6);
		
//		sortedList.merge();
		
		sortedList.printList();
	}
	
}
