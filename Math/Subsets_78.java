package Math;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a set of distinct integers, nums, return all possible subsets.
	
	Note: The solution set must not contain duplicate subsets.
	
	For example,
	If nums = [1,2,3], a solution is:
	
	[
	  [3],
	  [1],
	  [2],
	  [1,2,3],
	  [1,3],
	  [2,3],
	  [1,2],
	  []
	]
 * 
 * @author Rudolf
 *
 */
public class Subsets_78 {

	/**
     * Backtracking Algorithm:
     *      Create List<List>> result
     *      Sort nums[]
     *      Call helper function backtrack(List<List<>> result, List<Integer> tempList, int[] nums, int start)
     *      Return result
     * 
     * backtrack(List<List>> result, List<Integer> tempList, int[] nums, int start):
     *      Add tempList to result
     *      Produce every possible subset starting with tempList:
     *          Loop for int i from start to nums.length - 1
     *              Add nums[i] to tempList
     *              Call backtrack with start = i + 1
     *              Remove last element of tempList (getting here means we've produced every subset starting with tempList)
     *          
     */
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        getSubsets(result, new ArrayList<>(), nums, 0);
        return result;
    }
    
    private void getSubsets(List<List<Integer>> result, List<Integer> tempList, int[] nums, int start) {
        result.add(new ArrayList<>(tempList));
        for (int i = start; i < nums.length; ++i) {
            tempList.add(nums[i]);
            getSubsets(result, tempList, nums, i+1);
            tempList.remove(tempList.size() - 1);
        }
    }
    
    public static void main(String[] args) {
    	List<List<Integer>> result = new ArrayList<>();
    	List<Integer> test = new ArrayList<>();
    	test.add(1);
    	test.add(2);
    	result.add(test);
    	
    	System.out.println("Size: " + result.get(0).size());
    }
}
