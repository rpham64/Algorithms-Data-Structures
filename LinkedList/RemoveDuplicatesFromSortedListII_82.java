package LinkedList;

public class RemoveDuplicatesFromSortedListII_82 {

	public ListNode deleteDuplicates(ListNode head) {
        
        // Input Check: empty list OR 1 node
        if (head == null || head.next == null) return head;
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        ListNode prev = dummy;
        ListNode current = head;
        
        while (current != null && current.next != null) {
            
            if (current.val == current.next.val) {
                
                int duplicatedVal = current.val;
                
                // Delete duplicated values
                while (current.val == duplicatedVal) {
                    current = current.next;
                    
                    if (current == null) break;
                }
                
                prev.next = current;
                
            } else {
                
                // Iterate prev and current
                prev = current;
                current = current.next;
                
            }
        }
        
        return dummy.next;
    }
}
