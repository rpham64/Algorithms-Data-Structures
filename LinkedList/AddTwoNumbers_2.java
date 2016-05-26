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
        
        // Input Check: empty lists
        if (l1 == null && l2 == null) return l1;
        
        ListNode p1 = l1;
        ListNode p2 = l2;
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        int sum = 0;
        
        while (p1 != null || p2 != null) {      // Why use OR: If p1 or p2 is null, keep iterating.
                                                // Can't assume both lists are same size
            if (p1 != null) {
                sum += p1.val;
                p1 = p1.next;
            }
            if (p2 != null) {
                sum += p2.val;
                p2 = p2.next;
            }
            
            ListNode digit = new ListNode(sum % 10);    // Can be 1 or 2 digits. If 2 digits, carry 1 in sum
            current.next = digit;
            current = current.next;
            
            sum /= 10;
        }
        
        // Check: sum == 1
        if (sum == 1) {
            current.next = new ListNode(1);
        }
        
        return dummy.next;
    }
}
