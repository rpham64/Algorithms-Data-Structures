package LeetCode_Medium;

/**
 * Given an array of integers sorted in ascending order, 
 * find the starting and ending position of a given target value.

	Your algorithm's runtime complexity must be in the order of O(log n).
	
	If the target is not found in the array, return [-1, -1].
	
	For example,
	
	Given [5, 7, 7, 8, 8, 10] and target value 8,
	return [3, 4].
 * 
 * @author Rudolf
 *
 */
public class SearchForARange_34 {

	/**
     * Idea: Use binary search to find target in nums. 
     *      If not found, return [-1, -1].
     *      If found, decrement start index and increment end index until both numbers are not target.
     *          If start < 0, add 0 to result and stop decrementing
     *          If end = nums.length, add nums.length - 1 to result and stop incrementing
     *      Return [start, end]
     * 
     * Test Cases:
     *      1) [] 0                 [-1, -1]
     *      2) [1] 1                [0, 0]
     *      3) [1, 2] 2             [1, 1]
     *      4) [1, 2, 3, 3, 4] 3    [2, 3]
     */
    public int[] searchRange(int[] nums, int target) {
        
        int[] result = {-1, -1};
        
        // Null Check & Empty array & negative target
        if (nums == null || nums.length == 0 || target < 0) return result;
        
        int index = binarySearch(nums, target, 0, nums.length - 1);
        
        // Check if not found
        if (index < 0) return result;
        
        int start = index;
        int end = index;
        
        // Start will end at either 0 OR nums[start] is no longer target
        while (start > 0 && nums[start - 1] == target) {
            start--;
        }
        
        // End will end at either the last value in nums OR nums[end] is no longer target
        while (end < nums.length - 1 && nums[end + 1] == target) {
            end++;
        }
        
        result[0] = start;
        result[1] = end;
        
        return result;
    }
    
    private int binarySearch(int[] nums, int target, int low, int high) {
        
        while (low <= high) {
            
            int mid = (low + high) / 2;
            
            // Found target, so return its index
            if (nums[mid] == target) return mid;
            
            // Not found
            // Change low or high
            if (nums[mid] < target) {
                low = mid + 1;
            } else if (nums[mid] > target) {
                high = mid - 1;
            }
            
        }
        
        return -1;      // Not found in nums
    }
}
