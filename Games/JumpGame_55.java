package Games;

/**
 * Given an array of non-negative integers, you are initially positioned 
 * at the first index of the array.
	
	Each element in the array represents your maximum jump length at that position.
	
	Determine if you are able to reach the last index.
	
	For example:
	
	A = [2,3,1,1,4], return true.
	
	A = [3,2,1,0,4], return false.
 * 
 * @author rpham
 *
 */
public class JumpGame_55 {

	/**
     * Goal: Reach the end index by using maximal jumps (jumps where you can hit a range of indices, not just one index).
     *      Iterating allows you to check each number in nums, and on the way, you keep track of the max "distance" by
     *      comparing to the current num + index. If the current index is greater than the max reachable distance we've encountered,
     *      then the result is false since we can never reach this index.
     *      Overall, the result is true if the max reachable distance we encounter is >= end index.
     */
    public boolean canJump(int[] nums) {
        int reachable = 0;
        
        for (int i = 0; i < nums.length; ++i) {
            if (i > reachable) return false;    // Can never reach current index i
            reachable = Math.max(reachable, nums[i] + i);
        }
        
        return true;    // Reachable >= end index, so can reach end
    }
}
