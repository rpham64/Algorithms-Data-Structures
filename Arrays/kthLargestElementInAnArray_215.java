package Arrays;

/**
 * Find the kth largest element in an unsorted array. Note that it is the kth largest element 
 * in the sorted order, not the kth distinct element.
 * 
	For example,
	Given [3,2,1,5,6,4] and k = 2, return 5.
	
	Note: 
	You may assume k is always valid, 1 <= k <= array's length.
 * 
 * Source: https://leetcode.com/problems/kth-largest-element-in-an-array/description/
 * 
 * @author rpham
 * Date: 4/8/18
 *
 */
public class kthLargestElementInAnArray_215 {

	public int findKthLargest(int[] nums, int k) {
        if (nums.length == 1) return nums[0];
        
        // Convert to index of kth LARGEST.
        // If finding kth smallest, keep regular k.
        k = nums.length - k;
        
        // Use QuickSelect Algorithm
        int pivotIndex = 0;
        int left = 0;
        int right = nums.length - 1;
        
        while (left <= right) {
            pivotIndex = partition(nums, left, right, k);
            
            if (pivotIndex == k) {
                // Found the kth largest element in array
                break;
            } else if (pivotIndex < k) {
                // kth largest is right of pivotIndex in [pivotIndex + 1, right]
                left = pivotIndex + 1;
            } else {
                // kth largest is left of pivotIndex in [left, pivotIndex - 1]
                right = pivotIndex - 1;
            }
        }
        
        return nums[pivotIndex];
    }
    
    private int partition(int[] nums, int left, int right, int k) {
        if (left == right) {
            return left;
        }
        
        int pivot = nums[right];  // Choose rightmost num as pivot.
        int index = left;  // Index for swapping.
        
        for (int i = left; i < right; ++i) {
            if (nums[i] < pivot) {
                swap(nums, index, i);
                index++;
            }
        }
        swap(nums, index, right);
        return index;
    }
    
    private void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}
