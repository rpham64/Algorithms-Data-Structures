package Math;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a collection of integers that might contain duplicates, nums, return all possible subsets.
	
	Note: The solution set must not contain duplicate subsets.
	
	For example,
	If nums = [1,2,2], a solution is:
	
	[
	  [2],
	  [1],
	  [1,2,2],
	  [2,2],
	  [1,2],
	  []
	]
 * 
 * @author Rudolf
 *
 */
public class SubsetsII_90 {

	/**
     * Backtracking Algorithm:
     *      Create List<List<Integer>> result
     *      Sort nums[] (REQUIRED)
     *      Call helper function to build result
     *      Return result
     * 
     * Helper Variables:
     *      List<List<Integer>> result
     *      List<Integer> tempList
     *      int[] nums
     *      int start   (index)
     *      
     * Helper Algorithm:
     *      Add tempList to result
     *      Generate all subsets that start with tempList:
     *          Loop for int i from start to nums.length - 1
     *              Check duplicates: 
     *                  If i > start AND nums[i] == nums[i-1], continue     (skip duplicates)
     *              Add nums[i] to tempList 
     *              Call helper with start = i+1    (generate all subsets starting with tempList)
     *              Remove last element of tempList (finished generating all subsets starting with tempList)
     * 
     */
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        getSubsets(result, new ArrayList<>(), nums, 0);
        return result;
    }
    
    private void getSubsets(List<List<Integer>> result, List<Integer> tempList, int[] nums, int start) {
        result.add(new ArrayList<>(tempList));
        for (int i = start; i < nums.length; ++i) {
            
            // Skip duplicates
            if (i > start && nums[i] == nums[i-1]) continue;
            
            // Add current int to tempList
            tempList.add(nums[i]);
            
            // Generate all subsets starting with tempList
            getSubsets(result, tempList, nums, i+1);
            
            // Finished generating subsets, so backtrack and remove last int
            tempList.remove(tempList.size() - 1);
        }
    }
}
