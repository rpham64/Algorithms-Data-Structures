package Sorting;

import java.util.Arrays;

/**
 * Merge Sort Algorithm
 * 
 * Type: Divide and Conquer
 * 
 * Idea: Split an algorithm into halves and call merge sort on those halves.
 * 
 * Running Time: O(n log n) (Best, Worst, Average)
 * Space Complexity: O(n) (Auxiliary)
 * Sorts in Place: No (creates new arrays)
 * Stable: Yes
 * 
 * @author Rudolf
 *
 */
public class Merge {

	private int[] data;
	private int left;
	private int right;
	
	/**
	 * 
	 * @param data
	 */
	public static void sort(int[] data) {
		sort(data, 0, data.length-1);
	}
	
	/**
	 * Pseudocode:
	 * 
	 * Check: Array data is empty or contains one element. Return if so.
	 * Let mid = (left + right) / 2
	 * Apply recursion: call mergeSort on first half of data (from left to mid)
	 * Apply again: call mergeSort on second half of data (from mid + 1 to right)
	 * Merge both halves using merge method
	 * 
	 * @param data
	 * @param left
	 * @param right
	 */
	public static void sort(int[] data, int left, int right) {
		
		// Check: Array is empty or has one element
		if (left >= right) return;
		
		int mid = (left + right) / 2;
		
		sort(data, left, mid);
		sort(data, mid+1, right);
		merge(data, left, mid, right);
	}
	
	/**
	 * Helper method for sort
	 * 
	 * Pseudocode:
	 * 
	 * Let first_index = 0, second_index = 0, data_index = 0
	 * Create two temp arrays: one with size (mid - left + 1), other with size (right - mid)
	 * Fill these two temp arrays with elements from data
	 * Modify data: iterate through both temp arrays and input the smaller element into data.
	 * If there are any remaining elements left in either temp array, add them to the end of data.
	 * 
	 * Result: merged array
	 * 
	 * @param data
	 * @param left
	 * @param mid
	 * @param right
	 */
	private static void merge(int[] data, int left, int mid, int right) {
		
		int i;	// Counter for first temp array
		int j;	// Counter for second temp array
		int data_index;		// Counter for original array data
		
		int first_size = mid - left + 1;
		int second_size = right - mid;
		
		// Create temp arrays
		int[] first_array = new int[first_size];
		int[] second_array = new int[second_size];
		
		// Fill both arrays with elements from data
		for (i = 0; i < first_size; i++) {
			first_array[i] = data[left + i];
		}
		for (j = 0; j < second_size; j++) {
			second_array[j] = data[mid + j + 1];
		}
		
		// Iterate through and compare both temp arrays
		// Initialize i, j, data_index to 0
		i = 0;
		j = 0;
		data_index = left;
		
		while (i < first_size && j < second_size) {
			
			if (first_array[i] <= second_array[j]) {
				data[data_index] = first_array[i];
				i++;
			}
			else {
				data[data_index] = second_array[j];
				j++;
			}
			data_index++;
			
		}
		
		// At this point, one or no temp array will have elements left over and data
		// is not completely filled yet. Fill data with the rest of the elements.
		while (i < first_size) {
			data[data_index] = first_array[i];
			i++;
			data_index++;
		}
		while (j < second_size) {
			data[data_index] = second_array[j];
			j++;
			data_index++;
		}
		
	}
	
	public static void main(String[] args) {
		
		int[] data = {64, 25, 12, 22, 11, 1, 5, 8, 20, 50, 35, 75, 24, 15, 92, 81, 40};
		
		sort(data);
		System.out.println("Sorted: " + Arrays.toString(data));
		
	}

}
