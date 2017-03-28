package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * The string "PAYPALISHIRING" is written in a zigzag pattern 
 * on a given number of rows like this: 

	P   A   H   N
	A P L S I I G
	Y   I   R
	
	And then read line by line: "PAHNAPLSIIGYIR"
	
	Write the code that will take a string and 
	make this conversion given a number of rows:

	string convert(string text, int nRows);
	convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
 * 
 * Solution: https://leetcode.com/discuss/10493/easy-to-understand-java-solution
 * 
 * @author Rudolf
 *
 */
public class ZigZagConversion_6 {

	public String convert(String s, int numRows) {
        
        // Input Check: empty string
        if ("".equals(s) || s == null || numRows == 0) return s;
        
        // Idea: Create numRows # of StringBuilder and append each character to each builder
        int length = s.length();
        StringBuilder[] builder = new StringBuilder[numRows];
        
        for (int i = 0; i < numRows; ++i) {
            builder[i] = new StringBuilder();
        }
        
        // Iterate through String s and append to each stringbuilder
        int index = 0;
        
        while (index < length) {
            
            // Vertically down
            for (int i = 0; i < numRows && index < length; ++i) {
                builder[i].append(s.charAt(index++));
            }
            
            // Diagonally up
            for (int j = numRows - 2; j > 0 && index < length; --j) {
                builder[j].append(s.charAt(index++));
            }
            
        }
        
        // Append other stringbuilders to the 1st
        for (int k = 1; k < numRows; ++k) {
            builder[0].append(builder[k]);
        }
        
        return builder[0].toString();
    }
	
	/**
	 * 
     * Initialize:
     *      List<StringBuilder> list
     * 
     * 1) Add StringBuilders to list:
     *      Loop for i = 1 to numRows
     *          Create StringBuilder
     *          Add StringBuilder to list
     * 
     * 2) Iterate through String s, adding char to the respective Stringbuilder:
     *      Initialize int row = 1, boolean isIncreasing = true (counter for which row we're on)
     *      Loop for each char in s
     *          Add char to its respective StringBuilder in list (row - 1)
     *          If isIncreasing, increment row
     *          Else, decrement row
     *          If row == 1, set isIncreasing to true
     *          Else if row == numRows, set isIncreasing to false
     * 
     * 3) Iterate through list and combine the StringBuilders:
     *      Initialize StringBuilder result
     *      Loop for StringBuilder in list
     *          Convert builder to string
     *          Append builder to result
     *      Return result
     * 
     * Cases:
     *      1) numRows = 0 (return s)
     *      2) numRows = 1 (return s)
     *      3) numRows = 2 or more (follow pseudocode)
     * 
     * s = "PAYPALISHIRING"
     * c = L
     * numRows = 3
     * row = 3
     * isIncreasing = false
     * 
     * Builder 0: PA
     * Builder 1: APL
     * Builder 2: Y
     */
    public String convert2(String s, int numRows) {
        
        // Cases 1 and 2
        if (s == null || "".equals(s) || s.length() < 2 || numRows < 2) return s;
        
        // Case 3
        List<StringBuilder> builders = new ArrayList<>();
        
        // Step 1
        for (int i = 0; i < numRows; ++i) {
            builders.add(new StringBuilder());
        }
        
        // Step 2
        int row = 1;
        boolean isIncreasing = true;
        
        for (char c : s.toCharArray()) {
            
            builders.get(row - 1).append(c);
            
            if (isIncreasing) {
                row++;
            } else {
                row--;
            }
            
            if (row == 1) isIncreasing = true;
            else if (row == numRows) isIncreasing = false;
        }
        
        // Step 3
        StringBuilder result = new StringBuilder();
        
        for (StringBuilder builder : builders) {
            result.append(builder.toString());
        }
        
        return result.toString();
    }
}
