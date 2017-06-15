package Arrays;

/**
 * You are given two arrays (without duplicates) nums1 and nums2 where nums1¡¦s elements are subset of nums2. 
 * Find all the next greater numbers for nums1's elements in the corresponding places of nums2.
	
	The Next Greater Number of a number x in nums1 is the first greater number to its right in nums2. 
	If it does not exist, output -1 for this number.
	
	Example 1:
	
	Input: nums1 = [4,1,2], nums2 = [1,3,4,2].
	Output: [-1,3,-1]
	
	Explanation:
	    For number 4 in the first array, you cannot find the next greater number for it in the second array, so output -1.
	    For number 1 in the first array, the next greater number for it in the second array is 3.
	    For number 2 in the first array, there is no next greater number for it in the second array, so output -1.
	    
	Example 2:
	
	Input: nums1 = [2,4], nums2 = [1,2,3,4].
	Output: [3,-1]
	
	Explanation:
	    For number 2 in the first array, the next greater number for it in the second array is 3.
	    For number 4 in the first array, there is no next greater number for it in the second array, so output -1.
	    
	Note:
	All elements in nums1 and nums2 are unique.
	The length of both nums1 and nums2 would not exceed 1000.
 * 
 * @author Rudolf
 *
 */
public class NextGreaterElementI_496 {

	public int[] nextGreaterElement(int[] findNums, int[] nums) {
        
        if (findNums == null || nums == null || findNums.length == 0 || nums.length == 0) return findNums;
        
        for (int i = 0; i < findNums.length; ++i) {
            
            int temp = -1;
            int index = 0;
            
            // Find index in nums
            for (int j = 0; j < nums.length; ++j) {
                if (nums[j] == findNums[i]) {
                    index = j;
                    break;
                }
            }
            
            // Find next greater element in nums
            // Break if found
            for (int j = index; j < nums.length; ++j) {
                if (nums[j] > findNums[i]) {
                    temp = nums[j];
                    break;      // Only want the first greater element
                }
            }
            
            findNums[i] = temp;
        }
        
        return findNums;
    }
}
