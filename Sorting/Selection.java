package Sorting;

import java.util.Arrays;

/**
 * Selection Sort Algorithm
 * 
 * Idea: swap current with minimum element 
 * Running Time: O(n²) (Worst, Average & Best)
 * Auxiliary Space: O(1)
 * 
 * @author Rudolf
 *
 */
public class Selection {

	private int[] data;
	
	// Sorting method
	public static void sort(int[] data) {
		
		for (int curr = 0; curr < data.length; curr++) {
			
			// Set current index to min
			int min = curr;
			
			// Check the others if they are less than min.
			// If so, set min to the new min.
			// Swap if min is no longer i
			for (int checker = curr + 1; checker < data.length; checker++) {
				
				if (data[checker] < data[min]) {
					min = checker;
				}
				
			}
			
			if (min != curr) {
				swap(data, curr, min);
			}
			
		}
		
	}
	
	// Swap helper method
	private static void swap(int[] data, int a, int b) {
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
