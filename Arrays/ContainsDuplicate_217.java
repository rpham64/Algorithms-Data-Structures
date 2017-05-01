package Arrays;

import java.util.HashSet;

/**
 * LeetCode solution #217. Contains Duplicate
 * 
 * Given an array of integers, find if the array contains any duplicates. 
 * Your function should return true if any value appears at least twice in the array, 
 * and it should return false if every element is distinct.
 * 
 * @author Rudolf
 *
 */
public class ContainsDuplicate_217 {
    
    public boolean containsDuplicate(int[] nums) {
        
        // Check: nums is empty or has 1 element
        if (nums.length == 0 || nums.length == 1) return false;
        
        HashSet<Integer> visited = new HashSet<Integer>(nums.length);
        
        for (int num : nums) {
        	
            if (!visited.contains(num)) {
            	visited.add(num);
            }
            
            else {
                return true;
            }
        }
        
        return false;
    }
}