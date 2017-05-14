package Math;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum_39 {

	/**
     * Variables:
     *      List<List<Integer>> result
     * 
     * Algorithm:
     *      Create List result
     *      Use recursive helper function to generate all combinations and add to result
     *      Return result
     * 
     * Helper Variables:
     *      List<List<Integer>> result
     *      List<Integer> tempList
     *      int[] candidates
     *      int index   (current num)
     *      int sum     (sum of tempList)
     *      int target
     * 
     * Helper Algorithm:
     *      If sum equals target AND result does not contain tempList, add tempList to result
     *      Else if sum < target
     *          Loop for num from index to end
     *              Add num to tempList
     *              Generate all combinations with sum+num
     *              Remove num from tempList
     * 
     * Cases:
     *      1)  Candidates is empty (return empty list)
     *      2)  Non-empty (see algo)
     * 
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        
        List<List<Integer>> result = new ArrayList<>();
        
        // Case 1
        if (candidates == null) return result;
        
        // Case 2
        getCombinations(result, new ArrayList<>(), candidates, 0, 0, target);
        
        return result;
    }
    
    private void getCombinations(List<List<Integer>> result, List<Integer> tempList, int[] candidates, int index, int sum, int target) {
        
        if (sum == target && !result.contains(tempList)) {
        	
            result.add(new ArrayList<>(tempList));
            
        } else if (sum < target) {
            
        	// Generate combinations via backtracking
            for (int i = index; i < candidates.length; ++i) {
                tempList.add(candidates[i]);
                getCombinations(result, tempList, candidates, i, sum + candidates[i], target);
                tempList.remove(tempList.size() - 1);
            }
            
        }
        
    }
}
