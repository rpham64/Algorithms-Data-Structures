package LeetCode;

import java.util.Stack;

public class ValidParentheses_20 {

	/**
     * Idea: Iterate through the string from both ends, comparing each pair of adjacent characters. If not complements, return false.
     * 
     * Examples:
     *      1) ""           Y
     *      2) "{"          N
     *      3) "()"         Y
     *      4) "()[]"       Y
     *      5) "{)"         N
     *      6) "([])"       Y
     * 
     * Cases:
     *      1) Null string OR length 0 (true)
     *      2) Odd length (false, always)
     *      3) Even length
     *          - Create stack of complements
     *          - Iterate through string from 0 to end
     *              - If '(', '{' or '[', push their complement to stack
     *              - If ')', '}' or ']', pop from stack and compare to current char
     *                  - If stack is empty OR popped char is not the same, return false
     *          - Return true, if stack is empty (possibility of tail character lacking complement)
     */
    public boolean isValid(String s) {
        
        // Case 1
        if (s == null || "".equals(s) || s.length() == 0) return false;
        
        // Case 2
        if (s.length() % 2 == 1) return false;
        
        // Case 3
        Stack<Character> complements = new Stack<>();
        
        for (char c : s.toCharArray()) {
            
            switch(c) {
                
                case '(':
                    complements.push(')');
                    break;
                case '{':
                    complements.push('}');
                    break;
                case '[':
                    complements.push(']');
                    break;
                default:
                    if (complements.isEmpty() || complements.pop() != c) return false;
                
            }
            
        }
        
        return complements.isEmpty();    // For cases where tail character has no complement
    }
}
