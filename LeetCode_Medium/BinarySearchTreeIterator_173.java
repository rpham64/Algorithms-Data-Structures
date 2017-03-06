package LeetCode_Medium;

import java.util.Stack;

import LeetCode.TreeNode;

/**
 * Implement an iterator over a binary search tree (BST). 
 * Your iterator will be initialized with the root node of a BST.

Calling next() will return the next smallest number in the BST.

Note: next() and hasNext() should run in average O(1) time and uses O(h) memory, 
where h is the height of the tree.

 * 
 * @author Rudolf
 *
 */
public class BinarySearchTreeIterator_173 {

	private Stack<TreeNode> stack;

    public BinarySearchTreeIterator_173(TreeNode root) {
        stack = new Stack<>();
        findSuccessor(root);
    }
    
    /**
     * Pushes all left nodes to stack until smallest node is found
     */
    public void findSuccessor(TreeNode root) {
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode nextNode = stack.pop();
        int nextVal = nextNode.val;
        findSuccessor(nextNode.right);      // Find successor since we lose popped node after this
        return nextVal;
    }
}
