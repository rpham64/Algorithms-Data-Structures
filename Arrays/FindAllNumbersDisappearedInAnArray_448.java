package Arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an array of integers where 1 <= a[i] <= n (n = size of array), 
 * some elements appear twice and others appear once.
	
	Find all the elements of [1, n] inclusive that do not appear in this array.
	
	Could you do it without extra space and in O(n) runtime? 
	You may assume the returned list does not count as extra space.
	
	Example:
	
	Input:
	[4,3,2,7,8,2,3,1]
	
	Output:
	[5,6]
 * 
 * @author Rudolf
 *
 */
public class FindAllNumbersDisappearedInAnArray_448 {

	/**
	 * Idea: If an element i in [1, n] does not exist, then the num at index i-1 is unchanged in nums[].
	 * 		Setting nums[index] to negative means index appears in nums[], so we want the index where it's positive.
	 * 
	 * @param nums
	 * @return
	 */
	public List<Integer> findDisappearedNumbers(int[] nums) {
        
        List<Integer> result = new ArrayList<>();
        
        if (nums == null || nums.length == 0) return result;
        
        for (int i = 0; i < nums.length; ++i) {
            int index = Math.abs(nums[i]) - 1;		// Range: 1 to n will result in OutOfBounds, so set to index - 1
            if (nums[index] > 0) {
                nums[index] = -nums[index];
            }
        }
        
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] > 0) {
                result.add(i+1);
            }
        }
        
        return result;
    }
}
