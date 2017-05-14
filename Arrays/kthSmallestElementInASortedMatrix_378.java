package Arrays;

import java.util.PriorityQueue;

/**
 * Given a n x n matrix where each of the rows and columns are sorted in ascending order, 
 * find the kth smallest element in the matrix.
	
	Note that it is the kth smallest element in the sorted order, not the kth distinct element.
	
	Example:
	
	matrix = [
	   [ 1,  5,  9],
	   [10, 11, 13],
	   [12, 13, 15]
	],
	
	k = 8, return 13.
	
	Note: 
	You may assume k is always valid, 1 <= k <= n2.
 * 
 * @author Rudolf
 *
 */
public class kthSmallestElementInASortedMatrix_378 {

	/**
	 * Solution 1: Priority Queue
	 * 
	 * Time Complexity: O(n^2 * log n)
	 * Space Complexity: O(n^2)
	 * 
	 * @param matrix
	 * @param k
	 * @return
	 */
	public int kthSmallest(int[][] matrix, int k) {
        
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        
        for (int i = 0; i < matrix.length; ++i) {
            for (int j = 0; j < matrix[0].length; ++j) {
                queue.offer(matrix[i][j]);
            }
        }
        
        // PQ has all nums in sorted order
        // Poll until kth-smallest num has highest priority
        for (int i = 1; i < k; ++i) queue.poll();
        
        return queue.peek();
    }
	
	public static void main(String[] args) {
		System.out.println(Integer.MAX_VALUE);
		System.out.println(Integer.MAX_VALUE + 1);
	}
}
