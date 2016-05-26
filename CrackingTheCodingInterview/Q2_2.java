package CrackingTheCodingInterview;

/**
 * Implement an algorithm to find the kth to last element of a singly linked list.
 * 
 * @author Rudolf
 *
 */
public class Q2_2 {

	public ListNode getkthToLast(ListNode head, int k) {
		
		// Empty list OR k is negative
		if (head == null || k < 0) return null;
		
		int length = 1;
		ListNode current = head;
		
		// Get length of list
		while (current != null) {
			
			length++;
			current = current.next;
			
		}
		
		if (k >= length) return head;
		
		int i = length - k;
		
		current = head;
		
		while (i > 0) {
			current = current.next;
			i--;
		}
		
		return current;
	}
	
}
