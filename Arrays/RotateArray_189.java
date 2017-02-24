package Arrays;

/**
 * Rotate an array of n elements to the right by k steps.

	For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].
 * 
 * Solution: https://discuss.leetcode.com/topic/14341/easy-to-read-java-solution
 * 
 * @author Rudolf
 *
 */
public class RotateArray_189 {

	public void rotate(int[] nums, int k) {
        
        // Base Case: null, 0 or 1 element, k = 0
        if (nums == null || nums.length <= 1 || k == 0) return;
        
        k %= nums.length;
        
        // Idea: Reverse entire array, then the subarrays
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k-1);
        reverse(nums, k, nums.length - 1);
    }
    
    public void reverse(int[] nums, int start, int end) {
        
        while (start <= end) {
            
            // Swap start and end
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            
            // Increment/Decrement start/end
            start++;
            end--;
        }
        
    }
	
}
