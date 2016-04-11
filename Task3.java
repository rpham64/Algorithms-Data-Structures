
public class Task3 {

	public int solution(int[][] A) {
        // write your code in Java SE 8
		return numberOfCountries(A);
    }
	
	public int numberOfCountries(int[][] A) {
		
		// Array of false booleans
		boolean[][] checked = new boolean[A.length][A[0].length];
		
		int count = 0;
		
		for (int x = 0; x < A.length; x++) {
			for (int y = 0; y < A.length; y++) {
				
				if (checked[x][y]) continue;
				
				count++;
				color(A[x][y], checked, A, x, y);
			}
		}
		
		return count;
	}
	
	private void color(int val, boolean[][] checked, int[][] A, int x, int y) {
		
		// Check: x out of bounds
		if (x < 0 || x > A.length) return;
		
		// Check: y out of bounds
		if (y < 0 || y > A[0].length) return;
		
		// Check: if visited val in row x column y, return
		if (!checked[x][y]) return;
		
		// Check: if val is not the right val
		if (A[x][y] != val) return;
		
		checked[x][y] = true;
		
		// Color the neighboring tiles with same val
		color(val, checked, A, x + 1, y);
		color(val, checked, A, x - 1, y);
		color(val, checked, A, x, y + 1);
		color(val, checked, A, x, y - 1);
	}
	
}
