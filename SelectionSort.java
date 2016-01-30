import java.util.Scanner;

public class SelectionSort {
	
	private int[] array;
	
	// Sort Algorithm
	public static void sort(int[] array) {
		
		for (int i = 0; i < array.length-1; i++) {
			
			int min = i;
			
			for (int j = i + 1; j < array.length; j++) {
				if (array[j] < array[min]) { min = j; }
			}
			
			if (min != array[i]) {
				int temp = array[i];
				array[i] = array[min];
				array[min] = temp;
			}
		}
	}
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Selection Sort Test!\n");
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
