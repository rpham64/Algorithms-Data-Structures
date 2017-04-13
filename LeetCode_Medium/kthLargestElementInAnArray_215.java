package LeetCode_Medium;

import java.util.Arrays;
import java.util.PriorityQueue;

public class kthLargestElementInAnArray_215 {

	/**
     * Solutions:
     *      1)  Sort the array, then return array.length - k
     *          - Time: 3 ms (beats 88%)
     *          - Time Complexity: O(n log n)
     *          - Space Complexity: O(log n) using quicksort or built-in Arrays.sort, O(1) with heapsort, O(n) with mergesort
     *      2)  Priority Queue (lists elements from least to greatest)
     *          - Time Complexity: O(n log k) since Priority Queue is a binary heap and insertion/deletion takes O(lg k) time
     *                              Also, Priority Queue only keeps up to k elements, meaning the k-th largest up to the largest
     *                              (every other smaller element is removed)
     *          - Space Complexity: O(k) since we add to queue until it's of size k
     *      3)	Priority Queue (fill queue with nums, then using index i = nums.length - k, iterate down and poll until k == 0)
     *      	- Time: 28 ms
     *      	- Time Complexity: O(n log n) since insertion/deletion take log n time
     *      	- Space Complexity: O(n)
     * 
     */
    public int findKthLargest(int[] nums, int k) {
    	Arrays.sort(nums);
    	return nums[nums.length - k];
    }
    
    public int findKthLargest2(int[] nums, int k) {
        
    	PriorityQueue<Integer> queue = new PriorityQueue<>();
        
        for (int num : nums) {
            queue.offer(num);
            
            if (queue.size() > k) queue.poll();
        }
        
        return queue.peek();
    }
    
    public int findKthLargest3(int[] nums, int k) {
        
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        
        for (int num : nums) {
            queue.offer(num);
        }
        
        int i = nums.length - k;
        
        while (i > 0) {
            queue.poll();
            i--;
        }
        
        return queue.peek();
    }
}
