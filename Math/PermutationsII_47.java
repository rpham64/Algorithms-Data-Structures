package Math;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a collection of numbers that might contain duplicates, return all possible unique permutations.
	
	For example,
	
	[1,1,2] have the following unique permutations:
	
	[
	  [1,1,2],
	  [1,2,1],
	  [2,1,1]
	]
 * 
 * @author Rudolf
 *
 */
public class PermutationsII_47 {

	/**
     * Variables:
     *      List<List<Integer>> result
     * 
     * Algorithm:
     *      Create List<List<>> result
     *      Sort nums[]     (due to duplicates)
     *      Generate unique permutations via helper function
     *      Return result
     * 
     * Helper Variables:
     *      List<List<Integer>> result
     *      List<Integer> tempList
     *      int[] nums
     *      boolean[] used
     * 
     * Helper Algorithm:
     *      If tempList's size equals nums' length
     *          Add tempList to result
     *      Else    (build tempList)
     *          Loop for int i from 0 to nums.length - 1
     *              Check for duplicates:
     *                  If used[i] OR i > 0 AND nums[i] = nums[i-1] AND !used[i-1]
     *                      Continue
     *              Set used[i] := true
     *              Add nums[i] to tempList
     *              Generate all unique permutations starting with tempList:
     *                  Call helper with new tempList
     *              Finished generating permutations:
     *                  Set used[i] := false
     *                  Remove last int in tempList
     * 
     */
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        getPermutations(result, new ArrayList<>(), nums, new boolean[nums.length]);
        return result;
    }
    
    private void getPermutations(List<List<Integer>> result, List<Integer> tempList, int[] nums, boolean[] used) {
        
        if (tempList.size() == nums.length) {
            result.add(new ArrayList<>(tempList));
        } else {
            
            for (int i = 0; i < nums.length; ++i) {
                
                // Duplicates
            	// Why !used[i-1]?
            	// 		If nums[i] == nums[i-1] and used[i-1] == false, this means that 
            	//		all permutations starting with nums[i-1] were already produced.
            	//		So producing permutations using nums[i] would just result in duplicates.
                if (used[i] || i > 0 && nums[i] == nums[i-1] && !used[i-1]) continue;
                
                // Add current int to tempList and set boolean[i] to true
                used[i] = true;
                tempList.add(nums[i]);
                
                // Generate all permutations starting with tempList
                getPermutations(result, tempList, nums, used);
                
                // Remove int from tempList and set boolean[i] back to false
                used[i] = false;
                tempList.remove(tempList.size() - 1);
            }
            
        }
        
    }
}
