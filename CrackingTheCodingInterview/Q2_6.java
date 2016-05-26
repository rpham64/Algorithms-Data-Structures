package CrackingTheCodingInterview;

import LinkedList.ListNode;

/**
 * Given a circular linked list, implement an algorithm which returns the node at
the beginning of the loop.

	DEFINITION
	Circular linked list: A (corrupt) linked list in which a node's next pointer points
	to an earlier node, so as to make a loop in the linked list.
	
	EXAMPLE
	
	Input: A - > B - > C - > D - > E - > C [the same C as earlier]
	Output: C
 * 
 * 
 * @author Rudolf
 *
 */
public class Q2_6 {

	public ListNode detectCycle2(ListNode head) {
        
        // Input Check: empty list
        if (head == null) return head;
        
        ListNode slow = head;
        ListNode fast = head;
        
        // 1) Iterate slow and fast until they collide.
        // If fast is null, there is no cycle.
        while (fast != null && fast.next != null) {
            
            slow = slow.next;
            fast = fast.next.next;
            
            // 2) Cycle exists. Find start of cycle.
            if (slow == fast) {
                
                ListNode slow2 = head;
                
                while (slow2 != slow) {
                    slow = slow.next;
                    slow2 = slow2.next;
                }
                
                return slow;
            }
        }
        
        return null;
    }
}
