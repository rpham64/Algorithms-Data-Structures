package LinkedLists;

public interface LinkedListInterface {

	/** Returns the size of the list */
	public abstract int size();
	
	/** Returns true if the list is empty, else false */
	public abstract boolean isEmpty();
	
	/** Adds new node with data at the head of the list */
	public abstract void addFirst(Object data);
	
	/** Adds new node with data at the tail of the list */
	public abstract void addLast(Object data);
	
	/** Adds new node with data after the specified node */
	public abstract void add(Node key, Object data);
	
	/** Adds new node with data at the specified index */
	public abstract void add(int index, Object data);
	
	/** Returns the node at the specified index */
	public abstract Node get(int index);
	
	/** Returns the head node */
	public abstract Node removeHead();
	
	/** Returns the tail node */
	public abstract Node removeTail();
	
	/** Removes and returns the node with data */
	public abstract Node remove(Object data);
	
	/** Removes and returns the node at the specified index */
	public abstract Node remove(int index);
	
	/** Returns a String representation of the linked list */
	public abstract String toString();
	
}
