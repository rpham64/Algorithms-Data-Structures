package Queues;

import java.util.NoSuchElementException;
/**
 * An implementation of a queue using singly linked nodes in a
 * circular singly linked list.
 * The queue itself maintains links to head and tail nodes, 
 * so that enqueuing and dequeuing are O(1).
 * 
 * @author Rudolf
 *
 */
public class LinkedQueue extends Queue implements QueueInterface {

	private Node head = null;
	private Node tail = null;
	
	/** Returns the size of the queue */
	public int size() {
		
		int count = 0;
		
		for (Node curr = head; curr != null; curr = curr.next) {
			count++;
		}
		
		return count;
	}
	
	/** Returns true if the queue is empty, else false */
	public boolean isEmpty() {
		return head == null;
	}
	
	/** Adds given item to back/tail of queue */
	public void enqueue(Object item) {
		
		Node node = new Node(item, null);
		
		// If queue is empty, assign to head
		// Else, add to tail.next and re-assign tail to this node
		if (isEmpty()) {
			head = node;
		}
		else {
			tail.next = node;
		}
		
		tail = node;
		
	}
	
	/** Removes and returns item at front/head of queue */
	public Object dequeue() {
		
		// Check: Queue is empty
		if (isEmpty()) {
			throw new NoSuchElementException("Queue is empty. Cannot dequeue.");
		}
		
		// Save head's data to return
		Object first = head.data;
		
		// Check: one element (tail = head)
		// If so, set tail to null
		if (tail == head) tail = null;
		
		// Remove head from queue and re-assign head to head.next
		head = head.next;
		
		return first;
	}
	
	/** Returns item at front/head of queue */
	public Object peek() {
		
		// Check: Queue is empty
		if (isEmpty()) {
			throw new NoSuchElementException("Queue is empty. Nothing to peek at.");
		}
		
		return head.data;
	}
	
}
