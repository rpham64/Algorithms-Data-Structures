package Search;

/**
 * Given a sorted array and a target value, return the index if the target is found. 
 * If not, return the index where it would be if it were inserted in order.

	You may assume no duplicates in the array.
	
	Here are few examples.
	
	[1,3,5,6], 5 ¡÷ 2
	[1,3,5,6], 2 ¡÷ 1
	[1,3,5,6], 7 ¡÷ 4
	[1,3,5,6], 0 ¡÷ 0
 * 
 * @author Rudolf
 *
 */
public class SearchInsertPosition_35 {

	/**
     * Idea: Use binary search to find target in nums.
     *      If it exists, return the "middle" index.
     *      Else, iterate through nums until you find the num immediately larger than target.
     *          If it exists, return that index.
     *          Else, return the length of nums (since target is the max in nums)
     * Cases:
     *      1) Empty list OR null (return 0 since nums is empty)
     *      2) List length 1 or more (use pseudocode)
     */
    public int searchInsert(int[] nums, int target) {
        
        // Case 1
        if (nums == null || nums.length == 0) return 0;
        
        // Case 2
        int index = binarySearch(nums, target);     // If found, return index. Else, return -1.
        
        // If found, return its index
        if (index > 0) return index;
        
        // Assume not found (index = -1)
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] >= target) return i;         // Immediate "greater" num has index where target would be
        }
        
        // Assume immediate "greater" has not been found.
        // Thus, target is the max in nums, so return the length of nums.
        return nums.length;
    }
    
    private int binarySearch(int[] nums, int target) {
        
        int left = 0;
        int right = nums.length - 1;
        
        while (left <= right) {
            
            int mid = (left + right) / 2;
            
            if (nums[mid] == target) return mid;        // Found
            
            if (nums[mid] < target) {
                left = mid + 1;     // Target is RIGHT of mid, so raise the left
            } else if (nums[mid] > target) {
                right = mid - 1;    // Target is LEFT of mid, so lower the right
            }
        }
        
        return -1;      // Not found
    }
    
    /**
     * Simpler version with half the amount of code
     * 
     * @param nums
     * @param target
     * @return
     */
    public int searchInsert_simple(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        
        while (left <= right) {
            
            int mid = (left + right) / 2;
            
            if (nums[mid] == target) return mid;        // Found
            
            if (nums[mid] < target) {
                left = mid + 1;     // Target is RIGHT of mid, so raise the left
            } else if (nums[mid] > target) {
                right = mid - 1;    // Target is LEFT of mid, so lower the right
            }
        }
        
        return left;      // Not found
    }
}
