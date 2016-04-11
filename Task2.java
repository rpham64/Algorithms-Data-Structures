import java.util.HashMap;

public class Task2 {

	/**
	 * 
	 * 
	 * Default: Buy 30-day ticket (0 <= COST <= 25)
	 * 
	 * @param A
	 * @return
	 */
	public int solution(int[] A) {
        // write your code in Java SE 8
		int cost = 0;
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		
		// Fill map with <number in A, index>
		for (int i = 0; i < A.length; i++) {
			map.put(A[i], i);
		}
		
		// Iterate through array A
		// If X+6 exists, buy 7-day ticket and re-assign i to X+6's index
		// Else, buy 1-day ticket
		for (int index = 0; index < A.length; index++) {
			
			int curr = A[index];
			
			if (map.containsKey(curr + 6)) {
				
				cost += 7;
				index = map.get(curr + 6);	// Set index to X+6's index
				
			} else {
				
				cost += 2;
				
			}
			
		}
		
		if (cost > 25) return 25;
		
		return cost;
    }
	
	public static void main(String[] args) {
		
		Task2 task2 = new Task2();
		
		int[] A = {1, 2, 4, 5, 7, 29, 30};
		
		System.out.println("Cost: " + task2.solution(A));
	}
}
