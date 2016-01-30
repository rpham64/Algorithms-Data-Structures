import java.util.NoSuchElementException;
import java.io.IOException;
import java.util.Scanner;

// Heap Sort Algorithm Implementation

public class MaxHeap {

	private int array[];
	private int size;
	
	// Sort Method (Main)
	public static void sort(int[] array) {
		MaxHeap heap = new MaxHeap(array);
		for (int i = heap.size() - 1; i >= 0; i--) {
			int nextMax = heap.removeNext();
			
			// This is a rather naughty move, since heap.array is
	        // aliased to array.  We do this only because we know
	        // from the way the heap works that the end of the array
	        // can be used to store our sorted result in place.
			array[i] = nextMax;
		}
	}
	
	// Parameterized Constructor
	public MaxHeap(int array[]) {
		this.array = array;
		this.size = array.length;
		for (int i = size / 2 - 1; i >= 0; i--) {
			heapify(i);
		}
	}
	
	// Remove root (maximum)
	public int removeNext() throws NoSuchElementException {
		if (size == 0) {
			throw new NoSuchElementException();
		}
		
		// Remove the root node value. Shrink heap size by 1.
		int next = array[0];
		array[0] = array[--size]; // Equal to: array[0] = array[size]; size -= 1;
		heapify(0);
		return next;
	}
	
	public int size() {
		return this.size;
	}
	
	private int leftChild(int i) {
		return 2 * i + 1;
	}
	
	private int rightChild(int i) {
		return 2 * i + 2;
	}
	
	// Leaves max-heap in A[1..n-1]
	private void heapify(int i) {
		
		int largest = i;
		int left = leftChild(i);
		int right = rightChild(i);
		
		if (left < size && array[left] > array[largest]) {
			largest = left;
		}
		
		if (right < size && array[right] > array[largest]) {
			largest = right;
		}
		
		// If heap consistency was locally violated
		if (largest != i) {
			
			int temp = array[i];
			array[i] = array[largest];
			array[largest] = temp;
			
			// Recursively heapify the affected sub-tree
			heapify(largest);
			
		}
	}
	
	public static void main(String[] args) throws IOException {
		
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		System.out.println("Heap Sort Test.\n");
		System.out.print("Please enter number of integer elements: ");
		
		int n = scanner.nextInt();
		
		System.out.println("Enter " + n + " integer elements.");
		
		int[] array = new int[n];
		
		for (int i = 0; i < array.length; i++) {
			array[i] = scanner.nextInt();
		}
		
		sort(array);
		
		System.out.print("Sorted array: ");
		for (int i = 0; i < n; i++) {
			System.out.print(array[i] + " ");
		}
		
	}
}












