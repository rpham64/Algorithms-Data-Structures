package Math;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

/**
 * Given a list of non negative integers, arrange them such that they form the largest number.
	
	For example, given [3, 30, 34, 5, 9], the largest formed number is 9534330.
	
	Note: The result may be very large, so you need to return a string instead of an integer.
 * 
 * Source: https://leetcode.com/problems/largest-number/description/
 * 
 * @author rpham
 * Date: 4/9/18
 *
 */
public class LargestNumber_179 {

	/**
    *   Solutions:
    *       1) Brute Force: Generate all possible permutations and combine them into a number.
    *           - Time: O(n!)
    *           - Space: O(n) due to recursion call stack
    *       2) Sort using a custom comparator (optimal solution)
    *           - Time: O(k*n*logn) where k is the max length of String of in numbers[] and n is the number of Strings in numbers[].
    *           - Space: O(n) where n is the number of values in nums[].
    */
    public String largestNumber(int[] nums) {
        if (nums == null || nums.length == 0) return "";
        
        // Convert all nums in nums[] to String
        String[] numbers = new String[nums.length];
        
        for (int i = 0; i < nums.length; ++i) {
            numbers[i] = String.valueOf(nums[i]);
        }
        
        // Sort numbers[] using a custom comparator that checks if a pair s1 + s2 is greater than s2 + s1.
        // Compare second string to first string as this will put the results in descending order (max to min).
        
        // Time to compare and sort: O(k*n log n) where k is the max length of the Strings in numbers[] and n log n 
        // is the time taken to sort all Strings in numbers[] via QuickSort.
        Arrays.sort(numbers, new Comparator<String>() {
            @Override
            public int compare(String i, String j) {
                String s1 = i + j;
                String s2 = j + i;
                return s2.compareTo(s1);  // Takes O(k) time to compare two strings where k is the max length.
            }
        });
        
        // Edge Case: Num[] only contains 0's, so need to convert number result "00...0" to just "0".
        if (numbers[0].charAt(0) == '0') return "0";
        
        // Build number from numbers[] and return the result.
        StringBuilder builder = new StringBuilder();
        
        for (String number : numbers) builder.append(number);
        
        return builder.toString();
    }
    
    public static void main(String[] args) {
    	
    	int[] nums = {1, 2, 3, 4, 5};
    	Random random = new Random();
    	
    	for (int i = 0; i < nums.length; ++i) {
    		int randomPosition = random.nextInt(nums.length);
    		System.out.println("Random Position: " + randomPosition);
    		swap(nums, i, randomPosition);
    		System.out.println("Randomized Array after position " + randomPosition + Arrays.toString(nums));
    	}
    	
    	System.out.println("Randomized: " + Arrays.toString(nums));
    }
    
    private static void swap(int[] nums, int i, int j) {
    	int temp = nums[i];
    	nums[i] = nums[j];
    	nums[j] = temp;
    }
}
