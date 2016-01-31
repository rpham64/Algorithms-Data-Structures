package Sorting;

import java.util.Arrays;

/**
 * Counting Sort Algorithm
 * 
 * Idea: Let's call the given array "A". Find the maximum integer of A. Create a new array 
 * with size equal to this max integer and call the array "C" for count. Fill C with 0's.
 * Then, iterate through A and, if an element of A is an integer equal to an index of C, 
 * increment the value in that index of C. For example, if integer is 5 in A and C has index 5, 
 * increment the value in index 5 of C. Next, iterate from index 1 (second element) to the end
 * of C and add up the previous index element in C so that the value in each index of C represents
 * the number of integers less than or equal to the index.
 * Now, create a new empty array B with size equal to A. Iterate backwards through C and 
 * set the value of A's element to index of C, and set that value of C's element to the index of B.
 * Add A's element to this index of B (B[C[A[j]]] = A[j] for some value j).
 * Repeat this process until the array is sorted in B.
 * 
 * Running Times: O(n+k) where n is the number of elements in input array, and k is the range of input
 * Auxiliary Space: O(n+k)
 * 
 * @author Rudolf
 *
 */
public class Counting {

	private int[] data;
	
	public static int[] sort(int[] data) {
		
		// Initialize array "sorted" with size of data
		int[] sorted = new int[data.length];
		
		// Find the maximum of data
		int max = data[0];
		
		for (int num : data) {
			if (num > max) { max = num; }
		}
		
		// Create array "count" with size max+1 (of data)
		int[] count = new int[max + 1];
		
		// Count the occurrences of each integer in data
		for (int i = 0; i < data.length; i++) {
			count[data[i]]++;
		}
		
		// For j = 0 to end of "count", count the number of elements less than or
		// equals to i and store it in count[j]
		for (int j = 1; j < count.length; j++) {
			count[j] += count[j-1];
		}
		
		// For int i from data.length-1 downto 0
		// 		sorted[count[data[i]]] = data[i]
		//		count[data[i]] -= 1
		for (int i = data.length-1; i >= 0; i--) {
			sorted[--count[data[i]]] = data[i];
		}
		
		// Return sorted array
		return sorted;
		
	}
	
	public static void main(String[] args) {
		
		int[] data = {64, 25, 12, 22, 11, 1, 5, 8, 20, 50, 35, 75, 24, 15, 92, 81, 40};
		
		data = sort(data);
		System.out.println("Sorted: " + Arrays.toString(data));
	}
	
}
