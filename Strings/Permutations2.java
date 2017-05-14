package Strings;

public class Permutations2 {

	public static void main(String[] args) {
		
		Permutations2 test = new Permutations2();
		String word = "abc";
		
		test.getPermutations(word);
	}
	
	public void getPermutations(String word) {
		StringBuilder builder = new StringBuilder();
		getPermutations(builder, word, 0);
	}
	
	public void getPermutations(StringBuilder builder, String word, int start) {
		System.out.println(builder.toString());
		for (int index = start; index < word.length(); ++index) {
			builder.append(word.charAt(index));
			getPermutations(builder, word, index + 1);
			builder.setLength(builder.length() - 1);
		}
	}
}
