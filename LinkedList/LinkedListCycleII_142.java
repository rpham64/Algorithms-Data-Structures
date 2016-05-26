package LinkedList;

import java.util.HashSet;

/**
 * Given a linked list, return the node where the cycle begins. 
 * If there is no cycle, return null.

	Note: Do not modify the linked list.
	
	Follow up:
	Can you solve it without using extra space?
	
	Solution to follow up: https://leetcode.com/discuss/47292/java-o-1-space-solution-with-detailed-explanation
 * 
 * @author Rudolf
 *
 */
public class LinkedListCycleII_142 {

	/** Method 1: Using HashSet. Time: O(n), Space: O(n) */
	public ListNode detectCycle(ListNode head) {
        
        // Input Check: empty list
        if (head == null) return head;
        
        HashSet<ListNode> visited = new HashSet<>();
        
        for (ListNode current = head; current != null; current = current.next) {
            
            if (visited.contains(current)) {
                return current;
            }
            
            visited.add(current);
        }
        
        return null;
    }
	
	/** Method 2: Two Pointers. Time: O(n), Space: O(1) */
	public ListNode detectCycle2(ListNode head) {
        
        // Input Check: empty list
        if (head == null) return head;
        
        ListNode slow = head;
        ListNode fast = head;
        
        // 1) Iterate slow and fast until they collide.
        // If fast is null, there is no cycle.
        while (fast != null && fast.next != null) {
            
            slow = slow.next;
            fast = fast.next.next;
            
            // 2) Cycle exists. Find start of cycle.
            if (slow == fast) {
                
                ListNode slow2 = head;
                
                while (slow2 != slow) {
                    slow = slow.next;
                    slow2 = slow2.next;
                }
                
                return slow;
            }
        }
        
        return null;
    }
}
