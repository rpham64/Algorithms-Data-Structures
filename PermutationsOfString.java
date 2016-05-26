
/**
 * Prints out all permutations of a string.
 * 
 * # of permutations = n!
 * 
 * Solution: http://stackoverflow.com/a/4240323
 * 
 * @author Rudolf
 *
 */
public class PermutationsOfString {

	public static void permutation(String str) { 
	    permutation("", str); 
	}

	private static void permutation(String prefix, String str) {
	    int n = str.length();
	    if (n == 0) System.out.println(prefix);
	    else {
	        for (int i = 0; i < n; i++)
	            permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i+1, n));
	    }
	}
	
	public static void main(String[] args) {
		
		permutation("abcd");
		
	}
}
