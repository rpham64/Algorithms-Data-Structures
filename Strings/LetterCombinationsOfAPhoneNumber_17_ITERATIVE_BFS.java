package Strings;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given a digit string, return all possible letter combinations that the number could represent.
	
	A mapping of digit to letters (just like on the telephone buttons) is given below.
	
	
	
	Input:Digit string "23"
	Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * 
 * @author Rudolf
 *
 */
public class LetterCombinationsOfAPhoneNumber_17_ITERATIVE_BFS {

	/**
     * Idea: Imagine this problem to be a Trie where each level corresponds to each digit in digits.
     *      If created string is a leaf, add to list result. Else, add to queue for further processing.
     * 
     */
    public List<String> letterCombinations(String digits) {
        
        List<String> result = new ArrayList<>();
        
        if (digits == null || digits.length() == 0) return result;
        
        String[] letters = {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        int digitsIndex = 0;
        Queue<String> queue = new LinkedList<>();
        
        queue.offer("");
        
        while (!queue.isEmpty()) {
            
            int size = queue.size();
            int lettersIndex = Character.getNumericValue(digits.charAt(digitsIndex));
            digitsIndex++;
            
            for (int i = 0; i < size; ++i) {
                
                String current = queue.poll();
                
                for (char c : letters[lettersIndex].toCharArray()) {
                    
                    String newCurrent = current + c;
                    
                    if (newCurrent.length() == digits.length()) {
                        result.add(newCurrent);
                    } else {
                        queue.offer(newCurrent);
                    }
                }
            }
            
        }
        
        return result;
    }
}
