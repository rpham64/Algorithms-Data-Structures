import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Given the root of a tree, you are asked to find the most frequent subtree sum. 
 * The subtree sum of a node is defined as the sum of all the node values formed by the subtree rooted 
 * at that node (including the node itself). So what is the most frequent subtree sum value? 
 * If there is a tie, return all the values with the highest frequency in any order.
	
	Examples 1
	
	Input:
	
	  5
	 /  \
	2   -3
	
	return [2, -3, 4], since all the values happen only once, return all of them in any order.
	
	Examples 2
	
	Input:
	
	  5
	 /  \
	2   -5
	
	return [2], since 2 happens twice, however -5 only occur once.
	
	Note: You may assume the sum of values in any subtree is in the range of 32-bit signed integer.
 * 
 * Source: https://leetcode.com/problems/most-frequent-subtree-sum/description/
 * 
 * @author rpham
 * Date: 5/7/18
 *
 */
public class MostFrequentSubtreeSum_508 {

	private HashMap<Integer, Integer> map = new HashMap<>();  // Sums -> Frequency
    private int maxFrequency = 0;
    
    /**
     * PostOrder Tree Traversal to build HashMap bottom-up.
     * 
     * Time: O(n) where n is the number of nodes in the tree.
     * Space: O(n) where this can refer to the size of the HashMap (if all sums are different), size of int[] result, or the recursion stacks of getSum().
     * 
     * @param root
     * @return
     */
    public int[] findFrequentTreeSum(TreeNode root) {
        // 1) Build up HashMap of sum -> frequency
        // 2) Add all sums with highest frequency to array and return.
        
        if (root == null) return new int[0];
        
        getSum(root);
        
        // Build list with sums of max frequency.
        List<Integer> result = new ArrayList<>();
        
        for (int sum : map.keySet()) {
            if (map.get(sum) == maxFrequency) result.add(sum);
        }
        
        // Build int[] and copy the ints from result list.
        int[] sums = new int[result.size()];
        
        for (int i = 0; i < sums.length; ++i) {
            sums[i] = result.get(i);
        }
        
        return sums;
    }
    
    private int getSum(TreeNode root) {
        if (root == null) return 0;
        
        // PostOrder Traversal: Left, Right, then do something with the sums.
        int left = getSum(root.left);
        int right = getSum(root.right);
        
        int sum = root.val + left + right;
        
        // Store sum result into map and track its frequency.
        if (map.containsKey(sum)) {
            map.put(sum, map.get(sum) + 1);
        } else {
            map.put(sum, 1);
        }
        
        // Store max frequency.
        maxFrequency = Math.max(maxFrequency, map.get(sum));
        
        return sum;
    }
}
