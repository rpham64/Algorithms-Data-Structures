package Arrays;

/**
 * Given a sorted array consisting of only integers where every element appears twice 
 * except for one element which appears once. Find this single element that appears only once.
	
	Example 1:
	
	Input: [1,1,2,3,3,4,4,8,8]
	Output: 2
	
	Example 2:
	
	Input: [3,3,7,7,10,11,11]
	Output: 10
	
	Note: Your solution should run in O(log n) time and O(1) space.
 * 
 * @author Rudolf
 *
 */
public class SingleElementInASortedArray_540 {

	public int singleNonDuplicate(int[] nums) {
        
        int left = 0;
        int right = nums.length - 1;
        
        while (left < right) {
            
            int mid = left + (right - left) / 2;
            
            /**
             * If mid-1 and mid+1 do not match mid, then mid is the non-duplicate
             * Else, if mid is an even index (length from 0 to mid is odd)
             * 		If mid and mid-1 are different values, then the non-dup is on the left
             * 		Else, it's on the right
             * Else, if mid is an odd index (length from 0 to mid is even)
             * 		If mid and mid - 1 are the same, non-dup is on the right
             * 		Else, it's on the left
             */
            if (nums[mid] != nums[mid - 1] && nums[mid] != nums[mid + 1]) {
                return nums[mid];
            } else if (mid % 2 == 0 && nums[mid] == nums[mid - 1]) {
                right = mid - 1;
            } else if (mid % 2 == 1 && nums[mid] != nums[mid - 1]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        
        return nums[left];
    }
}
