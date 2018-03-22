package Arrays;

/**
 * Given an array of non-negative integers, you are initially 
 * positioned at the first index of the array.
	
	Each element in the array represents your maximum jump length at that position.
	
	Determine if you are able to reach the last index.
	
	For example:
	
	A = [2,3,1,1,4], return true.
	
	A = [3,2,1,0,4], return false.
 * 
 * Source: https://leetcode.com/problems/jump-game/description/
 * 
 * @author Rudolf
 *
 */
public class JumpGame_55 {

    public boolean canJump(int[] nums) {
    	
        int reachable = 0;  // Max reachable distance, so far.
        
        for (int i = 0; i < nums.length; ++i) {
            if (i > reachable) return false;
            reachable = Math.max(reachable, nums[i] + i);  // Ensures max reachable distance, so far.
        }
        
        return true;  // Able to reach last number.
    }
}
