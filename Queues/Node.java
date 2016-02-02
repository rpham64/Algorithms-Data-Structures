package Queues;

/**
 * Simple implementation of a linked list node for the Queue package.
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
