package Strings;

import java.util.ArrayList;
import java.util.List;

/**
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of 
 * rows like this: (you may want to display this pattern in a fixed font for better legibility)
	
	P   A   H   N
	A P L S I I G
	Y   I   R
	
	And then read line by line: "PAHNAPLSIIGYIR"
	
	Write the code that will take a string and make this conversion given a number of rows:
	
	string convert(string text, int nRows);
	convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
 * 
 * @author Rudolf
 *
 */
public class ZigZagConversion_6 {

	/**
     * Time Complexity: O(n + numRows) where n is length of s
     * Space Complexity: O(numRows)
     * 
     * Variables:
     *      List<StringBuilder> builders        (size = nRows)
     *      int index = 0                       (scans through zigzag and adds to builders)
     * 
     * Algorithm:
     *      Initialize list of builders:
     *          Loop for int i = 0 to nRows:
     *              Create new StringBuilder and add to list
     *      Iterate through s via zigzag using index:
     *          Loop while index < s.length():
     *              Loop for int i = 0 to nRows AND index < s.length():
     *                  Add char at index to builders(i)
     *                  Increment index
     *              Loop for int j = nRows - 2 to 1 AND index < s.length():
     *                  Add char at index to builders(j)
     *                  Increment index
     *      Iterate through builders and append to first builder:
     *          Loop for int i = 1 to size(list) - 1:
     *              StringBuilder builder = list.get(i)
     *              list.get(0).append(builder.toString())
     *      Return list.get(0).toString
     * 
     * Cases:
     *      1)  Null or empty string (return null)
     *      2)  nRows <= 0 (return s)
     *      3)  Default (whatever)
     * 
     */
    public String convert(String s, int numRows) {
        
        // Case 1
        if (s == null || s.length() == 0) return s;
        
        // Case 2
        if (numRows <= 0) return s;
        
        // Case 3
        List<StringBuilder> builders = new ArrayList<>();
        int index = 0;
        
        for (int i = 0; i < numRows; ++i) {
            builders.add(new StringBuilder());
        }
        
        while (index < s.length()) {
            
            for (int i = 0; i < numRows && index < s.length(); ++i) {
                builders.get(i).append(s.charAt(index));
                index++;
            }
            
            for (int i = numRows - 2; i > 0 && index < s.length(); --i) {
                builders.get(i).append(s.charAt(index));
                index++;
            }
        }
        
        for (int j = 1; j < builders.size(); ++j) {
            String sub = builders.get(j).toString();
            builders.get(0).append(sub);
        }
        
        return builders.get(0).toString();
    }
}
