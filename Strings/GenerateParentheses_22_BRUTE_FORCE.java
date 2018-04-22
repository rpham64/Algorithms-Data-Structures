import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses_22_BRUTE_FORCE {

	/**
    *   BRUTE FORCE: Generate all possible strings of length 2n.
    *
    *   Time: O(n * 2^2n) where 2^2n is the number of strings we can generate given n pairs. 
    *                     For each of the 2*2^n sequences, it takes O(n) time to validate it.
    *   Space: O(n * 2^2n) (???)
    *   
    *   Solution: https://leetcode.com/problems/generate-parentheses/solution/
    */
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        generateCombinations(result, 2*n, new StringBuilder());
        return result;
    }
    
    private void generateCombinations(List<String> result, int length, StringBuilder builder) {
        if (builder.length() == length) {
            String current = builder.toString();
            if (isValid(current)) {
                // Valid string, so add to list.
                result.add(current);
            }
        } else {
            // Generate combinations after adding "(" and ")".
            builder.append("(");
            generateCombinations(result, length, builder);
            builder.setLength(builder.length() - 1);
            
            builder.append(")");
            generateCombinations(result, length, builder);
            builder.setLength(builder.length() - 1);
        }
    }
    
    private boolean isValid(String current) {
        int balance = 0;
        for (char c : current.toCharArray()) {
            if (c == '(') {
                balance++;
            } else {  // ')'
                balance--;
            }
            if (balance < 0) return false;  // Should not be more ')' than '(' before finishing.
        }
        return balance == 0;  // Valid if equally balanced (balance = 0)
    }
}
