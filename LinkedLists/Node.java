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
	
}
