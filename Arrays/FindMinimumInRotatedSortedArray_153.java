package Arrays;

/**
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.

	(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
	
	Find the minimum element.
	
	You may assume no duplicate exists in the array.
 * 
 * Solution: https://leetcode.com/discuss/16260/java-solution-with-binary-search
 * 
 * @author Rudolf
 *
 */
public class FindMinimumInRotatedSortedArray_153 {

	/** Method: Binary Search. Time: O(log n), Space: O(1) */
	public int findMin(int[] nums) {
        
        // Base Case 0
        if (nums == null || nums.length == 0) return 0;
        
        // Base Case 1
        if (nums.length == 1) return nums[0];
        
        // Apply binary search to find the minimum
        return binarySearch(nums, 0, nums.length - 1);
    }
    
    private int binarySearch(int[] nums, int left, int right) {
        
        while (left < right) {
            
            int mid = (left + right) / 2;
            
            if (mid > 0 && nums[mid] < nums[mid-1]) {
                return nums[mid];
            }
            
            if (nums[left] <= nums[mid] && nums[mid] > nums[right]) {
                
                // Occurs on right
                left = mid + 1;
                
            } else {
                
                // Occurs on left
                right = mid - 1;
                
            }
        }
        
        return nums[left];
    }
}
