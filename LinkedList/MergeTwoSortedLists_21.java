package LinkedList;

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
	
	/**
     * Variables:
     *      ListNode head
     *      ListNode p          (pointer for connecting list1 and list2)
     * 
     * Algorithm:
     *      1) Initialize Variables:
     *              If l1.val < l2.val
     *                  p = l1
     *                  l1 = l1.next
     *              Else
     *                  p = l2
     *                  l2 = l2.next
     *          Set head := p
     *      2) Compare nodes at l1 and l2 until l1 or l2 is null:
     *              If node at l1 < node at l2
     *                  p.next = l1
     *                  l1 = l1.next
     *              Else (node at l2 < node at l1)
     *                  p.next = l2
     *                  l2 = l2.next
     *              p = p.next
     *      3)  Either l1 or l2 is null, so add rest of nodes in non-null list:
     *              While l1 is not null    
     *                  p.next = l1
     *                  Set l1 -> l1.next
     *                  p = p.next
     *              While l2 is not null
     *                  p.next = l2
     *                  Set l2 -> l2.next
     *                  p = p.next
     *      4)  Return head
     * 
     * Cases:
     *      1)  Both lists are null (return null)
     *      2)  One list is null or empty (return other list)
     *      3)  Both non-null and non-empty (see algorithm)
     * 
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        
        // Case 1
        if (l1 == null && l2 == null) return l1;
        
        // Case 2
        if (l1 == null && l2 != null) return l2;
        if (l1 != null && l2 == null) return l1;
        
        // Case 3
        // Step 1
        ListNode head;
        ListNode p;
        
        if (l1.val < l2.val) {
            p = l1;
            l1 = l1.next;
        } else {
            p = l2;
            l2 = l2.next;
        }
        
        head = p;
        
        // Step 2
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
        
        // Step 3
        while (l1 != null) {
            p.next = l1;
            l1 = l1.next;
            p = p.next;
        }
        while (l2 != null) {
            p.next = l2;
            l2 = l2.next;
            p = p.next;
        }
        
        return head;
    }
}
