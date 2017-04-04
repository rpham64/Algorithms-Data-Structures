package Search;

/**
 * Implement int sqrt(int x).

	Compute and return the square root of x.
 * 
 * @author Rudolf
 *
 */
public class Sqrt_of_x_69 {

	/**
     * Cases:
     *      1) x == 0 (return 0, else / by zero exception occurs in line 18)
     *      2) x > 0
     */
    public int mySqrt(int x) {
        
        // Case 1
        if (x == 0) return 0;
        
        // Case 2
        int left = 1;
        int right = x;
        int result = 0;
        
        while (left <= right) {
            
            int mid = left + (right - left) / 2;
            
            if (mid <= x/mid) {     // mid*mid <= x. Writing this way prevents int overflow
                left = mid + 1;
                
                // Since sqrt(x) results in either perfect or imperfect squares, mid*mid may never reach x.
                // Hence, we return mid if mid*mid is very, very close to (or equals) x.
                result = mid;
            } else {    // mid*mid > x
                right = mid - 1;
            }
        }
        
        return result;
    }
}
