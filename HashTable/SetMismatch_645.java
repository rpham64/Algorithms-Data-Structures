package HashTable;

import java.util.HashSet;

/**
 * The set S originally contains numbers from 1 to n. But unfortunately, due to the data error, 
 * one of the numbers in the set got duplicated to another number in the set, which results in 
 * repetition of one number and loss of another number.
	
	Given an array nums representing the data status of this set after the error. 
	Your task is to firstly find the number occurs twice and then find the number that is missing. 
	Return them in the form of an array.
	
	Example 1:
	
	Input: nums = [1,2,2,4]
	Output: [2,3]
	
	Note:
	The given array size will in the range [2, 10000].
	The given array's numbers won't have any order.

 * 
 * Source: https://leetcode.com/problems/set-mismatch/description/
 * 
 * @author rpham
 * Date: 5/2/18
 *
 */
public class SetMismatch_645 {

	/**
	 * HashSet Solution
	 * 
	 * Time: O(n)
	 * Space: O(n)
	 * 
	 * @param nums
	 * @return
	 */
	public int[] findErrorNums(int[] nums) {
        
        HashSet<Integer> set = new HashSet<>();
        int[] result = new int[2];
        
        // 1) Find duplicate while building set.
        for (int num : nums) {
            if (set.contains(num)) {
                result[0] = num;
            } else {
                set.add(num);
            }
        }
        
        // 2) Find missing number.
        for (int num = 1; num <= nums.length; ++num) {
            if (!set.contains(num)) {
                result[1] = num;
                break;
            }
        }
        
        return result;
    }
	
	/**
	 * OPTIMAL: Algorithm involving changing numbers to negative if visited.
	 * 
	 * Time: O(n)
	 * Space: O(1)
	 * 
	 * @param nums
	 * @return
	 */
	public int[] findErrorNums2(int[] nums) {
        int[] result = new int[2];
        
        // 1) Given current num, set the number at index num - 1 to negative.
        // If number at index num - 1 is already negative, then num is a duplicate.
        for (int num : nums) {
            int index = Math.abs(num) - 1;
            if (nums[index] < 0) {
                // Found duplicate, so add num to result[].
                result[0] = Math.abs(num);
            } else {
                nums[index] *= -1;
            }
        }
        
        // 2) Find missing number.
        for (int num = 1; num <= nums.length; ++num) {
            if (nums[num - 1] > 0) {
                // Found missing number, so add num to result[].
                result[1] = num;
            }
        }
        
        return result;
    }
}
