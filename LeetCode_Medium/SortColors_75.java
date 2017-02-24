package LeetCode_Medium;

public class SortColors_75 {

	/* Solution 1: Counting Sort */
	public void sortColors(int[] nums) {
        
        // Base Case: empty or 1 number
        if (nums == null || nums.length <= 1) return;
        
        // Inductive Case
        // Method: Counting Sort
        int[] count = new int[3];
        
        for (int num : nums) {
            count[num]++;
        }
        
        // Add colors back to nums
        int numsIndex = 0;
        
        for (int color = 0; color < count.length; ++color) {
            
            for (int i = count[color]; i > 0; --i) {
                
                nums[numsIndex++] = color;
                
            }
            
        }
    }
	
	/** Solution 2: Swapping 0's to left, 2's to right */
    public void sortColors2(int[] nums) {
        
        int left = 0;
        int right = nums.length - 1;
        int current = 0;
        
        while (current <= right) {
            
            if (nums[current] == 2) {
                // Swap current and right
                // Decrement current to re-checked swapped element
                swap(nums, current--, right--);
            } else if (nums[current] == 0) {
                // Swap current and left
                // No need to re-check swapped since we already passed left
                swap(nums, current, left++);
            }
            
            // ALWAYS ITERATE
            current++;
        }
    }
    
    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
