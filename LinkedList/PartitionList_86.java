package LinkedList;

/**
 * Given a linked list and a value x, partition it such that 
 * all nodes less than x come before nodes greater than or equal to x.

	You should preserve the original relative order of the nodes 
	in each of the two partitions. (ie. don't swap)
	
	For example,
	Given 1->4->3->2->5->2 and x = 3,
	return 1->2->2->4->3->5.
 * 
 * @author Rudolf
 *
 */
public class PartitionList_86 {

	public ListNode partition(ListNode head, int x) {
        
        // Input Check: empty list OR 1 node
        if (head == null || head.next == null) return head;
        
        // p1 = less than pointer
        // p2 = greater than or equal pointer
        // Idea: Keep two separate lists and concatenate them at the end as one list
        ListNode dummy1 = new ListNode(0);
        ListNode dummy2 = new ListNode(0);
        
        ListNode p1 = dummy1;
        ListNode p2 = dummy2;
        
        ListNode current = head;
        
        while (current != null) {
            
            if (current.val < x) {
                
                // Add to list 1
                p1.next = current;
                p1 = p1.next;
                
            } else {
                
                // Add to list 2
                p2.next = current;
                p2 = p2.next;
                
            }
            
            current = current.next;
        }
        
        p2.next = null;         // To remove cycle
        p1.next = dummy2.next;
        
        return dummy1.next;
    }
}
