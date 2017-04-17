package DynamicProgramming;

/**
 * Given an integer array nums, find the sum of the elements 
 * between indices i and j (i <= j), inclusive.

Example:
Given nums = [-2, 0, 3, -5, 2, -1]

sumRange(0, 2) -> 1
sumRange(2, 5) -> -1
sumRange(0, 5) -> -3

Note:
You may assume that the array does not change.
There are many calls to sumRange function.
 * 
 * @author Rudolf
 *
 */
public class RangeSumQuery_Immutable_303 {

	/**
	 * Idea: nums(i, j) = nums(0, j) - nums(0, i-1)
	 */
	public class NumArray {

	    private int[] sums;

	    public NumArray(int[] nums) {
	        
	        sums = new int[nums.length];
	        
	        for (int i = 0; i < sums.length; ++i) {
	            
	            if (i == 0) {
	                sums[i] = nums[i];
	            } else {
	                sums[i] = nums[i] + sums[i-1];
	            }
	            
	        }
	    }
	    
	    public int sumRange(int i, int j) {
	        if (i == 0) {
	            return sums[j];
	        } else {
	            return sums[j] - sums[i-1];
	        }
	    }
	}

	/**
	 * Your NumArray object will be instantiated and called as such:
	 * NumArray obj = new NumArray(nums);
	 * int param_1 = obj.sumRange(i,j);
	 */
	
}
