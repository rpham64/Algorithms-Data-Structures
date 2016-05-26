package LinkedList;

/**
 * Given a linked list, swap every two adjacent nodes and return its head.

For example,
Given 1->2->3->4, you should return the list as 2->1->4->3.

Your algorithm should use only constant space. 
You may not modify the values in the list, only nodes itself can be changed.

Solution: https://leetcode.com/discuss/90336/straight-forward-java-solution-without-recursion-dummy-nodes
 * 
 * @author Rudolf
 *
 */
public class SwapNodesInPairs_24 {

	public ListNode swapPairs(ListNode head) {
        
        // Input Check: empty list
        if (head == null || head.next == null) return head;
        
        ListNode p1 = head;
        ListNode p2 = head.next;
        ListNode prev = null;
        
        // Re-assign head
        ListNode newHead = p2;
        
        while (p1 != null && p2 != null) {
            
        	if (prev != null) {
                prev.next = p2;
            }
        	
            p1.next = p2.next;
            p2.next = p1;
            
            // Re-assign p1 and p2
            if (p1.next == null) break;
            
            prev = p1;
            p1 = p1.next;
            p2 = p1.next;
        }
        
        return newHead;
    }
	
}
