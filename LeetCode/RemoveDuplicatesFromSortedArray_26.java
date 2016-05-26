package LeetCode;

/**
 * Given a sorted array, remove the duplicates in place such that 
 * each element appear only once and return the new length.

	Do not allocate extra space for another array, you must do this 
	in place with constant memory.
	
	For example,
	Given input array nums = [1,1,2],
	
	Your function should return length = 2, with the first two elements 
	of nums being 1 and 2 respectively. 
	It doesn't matter what you leave beyond the new length.
 * 
 * @author Rudolf
 *
 */
public class RemoveDuplicatesFromSortedArray_26 {

	/** Idea: Iterate through array, and if current is larger than last of
	 *  new array, replace it with current. Else, skip the duplicate.
	 *  
	 *  Time: O(n)
	 *  Space: O(1)
	 * 
	 * @param nums
	 * @return
	 */
	public int removeDuplicates(int[] nums) {
        
        // Input Check: null array OR empty array OR 1 element
        if (nums == null || nums.length == 0) return 0;
        
        int length = 0;
        
        for (int num : nums) {
            
            if (length == 0 || num > nums[length - 1]) {
                
                nums[length++] = num;
                
            }
            
        }
        
        return length;
    }
}
