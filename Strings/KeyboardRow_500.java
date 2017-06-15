package Strings;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a List of words, return the words that can be typed using letters of alphabet on 
 * only one row's of American keyboard like the image below.
 * 
 * Example 1:
 * 
	Input: ["Hello", "Alaska", "Dad", "Peace"]
	Output: ["Alaska", "Dad"]
	
	Note:
	
	You may use one character in the keyboard more than once.
	You may assume the input string will only contain letters of alphabet.
 * 
 * @author Rudolf
 *
 */
public class KeyboardRow_500 {

	public String[] findWords(String[] words) {
        List<String> result = new ArrayList<>();
        for (String word : words) {
            if (word.toLowerCase().matches("[qwertyuiop]*|[asdfghjkl]*|[zxcvbnm]*")) result.add(word);
        }
        return result.toArray(new String[0]);
    }
}
