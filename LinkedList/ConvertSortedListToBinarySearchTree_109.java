
/**
 * Given a singly linked list where elements are sorted in ascending order, 
 * convert it to a height balanced BST.
	
	For this problem, a height-balanced binary tree is defined as a binary tree in which 
	the depth of the two subtrees of every node never differ by more than 1.
	
	
	Example:
	
	Given the sorted linked list: [-10,-3,0,5,9],
	
	One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:
	
	      0
	     / \
	   -3   9
	   /   /
	 -10  5
 * 
 * Source: https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree/description/
 * 
 * @author Rudolf
 *
 */
public class ConvertSortedListToBinarySearchTree_109 {

    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;
        int length = getLength(head);
        return buildBST(head, 0, length - 1);
    }
    
    private int getLength(ListNode head) {
        int length = 0;
        while (head != null) {
            head = head.next;
            length++;
        }
        return length;
    }
    
    private TreeNode buildBST(ListNode head, int start, int end) {
        if (start > end) return null;
        
        // Find middle of list and create TreeNode out of it.
        int mid = start + (end - start) / 2;
        
        ListNode current = head;
        for (int i = 0; i < mid; ++i) {
            current = current.next;
        }
        
        TreeNode root = new TreeNode(current.val);
        root.left = buildBST(head, start, mid - 1);
        root.right = buildBST(head, mid + 1, end);
        
        return root;
    }
}
