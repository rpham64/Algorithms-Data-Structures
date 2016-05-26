package LinkedList;

import java.util.Stack;

public class PalindromeLinkedList_234 {

	/** Method 1 - Time: O(n), Space: O(1) */
	public boolean isPalindrome(ListNode head) {
        
        // Input Check: empty list OR 1 node
        if (head == null || head.next == null) return true;
        
        // 1) Find middle of list
        ListNode fast = head;
        ListNode slow = head;
        
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        
        // Slow is now at middle of list
        
        // 2) Reverse second half of list
        ListNode prev = null;
        ListNode current = slow;
        ListNode next = null;
        
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        
        // 3) Check both first and second halves until p1 reaches otherHead
        ListNode p1 = head;
        ListNode p2 = prev;
        
        while (p2 != null) {
            if (p1.val != p2.val) {
                return false;
            }
            
            // Re-assign p1 and p2
            p1 = p1.next;
            p2 = p2.next;
        }
        
        // 4) Optional: Re-reverse second half back to original list
        
        return true;
    }
	
	/** Method 2 - Time: O(n), Space: O(n) */
	public boolean isPalindrome_Stack(ListNode head) {
        
        // Input Check: empty list OR 1 node
        if (head == null || head.next == null) return true;
        
        Stack<Integer> values = new Stack<Integer>();
        
        // Add list values to stack
        for (ListNode node = head; node != null; node = node.next) {
            values.push(node.val);
        }
        
        // Iterate through list again and compare to stack values
        for (ListNode node = head; node != null; node = node.next) {
            int currentVal = values.pop();
            
            if (node.val != currentVal) return false;
        }
        
        return true;
    }
	
}
