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
    
    public static String minWindow(String s, String t) {
        String result = "";
        if(s==""||t.length()>s.length())
            return result;
        int[] map = new int[128];
        int start = 0;
        int minStart = 0;
        int end = 0;
        int count = t.length();
        int minLength = Integer.MAX_VALUE;
        for(char temp:t.toCharArray()){
            map[temp]++;
        }
        while(end<s.length()){
            if(map[s.charAt(end)]>0)
                count--;
            map[s.charAt(end)]--;
            end++;
            while(count==0){
    			if (end - start < minLength) {
    				minStart = start;
    				minLength = end - start;
    			}
    			map[s.charAt(start)]++;
    			if (map[s.charAt(start)] > 0)
    				count++;
    			start++;
            }
        }
        return (minLength==Integer.MAX_VALUE)?"":s.substring(minStart, minStart+minLength);
    }
    
    public static void main(String[] args) {
    	System.out.println("String: " + minWindow("substring", "sub"));
    }
}
