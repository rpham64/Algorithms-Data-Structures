package LinkedList;

/**
 * Sort a linked list in O(n log n) time using constant space complexity.
 * 
 * Solution: https://leetcode.com/discuss/44369/java-merge-sort-solution
 * 
 * @author Rudolf
 *
 */
public class SortList_148 {

	/** Method: Merge Sort aka Divide-and-Conquer. Time: O(n log n), Space: O(1) */
	public ListNode sortList(ListNode head) {
        
        // Input Check: empty list OR 1 node
        if (head == null || head.next == null) return head;     // Already sorted
        
        // Determine midpoint of list
        ListNode prev = null;
        ListNode slow = head;
        ListNode fast = head;
        
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        
        // Break up list into two lists
        prev.next = null;
        
        // Apply recursion on first and second halves
        ListNode l1 = sortList(head);
        ListNode l2 = sortList(slow);
        
        return merge(l1, l2);
    }
    
    private ListNode merge(ListNode l1, ListNode l2) {
        
        ListNode dummy = new ListNode(0);
        ListNode p = dummy;
        
        while (l1 != null && l2 != null) {
            
            if (l1.val < l2.val) {
                p.next = l1;
                l1 = l1.next;
            } else {
                p.next = l2;
                l2 = l2.next;
            }
            
            p = p.next;
            
        }
        
        // l1 or l2 is null
        // Add the rest of the non-null list
        if (l1 != null) {
            p.next = l1;
        }
        if (l2 != null) {
            p.next = l2;
        }
        
        return dummy.next;
    }
}
