package Sorting;

import java.util.Arrays;

/**
 * Bubble Sort Algorithm 
 * 
 * Idea: largest elements get "bubbled" at the end of array
 * Running Times: O(n) (Best), O(n²) (Average + Worst)
 * Auxiliary Space: O(1)
 * Sorts in Place: Yes
 * Stable: Yes
 * 
 * @author Rudolf
 *
 */
public class Bubble {

	private int[] data;
	
	/**
	 * Bubble Sort Method
	 * Idea: Compare pairs of elements (j and j+1).
	 * If element j is greater than element j+1, swap them. 
	 * 
	 * @param data
	 */
	public static void sort(int[] data) {
		
		// Swapped status for iteration
		// Idea: If any swap occurs in the array, set swapped to true to keep the for loop going.
		// If no swap occurs from start to end of array, then set swapped to false. Array is sorted.
		boolean swapped = true;
		
		while (swapped) {
			
			// Initial status: no elements swapped before pass
			swapped = false;
			
			// Iterate from first element (i=0) to second to last element (data.length - 2)
			// If current element is greater than the next element (data[i] > data[i+1]), swap them.
			// Set swapped status to true.
			for (int i = 0; i < data.length - 1; i++) {
				
				if (data[i] > data[i+1]) {
					swap(data, i, i+1);
					swapped = true;
				}
				
			}
		}

	}
	
	public static void swap(int[] data, int a, int b) {
		int temp = data[a];
		data[a] = data[b];
		data[b] = temp;
	}
	
	public static void main(String[] args) {
		
		int[] data = {64, 25, 12, 22, 11, 1, 5, 8, 20, 50, 35, 75, 24, 15, 92, 81, 40};
		
		sort(data);
		System.out.println("Sorted: " + Arrays.toString(data));
		
	}

}
