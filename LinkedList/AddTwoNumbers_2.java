package LinkedList;

/**
 * You are given two linked lists representing two non-negative numbers. 
 * The digits are stored in reverse order and each of their nodes 
 * contain a single digit. Add the two numbers and return it as a linked list.

	Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
	Output: 7 -> 0 -> 8
 * 
 * @author Rudolf
 *
 */
public class AddTwoNumbers_2 {

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        int sum = 0; // Running Sum (carry + l1.val + l2.val)
        
        while (l1 != null || l2 != null) {      // Why use OR: If p1 or p2 is null, keep iterating.
                                                // Covers both cases of l1 and l2 being same or different length.
        	sum /= 10;
        	
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            
            // Since sum can be greater than or equal to 10, use % 10 to get a single digit.
            current.next = new ListNode(sum % 10);
            current = current.next;
        }
        
        // Check if sum >= 10.
        // If so, we need to take care of the last carry.
        if (sum / 10 == 1) {
            current.next = new ListNode(1);
        }
        
        return dummy.next;
    }
}
