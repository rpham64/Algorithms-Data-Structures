package Queues;

import java.util.NoSuchElementException;
/**
 * An implementation of a queue using a fixed, non-expandable array
 * whose capacity is set in its constructor.
 * 
 * @author Rudolf
 *
 */
public class BoundedQueue extends Queue implements QueueInterface {

	private Object[] data;
	private int size = 0;
	private int head;		// Index of current front item, if one exists
	private int tail;		// Index of next item to be added, at the back
	
	public BoundedQueue(int capacity) {
		data = new Object[capacity];
	}
	
	/** Returns the size of the queue */
	public int size() {
		return size;
	}
	
	/** Returns true if the queue is empty, else false */
	public boolean isEmpty() {
		return size == 0;
	}
	
	/** Adds given item to back/tail of queue */
	public void enqueue(Object item) {
		
		// Check: Queue is full
		if (size() == data.length) {
			throw new IllegalStateException("Queue is full. Unable to enqueue given item.");
		}
		
		data[tail] = item;
		tail = (tail + 1) % data.length;
		size++;
		
	}
	
	/** Removes and returns item at front/head of queue */
	/**
	 * Pseudocode:
	 * 
	 * Check: queue is not empty. If empty, throw NoSuchElementException
	 * 
	 * Set head of queue as "first"
	 * Set head of queue element as NULL
	 * Increment head
	 * Decrement size
	 * return first
	 * 
	 */
	public Object dequeue() {
		
		if (size == 0) {
			throw new NoSuchElementException("Queue is empty. Cannot dequeue.");
		}
		
		Object first = data[head];
		data[head] = null;
		head = (head + 1) % data.length;
		size--;
		return first;
	}
	
	/** Returns item at front/head of queue */
	public Object peek() {
		
		if (size == 0) {
			throw new NoSuchElementException("Queue is empty. No items to peek at.");
		}
		
		return data[head];
	}
	
}
