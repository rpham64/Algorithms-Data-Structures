package CrackingTheCodingInterview;

public class Q1_6 {

	public void rotateImage(int[][] matrix) {
		
		int n = matrix.length;
		
		for (int layer = 0; layer < n/2; ++layer) {
			
			int first = layer;
			int last = n - 1 - layer;
			
			for (int i = first; i < last; ++i) {
				
				int offset = i - first;
				
				// Swap elements
				
				// Top
				int temp = matrix[first][i];
				
				// Left -> Top
				matrix[first][i] = matrix[last-offset][first];
				
				// Bottom -> Left
				matrix[last-offset][first] = matrix[last][last-offset];
				
				// Right -> Bottom
				matrix[last][last-offset] = matrix[i][last];
				
				// Top -> Right
				matrix[i][last] = temp; 
				
			}
			
		}
		
	}
	
}
