import java.util.ArrayList;
import java.util.List;

/**
 * Given a string S, we can transform every letter individually to be lowercase or uppercase to create another string. 
 *  Return a list of all possible strings we could create.
	
	Examples:
	
	Input: S = "a1b2"
	Output: ["a1b2", "a1B2", "A1b2", "A1B2"]
	
	Input: S = "3z4"
	Output: ["3z4", "3Z4"]
	
	Input: S = "12345"
	Output: ["12345"]
	
	Note:
	
	S will be a string with length at most 12.
	S will consist only of letters or digits.
 * 
 * Source: https://leetcode.com/problems/letter-case-permutation/description/
 * 
 * @author rpham
 * Date: 5/7/18
 *
 */
public class LetterCasePermutation_784 {

	/**
	 * Simple Permutation Algorithm
	 * 
	 * Time: O(2^n) where n is the number of characters in S. This is because for each character in S, we have two possibilities: uppercase, and lowercase.
	 * Space: O(2^n) where n is the number of characters in S.
	 * 
	 * @param S
	 * @return
	 */
	public List<String> letterCasePermutation(String S) {
        List<String> result = new ArrayList<>();
        generatePermutations(result, S.toCharArray(), 0);
        return result;
    }
    
    private void generatePermutations(List<String> result, char[] chars, int currentIndex) {
        // Termination
        if (currentIndex == chars.length) {
            result.add(new String(chars));
            return;
        }
        
        // Recursion
        if (chars[currentIndex] <= '9') {
            // Found number
            generatePermutations(result, chars, currentIndex + 1);
        } else {
            // Found letter
            chars[currentIndex] = Character.toLowerCase(chars[currentIndex]);
            generatePermutations(result, chars, currentIndex + 1);
            
            chars[currentIndex] = Character.toUpperCase(chars[currentIndex]);
            generatePermutations(result, chars, currentIndex + 1);
        }
    }
}
