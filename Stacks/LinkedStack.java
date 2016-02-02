package Stacks;

import java.util.NoSuchElementException;
/**
 * An implementation of the stack interface using singly-linked nodes.
 * 
 * @author Rudolf
 *
 */
public class LinkedStack extends Stack implements StackInterface {

	private Node top;
	
	/**	Returns the number of items currently in the stack */
	public int size() {
		
		int count = 0;
		
		for (Node curr = top; curr != null; curr = curr.next) {
			count++;
		}
		
		return count;
	}

	/** Returns true if stack is empty, else false */
	public boolean isEmpty() {
		return size() == 0;
	}
	
	/** Adds the given item to the top of the stack */
	public void push(Object item) {
		top = new Node(item, top);	// Adds node to top of stack (front of linked list)
	}
	
	/** Removes and returns the item at the top of the stack */
	public Object pop() {

		Object item = peek();
		top = top.next;
		
		return item;
	}
	
	/** Returns the top item from the stack without removing it */
	public Object peek() {
		
		// Check: empty stack
		if (top == null) {
			throw new NoSuchElementException("Stack is empty.");
		}
		
		return top.data;
	}
	
}
