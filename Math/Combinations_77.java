package Math;

import java.util.ArrayList;
import java.util.List;

/**
 * Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
	
	For example,
	
	If n = 4 and k = 2, a solution is:
	
	[
	  [2,4],
	  [3,4],
	  [2,3],
	  [1,2],
	  [1,3],
	  [1,4],
	]
 * 
 * @author Rudolf
 *
 */
public class Combinations_77 {

	public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        getList(result, n, k, 1, new ArrayList<>());
        return result;
    }
    
    private void getList(List<List<Integer>> result, int n, int k, int start, List<Integer> tempList) {
        
        if (tempList.size() == k) {
            result.add(new ArrayList<>(tempList));
        } else if (tempList.size() < k) {   // Build tempList
            
            for (int i = start; i <= n; ++i) {
                tempList.add(i);
                getList(result, n, k, i + 1, tempList);
                tempList.remove(tempList.size() - 1);
            }
            
        }
        
    }
}
