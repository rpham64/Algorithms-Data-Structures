package LinkedList;

/**
 * A linked list is given such that each node contains an additional random pointer 
 * which could point to any node in the list or null.

	Return a deep copy of the list.	
 * 
 * @author Rudolf
 *
 */
public class CopyListWithRandomPointer_138 {

	/**
     * Cases:
     *      1)  Empty list (return head)
     *      2)  Non-empty list (see algorithm)
     * 
     * Algorithm:
     *      Set current = head
     *          next = null
     *      Create copy nodes and assign their next pointers:
     *          Loop while current is NOT null
     *              Set next := current.next
     *              Create RandomListNode copy w/ current.label
     *              Set current.next := copy
     *              Set copy.next := next
     *              Set current := copy.next
     *      Assign random pointers on copy nodes:
     *          Set current := head
     *          Loop while current is NOT null
     *              if current.random is NOT null
     *                  Set current.next.random := current.random.next  (copy -> copy)
     *              Set current := current.next.next
     *      Re-assign copy next pointers and fix original list:
     *          Create dummy RandomListNode
     *          Set current := head
     *          Set dummy.next := current.next
     *          Set copy := current.next
     *          Loop while current NOT null:
     *              current.next := current.next.next
     *              
     *              Re-assign next pointer for copy:
     *                  copy.next := copy.next.next
     *                  copy := copy.next
     *              
     *              current := current.next
     *      Return dummy.next
     * 
     */
    public RandomListNode copyRandomList(RandomListNode head) {
        
        // Case 1
        if (head == null) return head;
        
        // Case 2
        RandomListNode current = head;
        RandomListNode next = null;
        
        // 1) Create copy nodes and assign next pointers
        while (current != null) {
            next = current.next;
            RandomListNode copy = new RandomListNode(current.label);
            current.next = copy;
            copy.next = next;
            current = current.next.next;
        }
        
        // 2) Assign random pointers on copy nodes
        current = head;
        
        while (current != null) {
            if (current.random != null) {
                current.next.random = current.random.next;
            }
            current = current.next.next;
        }
        
        // 3) Re-assign copy next pointers and fix original list
        RandomListNode dummy = new RandomListNode(0);
        current = head;
        RandomListNode copy;
        RandomListNode copyIter = dummy;
        
        while (current != null) {
            
            next = current.next.next;
            
            // Re-assign copy next pointer
            copy = current.next;
            copyIter.next = copy;
            copyIter = copy;
            
            // Fix original next pointers
            current.next = next;
            current = current.next;
        }
        
        return dummy.next;
    }
}
