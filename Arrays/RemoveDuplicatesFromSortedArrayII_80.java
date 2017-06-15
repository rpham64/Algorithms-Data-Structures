package Arrays;

/**
 * Follow up for "Remove Duplicates":
	What if duplicates are allowed at most twice?
	
	For example,
	Given sorted array nums = [1,1,1,2,2,3],
	
	Your function should return length = 5, with the first five elements of nums being 1, 1, 2, 2 and 3. 
	It doesn't matter what you leave beyond the new length.
 * 
 * @author Rudolf
 *
 */
public class RemoveDuplicatesFromSortedArrayII_80 {

	/**
	 * Time Complexity: O(n)
	 * Space Complexity: O(1)
	 * 
	 * @param nums
	 * @return
	 */
	public int removeDuplicates(int[] nums) {
        
        if (nums.length <= 2) return nums.length;
        
        int index = 1;
        int count = 1;
        
        for (int i = 1; i < nums.length; ++i) {
            
            // Non-duplicate => Reset count to 1 and copy
            // Duplicate => Copy and increment count if count < 2
            if (nums[i] != nums[i-1]) {
                nums[index++] = nums[i];
                count = 1;
            } else {
                if (count < 2) {
                    nums[index++] = nums[i];
                    count++;
                }
            }
            
        }
        
        return index;
    }
}
