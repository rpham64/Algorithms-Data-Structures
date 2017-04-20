package Arrays;

import java.util.HashMap;

import junit.framework.Assert;

/**
 * Different ways of counting objects in a data set.
 * 
 * 	1)	Arrays				(Time: O(n), Space: O(max(num) + 1))
 * 	2)	HashMap				(Time: O(n), Space: O(n))
 * 	3)	Brute Force			(Time: O(n^2), Space: O(1))
 * 
 * @author Rudolf
 *
 */
public class Counting {

	public static void main(String[] args) {
		
		Counting test = new Counting();
		int[] nums = {1, 2, 3, 4, 5, 5, 6, 6, 6, 7, 8, 9, 9, 10, 12};
		
		// Test 1
//		int[] count = test.count(nums);
//		
//		for (int i = 0; i < count.length; ++i) {
//			System.out.println("Count of " + i + ": " + count[i]);
//		}
		
		// Test 2
//		HashMap<Integer, Integer> countMap = test.count2(nums);
//		
//		for (int num : countMap.keySet()) {
//			System.out.println("Count of: " + num + ": " + countMap.get(num));
//		}
		
		// Test 3
		double mean = 6.2; 
		double median = 6.0;
		int mode = 6;
		
		System.out.println("Mean: " + test.mean(nums));
		System.out.println("Median: " + test.median(nums));
		System.out.println("Mode: " + test.mode(nums));
	}
	
	/**
	 * Given int[] nums, returns an int[] containing the frequencies of each int in nums.
	 * 
	 * @param nums
	 * @return
	 */
	public int[] count(int[] nums) {
		
		// Step 1: Find max of nums
		int max = nums[0];
		
		for (int num : nums) max = Math.max(max,  num);
		
		// Step 2: Create int[] count with size max+1
		int[] count = new int[max + 1];
		
		// Step 3: Iterate through nums and increment value in count
		for (int num : nums) count[num]++;
		
		// Step 4: Return count
		return count;
	}
	
	public HashMap<Integer, Integer> count2(int[] nums) {
		
		HashMap<Integer, Integer> count = new HashMap<>();
		
		// Iterate through nums and add their counts to the hashmap
		for (int num : nums) {
			if (count.containsKey(num)) {
				count.put(num, count.get(num) + 1);
			} else {
				count.put(num, 1);
			}
		}
		
		return count;
	}
	
	public double mean(int[] nums) {
		
		double sum = 0;
		int n = nums.length;
		
		for (int num : nums) {
			sum += num;
		}
		
		return sum / n;
	}
	
	/**
	 * Cases:
	 * 		1)	Odd length (return mid)
	 * 		2)	Even length (return (nums[mid] + nums[mid + 1]) / 2)
	 * 
	 * @param nums
	 * @return
	 */
	public double median(int[] nums) {
		
		int left = 0;
		int right = nums.length - 1;
		int mid = left + (right - left) / 2;
		
		if (nums.length % 2 == 1) {
			return nums[mid];
		} else {		// Even length
			return (nums[mid] + nums[mid+1]) / 2.0;
		}
	}
	
	public int mode(int[] nums) {
		
		int mode = 0;			// Most frequently occurring num in nums
		int maxCount = 0;		// Set mode if count of num > maxCount
		
		for (int i = 0; i < nums.length; ++i) {
			
			int count = 0;
			
			for (int j = 0; j < nums.length; ++j) {
				
				if (nums[i] == nums[j]) count++;
				
			}
			
			if (count > maxCount) {
				maxCount = count;
				mode = nums[i];
			}
		}
		
		return mode;
	}
}
