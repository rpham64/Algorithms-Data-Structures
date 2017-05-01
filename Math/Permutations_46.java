package Math;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a collection of distinct numbers, return all possible permutations.
	
	For example,
	
	[1,2,3] have the following permutations:
	
	[
	  [1,2,3],
	  [1,3,2],
	  [2,1,3],
	  [2,3,1],
	  [3,1,2],
	  [3,2,1]
	]
 * 
 * @author Rudolf
 *
 */
public class Permutations_46 {

	/**
     * Algorithm:
     *      Create List<List>> result
     *      Sort nums???
     *      Call helper function to build result
     *      Return result
     *      
     * Helper Variables:
     *      List<List<Integer>> result
     *      List<Integer> tempList
     *      int[] nums
     * 
     * Helper Algorithm:
     *      If tempList's size equals nums' length
     *          Add tempList to result
     *      Loop for int i from 0 to nums.length - 1
     *          If tempList contains nums[i], continue
     *          Add nums[i] to tempList
     *          Call helper with new tempList       (generate all permutations starting with tempList)
     *          Remove last int in tempList         (finished generating, so replace last int with new one)
     * 
     */
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        getPermutations(result, new ArrayList<>(), nums);
        return result;
    }
    
    private void getPermutations(List<List<Integer>> result, List<Integer> tempList, int[] nums) {
        
        if (tempList.size() == nums.length) result.add(new ArrayList<>(tempList));
        
        for (int i = 0; i < nums.length; ++i) {
            
            // No duplicates
            if (tempList.contains(nums[i])) continue;
            
            // Add current num to tempList
            tempList.add(nums[i]);
            
            // Generate all permutations starting with tempList
            getPermutations(result, tempList, nums);
            
            // Remove last int from tempList (finished generating)
            tempList.remove(tempList.size() - 1);
        }
    }
}
