package CrackingTheCodingInterview;

/**
 * Write a method to replace all spaces in a string with'%20'. You may assume that
the string has sufficient space at the end of the string to hold the additional
characters, and that you are given the "true" length of the string. (Note: if implementing
in Java, please use a character array so that you can perform this operation
in place.)
EXAMPLE
Input: "Mr John Smith
Output: "Mr%20John%20Smith"
 * 
 * @author Rudolf
 *
 */
public class Q1_4 {

	public static String replaceSpaces(String s) {

		// Input Check
		if (s.length() == 0) return s;	// Empty

		String[] words = s.trim().split(" ");

		StringBuilder builder = new StringBuilder(words[0]);

		for (int i = 1; i < words.length; i++) {
			builder.append("%20").append(words[i]);
		}
		
		return builder.toString();
	}
	
	public static void main(String[] args) {
		
		String input = "Mr John Smith    ";
		
		System.out.println("Testing input: " + replaceSpaces(input));
	}
}
