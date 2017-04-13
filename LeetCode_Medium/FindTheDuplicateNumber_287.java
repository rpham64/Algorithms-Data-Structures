package LeetCode_Medium;

import java.util.Arrays;

/**
 * Given an array nums containing n + 1 integers where each integer is between 1 and n (inclusive), 
 * prove that at least one duplicate number must exist. 
 * Assume that there is only one duplicate number, find the duplicate one.
	
	Note:
	
	You must not modify the array (assume the array is read only).
	You must use only constant, O(1) extra space.
	Your runtime complexity should be less than O(n^2).
	There is only one duplicate number in the array, but it could be repeated more than once.
 * 
 * @author Rudolf
 *
 */
public class FindTheDuplicateNumber_287 {

	/**
     * Solutions (unsorted):
     *     1)  Brute Force: Iterate through nums and compare current int to every other int. Return current int if both are equal.
     *             - Time: 189 ms
     *             - Time Complexity: O(n^2)
     *             - Space Complexity: O(1)
     *     2)  Binary Search + Sorting: Sort nums, then iterate through nums and cast binary search on rest of nums for current num.
     *             - Time: 9 ms
     *             - Time Complexity: O(n log n)
     *             - Space Complexity: O(1) if using heap sort, O(log n) if quicksort, O(n) if merge sort
     *             - Note: This solution actually fails because sorting modifies the array
     *     3)  Binary Search w/o sorting
     *     			- Time: 6 ms
     *              - Time Complexity: O(n) since you repeatedly iterate through nums. Left, right and mid do not affect the time.
     *              - Space Complexity: O(1) with only int count, left, right, mid
     * 
     * Variables:
     *      int left = 0
     *      int right = nums.length - 1
     *      int mid = left + (right - left) / 2         // Middle index. Number to compare to
     *      int count = 0                               // Count of nums <= mid
     * 
     * Algorithm:
     *      Initialize variables
     *      Loop while left < right:
     *          mid := left + (right - left) / 2
     *          count := 0
     *          Iterate through nums and count number <= mid:
     *              Loop for num in nums
     *                  If num <= mid, increment count
     *          Count is either == (no dup) or > mid (has dup):
     *              If count <= mid, set left := mid + 1
     *              Else if count > mid, set right := mid
     *      Left == high, so return low (duplicate value)
     * 
     * Cases:
     *      1)  Default (no edge cases to check since nums is given to be non-null and non-empty)
     */
    public int findDuplicate(int[] nums) {
        for (int i = 0; i < nums.length - 1; ++i) {
            for (int j = i+1; j < nums.length; ++j) {
                if (nums[i] == nums[j]) return nums[i];
            }
        }
        return -1;      // Not found (should never be called)
    }
    
    public int findDuplicate2(int[] nums) {
       
    	Arrays.sort(nums);
       
    	for (int i = 0; i < nums.length; ++i) {
    		int dupIndex = Arrays.binarySearch(nums, i+1, nums.length, nums[i]);
    		if (dupIndex > i) return nums[i];
    	}
       
    	return -1;  // Not found
    }
    
    public int findDuplicate3(int[] nums) {
        
        int left = 0;
        int right = nums.length - 1;
        
        while (left < right) {
            
            int mid = left + (right - left) / 2;
            int count = 0;
            
            for (int num : nums) {
                if (num <= mid) count++;
            }
            
            if (count <= mid) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        
        return left;
    }
}
