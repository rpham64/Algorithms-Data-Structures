package LeetCode_Medium;

public class OddEvenLinkedList_328 {

	public ListNode oddEvenList(ListNode head) {
        
        // Input Check: empty list OR 1 node
        if (head == null || head.next == null) return head;
        
        ListNode p1 = head;
        ListNode p2 = head.next;
        ListNode evenHead = p2;
        
        // NOTE: When using somePointer.next.next, check somePointer.next.
        // Similarly, for somePointer.next, check somePointer.
        while (p1.next != null && p2.next != null) {
            
            // Re-assign next pointers
            p1.next = p1.next.next;
            p2.next = p2.next.next;
            
            // Re-assign p1 and p2
            p1 = p1.next;
            p2 = p2.next;
        }
        
        // Link last odd node to even head node
        p1.next = evenHead;
        
        return head;
    }
	
}
