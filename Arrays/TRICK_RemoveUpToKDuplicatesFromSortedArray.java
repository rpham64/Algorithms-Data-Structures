package Arrays;

import java.util.Arrays;

public class TRICK_RemoveUpToKDuplicatesFromSortedArray {

	public int[] removeDuplicates(int[] nums, int k) {
		
		if (nums.length <= k) return nums;
		
		int index = 1;
		int count = 1;
		
		for (int i = 1; i < nums.length; ++i) {
			
			// Non-duplicate => Copy and set count to 1
			// Duplicate => If count < k, copy and increment count
			if (nums[i] != nums[i-1]) {
				nums[index++] = nums[i];
				count = 1;
			} else {
				if (count < k) {
					nums[index++] = nums[i];
					count++;
				}
			}
			
		}
		
		// Optional: Create copy subarray
		int[] copy = Arrays.copyOfRange(nums, 0, index);
		
		return copy;
	}
	
	public static void main(String[] args) {
		TRICK_RemoveUpToKDuplicatesFromSortedArray test = new TRICK_RemoveUpToKDuplicatesFromSortedArray();
		int[] nums = {1, 2, 2, 2, 2, 2, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5, 5, 5, 5};
		
		for (int num : test.removeDuplicates(nums, 3)) {
			System.out.println(num);
		}
	}
}
