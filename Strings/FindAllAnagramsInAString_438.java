package Strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindAllAnagramsInAString_438 {

	/**
	 * Slow Solution using two arrays and copying
	 * 
	 * Time Complexity: O(n^2 + m) where n is length of s, m is length  of p
	 * Space Complexity: O(n)
	 * 
     * Variables:
     *      List<Integer> result
     *      int[] count (size = 128 in case of ASCII)
     *      int[] copy (size = 128, a copy of count that we'll keep recreating)
     * 
     * Algorithm:
     *      1)  Create counting array that counts the frequency of each letter in p.
     *      2)  Iterate through s from index 0 to length(s) - length(p)    [exclusive]
     *              Create a copy of the counting array to use for decrementing and counting.
     *      3)      Loop for char from index i to i+length(p)   [exclusive]
     *                  Decrement count in counting copy
     *              Loop through counting copy and check if all entries are 0.
     *                  If so, add index to List result
     *      4)  Return List result
     * 
     * Cases:
     *      1)  Both strings are null (return null List)
     *      2)  One string is null (return null list)
     *      3)  Both strings are NON-EMPTY and NON-NULL (follow algorithm above)
     */
    public List<Integer> findAnagrams(String s, String p) {
        
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
            
            // Step 3
            for (int j = i, end = j+p.length(); j < end; ++j) {
                copy[s.charAt(j)]--;
            }
            
            for (int index = 0; index < copy.length; ++index) {
                if (copy[index] != 0) {
                    break;
                } else if (index == copy.length - 1 && copy[index] == 0) {
                    result.add(i);
                }
            }
        }
        
        // Step 4
        return result;
    }
    
    /**
     * Sliding Window Solution
     * 
     * Time: O(n + m) where n is length of s, m is length of p
     * 
     * Variables:
     *      List<Integer> result
     *      int[] count (size = 128 for standard ascii, 256 for extended)(for tracking char frequencies)
     *      int start = 0       (left pointer)
     *      int end = 0         (right pointer)
     *      int counter = 0     (keeps track of number of valid chars)
     * 
     * Algorithm:
     *      1)  Iterate through p and increment its char's counts in count[]
     *      2)  Loop while end is less than s.length
     *              If current char's count >= 1 (found valid char from p), increment counter
     *              Decrement current char's count
     *              Increment end
     *      3)  Check if current window's length equals p.length (end - start = p.length)
     *              If so, check if counter equals p.length
     *                  If true, add int start to List result
     *              If count of char at start is >= 0 (found valid char from p), decrement counter
     *              Increment start char's count
     *              Increment start
     *      4)  Return result
     * 
     * Idea between steps 2 and 3: All "invalid" chars have count less than 0, while the "valid" chars from p have count >= 0.
     * 
     * Cases:
     *      1)  s is empty OR null, and p is NULL (return empty list)
     *      2)  s.length > p.length (return empty list since s.length should be greater than p.length)
     *      3)  s.length >= p.length (see algorithm)
     */
    public List<Integer> findAnagrams2(String s, String p) {
        
        // Cases 1 and 2
        if (s == null || s.length() == 0 || p == null || s.length() < p.length()) return new ArrayList<Integer>();
        
        // Case 3
        List<Integer> result = new ArrayList<>();
        int[] count = new int[128];
        int start = 0;
        int end = 0;
        int counter = 0;
        
        // Step 1
        for (char c : p.toCharArray()) count[c]++;
        
        // Step 2
        while (end < s.length()) {
            
            char charEnd = s.charAt(end);
            
            if (count[charEnd] >= 1) counter++;
            count[charEnd]--;
            end++;
            
            // Step 3
            if (end - start == p.length()) {		// Found correct window size
                
                if (counter == p.length()) result.add(start);
                
                char charStart = s.charAt(start);
                
                if (count[charStart] >= 0) counter--;
                count[charStart]++;
                start++;
            }
        }
        
        // Step 4
        return result;
    }
}
