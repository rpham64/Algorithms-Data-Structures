package CrackingTheCodingInterview;

/**
 * Implement an algorithm to delete a node in the middle of a singly linked list, 
 * given only access to that node.
 * 
 * EXAMPLE
 * 
 * Input: a -> b -> c -> d -> e. Remove 'c'
 * Output: a -> b -> d -> e
 * 
 * @author Rudolf
 *
 */
public class Q2_3 {

	public boolean remove(ListNode node) {
		
		// Input Check: empty list or null node
		if (node == null || node.next == null) return false;
		
		node.val = node.next.val;
		node.next = node.next.next;
		
		return true;
	}
	
}
