import java.util.Scanner;
import java.util.Random;

public class QuickSort {

	// Sort Method
	public void sort(int data[], int start, int end) {
		
		int index;
		
		if (start < end) {
			index = partition(data, start, end);
			sort(data, start, index - 1);
			sort(data, index + 1, end);
		}
	}
	
	// Randomized version of Quicksort
	public void randomSort(int data[], int start, int end) {
		
		int index;
		
		if (start < end) {
			index = randomPartition(data, start, end);
			randomSort(data, start, index - 1);
			randomSort(data, index + 1, end);
		}
	}
	
	// Randomized version of Partition
	private int randomPartition(int data[], int start, int end) {
		Random random = new Random();
		int i = random.nextInt(end - start + 1) + start;
		
		swap(data, end, i);
		return partition(data, start, end);
	}
	
	private int partition(int data[], int start, int end) {
		
		int pivot = data[end];
		int i = start - 1;
		
		for (int j = start; j < end; j++) {
			if (data[j] <= pivot) {
				
				i++;
				swap(data, i, j);
			}
		}
		
		swap(data, i+1, end);
		return i + 1;
	}
	
	private void swap(int data[], int i, int j) {
		
		int temp = data[i];
		data[i] = data[j];
		data[j] = temp;
		
	}
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		QuickSort sorter = new QuickSort();
		
		System.out.println("Quicksort Test!\n");
		System.out.print("Please enter number of integer elements: ");
		
		int n = scanner.nextInt();
		
		System.out.println("Enter " + n + " integer elements.");
		
		int[] array = new int[n];
		
		for (int i = 0; i < array.length; i++) {
			array[i] = scanner.nextInt();
		}
		
		sorter.randomSort(array, 0, array.length - 1);
		
		System.out.print("Sorted array: ");
		for (int i = 0; i < n; i++) {
			System.out.print(array[i] + " ");
		}
		
	}
}
