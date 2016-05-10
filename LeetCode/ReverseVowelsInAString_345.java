package LeetCode;

public class ReverseVowelsInAString_345 {

	/**
     * s = "hello"
     * 
     * vowels = [e, o]
     * i = 0
     * 
     * builder = "holle"
     */
    public String reverseVowels(String s) {
        
        // Input Check: empty string
        if (s.length() == 0 || "".equals(s)) return s;
        
        char[] vowels = new char[s.length()];
        int i = 0;
        
        // Add vowels to char array
        for (char c : s.toCharArray()) {
            if (isVowel(c)) {
                vowels[i++] = c;
            }
        }
        
        // Reverse vowels in s
        StringBuilder builder = new StringBuilder();
        
        for (char c : s.toCharArray()) {
            if (isVowel(c)) {
                builder.append(vowels[--i]);
            }
            else {
                builder.append(c);
            }
        }
        
        return builder.toString();
    }
    
    private boolean isVowel(char c) {
        return "AEIOUaeiou".indexOf(c) != -1;
    }
	
}
