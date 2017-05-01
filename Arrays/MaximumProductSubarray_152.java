package Arrays;

public class MaximumProductSubarray_152 {

	/**
     * Solutions:
     *      1)  Brute Force: For all lengths 1 to n, multiply first num by next num and store product, if it exceeds the max.
     *                      For a length of, say 5, set product to first num, multiply by second num and compare, multiply by
     *                      third num and compare, etc.
     *          - Time: O(n^2)
     *          - Space: O(1)
     *      2)  
     *  
     * Variables:
     *      int maxProduct = 0
     * 
     * Algorithm:
     *      Loop for int i = 0 to n-1
     *          Create int product = 1
     *          Loop for int j = i to n-1
     *              product *= nums[j]
     *              If product > maxProduct
     *                  maxProduct = product
     *      Return maxProduct
     *              
     * 
     * Cases:
     *      1)  nums is null or empty (return 0)
     *      2)  Length 1+ (see algorithm)
     * 
     */
    public int maxProduct1(int[] nums) {
        
        if (nums == null) return 0;
        
        long maxProduct = Long.MIN_VALUE;
        
        for (int i = 0; i < nums.length; ++i) {
            int product = 1;
            for (int j = i; j < nums.length; ++j) {
                product *= nums[j];
                
                maxProduct = Math.max(maxProduct, product);
            }
        }
        
        return (int) maxProduct;
    }
}
