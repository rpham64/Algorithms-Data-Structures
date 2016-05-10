package LeetCode;

import java.util.HashSet;

public class IntersectionOfTwoLinkedLists_160 {

	/** Method 1 - Using Hashing. Time: O(n + m), Space: O(n) */
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        
        // Input Check: empty list (either)
        if (headA == null || headB == null) return null;
        
        HashSet<ListNode> visitedA = new HashSet<>();
        
        // Add nodes in A to visitedA
        for (ListNode node = headA; node != null; node = node.next) {
            visitedA.add(node);
        }
        
        // Iterate through list B and check if visited
        for (ListNode node = headB; node != null; node = node.next) {
            if (visitedA.contains(node)) return node;
        }
        
        return null;
    }
}
