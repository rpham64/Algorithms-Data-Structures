package LeetCode_Medium;

public class RotateList_61 {

	public ListNode rotateRight(ListNode head, int k) {
        
        // Input Check: empty list OR 1 node OR k = 0
        if (head == null || k == 0) return head;
        
        ListNode current = head;
        int length = 1;
        
        // Determine length of list
        while (current.next != null) {
            current = current.next;
            length++;
        }
        
        current.next = head;    // Turns list into a circle
        k %= length;            // If k > length of list
        
        for (int i = 0; i < length - k; ++i) {
            current = current.next;
        }
        
        // Current is now at breakpoint
        head = current.next;
        current.next = null;
        
        return head;
    }
}
