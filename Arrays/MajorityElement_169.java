package Arrays;

/**
 * Given an array of size n, find the majority element. 
 * The majority element is the element that appears more than floor(n/2) times.

	You may assume that the array is non-empty and the majority element always exist in the array.
 * 
 * @author Rudolf
 *
 */
public class MajorityElement_169 {

	/**
     * Variables:
     *      int major = num[0]      (default)
     *      int count = 1           (number of occurrences of major)
     * 
     * Algorithm:
     *      1)  Iterate from index i = 1 to end
     *      2)  If count is 0, increment count and set major to current num
     *          Else, if current num equals major, increment count
     *          Else, decrement count
     *      3)  Return major
     * 
     */
    public int majorityElement(int[] nums) {
        
        int major = nums[0];
        int count = 1;
        
        for (int i = 1; i < nums.length; ++i) {
            
            if (count == 0) {
                count++;
                major = nums[i];
            } else if (nums[i] == major) {
                count++;
            } else {
                count--;
            }
            
        }
        
        return major;
    }
}
