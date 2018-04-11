package Math;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * Given some array (say, int[]), shuffle the array and return it.
 * 
 * @author rpham
 * Date: 4/10/18
 *
 */
public class ShuffleAlgorithm {
	
	public static void main(String[] args) {
		ShuffleAlgorithm test = new ShuffleAlgorithm();
		int[] nums = {1, 2, 3, 4, 5};
		
		System.out.println("Randomized: " + Arrays.toString(test.shuffle(nums)));
	}

	/**
	 * Approach #1: Iterate through an array and swap the current value with another value in the array.
	 * 				The second index is generated randomly using the Random class.
	 * 
	 * @param nums
	 * @return
	 */
	public int[] shuffle(int[] nums) {
		if (nums == null || nums.length < 2) return nums;
		
		Random random = new Random();
		
		for (int i = 0; i < nums.length; ++i) {
			int randomIndex = random.nextInt(nums.length);  // Generate some random index within 0...nums.length
			swap(nums, i, randomIndex);  // Swap current num with the num in the randomly generated index.
		}
		
		return nums;
	}
	
	/**
	 * Approach #2: Using Collections.shuffle.
	 * 
	 * Note: Collections.shuffle() works best if given an Integer[], not an int[] as you must manually fill the list and
	 * 		cannot use Arrays.asList() or List.toArray(new Object[]) methods.
	 * 
	 * @param nums
	 * @return
	 */
	public int[] shuffle2(int[] nums) {
		if (nums == null || nums.length < 2) return nums;
		
		// Add nums[] to a list.
		List<Integer> shuffledNums = new ArrayList<>();
		
		for (int num : nums) {
			shuffledNums.add(num);
		}
		
		// Shuffle nums list.
		Collections.shuffle(shuffledNums);
		
		// Re-add the numbers from shuffledNums list back into nums[].
		for (int i = 0; i < nums.length; ++i) {
			nums[i] = shuffledNums.get(i);
		}
		
		return nums;
	}
	
	private void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
}
