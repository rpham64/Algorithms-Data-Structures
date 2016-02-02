package Stacks;

import java.util.NoSuchElementException;
/**
 * Stack Implementation using a bounded array
 * 
 * @author Rudolf
 *
 */
public class BoundedStack extends Stack implements StackInterface {

	private Object[] data;		// Stack array
	private int size = 0; 	// Number of items in stack (not capacity)
	
	/** Constructor */
	public BoundedStack(int capacity) {
		data = new Object[capacity];
	}
	
	/**	Returns the number of items currently in the stack */
	public int size() {
		return size;
	}

	/** Returns true if stack is empty, else false */
	public boolean isEmpty() {
		return size == 0;
	}
	
	/** Adds the given item to the top of the stack */
	public void push(Object item) {
		
		// Corner Case: Stack is full
		if (size == data.length) {
			throw new IllegalStateException("Unable to push given item. Stack is full.");
		}
		
		// Add item to index size, then increment size
		data[size++] = item;
	}
	
	/** Removes and returns the item at the top of the stack */
	public Object pop() {
		
		// Corner Case: Size is 0. Throw NoSuchElementException
		if (size == 0) {
			throw new NoSuchElementException("Stack is empty. No items to pop.");
		}
		
		Object popped = data[size - 1];		// Size of n implies last item is at index n-1
		
		data[--size] = null;
		return popped;
	}
	
	/** Returns the top item from the stack without removing it */
	public Object peek() {
		
		if (size == 0) {
			throw new NoSuchElementException("Stack is empty. No items to peek at.");
		}
		
		Object peeked = data[size - 1];		// Size of n implies last item is at index n-1
		
		return peeked;
	}
	
}
