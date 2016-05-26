package LinkedList;

/**
 * Write a function to delete a node (except the tail) in a 
 * singly linked list, given only access to that node.
 * 
 * Supposed the linked list is 1 -> 2 -> 3 -> 4 and you are 
 * given the third node with value 3, the linked list should 
 * become 1 -> 2 -> 4 after calling your function.
 * 
 * @author Rudolf
 *
 */
public class DeleteNodeInLinkedList_237 {
	
	public void deleteNode(ListNode node) {
		
		// Input Check: if node is null, return
		if (node == null) return;
		
		// Replace node's val to node.next and next node to node.next.next
		// Idea: Replace node with its next node, then delete that next node
		node.val = node.next.val;
		node.next = node.next.next;
	}

}
