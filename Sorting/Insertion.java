package Sorting;

import java.util.Arrays;

/**
 * Insertion Sort Algorithm
 * 
 * Idea: sorting playing cards in hand. Use key element to compare previous elements.
 * Insert key element after "lesser" element
 * 
 * Running Time: O(n) (Best), O(n²) (Average + Worst)
 * Sorts in Place: Yes
 * Stable: Yes
 * 
 * @author Rudolf
 *
 */
public class Insertion {

	private int[] data;
	
	/**
	 * Insertion Sort method
	 * 
	 * Pseudocode:
	 * For i = 1 to data.length - 1 (skip first element)
	 * 		Set key to be current element data[i]
	 * 		Set j = i - 1 (previous element. Used to iterate backwards until j = 0)
	 * 		While j >= 0 and A[j] > key
	 * 			Set A[j+1] = A[j]	(Moving greater elements up the array)
	 * 			j = j - 1	(Decrement to check previous elements)
	 * 		A[j+1] = key
	 * 
	 * @param data
	 */
	public static void sort(int[] data) {
		
		for (int i = 1; i < data.length; i++) {
			
			int key = data[i];
			int j = i - 1;
			
			while (j >= 0 && data[j] > key) {
				
				data[j+1] = data[j];
				j--;
				
			}
			data[j+1] = key;
		}
		
	}
	
	public static void main(String[] args) {
		
		int[] data = {64, 25, 12, 22, 11, 1, 5, 8, 20, 50, 35, 75, 24, 15, 92, 81, 40};
		
		sort(data);
		System.out.println("Sorted: " + Arrays.toString(data));
		
	}

}
