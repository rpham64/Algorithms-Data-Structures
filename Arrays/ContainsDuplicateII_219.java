package Arrays;

import java.util.HashMap;

/**
 * LeetCode Solution #219. Contains Duplicate II
 * 
 * Given an array of integers and an integer k, find out whether there are two 
 * distinct indices i and j in the array such that nums[i] = nums[j] and the 
 * difference between i and j is at most k.
 * 
 * @author Rudolf
 *
 */
public class ContainsDuplicateII_219 {
	
	public boolean containsNearbyDuplicate(int[] nums, int k) {
        
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        
        for (int currentIndex = 0; currentIndex < nums.length; currentIndex++) {
            
        	int currentNum = nums[currentIndex];

            if (map.containsKey(currentNum)) {
                
                int otherIndex = map.get(currentNum);	// Index of duplicate
                
                if (currentIndex - otherIndex <= k) return true;
                
            }
            
            map.put(currentNum, currentIndex);
            
        }
        
        return false;
    }

}
