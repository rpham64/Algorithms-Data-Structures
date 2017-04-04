package Search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Given two arrays, write a function to compute their intersection.

	Example:
	Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2, 2].
	
	Note:
	
	Each element in the result should appear as many times as it shows in both arrays.
	The result can be in any order.
	
	Follow up:
	
	What if the given array is already sorted? How would you optimize your algorithm?
	What if nums1's size is small compared to nums2's size? Which algorithm is better?
	What if elements of nums2 are stored on disk, and the memory is limited such that you 
	cannot load all elements into the memory at once?
 * 
 * @author Rudolf
 *
 */
public class IntersectionOfTwoArraysII_350 {

	/**
	 * HashMap solution
	 * 
	 * Time Complexity: O(n + m) where n is length of nums1, m is length of nums2
	 * Space Complexity: O(n) where n is length of nums1
	 * 
     * Algorithm:
     *      1)  Create a hashmap that counts nums1's integer frequencies.
     *      2)  Iterate through nums2 and check if hashmap contains num from nums2.
     *          If count is greater than 0, decrement count and add to intersection array.
     *      3)  Create subarray of intersection from 0 to index
     * 
     * Variables:
     *      HashMap<Integer, Integer> (num -> count)
     *      int[] result (size = nums2.length)
     * 
     * Cases:
     *      1)  Both arrays are null (return null)
     *      2)  One array is null (return null)
     *      3)  One or both arrays are empty (return empty array)
     *      4)  Both arrays are NOT null and NOT empty
     * 
     * Examples:
     *      1)  nums1 = [1, 1, 1, 2, 2, 3, 3, 3]
     *          nums2 = [1, 1, 2, 3, 5]
     *          result = [1, 1, 2, 3]
     */
    public int[] intersect(int[] nums1, int[] nums2) {
        
        // Case 1 and 2
        if (nums1 == null || nums2 == null) return null;
        
        // Case 3
        if (nums1.length == 0 || nums2.length == 0) return new int[0];
        
        // Case 4
        
        // Step 1
        HashMap<Integer, Integer> count = new HashMap<>();
        
        for (int num : nums1) {
            if (!count.containsKey(num)) {
                count.put(num, 1);
            } else {
                int oldCount = count.get(num);
                count.put(num, oldCount + 1);
            }
        }
        
        // Step 2
        int[] intersection = new int[Math.min(nums1.length, nums2.length)];   // Assume nums1 length not always greater than nums2's
        int index = 0;
        
        for (int num : nums2) {
            
            if (count.containsKey(num) && count.get(num) > 0) {
                // Add num to intersection
                intersection[index++] = num;
                
                // Decrement count
                count.put(num, count.get(num) - 1);
            }
        }
        
        // Step 3
        return Arrays.copyOfRange(intersection, 0, index);
    }
    
    public static List<Integer> findAnagrams(String s, String p) {
        
        List<Integer> result = new ArrayList<>();
        
        // Case 1 and 2
        if (s == null || p == null) return result;
        
        // Case 3
        
        // Step 1
        int[] count = new int[128];     // Assume ASCII
        
        for (char c : p.toCharArray()) {
            count[c]++;
        }
        
        // Step 2
        for (int i = 0; i <= s.length() - p.length(); ++i) {
        	
            int[] copy = Arrays.copyOf(count, count.length);
            
            String sub = s.substring(i, i+p.length());
            System.out.println(sub);
            
            // Step 3
            for (int j = i, end = j+p.length(); j < end; ++j) {
                copy[s.charAt(j)]--;
            }
            
            for (int index = 0; index < copy.length; ++index) {
                if (copy[index] != 0) {
                	System.out.println(sub + ": " + false);
                	System.out.println("Value: " + copy[index]);
                	System.out.println("Index: " + index);
                    break;
                } else if (index == copy.length - 1 && copy[index] == 0) {
                    result.add(i);
                    System.out.println(sub + ": " + true);
                }
            }
        }
        
        // Step 4
        return result;
    }
    
    public static void main(String[] args) {
    	findAnagrams("cbaebabacd", "abc");
    }
}
