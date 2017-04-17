package DynamicProgramming;

import java.util.HashMap;

/**
 * Given a list of non-negative numbers and a target integer k, 
 * write a function to check if the array has a continuous subarray 
 * of size at least 2 that sums up to the multiple of k, 
 * that is, sums up to n*k where n is also an integer.
	
	Example 1:
	
	Input: [23, 2, 4, 6, 7],  k=6
	Output: True
	
	Explanation: Because [2, 4] is a continuous subarray of size 2 and sums up to 6.
	
	Example 2:
	
	Input: [23, 2, 6, 4, 7],  k=6
	Output: True
	
	Explanation: Because [23, 2, 6, 4, 7] is an continuous subarray of size 5 and sums up to 42.
	
	Note:
	
	The length of the array won't exceed 10,000.
	You may assume the sum of all the numbers is in the range of a signed 32-bit integer.
 *
 * @author Rudolf
 *
 */
public class ContinuousSubarraySum_523 {

	/**
     * Solutions:
     *      1)  Brute Force
     *          - Idea: Iterate through nums and add to every other num. On each addition, check if sum % k == 0.
     *                  If so, return true.
     *          - Time: 80 ms
     *          - Time Complexity: O(n^2)
     *          - Space Complexity: O(1)
     *      2)  HashMap
     *          - Idea: Iterate through nums and keep a running sum. Take running sum % k and check if the hashmap
     *                  contains sum % k. If so, if distance from stored index to current index is 2 or more, return true.
     *                  Else, put (runningSum::index) into hashmap.
     *          - Formula: (index + n*k) mod k = index where index can be 0...n-1
     *          - Example: 1 mod 6 = 1
     *                      Add 6 and take mod: 1 + 6 mod 6 = 1
     *          - Time: 13 ms
     *          - Time Complexity: O(n)
     *          - Space Complexity: O(min(n, k)) since n is length of nums and k determines how "strict" the hashmap size will be.
     * 
     * Variables:
     *      int sum = 0
     * 
     * Algorithm (brute force):
     *      Initialize sum
     *      Loop for int i from 0 to nums.length - 2
     *          sum := nums[i]
     *          Loop for int j = i+1 to nums.length - 1
     *              sum += nums[j]
     *              If sum % k == 0, return true
     *      Return false
     * 
     * Variables:
     *      int sum = 0
     *      HashMap<Integer, Integer> map
     * 
     * Algorithm (hashmap):
     *      Initialize sum and hashmap
     *      Loop for int i from 0 to nums.length - 1
     *          sum += nums[i]
     *          Check if k is nonzero:
     *              If k != 0, set sum %= k
     *          Check if hashmap contains sum and dist of indices is 2+:
     *              If map contains sum and index - value >= 2, return true
     *              Else, put(sum, index) into hashmap
     *      Return false
     * 
     * Cases:
     *      1)  Nums is null or length < 2 (return false)
     *      2)  k == 0
     *      3)  Nums is length 2+ and k != 0 (see algorithm)
     */
    public boolean checkSubarraySum(int[] nums, int k) {
        
        // Case 1
        if (nums == null || nums.length < 2) return false;
        
        // Case 3
        int sum;
        
        for (int i = 0; i < nums.length - 1; ++i) {
            
            sum = nums[i];
            
            for (int j = i+1; j < nums.length; ++j) {
                
                sum += nums[j];
                
                // Case 2
                // k == 0 OR k != 0
                // If k == 0, sum % k throws an ArithmeticException (divide by zero)
                //      True only if sum == 0 due to no negatives in nums
                if (sum == k || (k != 0 && sum % k == 0)) return true;
            }
        }
        
        return false;       // Not found
    }
    
    public boolean checkSubarraySum2(int[] nums, int k) {
        
        // Case 1
        if (nums == null || nums.length < 2) return false;
        
        // Case 2 and 3
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        
        map.put(0, -1);     // Case of 0 in nums
        
        for (int i = 0; i < nums.length; ++i) {
            
            sum += nums[i];
            
            // Check if k is nonzero
            if (k != 0) sum %= k;
            
            // Check if hashmap contains sum and dist of indices >= 2
            if (map.containsKey(sum)) {
                if (i - map.get(sum) >= 2) return true;
            }
            else {
                map.put(sum, i);
            }
        }
        
        return false;       // Not found
    }
}
