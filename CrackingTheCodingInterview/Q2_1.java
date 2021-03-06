package CrackingTheCodingInterview;

import java.util.HashSet;

/**
 * Write code to remove duplicates from an unsorted linked list.
 * 
	FOLLOW UP
	How would you solve this problem if a temporary buffer is not allowed?
 * 
 * 
 * @author Rudolf
 *
 */
public class Q2_1 {

	/** Answer 1: Using HashSet => Time: O(n), Space: O(n) */
	public ListNode removeDuplicates(ListNode head) {
		
		// Empty list OR 1 node
		if (head == null || head.next == null) return head;
		
		HashSet<Integer> visited = new HashSet<>();
		
		ListNode prev = null;
		ListNode current = head;
		
		while (current != null) {
			
			if (visited.contains(current.val)) {
				
				// Delete current
				prev.next = current.next;
				
			} else {
				
				// Add current to hashset
				visited.add(current.val);
				prev = current;
				
			}
			
			// Iterate current
			current = current.next;
			
		}
		
		return head;
	}
	
	/** Answer 2: No temporary buffer => O(n�) time, O(1) space */
	public ListNode removeDuplicates2(ListNode head) {
		
		// Empty list OR 1 node
		if (head == null || head.next == null) return head;
		
		ListNode current = head;
		
		while (current != null) {
			
			ListNode runner = current;
			
			while (runner.next != null) {
				
				if (runner.next.val == current.val) {
					runner.next = runner.next.next;
				} else {
					runner = runner.next;
				}
				
			}
			
			current = current.next;
		}
		
		return head;
	}
	
}
