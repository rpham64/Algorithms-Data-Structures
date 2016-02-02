package Queues;

/**
 * A small queue interface. Can query the size of the queue, ask whether it
 * is empty, enqueue and dequeue items, and peek at the front item.
 * 
 * @author Rudolf
 *
 */
public interface QueueInterface {

	/** Returns the size of the queue */
	public abstract int size();
	
	/** Returns true if the queue is empty, else false */
	public abstract boolean isEmpty();
	
	/** Adds given item to back/tail of queue */
	public abstract void enqueue(Object item);
	
	/** Removes and returns item at front/head of queue */
	public abstract Object dequeue();
	
	/** Returns item at front/head of queue */
	public abstract Object peek();
	
}
