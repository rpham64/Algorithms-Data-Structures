import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Amazon {
	
	public static void main(String[] args) {
		Amazon test = new Amazon();
		List<String> words = new ArrayList<>(Arrays.asList("racecar", "tacocat", "hello", "a", "b", "c"));
		
		for (String word : words) {
			System.out.println(word + ": " + test.isPalindrome(word));
		}
		
		List<String> words2 = new ArrayList<>(Arrays.asList("racecars", "racecar", "tacocat", "tacoocat", "hello", "a", "b", "c"));
		System.out.println("Longest palindrome: " + test.getLargestPalindrome(words2));
	tacocat
	hello
	a
	b
	c*/

	/**
	 * Cases:
	 *      1) Empty string or length is 0  (false)
	 *      2) 1 letter (true)
	 *      3) 2+ letters 
	 */
	boolean isPalindrome(String word) {
	    
	    // Case 1
	    if (word == null || "".equals(word) || word.length() == 0) return false;
	    
	    // Case 2
	    if (word.length() == 1) return true;
	    
	    // Case 3
	    int left = 0;
	    int right = word.length() - 1;
	    
	    while (left <= right) {
	        
	        // Check: if left and right are the same characters
	        // If yes, increment left and decrement right
	        // If no, return false
	        if (word.charAt(left) == word.charAt(right)) {
	            left++;
	            right--;
	        } else {
	            return false;       // Not a palindrome
	        }
	    }
	    
	    return true;    // Is a palindrome
	}

/*	racecars
	racecar
	tacocat
	tacoocat <---
	hello
	a
	b
	c*/


	/**
	 * Cases:
	 *      1) List is empty OR null
	 *      2) Non-empty list (iterate through and check)
	 *          - If no palindrome, return null
	 *          - If palindrome, add to a list of palindromes
	 *              - iterate through list of palindromes and return longest palindrome
	 */
	String getLargestPalindrome(List<String> list) {
	    
	    // Case 1
	    if (list == null || list.size() == 0) return null;
	    
	    // Case 2
	    List<String> palindromes = new ArrayList<>();
	    
	    for (int i = 0; i < list.size(); ++i) {
	        
	        // If yes, add to palindromes
	        // If no, continue
	        String current = list.get(i);
	        
	        if (isPalindrome(current)) {
	            palindromes.add(current);
	        } else {
	            continue;
	        }
	    }
	    
	    // Check: palindromes is empty => return null (no palindromes)
	    if (palindromes.size() == 0) return null;
	    
	    // Palindromes list is non-empty, iterate through and return the longest palindrome
	    String longestPalindrome = "";
	    
	    for (int i = 0; i < palindromes.size(); ++i) {
	        
	        // Compare longestPalindrome and current string lengths
	        // If longer, store current as longestPalindrome
	        // Else, continue
	        String current = palindromes.get(i);
	        
	        if (current.length() > longestPalindrome.length()) {
	            longestPalindrome = current;
	        }
	    }
	    
	    return longestPalindrome;
	}

	String getLargestPalindrome2(List<String> list) {
		
		// Case 1
		if (list == null || list.size() == 0) return null;
		
		// Case 2
		String longestPalindrome = "";
		for (String string : list) {
			if (isPalindrome(string) && string.length() > longestPalindrome.length()) {
				 longestPalindrome = string;
			}
		}
		
		return longestPalindrome;
	}

}
