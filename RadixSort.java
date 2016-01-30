import java.util.Scanner;

public class RadixSort {
	
	public static void sort(int[] data) {
		
		int max = data[0];
		
		for (int i = 0; i < data.length; i++) {
			if (data[i] > max) {
				max = data[i];
			}
		}
		
		int length = String.valueOf(max).length();
		
		// Sort Algorithm
		for (int i = 1; i < length; i++) {
			
		}
	}
	
	public static void main(String[] args) {
		
		
	}
}
