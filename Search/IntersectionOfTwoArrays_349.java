package Search;

import java.util.Arrays;
import java.util.HashSet;

/**
 * Given two arrays, write a function to compute their intersection.

	Example:
	Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2].
	
	Note:
	Each element in the result must be unique.
	The result can be in any order.
 * 
 * @author Rudolf
 *
 */
public class IntersectionOfTwoArrays_349 {

	/**
     * Examples:
     *      1)  num1 = [1, 2, 2, 1]
     *          num2 = [2, 2]
     *          result = [2]
     * 
     *      2)  num1 = [1, 1, 2, 3, 4, 4, 5, 6]
     *          num2 = [1, 2, 3, 4]
     *          result = [1, 2, 3, 4]   ???
     * 
     * Cases:
     *      1) Both arrays are null (return null int[])
     *      2) One array is null (return null int[])
     *      3) Both arrays are NOT null
     * 
     * Variables:
     *      int[] result
     *      int index                           // For iterating through result
     *      HashSet<Integer> set1               // Unique integers from nums1
     *      HashSet<Integer> set2               // Unique integers from nums2 also found in set1
     *      
     * Algorithm:
     *      1) Iterate through nums1, filling intersected hashset with uniques from nums1.
     *      2) Iterate through nums2, checking if set1 contains ints from num2. 
     *          If so, add to set2 (set of uniques from nums2).
     *      3) Iterate through set2 and add to result.
     *      4) Return result.
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        
        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();
        
        // Cases 1 and 2
        if (nums1 == null || nums2 == null) return null;
        
        // Case 3
        // Step 1: Fill set1
        for (int num : nums1) set1.add(num);
        
        // Step 2: Fill set2, checking if set1 contains ints from num2
        for (int num : nums2) {
            if (set1.contains(num)) set2.add(num);
        }
        
        // Step 3: Convert set2 to result
        int[] result = new int[set2.size()];
        int index = 0;
        
        for (int num : set2) {
            result[index++] = num;
        }
        
        // Step 4: Return result
        return result;
    }
    
    /**
     * Binary Search Version
     * 
     * Cases:
     *      1) Both arrays are null (return null int[])
     *      2) One array is null (return null int[])
     *      3) Both arrays are NOT null
     * 
     * Variables:
     *      HashSet<Integer> intersection
     *      int[] result (size = intersection.size)
     *      int index
     * 
     * Algorithm:
     *      1) Sort nums2
     *      2) Iterate through nums1, casting binary search on each integer.
     *          If binary search returns true, add the integer to a HashSet called intersection
     *      3) Initialize result array. Convert intersection HashSet to result array and return result.
     */
    public int[] intersection2(int[] nums1, int[] nums2) {
        
        // Cases 1 and 2
        if (nums1 == null || nums2 == null) return null;
        
        // Case 3
        HashSet<Integer> intersection = new HashSet<>();
        
        // Step 1: Sort nums2
        Arrays.sort(nums2);         // Time Complexity: O(n log n)
        
        // Step 2: Compare nums1 and num2
        for (int num : nums1) {
            if (Arrays.binarySearch(nums2, num) >= 0) intersection.add(num);
        }
        
        // Step 3
        int[] result = new int[intersection.size()];
        int index = 0;
        
        for (int num : intersection) result[index++] = num;
        
        return result;
    }
}
