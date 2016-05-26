package LeetCode;

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
	
}
