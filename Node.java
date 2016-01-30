/* My LinkedList Implementation
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
public class Node<AnyType>{

	// Two components: data (element), and next (pointer)
	private AnyType data;
	private Node<AnyType> next;
	private Node<AnyType> head = null;
	
	public Node(AnyType data, Node<AnyType> next) {
		this.data = data;
		this.next = next;
	}
	
	// Add item to start
	public void addFirst(AnyType data) {
		head = new Node<AnyType>(data, head);
	}
	
	// Add item to end
	public void addLast(AnyType data) {
		
		if (head == null) { addFirst(data); }
		// Traverse linked list until next is null
		// Add new node with next pointing to null
		Node<AnyType> curr = head;
		while (curr.next != null) {
			curr = curr.next;
		}
		curr.next = new Node<AnyType>(data, null);
		
	}

/*	Inserts new node after specified node
 * 	@param data (whose node we insert after)
 * 	@param toInsert (new node to insert)
 */
	public void insertAfter(AnyType data, AnyType toInsert) {
		
		// Traverse linked list until next is null or we find 
		// the specified node
		// Add new node after specified node
		Node<AnyType> curr = head;
		while (curr.next != null && !curr.data.equals(data)) {
			curr = curr.next;
		}
		
		// Check: curr is null
		if (curr != null) { curr.next = new Node<AnyType>(toInsert, curr.next); }
		
	}
	
	/*	Inserts new node before specified node
	 * 	@param data (whose node we insert before)
	 * 	@param toInsert (new node to insert)
	 */
	public void insertBefore(AnyType data, AnyType toInsert) {
		
		// Check: linked list is empty
		if (head == null) return;
		
		// Check: linked list has one node (head)
		if (head.data.equals(data)) {
			addFirst(toInsert);
			return;
		}
		
		// Traverse until we find node next has data
		// Add node after prev node and before curr node
		Node<AnyType> prev = null;
		Node<AnyType> curr = head;
		
		while (curr.next != null && !curr.data.equals(data)) {
			prev = curr;
			curr = curr.next;
		}
		// Insert after prev and before curr
		if (curr != null) { prev.next = new Node<AnyType>(toInsert, curr); }
		
	}
	
	// Delete key's node
	public void delete(AnyType key) {
		
		// Base case: linked list is empty (0 elements)
		if (head == null) return;
		
		// Base case: linked list has one element (head) (1 element)
		if (head.data.equals(key)) {
			head = head.next; // Head becomes null node
			return;
		}
		
		// Inductive Step: linked list has two or more elements (2+ elements)
		
		// Traverse until we find node with key
		// Assign pointer from prev to curr.next
		Node<AnyType> prev = null;
		Node<AnyType> curr = head;
		
		while (curr != null && !curr.data.equals(key)) {
			prev = curr;
			curr = curr.next;
		}
		// Check: curr is null
		if (curr == null) throw new RuntimeException("cannot delete. Current node is null");
		
		// Re-assign pointers to delete curr
		prev.next = curr.next;
		
	}
	
	
	
}
