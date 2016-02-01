package StacksQueues;

import java.util.LinkedList;
/**
 * A Stack class implemented as a wrapper around the LinkedList class.
 * All stack methods simply delegate to LinkedList methods.
 * 
 * @author Rudolf
 *
 */
public class Stack implements StackInterface {

	private LinkedList<Object> list = new LinkedList<Object>();
	
	/**	Returns the number of items currently in the stack */
	public int size() { 
		return list.size(); 
	}

	/** Returns true if stack is empty, else false */
	public boolean isEmpty() {
		return size() == 0;
	}
	
	/** Adds the given item to the top of the stack */
	public void push(Object item) {
		list.addFirst(item);
	}
	
	/** Removes and returns the item at the top of the stack */
	public Object pop() {
		return list.removeFirst();
	}
	
	/** Returns the top item from the stack without removing it */
	public Object peek() {
		return list.getFirst();
	}
	
}
