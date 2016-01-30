import java.util.Scanner;

public class CountingSort {
	
	// Sort Method
	public static void sort(int data[]) {
		
		int max = data[0];
		
		for (int i = 1; i < data.length; i++) {
			if (data[i] > max) {
				max = data[i];
			}
		}
		
		int[] count = new int[max + 1];
		
		// Make count array for each element
		for (int i = 0; i < data.length; i++) {
			count[data[i]]++;
		}
		
		// Modify count array with number of elements less than or equal to each element
		for (int i = 1; i < count.length; i++) {
			count[i] += count[i-1];
		}
		
		// Sort the array
		int j = 0;
		
		for (int i = 0; i < count.length; i++) {
			while (j < count[i]) {
				data[j++] = i;
			}
		}
		
	}
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Counting Sort Test!\n");
		System.out.print("Please enter number of integer elements: ");
		
		int n = scanner.nextInt();
		
		System.out.println("Enter " + n + " integer elements.");
		
		int[] data = new int[n];
		
		for (int i = 0; i < data.length; i++) {
			data[i] = scanner.nextInt();
		}
		
		sort(data);
		
		System.out.print("Sorted array: ");
		for (int i = 0; i < n; i++) {
			System.out.print(data[i] + " ");
		}
		
	}
}
