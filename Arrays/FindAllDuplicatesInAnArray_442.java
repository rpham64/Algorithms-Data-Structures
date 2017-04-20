package Arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Given an array of integers, 1 <= a[i] <= n (n = size of array), 
 * some elements appear twice and others appear once.
	
	Find all the elements that appear twice in this array.
	
	Could you do it without extra space and in O(n) runtime?
	
	Example:
	
	Input:
	[4,3,2,7,8,2,3,1]
	
	Output:
	[2,3]
 * 
 * @author Rudolf
 *
 */
public class FindAllDuplicatesInAnArray_442 {
	
	/**
     * Solutions:
     *      1)  Brute Force: Iterate through nums and compare to every other num. Add duplicates to List result and return.
     *              - Time Complexity: O(n^2)
     *              - Space Complexity: O(1)
     *      2)  Counting Array/Hashmap
     *              - Time Complexity: O(n)
     *              - Space Complexity: O(n)
     *      3)  Iterate through nums and set nums[index - 1] to negative. (index - 1 due to range 1...n)
     *          If nums[index - 1] < 0, then index is a duplicate, so add index to result and reset nums[index - 1] to positive.
     *              - Time Complexity: O(n)
     *              - Space Complexity: O(1)
     * 
     * Non-solutions:
     *      1)  Binary Search: nums is unsorted. Would also require O(n log n) time
     *      2)  Iterate through nums and compare current with next num: nums is unsorted
     *      3)  Counting array or HashMap: Runs in O(n) time but requires O(n) space
     *      4)  Sorting: Requires O(n log n) time at minimum
     * 
     * Variables (3):
     *      List<Integer> result
     *      int index = abs(nums[i]) - 1        (Ex: nums from 1...8 would have indices 0...7, so index = 8 is out of bounds)
     * 
     * Algorithm (3):
     *      Initialize List result
     *      Loop for i from 0 to nums.length - 1
     *          Set index := abs(nums[i]) - 1
     *          If nums[index] < 0
     *              Add index + 1 to result
     *          Set nums[index] := -nums[index]
     *      Return result
     * 
     * Cases:
     *      1)  Length 1 (return result since no duplicates)
     *      2)  Length 2+ (see algorithm)
     */
    public List<Integer> findDuplicates3(int[] nums) {
        
        List<Integer> result = new ArrayList<>();
        
        // Case 1
        if (nums.length == 1) return result;
        
        // Case 2
        for (int i = 0; i < nums.length; ++i) {
        	
        	// Since range is from 1 to n, subtract 1 from index to avoid out of bounds
            int index = Math.abs(nums[i]) - 1;
            
            if (nums[index] < 0) {			// Visited index before, so index + 1 must be duplicate
                result.add(index + 1);
            }
            
            nums[index] = -nums[index];
        }
        
        return result;
    }

    public List<Integer> findDuplicates(int[] nums) {
        
        List<Integer> result = new ArrayList<>();
        
        // Case 1
        if (nums.length == 1) return result;
        
        // Case 2
        for (int i = 0; i < nums.length - 1; ++i) {
            for (int j = i+1; j < nums.length; ++j) {
                if (nums[i] == nums[j]) result.add(nums[i]);
            }
        }
        
        return result;
    }
    
    public List<Integer> findDuplicates2(int[] nums) {
        
        List<Integer> result = new ArrayList<>();
        
        // Case 1
        if (nums.length == 1) return result;
        
        // Case 2
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }
        
        for (int num : map.keySet()) {
            if (map.get(num) == 2) result.add(num);
        }
        
        return result;
    }
}
