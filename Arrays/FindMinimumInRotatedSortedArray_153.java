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
        
        if (nums == null) return 0;
        
        int low = 0;
        int high = nums.length - 1;
        
        while (low < high) {
            
            int mid = low + (high - low) / 2;
            
            // Rotated => min if nums[min] < nums[min - 1]
            if (mid > 0 && nums[mid] < nums[mid - 1]) {
                return nums[mid];
            }
            
            // Non-rotated => min is at low
            if (nums[low] < nums[mid] && nums[mid] < nums[high]) {
                return nums[low];
            } else if (nums[mid] > nums[high]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        
        return nums[low];
    }
}
