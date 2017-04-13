package Strings;

/**
 * Given a string s and a string t, check if s is subsequence of t.
	
	You may assume that there is only lower case English letters in both s and t. 
	t is potentially a very long (length ~= 500,000) string, and s is a short string (<=100).
	
	A subsequence of a string is a new string which is formed from the original string by 
	deleting some (can be none) of the characters without disturbing the relative positions 
	of the remaining characters. (ie, "ace" is a subsequence of "abcde" while "aec" is not).
	
	Example 1:
	s = "abc", t = "ahbgdc"
	
	Return true.
	
	Example 2:
	s = "axc", t = "ahbgdc"
	
	Return false.
	
	Follow up:
	
	If there are lots of incoming S, say S1, S2, ... , Sk where k >= 1B, and you want to check 
	one by one to see if T has its subsequence. In this scenario, how would you change your code?
 * 
 * 
 * @author Rudolf
 *
 */
public class IsSubsequence_392 {

	/**
	 * Brute Force solution
	 * Time: 45 ms
	 * 
     * Examples:
     *      1)  s = "abc"
     *          t = "ahbgdc"
     *          true
     *      
     *      2)  s = "axc"
     *          t = "ahbgdc"
     *          false
     * 
     * Solutions:
     *      1) Brute Force
     *          - For each letter in s, iterate through t and compare the two characters.
     *          - Time: O(nm) where n is length of s, m is length of t
     *          - Space: O(1)
     *      2) Sort both s and t, then iterate through s and use binary search to find current char in t. 
     *          If next char in s is duplicate, increment/decrement index in t to find duplicate.
     *          - Time: O(n log n + m log m + n + log m)    [wtf?]
     *          - Space: O(n + m) 
     * 
     * Variables:
     *      int indexS = 0  (for iterating through s)
     *      int indexT = 0  (for iterating through t)
     * 
     * Algorithm:
     *      1) Loop while indexT is less than t.length
     *      2) If s.charAt indexS equals t.charAt indexT
     *          Increment indexS
     *          If indexS is equal to s.length, return true (we're done)
     *      3) Increment indexT
     *      4) Return false (reached end of t but not of s, hence s is NOT a subsequence)
     * 
     * Cases:
     *      1) s is empty (length = 0   =>  true?)
     *      2) s is non-empty (see algorithm above)
     */
    public boolean isSubsequence(String s, String t) {
        
        // Case 1
        if (s.length() == 0) return true;
        
        // Case 2
        int indexS = 0;
        int indexT = 0;
        
        while (indexT < t.length()) {
            
            if (s.charAt(indexS) == t.charAt(indexT)) {
                indexS++;
                
                if (indexS == s.length()) return true;
            }
            
            indexT++;
        }
        
        return false;
    }
    
    /**
     * Solution using String#indexOf (proven to be faster than String#charAt)
     * Time taken: 2 ms (!!!!)
     * 
     * Time Complexity: O(nm)
     * Space Complexity: O(1)
     * 
     * Variables:
     *      int index = 0   (stores String#indexOf value)
     * 
     * Algorithm:
     *      1)  Iterate through chars of s
     *      2)  Use String#indexOf to search for current char in t
     *          If method returns -1, return false (current char does not exist in t)   
     *      3)  Return true (all chars of s found in t)
     * 
     * Cases:
     *      1) s is empty (length == 0, return true)
     *      2) t is shorter than s (return false)
     *      3) s is non-empty (see algorithm)
     */
    public boolean isSubsequence2(String s, String t) {
        
        // Case 1
        if (s.length() == 0) return true;
        
        // Case 2
        if (t.length() < s.length()) return false;
        
        // Case 3
        int index = 0;
        
        for (char c : s.toCharArray()) {
            index = t.indexOf(c, index);
            if (index == -1) return false;
            index++;
        }
        
        return true;
    }
}
