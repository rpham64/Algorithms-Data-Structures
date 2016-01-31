package Sorting;

import java.util.Arrays;

/**
 * Heap Sort Algorithm
 * 
 * Idea: Convert the array into a heap/binary tree. To sort the heap, compare each parent node with its
 * children and set the parent node as the greatest of the three. Recursively use this "heapify" process 
 * to bring the largest element to the root. Swap the root with the LAST element of the heap, down-size
 * the heap by 1, then repeat the heapify process. The algorithm will sort the array by putting the 
 * greatest elements to the end of the array up to the start of the array. 
 * 
 * Running Time: O(n log n) (Best, Worst, Average)
 * Auxiliary Space: O(1)
 * 
 * @author Rudolf
 *
 */
public class MaxHeap {

	private int[] data;
	private int size;
	
	// Getters and Setters
	
	/**
	 * Heap size (number of nodes, also number of array elements)
	 * 
	 * @return
	 */
	public int size() {
		return this.size;
	}
	
	/**
	 * Left child index
	 * 
	 * @param i
	 * @return
	 */
	public int leftChild(int i) {
		return 2*i + 1;
	}
	
	/**
	 * Right child index
	 * 
	 * @param i
	 * @return
	 */
	public int rightChild(int i) {
		return 2*i + 2;
	}
	
	// Max Heap Constructor
	public MaxHeap(int[] data) {
		this.data = data;
		this.size = data.length;
		
		// Apply heapify to the parents to build the array.
		for (int i = size()/2 - 1; i >= 0; i--) {
			heapify(i);
		}
	}
	
	/**
	 * Main Sort Method
	 * 
	 * Pseudocode:
	 * 
	 * Build heap using MaxHeap constructor
	 * for int size-1 to 0
	 * 		Remove largest from root (using removeMax method)
	 * 		Set last element as root
	 * 
	 * @param data
	 */
	public static void sort(int[] data) {
		
		MaxHeap heap = new MaxHeap(data);
		
		for (int i = heap.size - 1; i >= 0; i--) {
			int max = heap.removeMax();
			data[i] = max;
		}
		
	}
	
	/**
	 * Compares parent nodes with children nodes and sets the parent as the largest
	 * element of the three.
	 * 
	 * Pseudocode:
	 * 
	 * Initialize largest = i, left = leftChild(i) and right = rightChild(i).
	 * Check which is the largest: compare largest and left, then largest and right.
	 * If left element is greater than the largest element, set largest index to left index.
	 * Similarly, if right element is greater than the largest element, set largest index to right index.
	 * If largest is not equal to i, swap the new largest and i elements. Parent is now the largest element.
	 * Apply recursion: cast heapify on the affected child by using heapify(largest).
	 * 
	 * Note: Indices do not change! Only the elements that were swapped.
	 * 
	 * 		i			--->		largest = i		--if left is largest-->			i	
	 * left	  right				left		right							largest		right
	 * 
	 * @param i
	 */
	private void heapify(int i) {
		
		int largest = i;
		int left = leftChild(i);
		int right = rightChild(i);
		
		// Compare parent and child nodes. Set largest index to greatest element's index
		if (left < this.size && data[left] > data[largest]) {
			largest = left;
		}
		if (right < this.size && data[right] > data[largest]) {
			largest = right;
		}
		
		// If largest index has changed from i, swap largest and i elements.
		if (largest != i) {
			
			swap(data, largest, i);
			
			// Apply recursion on affected child index (largest)
			heapify(largest);
		}
		
	}
	
	/**
	 * Helper Method to remove and return max element at root 
	 * 
	 * Pseudocode:
	 * 
	 * Set int max = data[0]
	 * Set root as last element of heap (data[size-1]). Decrement heap size.
	 * Call heapify on new root to rebuild heap (heapify(0))
	 * return max
	 * 
	 * @return
	 */
	private int removeMax() {
		
		int max = data[0];
		data[0] = data[--size];
		
		heapify(0);
		
		return max;
	}
	
	private void swap(int[] data, int a, int b) {
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
