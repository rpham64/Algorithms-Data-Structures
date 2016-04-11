package LeetCode;

/**
 * Merge two sorted linked lists and return it as a new list. 
 * The new list should be made by splicing together the nodes 
 * of the first two lists.
 * 
 * Solution: http://blog.csdn.net/runningtortoises/article/details/45622329
 * 
 * @author Rudolf
 *
 */
public class MergeTwoSortedLists_21 {
	
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        
        // Input Check: if l1 is null, return l2. Else, if l2 is null, return l1.
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        
        // Determine head of new list
        ListNode head, current;
        
        if (l1.val < l2.val) {
            current = l1;
            l1 = l1.next;
        } else {
            current = l2;
            l2 = l2.next;
        }
        
        head = current;
        
        // Iterate and compare nodes of both lists
        // Connect node with smaller value to head and repeat
        while (l1 != null && l2 != null) {
            
            if (l1.val < l2.val) {
                current.next = l1;
                l1 = l1.next;
            } else {
                current.next = l2;
                l2 = l2.next;
            }
            
            current = current.next;
        }
        
        if (l1 == null) {
            current.next = l2;
        } else if (l2 == null) {
            current.next = l1;
        }
        
        return head;
    }

}
