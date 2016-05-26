package CrackingTheCodingInterview;

import java.util.HashSet;

/**
 * Write code to remove duplicates from an unsorted linked list.
 * 
 * @author Rudolf
 *
 */
public class Q2_1b {

	public ListNode removeDuplicates(ListNode head) {
		
		// Input Check: empty list OR 1 node
		if (head == null || head.next == null) return head;
		
		ListNode dummy = new ListNode(0);
		
		HashSet<Integer> visited = new HashSet<>();
		
		ListNode prev = dummy;
		ListNode current = head;
		
		dummy.next = head;
		
		while (current != null) {
			
			if (visited.contains(current.val)) {
				
				prev.next = current.next;
				
			} else {
				
				visited.add(current.val);
				
				prev = prev.next;
				
			}
			
			current = current.next;
		}
		
		return dummy.next;
	}
	
	// FOLLOW UP: Solve without a temporary buffer
	
	public ListNode removeDuplicatesWithoutBuffer(ListNode head) {
		
		// Input Check: empty list OR 1 node
		if (head == null || head.next == null) return head;
		
		ListNode current = head;
		
		while (current != null) {
			
			ListNode runner = current;
			
			while (runner != null && runner.next != null) {
				
				if (runner.next.val == current.val) {
					
					// Delete runner.next
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
