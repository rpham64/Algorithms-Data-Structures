package Stacks;

/**
 * Singly Linked List Node implementation
 * 
 * Two components of a node: 1) data, 2) next pointer
 * 
 * @author Rudolf
 *
 */
public class Node {

	public Object data;
	public Node next;
	
	public Node(Object data, Node next) {
		this.data = data;
		this.next = next;
	}
	
}
