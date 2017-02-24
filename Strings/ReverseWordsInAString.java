package Strings;

public class ReverseWordsInAString {

	/**
	 * Write a function that reverses the order of words in a string.
	 * 
	 * Example:
	 * 
	 * Given: "Do or do not, there is no try."
	 * Return: "try. no is there not, do or Do"
	 * 
	 * @param str
	 * @return
	 */
	public static String reverse(String str) {
		
		/**
		 * First, split str into an array of words.
		 * Then, create a StringBuilder and append the last word
		 * Next, iterate backwards through the array of words and append space, then the word
		 * Finally, return StringBuilder as string
		 */
		
		String[] words = str.split(" ");
		StringBuilder builder = new StringBuilder();
		
		builder.append(words[words.length - 1]);
		
		for (int i = words.length - 2; i >= 0; --i) {
			builder.append(" ").append(words[i]);
		}
		
		return builder.toString();
	}
	
	public static void main(String[] args) {
		
		String str = "Do or do not, there is no try.";
		
		System.out.println("Answer: " + reverse(str));
	}
}
