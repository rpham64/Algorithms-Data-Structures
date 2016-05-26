package CrackingTheCodingInterview;

/**
 * Implement a function to check if a linked list is a palindrome.
 * 
 * Follow up:
 * 
	Could you do it in O(n) time and O(1) space?
 * 
 * @author Rudolf
 *
 */
public class Q2_7 {

	public boolean isPalindrome(ListNode head) {
        
        // Input Check: empty list OR 1 node
        if (head == null || head.next == null) return true;
        
        ListNode prev = null;
        ListNode slow = head;
        ListNode fast = head;
        
        // 1) Find the midpoint of the list
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        
        // slow is at midpoint
        prev.next = null;
        
        // 2) Reverse second list starting at slow
        prev = null;
        ListNode next = null;
        
        while (slow != null) {
            next = slow.next;
            slow.next = prev;
            prev = slow;
            slow = next;
        }
        
        // prev is now at head of second list
        
        // 3) Iterate through both lists and compare their nodes
        ListNode p1 = head;
        ListNode p2 = prev;
        
        while (p1 != null && p2 != null) {
            
            if (p1.val != p2.val) return false;
            
            p1 = p1.next;
            p2 = p2.next;
        }
        
        return true;
    }
}
