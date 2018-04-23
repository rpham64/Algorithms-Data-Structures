/**
 * Given an integer array with no duplicates. A maximum tree building on this array is defined as follow:
	
	The root is the maximum number in the array.
	The left subtree is the maximum tree constructed from left part subarray divided by the maximum number.
	The right subtree is the maximum tree constructed from right part subarray divided by the maximum number.
	Construct the maximum tree by the given array and output the root node of this tree.
	
	Example 1:
	
	Input: [3,2,1,6,0,5]
	Output: return the tree root node representing the following tree:
	
	      6
	    /   \
	   3     5
	    \    / 
	     2  0   
	       \
	        1
	        
	Note:
	The size of the given array will be in the range [1,1000].
 * 
 * @author rpham
 *
 */
public class MaximumBinaryTree_654 {

	/**
    *   Simple DFS Recursion Algorithm
    *
    *   Time:
    *       - O(n log n) (average) where n is the length of nums[].
    *       - O(n^2) (worst) if we have a linear tree that's always increasing ([6, 5, 4, 3, 2, 1]) or decreasing ([1, 2, 3, 4, 5, 6]).
    *           - Explanation: Traverse entire array to find max is 6. Then traverse array from 5 to 1 to find max is 5.
    *                          Then from 4 to 1 to find max is 4, etc.
    *       - HINT: Think QuickSort or mergesort as one side of divide-and-conquer always involves n elements, resulting in n^2 time.
    *   Space: O(n) since we create n nodes to construct the tree.
    */
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums == null) return null;
        return buildRoot(nums, 0, nums.length - 1);
    }
    
    private TreeNode buildRoot(int[] nums, int start, int end) {
        if (start > end) return null;  // Termination
        
        // Find max number in nums and its index from start to end.
        int maxNum = nums[start];
        int maxIndex = start;
        
        for (int i = start + 1; i <= end; ++i) {
            if (nums[i] > maxNum) {
                maxNum = nums[i];
                maxIndex = i;
            }
        }
        
        // Create TreeNode with max number as val.
        TreeNode root = new TreeNode(maxNum);
        
        // Recursively call buildRoot on root.left and root.right
        root.left = buildRoot(nums, start, maxIndex - 1);
        root.right = buildRoot(nums, maxIndex + 1, end);
        
        // Return root
        return root;
    }
}
