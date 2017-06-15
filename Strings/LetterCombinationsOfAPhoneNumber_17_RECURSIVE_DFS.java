package Strings;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a digit string, return all possible letter combinations that the number could represent.
	
	A mapping of digit to letters (just like on the telephone buttons) is given below.
	
	
	
	Input:Digit string "23"
	Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * 
 * @author Rudolf
 *
 */
public class LetterCombinationsOfAPhoneNumber_17_RECURSIVE_DFS {

	/**
	 * Number of Combinations = 3^n to 4^n
	 * 
	 * @param digits
	 * @return
	 */
	public List<String> letterCombinations(String digits) {
        
        List<String> result = new ArrayList<>();
        String[] letters = {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        
        if (digits == null || digits.length() == 0) return result;
        
        helper(result, digits, 0, new StringBuilder(), letters);
        
        return result;
    }
    
    private void helper(List<String> result, String digits, int start, StringBuilder builder, String[] letters) {
        
        if (builder.length() == digits.length()) {
            result.add(builder.toString());
        } else if (builder.length() < digits.length() && start < digits.length()) {
            
            int index = Character.getNumericValue(digits.charAt(start));
            
            for (char c : letters[index].toCharArray()) {
                builder.append(c);
                helper(result, digits, start + 1, builder, letters);
                builder.deleteCharAt(builder.length() - 1);
            }
        }
        
    }
    
    public static void main(String[] args) {
    	LetterCombinationsOfAPhoneNumber_17_RECURSIVE_DFS test = new LetterCombinationsOfAPhoneNumber_17_RECURSIVE_DFS();
    	List<String> combinations = test.letterCombinations("239");
    	
    	for (String word : combinations) {
    		System.out.println(word);
    	}
    	
    	System.out.println("Size: " + combinations.size());
    }
}
