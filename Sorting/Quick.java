package Sorting;

import java.util.Arrays;

/**
 * Quick Sort Algorithm!
 * 
 * Type: Divide and Conquer
 * 
 * Idea: Pick an element of an array as the "pivot". Start from the leftmost element and keep
 * track of the index of smaller elements as "i". Iterate through the array with "current". If
 * "current" is smaller than "i", swap current and i, then increment i. Else, do nothing.
 * Once you reach the end, swap element i+1 and the pivot. The pivot is now in its "sorted" position at i+1.
 * Apply recursion to the smaller elements left of the pivot (pivot_index - 1) and right of the pivot
 * (pivot_index + 1).
 * 
 * Running Times:
 * - Best: O(n log n) [Occurs if the partition process always picks middle element as the pivot]
 * - Average: O(n log n)
 * - Worst: O(n²) [Occurs if partition picks largest OR smallest element as pivot, or the array is already sorted]
 * 
 * - Note: Typically faster in practice than Merge and Heap Sorts. Can avoid worst case by using randomized
 * partition process (pick pivot randomly).
 * 
 * @author Rudolf
 *
 */
public class Quick {
	
	/**
	 * Quick Sort method
	 * 
	 * Pseudocode:
	 * 
	 * Check: if array data has 1 or no elements (if left > right)
	 * Apply partition on data and return pivot index.
	 * Apply recursion: sort method on first half of data (i = 0 to pivot index - 1)
	 * Apply recursion again: sort method on second half of data (i = pivot index + 1 to end)
	 * 
	 * @param data
	 */
	public static void sort(int[] data) {
		sort(data, 0, data.length-1);
	}
	
	public static void sort(int[] data, int start, int end) {
		
		// Check: Array data has 1 or no elements
		if (start > end) return;
		
		int pivot_index = partition(data, start, end);
		sort(data, start, pivot_index - 1);
		sort(data, pivot_index + 1, end);
		
	}
	
	/**
	 * Partition Process
	 * 
	 * Pseudocode:
	 * 
	 * Initialize pivot as end of data (data[end])
	 * Initialize smaller element index as i = start - 1
	 * From index = 0 to end, 
	 * 		if element curr is less than pivot
	 * 			increment i
	 * 			swap element i and current
	 * swap element i+1 and pivot (use pivot index) 
	 * return i+1 (the new pivot index)
	 * 
	 * @param data
	 * @return
	 */
	private static int partition(int[] data, int start, int end) {
		
		int pivot = data[end];	// Can change to any element
		int i = start;
		
		for (int index = start; index < end; index++) {
			if (data[index] < pivot) {
				swap(data, i, index);
				i++;
			}
		}
		
		swap(data, i, end);
		return i;
	}
	
	/**
	 * Swap helper method
	 * 
	 * @param data
	 * @param a
	 * @param b
	 */
	private static void swap(int[] data, int a, int b) {
		int temp = data[a];
		data[a] = data[b];
		data[b] = temp;
	}
	
	public static void main(String[] args) {
		
		int[] data = {64, 25, 12, 22, 11, 1, 5, 8, 20, 50, 35, 75, 24, 15, 92, 81, 40};
		int[] sorted = Arrays.copyOf(data, data.length);
		Arrays.sort(sorted);
		
		System.out.println("Data: " + Arrays.toString(data));
		System.out.println("Sorted Array: " + Arrays.toString(sorted));
		
		sort(data);
		System.out.println("Sorted: " + Arrays.equals(data, sorted));
	}

}
