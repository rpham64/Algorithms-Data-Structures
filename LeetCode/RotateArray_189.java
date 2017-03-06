package LeetCode;

public class RotateArray_189 {

	/** Method 1: Using arrays and modular arithmetic. Time: O(n), Space: O(n) */
	public void rotate(int[] nums, int k) {
        
        // Input Check: empty array
        if (nums.length == 0) return;
        
        int n = nums.length;
        int[] rotated = new int[n];
        
        for (int i = 0; i < n; ++i) {
            rotated[(i+k) % n] = nums[i];
        }
        
        // Copy rotated into nums
        for (int i = 0; i < n; ++i) {
            nums[i] = rotated[i];
        }
        
    }
	
	/** Method 2: Divide and Conquer technique using reverse. Time: O(n), Space: O(1) */
	/** Note: Actually slower than method 1 due to recursion */
	public void rotate2(int[] nums, int k) {
        
        // Input Check: empty array
        if (nums == null || nums.length == 0 || nums.length == 1) return;
        
        // Idea: Reverse 0 to k, then k+1 to end,  then 0 to end
        k = k % nums.length;
        reverse(nums, 0, nums.length - 1 - k);
        reverse(nums, nums.length - k, nums.length-1);  // Note: Better to use length - k than k + 1 due to ArrayIndexOutOfBoundsException
        reverse(nums, 0, nums.length-1);
    }
    
    private void reverse(int[] nums, int left, int right) {
    	
        while (left < right) {
            
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            
            left++;
            right--;
        }
        
    }
}
