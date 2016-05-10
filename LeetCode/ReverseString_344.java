package LeetCode;

public class ReverseString_344 {

	/**
     * s = "hello"
     * 
     * letters = [h, e, l, l, o]
     * i = 2
     * 
     * builder = "olleh"
     */
    public String reverseString(String s) {
        
        // Input Check:
        if (s.length() == 0 || "".equals(s)) return s;
        
        char[] letters = s.toCharArray();
        
        StringBuilder builder = new StringBuilder();
        
        for (int i = letters.length - 1; i >= 0; --i) {
            builder.append(letters[i]);
        }
        
        return builder.toString();
    }
	
}
