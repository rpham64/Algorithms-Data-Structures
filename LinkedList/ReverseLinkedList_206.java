package LinkedList;

public class ReverseLinkedList_206 {
	
	/** Method 1 - Time: O(n), Space: O(1) */
	public ListNode reverseList(ListNode head) {
        
        ListNode prev = null;
        ListNode current = head;
        ListNode next = null;
        
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        
        head = prev;
        
        return head;
    }

	/** Method 2 - Time: O(n), Space: O(1) */
	public ListNode reverseList2(ListNode head) {
        
        // Input Check: empty list OR 1 node
        if (head == null || head.next == null) return head;
        
        ListNode p1 = head;
        ListNode p2 = head.next;
        ListNode p3 = head.next.next;
        
        p1.next = null;
        
        while (p1 != null && p2 != null) {
            p2.next = p1;
            
            // Re-assign p1 p2 and p3
            p1 = p2;
            p2 = p3;
            
            if (p3 != null) {
                p3 = p3.next;
            }
        }
        
        head = p1;
        
        return head;
    }
	
}
