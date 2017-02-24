package LinkedList;

public class LinkedListCycle_141 {

	/** Time: O(n), Space: O(1) */
	public boolean hasCycle(ListNode head) {
        
        // Input Check: empty list
        if (head == null) return false;
        
        ListNode fast = head;
        ListNode slow = head;
        
        // fast.next and fast.next.next is FASTER (SERIOUSLY LEETCODE WTF)
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            
            if (fast == slow) return true;
        }
        
        return false;
    }
}
