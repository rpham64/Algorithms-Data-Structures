package Search;

/**
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
	
	(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
	
	You are given a target value to search. If found in the array return its index, otherwise return -1.
	
	You may assume no duplicate exists in the array.
 * 
 * @author Rudolf
 *
 */
public class SearchInRotatedSortedArray_33 {

	public int search(int[] nums, int target) {
        
        // Non-rotated => Regular binary search
        // Rotated => Find minimum index, set start and end indices, cast regular binary search on region
        if (nums == null || nums.length == 0) return -1;
        
        int minIndex = getMinIndex(nums);
        if (nums[minIndex] == target) return minIndex;
        
        int n = nums.length;
        int start = (target <= nums[n-1]) ? minIndex : 0;
        int end = (target > nums[n-1]) ? minIndex : n-1;
        
        while (start <= end) {
            
            int mid = start + (end - start) / 2;
            
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        
        return -1;      // Not found
    }
    
    private int getMinIndex(int[] nums) {
        
        int start = 0;
        int end = nums.length - 1;
        
        while (start < end) {
            
            int mid = start + (end - start) / 2;
            
            // Normal condition: nums[start] < nums[mid] < nums[end]
            // nums[mid] > nums[end]    =>  min in (mid, end]
            // nums[low] >= nums[mid]   =>  min in [low, end]
            if (nums[mid] > nums[end]) {
                start = mid + 1;
            } else {    // nums[low] >= nums[mid]
                end = mid;
            }
        }
        
        return start;
    }
}
