package Strings;

/**
 * Given a group of two strings, you need to find the longest uncommon subsequence 
 * of this group of two strings. The longest uncommon subsequence is defined as the 
 * longest subsequence of one of these strings and this subsequence should not be 
 * any subsequence of the other strings.
	
	A subsequence is a sequence that can be derived from one sequence by deleting some 
	characters without changing the order of the remaining elements. Trivially, any string 
	is a subsequence of itself and an empty string is a subsequence of any string.
	
	The input will be two strings, and the output needs to be the length of the longest 
	uncommon subsequence. If the longest uncommon subsequence doesn't exist, return -1.
	
	Example 1:
	
	Input: "aba", "cdc"
	Output: 3
	
	Explanation: The longest uncommon subsequence is "aba" (or "cdc"), 
	because "aba" is a subsequence of "aba", 
	but not a subsequence of any other strings in the group of two strings. 
	
	Note:
	
	Both strings' lengths will not exceed 100.
	Only letters from a ~ z will appear in input strings.
 * 
 * @author Rudolf
 *
 */
public class LongestUncommonSubsequenceI_521 {

	/**
     * Examples:
     *      1)  "", ""      ->      -1
     *      2)  "", "abc"   ->      3   ("" is a subsequence of abc and would return -1, BUT abc is NOT a subsequence of "", hence 3...)
     *      3)  "a", "abc"  ->      3   (a is subsequence of abc and would return 1, but abc is NOT a subsequence of a, so 3)
     *      4)  "wtf", "fuckthisshit"   ->      12  (the second is clearly NOT a subsequence of the other...)
     */
    public int findLUSlength(String a, String b) {
        return a.equals(b) ? -1 : Math.max(a.length(), b.length());
    }
}
