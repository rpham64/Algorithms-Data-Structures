package Queues;

import java.util.LinkedList;
/**
 * A trivial implementation of the simple queue interface.
 * Built as a wrapper around the LinkedList class from java.util.
 * 
 * @author Rudolf
 *
 */
public class Queue implements QueueInterface {

	private LinkedList<Object> list = new LinkedList<Object>();
	
	/** Returns the size of the queue */
	public int size() {
		return list.size();
	}
	
	/** Returns true if the queue is empty, else false */
	public boolean isEmpty() {
		return list.isEmpty();
	}
	
	/** Adds given item to back/tail of queue */
	public void enqueue(Object item) {
		list.addLast(item);
	}
	
	/** Removes and returns item at front/head of queue */
	public Object dequeue() {
		return list.removeFirst();
	}
	
	/** Returns item at front/head of queue */
	public Object peek() {
		return list.getFirst();
	}
	
}
