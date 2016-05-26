package LinkedList;

/**
 * Given a singly linked list L: L0->L1->...->Ln-1->Ln,
	reorder it to: L0->Ln->L1->Ln-1->L2->Ln-2->…
	
	You must do this in-place without altering the nodes' values.
	
	For example,
	Given {1,2,3,4}, reorder it to {1,4,2,3}.
 * 
 * @author Rudolf
 *
 */
public class ReorderList_143 {

	public void reorderList(ListNode head) {
        
        // Input Check: empty list OR 1 node
        if (head == null || head.next == null) return;
        
        // 1) Find midpoint
        ListNode slow = head;
        ListNode fast = head;
        
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        // 2) Reverse second half of list from slow
        ListNode prev = null;
        ListNode next = null;
        
        while (slow != null) {
            next = slow.next;
            slow.next = prev;
            prev = slow;
            slow = next;
        }
        
        // 3) Weave the front to back and move towards middle of list
        ListNode p1 = head;
        ListNode p2 = prev;     // At head of second list
        
        // Either p1 == p2 OR one will be next to null
        while (p1.next != null && p2.next != null) {
            
            ListNode next1 = p1.next;
            ListNode next2 = p2.next;
            
            p1.next = p2;
            p2.next = next1;
            
            p1 = next1;
            p2 = next2;
        }
    }
}
