package Stacks;

/**
 * Stack Interface
 * 
 * You can query the size of the stack and ask whether it is empty,
 * push items, pop items, and peek at the top item.
 * 
 * @author Rudolf
 *
 */
public interface StackInterface {

	/**	Returns the number of items currently in the stack */
	public abstract int size();

	/** Returns true if stack is empty, else false */
	public abstract boolean isEmpty();
	
	/** Adds the given item to the top of the stack */
	public abstract void push(Object item);
	
	/** Removes and returns the item at the top of the stack */
	public abstract Object pop();
	
	/** Returns the top item from the stack without removing it */
	public abstract Object peek();
	
}
