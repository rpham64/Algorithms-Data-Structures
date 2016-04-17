package LeetCode_Medium;

/**
 * Given an input string, reverse the string word by word.

	For example,
	Given s = "the sky is blue",
	return "blue is sky the".
 * 
 * @author Rudolf
 *
 */
public class ReverseWordsInAString_151 {

	public static String reverseWords(String s) {
        
        String[] words = s.trim().split(" +");	// trim removes leading and trailing spaces
        int length = words.length;
        
        StringBuilder builder = new StringBuilder();
        
        // Append last word to start of stringbuilder
        builder.append(words[length - 1]);
        
        for (int i = length - 2; i >= 0; i--) {
            builder.append(" ").append(words[i]);
        }
        
        return builder.toString();
    }
	
	public static void main(String[] args) {
		
		System.out.println(reverseWords(""));
		System.out.println(reverseWords(" "));
		System.out.println(reverseWords("  "));
		System.out.println(reverseWords("abc d"));
		System.out.println(reverseWords("this is a test"));
	}
	
}
