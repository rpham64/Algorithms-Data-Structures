package LeetCode;

/**
 * Given a linked list, remove the nth node from the 
 * end of list and return its head.
 * 
 * For example,
 * 
 * Given linked list: 1->2->3->4->5, and n = 2.
 * After removing the second node from the end, 
 * the linked list becomes 1->2->3->5.
 * 
 * Note:
 * 
 * Given n will always be valid.
 * Try to do this in one pass.
 * 
 * @author Rudolf
 *
 */
public class RemoveNthNodeFromEndOfList_19 {

	public ListNode removeNthFromEnd(ListNode head, int n) {
        
        // Input Check: if head is null, return head
        if (head == null) return head;
        
        // Find nth node from start
        // Set currentNode to this node
        ListNode currentNode = head;
        ListNode prevNode = head;
        
        for (int i = 0; i < n; i++) {
            currentNode = currentNode.next;
            
            // Edge Case: currentNode is null 
            // => n is length of linked list 
            // => delete head
            if (currentNode == null) {
                head = head.next;
                return head;
            }
        }
        
        // Iterate both nodes until currentNode is the tail node
        while (currentNode.next != null) {
            currentNode = currentNode.next;
            prevNode = prevNode.next;
        }
        
        // prevNode.next is now the nth to last node
        // Delete prevNode.next
        prevNode.next = prevNode.next.next;
        
        return head;
    }
	
}
