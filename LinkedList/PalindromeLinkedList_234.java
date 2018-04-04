package LinkedList;

import java.util.Stack;

/**
 * Given a singly linked list, determine if it is a palindrome.
	
	Follow up:
	Could you do it in O(n) time and O(1) space?
 * 
 * Source: https://leetcode.com/problems/palindrome-linked-list/description/
 * 
 * @author Rudolf
 *
 */
public class PalindromeLinkedList_234 {

	/** Method 1 - Time: O(n), Space: O(1) */
	public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;
        
        // Find middle
        ListNode p1 = head;
        ListNode p2 = head;
        
        while (p2 != null && p2.next != null) {
            p1 = p1.next;
            p2 = p2.next.next;
        }
        
        // Reverse second half, starting at p1
        ListNode rightHead = reverse(p1);
        
        // Compare leftHead and rightHead until they're different (false)
        // or one becomes null (true)
        ListNode leftHead = head;
        
        while (leftHead != null && rightHead != null) {
            if (leftHead.val != rightHead.val) return false;
            leftHead = leftHead.next;
            rightHead = rightHead.next;
        }
        
        return true;
    }
    
    private ListNode reverse(ListNode head) {
        if (head == null) return head;
        
        ListNode current = head;
        ListNode prev = null;
        ListNode next = null;
        
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        
        return prev;
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
