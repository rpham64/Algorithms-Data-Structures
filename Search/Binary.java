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

	private int[] data;
	private int num;
	
	/**
	 * Given an array data, implement binary search to find an integer num.
	 * 
	 * @param data
	 * @param num
	 * @return index of num
	 */
	public static int binarySearch(int[] data, int num) {
		
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
			int mid = (low + high) / 2;
			
			if (data[mid] == num) return mid;
			
			// If num is less than the middle element, set high = mid - 1
			// If num is greater than the middle element, set low = mid + 1
			if (num < data[mid]) { 
				high = mid - 1; 
			}
			
			else if (num > data[mid]) { 
				low = mid + 1; 
			}
			
		}

		return -1;	// Not found
	}
	
	public static void main(String[] args) {
		
		int[] data = {0, 5, 13, 19, 22, 41, 55, 68, 72, 81, 98};
		
		System.out.println("Answer: " + binarySearch(data, 55));
		
	}

}
