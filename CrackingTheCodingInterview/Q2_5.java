package CrackingTheCodingInterview;

/**
 * You have two numbers represented by a linked list, where each node contains a
	single digit. The digits are stored in reverse order, such that the 1's digit is at the
	head of the list. Write a function that adds the two numbers and returns the sum
	as a linked list.
	
	EXAMPLE
	Input: (7-> 1 -> 6) + (5 -> 9 -> 2).That is, 617 + 295.
	Output: 2 -> 1 -> 9.That is, 912.
	
	FOLLOW UP
	Suppose the digits are stored in forward order. Repeat the above problem.
	
	EXAMPLE
	Input: (6 -> 1 -> 7) + (2 -> 9 -> 5).That is, 617 + 295.
	Output: 9 -> 1 -> 2. That is, 912.
 * 
 * 
 * @author Rudolf
 *
 */
public class Q2_5 {

	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
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
