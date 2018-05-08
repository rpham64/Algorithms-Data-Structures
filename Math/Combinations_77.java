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

	/**
	 * Backtracking Algorithm
	 * 
	 * Time: O(n * (n choose k)) = O(n * (n! / (k!)(n-k)!)) where n is the upper bound in range of numbers, and k is the size of the subsets.
	 * 		- This is because according to the combinations formula, there are O(n choose k) combinations, and it takes n time to generate each combination.
	 * Space: O(n choose k) as they're all stored within the result list.
	 * 
	 * 
	 * @param n
	 * @param k
	 * @return
	 */
	public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        if (k == 0) return result;
        generateCombinations(result, new ArrayList<>(), 1, n, k);
        return result;
    }
    
    private void generateCombinations(List<List<Integer>> result, List<Integer> subList, int current, int max, int k) {
        // Termination
        if (subList.size() == k) {
            result.add(new ArrayList<>(subList));
            return;
        }
        
        // Recursion
        for (int num = current; num <= max; ++num) {
            subList.add(num);
            generateCombinations(result, subList, num + 1, max, k);
            subList.remove(subList.size() - 1);
        }
    }
}
