package Search;

/**
 * Binary Search Implementation
 * 
 * Idea: To search for an element in an array, check the middle element. If element is less, check the
 * first half of the array. If element is more, check the second half of the array.
 * 
 * Running Time: O(log n)
 * Space Complexity: In auxiliary, O(1) for iterative implementation, O(log n) for recursive implementation. 
 * 
 * @author Rudolf
 *
 */

public class Binary {

	/**
	 * Given an array data, implement binary search to find an integer num.
	 * 
	 * @param data
	 * @param target
	 * @return index of num
	 */
	public static int binarySearch(int[] data, int target) {
		
		// Set low to 0, high to length of data array
		int low = 0;
		int high = data.length - 1;
		
		// Check: low <= high
		while (low <= high) {
			
			/**
			 * Note: 3 different ways to get mid
			 * 		1) mid = (low + high) / 2
			 * 			- Problem: If both low and high are very big, then you'll run into overflow.
			 * 		2) mid = low + (high - low) / 2
			 * 			- No overflow problem
			 * 			- Source: http://stackoverflow.com/questions/27167943/why-leftright-left-2-will-not-overflow
			 * 		3) mid = (low + high) >>> 1
			 * 			- Uses bit shift operator to shift the number right by 1 
			 * 			- Equivalent to dividing by 2
			 * 			- Also avoids overflow
			 * 
			 */
			int mid = low + (high - low) / 2;
			
			if (data[mid] == target) {
				return mid;
			} else if (target < data[mid]) {
				// Target is left of mid, so set high := mid - 1
				high = mid - 1;
			} else {
				// Target is right of mid, so set low := mid + 1
				low = mid + 1;
			}
		}

		return -1;	// Not found
	}
	
	public static void main(String[] args) {
		int[] data = {0, 5, 13, 19, 22, 41, 55, 68, 72, 81, 98};
		System.out.println("Expected: 6. Actual: " + binarySearch(data, 55));
	}

}
