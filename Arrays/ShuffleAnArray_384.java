package Arrays;

import java.util.HashSet;
import java.util.Random;

/**
 * Shuffle a set of numbers without duplicates.
	
	Example:
	
	// Init an array with set 1, 2, and 3.
	int[] nums = {1,2,3};
	Solution solution = new Solution(nums);
	
	// Shuffle the array [1,2,3] and return its result. Any permutation of [1,2,3] must equally likely to be returned.
	solution.shuffle();
	
	// Resets the array back to its original configuration [1,2,3].
	solution.reset();
	
	// Returns the random shuffling of array [1,2,3].
	solution.shuffle();
 * 
 * Source: https://leetcode.com/problems/shuffle-an-array/description/
 * 
 * @author rpham
 * Date: 4/10/18
 *
 */
public class ShuffleAnArray_384 {

	private int[] nums;  // Store the original array for O(1) time when calling reset().
    
    public ShuffleAnArray_384(int[] nums) {
        this.nums = nums;
    }
    
    /** Resets the array to its original configuration and return it. */
    // Time: O(1)
    // Space: O(1)
    public int[] reset() {
        return nums;
    }
    
    /** Returns a random shuffling of the array. */
    // Time: O(n) where n is the length of nums[]
    // Space: O(n) where n is the length of nums[]. Allocated for storing the shuffled values and not overriding the original.
    public int[] shuffle() {
        int[] shuffled = clone(nums);
        Random random = new Random();
        
        for (int i = 0; i < shuffled.length; ++i) {
            int randomIndex = random.nextInt(shuffled.length);
            swap(shuffled, i, randomIndex);
        }
        
        return shuffled;
    }
    
    /**
     * Simple clone method.
     * 
     * Time: O(n) where n is the length of the input array.
     * Space: O(n) where n is the length of the input array. Allocated to create a copy of the input.
     * 
     * @param nums
     * @return A cloned array of the original nums[].
     */
    private int[] clone(int[] nums) {
        int[] copy = new int[nums.length];
        
        for (int i = 0; i < copy.length; ++i) {
            copy[i] = nums[i];
        }
        
        return copy;
    }
    
    /**
     * Simple swap method.
     * 
     * Time: O(1)
     * Space: O(1)
     * 
     * @param data
     * @param i
     * @param j
     */
    private void swap(int[] data, int i, int j) {
        int temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */