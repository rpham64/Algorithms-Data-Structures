package Arrays;

/**
 * Given an unsorted array return whether an increasing subsequence of length 3 exists or not in the array.
	
	Formally the function should:
	
	Return true if there exists i, j, k 
	such that arr[i] < arr[j] < arr[k] given 0 <= i < j < k <= n-1 else return false.
	
	Your algorithm should run in O(n) time complexity and O(1) space complexity.
	
	Examples:
	
	Given [1, 2, 3, 4, 5],
	return true.
	
	Given [5, 4, 3, 2, 1],
	return false.
 * 
 * Source: https://leetcode.com/problems/increasing-triplet-subsequence/description/
 * Solution: https://leetcode.com/problems/increasing-triplet-subsequence/discuss/79004/Concise-Java-solution-with-comments.
 * 
 * @author rpham
 * Date: 4/21/18
 *
 */
public class IncreasingTripletSubsequence_334 {

	/**
	 * Find the Minimum, then the Middle, then the Maximum values in the triplet.
	 * 
	 * Time: O(n)
	 * Space: O(1)
	 * 
	 * @param nums
	 * @return
	 */
	public boolean increasingTriplet(int[] nums) {
        int first = Integer.MAX_VALUE;
        int second = Integer.MAX_VALUE;
        
        for (int num : nums) {
            if (num <= first) {  // num <= first
                first = num;
            } else if (num <= second) {  // first < num <= second
                second = num;
            } else {  // second < num
                return true;  // Found third value
            }
        }
        
        return false;
    }
}
