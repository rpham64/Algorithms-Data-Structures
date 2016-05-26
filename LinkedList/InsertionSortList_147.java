package LinkedList;

/**
 * Sort a linked list using insertion sort.
 * 
 * @author Rudolf
 *
 */
public class InsertionSortList_147 {

	/** Method used: Insertion Sort via Swapping. Time: O(n²), Space: O(1) */
	public ListNode insertionSortList(ListNode head) {
        
        // Input Check: empty list OR 1 node
        if (head == null || head.next == null) return head;
        
        ListNode current = head;
        
        while (current != null) {
            
            ListNode checker = head;
            
            while (checker != current) {
                
                if (checker.val > current.val) {
                
                    // Swap checker.val and current.val
                    int temp = checker.val;
                    checker.val = current.val;
                    current.val = temp;
                
                }
                
                checker = checker.next;
            }
            
            current = current.next;
        }
        
        return head;
    }
	
}
