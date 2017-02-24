package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle_118 {

	/** Method 1 - Binomial Coefficients */
	public static List<List<Integer>> generate(int numRows) {
        
        List<List<Integer>> pascal = new ArrayList<>();
        
        for (int n = 0; n < numRows; ++n) {
            
            List<Integer> row = new ArrayList<>();
            
            int nCk = 1;
            
            for (int k = 0; k <= n; ++k) {
            	
                row.add(nCk);
                
                System.out.print(nCk + " ");
                
                nCk = nCk * (n - k) / (k + 1);
                
            }
            System.out.println();
            
            pascal.add(row);   
        }
        
        return pascal;
    }
	
	/** Method 2 - Adding previous row elements */
	public static List<List<Integer>> createTriangle(int numRows) {
        
        List<List<Integer>> pascal = new ArrayList<>();
        
        for (int n = 0; n < numRows; ++n) {
            
            List<Integer> row = new ArrayList<>();
            
            for (int k = 0; k <= n; ++k) {
                
                if (k == 0 || k == n) {
                    row.add(1);
                }
                else {
                    row.add(pascal.get(n-1).get(k-1) + 
                            pascal.get(n-1).get(k));
                }
                
            }
            
            pascal.add(row);   
        }
        
        return pascal;
    }
	
	
	public static void main(String[] args) {
		
		int numRows = 9;
		
		generate(numRows);
//		createTriangle(numRows);
		
	}
	
}
