package Search;

public class GuessNumberHigherOrLower_374 extends GuessGame {

	public GuessNumberHigherOrLower_374(int num) {
		super(num);
	}

	/**
     * Range: 1 to n
     * Given: right bound of range
     * 
     * Return: correct number
     * 
     * Initialize:
     *      int left = 1
     *      int right = n
     * 
     * Loop while left <= right
     *      Create int mid = (left + right) >>> 1
     *      If guess(mid) returns 0, return mid
     *      Else if guess(mid) returns -1
     *          Set right = mid - 1
     *      Else    (guess(mid) returns 1)
     *          Set left = mid + 1
     * Return -1 (not found, if that's even possible)
     */
    public int guessNumber(int n) {
        
        int left = 1;
        int right = n;
        
        while (left <= right) {
            
            int mid = (left + right) >>> 1;
            System.out.println("Mid: " + mid);
            
            int myGuess = guess(mid);
            
            if (myGuess == 0) return mid;
            
            if (myGuess == -1) {     // Guess was too high
                right = mid - 1;
            } else {                    // Guess was too low
                left = mid + 1;
            }
        }
        
        return -1;  // Not found
    }
    
    public static void main(String[] args) {
    	GuessNumberHigherOrLower_374 test = new GuessNumberHigherOrLower_374(6);
    	System.out.println(test.guessNumber(10));
    }
}
