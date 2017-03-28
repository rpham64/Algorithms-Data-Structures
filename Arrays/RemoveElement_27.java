package Arrays;

/**
 * Given an array and a value, remove all instances of that value in place and return the new length.

	Do not allocate extra space for another array, you must do this in place with constant memory.
	
	The order of elements can be changed. It doesn't matter what you leave beyond the new length.
	
	Example:
	Given input array nums = [3,2,2,3], val = 3
	
	Your function should return length = 2, with the first two elements of nums being 2.
 * 
 * @author Rudolf
 *
 */
public class RemoveElement_27 {

	/**
     * Initialize:
     *      int index = 0
     *      int length = 0
     * 
     * Loop for num in nums
     *      If num is not equal to val
     *          Set nums[index] to num
     *          Increment index
     *          Increment length
     * Return length
     * 
     * Cases:
     *      1) Empty Array (returns length 0)
     *      2) Array of length 1
     *          - If equal to val, returns length 0
     *          - If not, returns length 1
     *      3) Array of length 2+ (follow pseudocode above)
     */
    public int removeElement(int[] nums, int val) {
        
        int index = 0;
        int length = 0;
        
        // Case 1
        if (nums.length == 0 || nums == null) return length;
        
        // Cases 2 and 3
        for (int num : nums) {
            if (num != val) {
                nums[index++] = num;
                length++;
            }
        }
        
        return length;
    }
}
