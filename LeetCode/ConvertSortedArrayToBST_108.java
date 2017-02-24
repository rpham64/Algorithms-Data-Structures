package LeetCode;

/**
 * Given an array where elements are sorted in ascending order, 
 * convert it to a height balanced BST.
 * 
 * @author Rudolf
 *
 */
public class ConvertSortedArrayToBST_108 {

	/**
     * nums = [1, 3, 4, 5, 7, 8, 9]
     * 
     * Tree:            5
     *                 / \
     *                3   8
     *               / \ / \
     *              1  4 7  9 
     * 
     * Idea: use Binary Search to create the next TreeNode. Left elements are less, right elements are greater.
     */
    public TreeNode sortedArrayToBST(int[] nums) {
        
        // Null Check
        if (nums == null || nums.length == 0) return null;

        return getNode(nums, 0, nums.length - 1);
    }
    
    /**
     * Use binary search to retrieve current TreeNode
     */
    private TreeNode getNode(int[] nums, int low, int high) {
    
        if (low > high) return null;    // Not found
        
        int mid = (low + high) / 2;
        
        // Recursive Case - Call getNode on left and right
        TreeNode current = new TreeNode(nums[mid]);
        current.left = getNode(nums, low, mid - 1);
        current.right = getNode(nums, mid + 1, high);
        
        return current;
    }
    
}
