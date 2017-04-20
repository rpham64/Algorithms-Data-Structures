package LeetCode;

import java.util.HashSet;
import java.util.PriorityQueue;

public class ThirdMaximumNumber_414 {

	/**
	 * Note: int can't be null, but Integer CAN.
	 * 		Use "equals" for comparing Integers.
	 * 
     * Idea: Keep track of three maximums (1st, 2nd and 3rd maximum). Iterate through nums.
     *      If num is equal to 1st, 2nd or 3rd max, continue (no duplicates allowed)
     *      If num is greater than 1st max,
     *          Set 3rd max to 2nd max
     *          Set 2nd max to 1st max
     *          Set 1st max to this num
     *      If num is greater than 2nd max
     *          Set 3rd max to 2nd max
     *          Set 2nd max to this num
     *      If num is greater than 3rd max
     *          Set 3rd max to this num
     *      
     */
    public int thirdMax(int[] nums) {
        
        Integer max1 = null;
        Integer max2 = null;
        Integer max3 = null;
        
        for (Integer num : nums) {
            
            if (num.equals(max1) || num.equals(max2) || num.equals(max3)) continue;    // No duplicates allowed
            
            if (max1 == null || num > max1) {
                max3 = max2;
                max2 = max1;
                max1 = num;
            }
            else if (max2 == null || num > max2) {
                max3 = max2;
                max2 = num;
            }
            else if (max3 == null || num > max3) {
                max3 = num;
            }
        }
        
        // max3 could be null (example 2) or the right num
        // If null, return max1
        // Else, return max3
        return max3 == null ? max1 : max3;
    }
    
    /**
     * Time Complexity: O(n log n)
     * Space Complexity: O(n)
     * 
     * Variables:
     *      PriorityQueue<Integer> queue        (size <= 3)
     *      HashSet<Integer> visited            (for ignoring duplicates)
     * 
     * Algorithm:
     *      Initialize priority queue and hashset
     *      Loop for num in nums
     *          If visited does not contain num
     *              Add num to priorityqueue and hashset
     *              If priorityqueue size > 3, poll from queue
     *      Check if queue size < 3 (nums length < 3 or there were duplicates)
     *          If queue size < 3
     *              Poll from queue until size is 1
     *      Return queue.peek
     * 
     * Cases:
     *      1)  Nums is null (return 0)
     *      2)  Nums is non-null
     *          - If length < 3, return first maximum (Example 2)
     *          - Else, return third maximum (Examples 1 and 3)
     */
    public int thirdMax2(int[] nums) {
        
        // Case 1
        if (nums == null) return 0;
        
        // Case 2
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        HashSet<Integer> visited = new HashSet<>();
        
        for (int num : nums) {
            if (!visited.contains(num)) {
                visited.add(num);
                queue.add(num);
                
                if (queue.size() > 3) queue.poll();
            }
        }
        
        if (queue.size() < 3) {
            while (queue.size() > 1) queue.poll();
        }
        
        return queue.peek();
    }
}
