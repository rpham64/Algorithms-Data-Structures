package Math;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a collection of candidate numbers (C) and a target number (T), 
 * find all unique combinations in C where the candidate numbers sums to T.
	
	Each number in C may only be used once in the combination.
	
	Note:
	
	All numbers (including target) will be positive integers.
	The solution set must not contain duplicate combinations.
	For example, given candidate set [10, 1, 2, 7, 6, 1, 5] and target 8, 
	A solution set is: 
	[
	  [1, 7],
	  [1, 2, 5],
	  [2, 6],
	  [1, 1, 6]
	]
 * 
 * @author Rudolf
 *
 */
public class CombinationSumII_40 {

	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        
        List<List<Integer>> result = new ArrayList<>();
        
        if (candidates == null) return result;
        
        Arrays.sort(candidates);
        getCombinations(result, new ArrayList<>(), candidates, target, 0);
        
        return result;
    }
    
    private void getCombinations(List<List<Integer>> result, List<Integer> tempList, int[] candidates, int remain, int start) {
        
        if (remain == 0 && !result.contains(tempList)) {
            result.add(new ArrayList<>(tempList));
        } else if (remain > 0) {
            
            for (int index = start; index < candidates.length; ++index) {
                
                // If duplicate, continue
                // if (index > 0 && candidates[index] == candidates[index-1]) continue;
                
                tempList.add(candidates[index]);
                getCombinations(result, tempList, candidates, remain - candidates[index], index + 1);
                tempList.remove(tempList.size() - 1);
            }
            
        }
        
    }
}
