package Strings;

/**
 * An efficient function that deletes characters from an ASCII string.
 * 
 * Running Time: O(n + m)
 * 
 * @author Rudolf
 *
 */
public class RemoveSpecifiedCharacters {

	public static String removeChars(String str, String remove) {
		
		char[] originalString = str.toCharArray();
		char[] charsToRemove = remove.toCharArray();
		int current = 0;
		
		// Create flags array for determining which chars to delete
		boolean[] flags = new boolean[128];		// size of 128 assumes ASCII
		
		// Set flags for characters to be removed
		for (char c : charsToRemove) {
			
			flags[c] = true;	// char has number value in ASCII
			
		}
		
		// Loop through original string, copying over characters
		// that aren't flagged
		for (char c : originalString) {
			
			if (!flags[c]) {
				
				originalString[current++] = c;
				
			}
			
		}
		
		return new String(originalString, 0, current);
	}
	
	public static void main(String[] args) {
		
		String str = "Battle of the Vowels: Hawaii vs. Grozny";
		
		System.out.println("Answer: " + removeChars(str, "aeiou"));
		
	}
}
