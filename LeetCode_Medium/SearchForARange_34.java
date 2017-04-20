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
     * Solutions:
     *      1)  Brute Force: Iterate through nums until you find target. Using a window, expand the right bound
     *                      until right is out of bounds or num[right] != target.
     *                      Add ints left and right to int[] and return.
     *              - Time Complexity: O(n)
     *              - Space Complexity: O(1)
     *      2)  Binary Search: Search for target. If it exists, tighten the window by checking the left-most and right-most
     *                      nums if they're equal to target. Add left and right to int[] and return.
     *                      Else, return {-1, -1}.
     *              - Time: 9 ms
     *              - Time Complexity: O(log n)
     *              - Space Complexity: O(1)
     * 
     * Variables (2):
     *      int[] result = {-1, -1}     (default)
     *      int left = 0
     *      int right = nums.length - 1
     *      int mid = left + (right - left) / 2
     * 
     * Algorithm (2):
     *      Initialize result
     *      Check cases 1 and 2
     *      Initialize left, right
     *      Use binary search to find target:
     *          while left < right
     *              mid := left + (right - left) / 2
     *              If nums[mid] == target
     *                  Tighten left bound:
     *                      While nums[left] != target
     *                          left++
     *                  Tighten right bound:
     *                      While nums[right] != target
     *                          right--
     *                  Set result[0] := left, result[1] := right
     *                  Return result
     *              Else if nums[mid] < target
     *                  Set low := mid + 1
     *              Else
     *                  Set high := mid - 1
     *      Return result (not found)
     *              
     * Cases:
     *      1)  Nums is null or empty (return [-1, -1])
     *      2)  Nums size is 1+ (see algorithm)
     *      
     * Test Cases:
     *      1) [] 0                 [-1, -1]
     *      2) [1] 1                [0, 0]
     *      3) [1, 2] 2             [1, 1]
     *      4) [1, 2, 3, 3, 4] 3    [2, 3]
     */
	public int[] searchRange(int[] nums, int target) {
        
        int[] result = {-1, -1};
        
        // Case 1
        if (nums == null || nums.length == 0) return result;
        
        // Case 2
        int left = 0;
        int right = nums.length - 1;
        
        while (left <= right) {
            
            int mid = left + (right - left) / 2;
            
            if (nums[mid] == target) {
                
                while (nums[left] != target) left++;
                while (nums[right] != target) right--;
                
                result[0] = left;
                result[1] = right;
                
                return result;
            }
            else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return result;      // Not found
    }
}
