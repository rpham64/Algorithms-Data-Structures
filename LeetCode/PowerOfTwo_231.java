package LeetCode;

/**
 * Given an integer, write a function to determine if it is a power of two.
 * 
 * @author Rudolf
 *
 */
public class PowerOfTwo_231 {

	public static boolean isPowerOfTwo(int n) {
        return n > 0 && ((n & n-1) == 0);
    }
	
	public static void main(String[] args) {
		
		/*for (int i = 0; i < 40; i++) {
			System.out.println(i + ": " + isPowerOfTwo(i));
		}*/
		String s = "  a  ";
		
		String[] words = s.split(" ");
		
		System.out.println(words.length);
		
		for (String word : words) {
			System.out.println(word);
		}
		
	}
}
