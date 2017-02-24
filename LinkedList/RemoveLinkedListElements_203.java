package LinkedList;

/**
 * Remove all elements from a linked list of integers that have value val.

	Example
	Given: 1 --> 2 --> 6 --> 3 --> 4 --> 5 --> 6, val = 6
	Return: 1 --> 2 --> 3 --> 4 --> 5
 * 
 * @author Rudolf
 *
 */
public class RemoveLinkedListElements_203 {

	public ListNode removeElements(ListNode head, int val) {
        
        // Base Case: empty list
        if (head == null) return head;
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        ListNode prev = dummy;
        ListNode current = head;
        
        while (current != null) {
            
            if (current.val == val) {
                prev.next = current.next;
            } else {
                prev = current;
            }
            
            // ALWAYS ITERATE CURRENT
            current = current.next;
        }
        
        return dummy.next;
    }
}
