import java.util.ArrayList;
import java.util.List;

/**
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

	For example, given n = 3, a solution set is:
	
	[
	  "((()))",
	  "(()())",
	  "(())()",
	  "()(())",
	  "()()()"
	]
 * 
 * Source: https://leetcode.com/problems/generate-parentheses/description/
 * 
 * @author rpham
 * Date: 4/21/18
 *
 */
public class GenerateParentheses_22 {
	
	/**
	 * Backtracking Algorithm
	 * 
	 * Time: O(2n * Cat(n)) = O(n * Cat(n)) where n is the input number of pairs, and Cat(n) refers to the Catalan number for n.
	 * 										Cat(n) is also the NUMBER OF POSSIBLE STRINGS to generate.
	 * 
	 * 		- Cat(n) = C(2n, n) / (n + 1)
	 * 
	 * Space: O(n * Cat(n)) where Cat(n) is the number of Strings and n is the amount of characters in each string.
	 * 
	 * @param n Number of pairs of parentheses.
	 * @return List of Strings containing all valid combinations of well-formed parentheses.
	 */
	public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        generateCombinations(n, result, new StringBuilder(), 0, 0);
        return result;
    }
    
    private void generateCombinations(int numMax, List<String> result, StringBuilder builder, int numOpen, int numClosed) {
        // Base Case: If numOpen == numMax and numClosed == numMax, add builder.toString() to list.
        if (numOpen == numMax && numClosed == numMax) {
            // Valid String, so add to result list.
            result.add(builder.toString());
            return;
        }
        
        // Case 1: If numOpen < numMax, add "(" to builder and generate the next combinations with backtracking.
        // This is because we can freely add "(" to builder until it reaches numMax.
        if (numOpen < numMax) {
            builder.append("(");
            generateCombinations(numMax, result, builder, numOpen + 1, numClosed);
            builder.setLength(builder.length() - 1);  // Remove last char as this is backtracking.
        }
        
        // Case 2: If numClosed < numOpen, add ")" to builder and generate the next combinations with backtracking.
        // This is because we have to close the parantheses by adding as much ")" as there are "(" (aka until numClosed == numOpen).
        if (numClosed < numOpen) {
            builder.append(")");
            generateCombinations(numMax, result, builder, numOpen, numClosed + 1);
            builder.setLength(builder.length() - 1);  // Remove last char as this is backtracking.
        }
    }
}
