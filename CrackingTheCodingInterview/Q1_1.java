package CrackingTheCodingInterview;

import java.util.HashSet;

/**
 * Implement an algorithm to determine if a string has all unique characters. 
 * What if you cannot use additional data structures?
 * 
 * Ex: "cat" has all unique characters, but "apple" does not.
 * 
 * @author Rudolf
 *
 */
public class Q1_1 {

	/**
	 * Data Structure: HashSet
	 * Time Complexity: O(n)
	 * Space Complexity: O(n)
	 * 
	 * @param s
	 * @return
	 */
	public static boolean isUnique(String s) {
		
		HashSet<Character> chars = new HashSet<>();
		
		for (char c : s.toCharArray()) {
			
			if (chars.contains(c)) {
				return false;
			}
			else {
				chars.add(c);
			}
			
		}
		
		return true;
	}
	
	public static void main(String[] args) {
		
		String test = "hello";
		String test2 = "cat";
		String test3 = "apple";
		
		System.out.println("Test 1: " + isUnique(test));
		System.out.println("Test 2: " + isUnique(test2));
		System.out.println("Test 3: " + isUnique(test3));
	}
}
