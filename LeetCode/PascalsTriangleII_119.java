package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an index k, return the kth row of the Pascal's triangle.

	For example, given k = 3,
	Return [1,3,3,1].
	
	Note:
	Could you optimize your algorithm to use only O(k) extra space?
 * 
 * @author Rudolf
 *
 */
public class PascalsTriangleII_119 {

	/** Time: O(n), Space: O(k) */
	public List<Integer> getRow(int rowIndex) {
        
        // Iterative Case: k >= 0
        List<Integer> previousRow = new ArrayList<>();
        
        for (int row = 0; row <= rowIndex; ++row) {
            
            List<Integer> currentRow = new ArrayList<>();
            
            for (int k = 0; k <= row; ++k) {
                
                if (k == 0 || k == row) {
                    currentRow.add(1);
                } else {
                    currentRow.add(previousRow.get(k-1) + previousRow.get(k));
                }
                
            }
            
            previousRow = currentRow;
        }
        
        return previousRow;
    }
	
}
