package LinkedList;

/**
 * Given a list, rotate the list to the right by k places, where k is non-negative.

	For example:
	Given 1->2->3->4->5->NULL and k = 2,
	return 4->5->1->2->3->NULL.
 * 
 * @author Rudolf
 *
 */
public class RotateList_61 {

	/** Method 1: Cycle Linked List. Time: O(n), Space: O(1) */
	public ListNode rotateRight(ListNode head, int k) {
        
        // Input Check: empty list OR 1 node OR k = 0
        if (head == null || k == 0) return head;
        
        ListNode current = head;
        int length = 1;
        
        // Determine length of list
        while (current.next != null) {
            current = current.next;
            length++;
        }
        
        current.next = head;    // Turns list into a circle
        k %= length;            // If k > length of list
        
        for (int i = 0; i < length - k; ++i) {
            current = current.next;
        }
        
        // Current is now at breakpoint
        head = current.next;
        current.next = null;
        
        return head;
    }
}
