package CrackingTheCodingInterview;

public class Q1_5 {

	public static String compressString(String s) {

		// Input Check: empty string
		if (s.length() == 0) return s;

		char[] letters = s.toCharArray();
		StringBuilder builder = new StringBuilder();
		int length = 1;
		
		for (int i = 1; i < letters.length; ++i) {
			
			if (letters[i-1] == letters[i]) {
				
				length++;
				
			} else {
				
				builder.append(letters[i-1]).append(length);
				length = 1;
				
			}
			
		}
		
		builder.append(letters[letters.length - 1]).append(length);	// Last character

		String compressed = builder.toString();

		return compressed.length() > s.length() ? compressed : s;
	}
	
	public static void main(String[] args) {
		
		String s = "aabcccccaaa";
		
//		compressString(s);
		System.out.println(compressString(s));
	}
	
}
