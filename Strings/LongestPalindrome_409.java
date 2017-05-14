package Strings;

import java.util.HashSet;

/**
 * Given a string which consists of lowercase or uppercase letters, 
 * find the length of the longest palindromes that can be built with those letters.
	
	This is case sensitive, for example "Aa" is not considered a palindrome here.
	
	Note:
	Assume the length of given string will not exceed 1,010.
	
	Example:
	
	Input:
	"abccccdd"
	
	Output:
	7
	
	Explanation:
	One longest palindrome that can be built is "dccaccd", whose length is 7.
 * 
 * @author Rudolf
 *
 */
public class LongestPalindrome_409 {

	/**
     * Idea: Use a hashset and add the characters of s. If hashset contains the current character, the current character is a pair,
     *      so increment the count and remove the character from the hashset. If not, add the current character to the hashset.
     *      Multiply the count by 2 (number of characters in pairs) and add one if the hashset is non-empty (only odds in hashset now).
     */
    public int longestPalindrome(String s) {
        
        int numPairs = 0;
        HashSet<Character> set = new HashSet<>();
        
        for (char c : s.toCharArray()) {
            if (set.contains(c)) {
                numPairs++;
                set.remove(c);
            } else {
                set.add(c);
            }
        }
        
        numPairs *= 2;      // Number of characters in pairs
        
        return set.isEmpty() ? numPairs : numPairs + 1;
    }
}
