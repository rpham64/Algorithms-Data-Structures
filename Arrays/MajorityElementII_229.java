package Arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an integer array of size n, find all elements that appear more than floor(n/3) times. 
 * The algorithm should run in linear time and in O(1) space.
 * 
 * Algorithm used: Boyer-Moore Vote Algorithm
 * 
 * @author Rudolf
 *
 */
public class MajorityElementII_229 {

	public List<Integer> majorityElement(int[] nums) {
        
        List<Integer> result = new ArrayList<>();
        
        if (nums == null || nums.length == 0) return result;
        
        int candidate1 = nums[0];
        int candidate2 = nums[0];
        int count1 = 0;
        int count2 = 0;
        
        // Pass 1: Find the two majority elements in nums[] (max 2 since only up to 2 can appear more than n/3 times)
        for (int num : nums) {
            
            if (num == candidate1) {
                count1++;
            } else if (num == candidate2) {
                count2++;
            } else if (count1 == 0) {
                candidate1 = num;
                count1 = 1;
            } else if (count2 == 0) {
                candidate2 = num;
                count2 = 1;
            } else {
                count1--;
                count2--;
            }
            
        }
        
        // Pass 2: Check the counts of candidates 1 and 2 to see if their counts are > n/3. 
        //          If so, add to result List
        count1 = 0;
        count2 = 0;
        
        for (int num : nums) {
            if (num == candidate1) {
                count1++;
            } else if (num == candidate2) {
                count2++;
            }
        }
        
        if (count1 > nums.length / 3) result.add(candidate1);
        if (count2 > nums.length / 3) result.add(candidate2);
        
        return result;
    }
}
