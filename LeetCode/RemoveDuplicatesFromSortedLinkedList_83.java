package LeetCode;

/**
 * #83. Remove Duplicates from Linked List
 * 
 * Given a sorted linked list, delete all duplicates such that each element appear only once.
 * 
 * @author Rudolf
 *
 */
public class RemoveDuplicatesFromSortedLinkedList_83 {

	public ListNode deleteDuplicates(ListNode head) {
        
        if (head == null) return head;
        
        ListNode currentNode = head;
        
        while (currentNode.next != null) {
            
            if (currentNode.val == currentNode.next.val) {
                
                currentNode.next = currentNode.next.next;
                
            } else {
                
                currentNode = currentNode.next;
                
            }
            
        }
        
        return head;
	}
}
