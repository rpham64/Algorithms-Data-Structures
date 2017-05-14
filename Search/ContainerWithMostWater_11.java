package Search;

/**
 * Given n non-negative integers a1, a2, ..., an, where each represents a point 
 * at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of 
 * line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis 
 * forms a container, such that the container contains the most water.

	Note: You may not slant the container and n is at least 2.
 * 
 * @author Rudolf
 *
 */
public class ContainerWithMostWater_11 {

	/**
	 * Idea: Calculate area at the two endpoints and adjust whichever endpoint has the lower height.
	 * 		By doing so, you'd be eliminating the lower heights in anticipation of the higher ones.
	 * 		Reason is that the area's height will always be the lower height, so keeping the lower height
	 * 		will actually LOWER the area of the container since we'd have to move the higher height's pointer.
	 * 
	 * Time Complexity: O(n)
	 * Space Complexity: O(1)
	 * 
	 * @param height
	 * @return
	 */
	public int maxArea(int[] height) {
        
        int maxArea = 0;
        int left = 0;
        int right = height.length - 1;
        
        while (left < right) {
            
            int currentHeight = Math.min(height[left], height[right]);
            maxArea = Math.max(maxArea, currentHeight * (right - left));
            
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        
        return maxArea;
    }
}
