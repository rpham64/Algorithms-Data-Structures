package Strings;

import java.util.HashMap;

/**
 * Finds first nonrepeated character in a String
 * 
 * Running Time: O(n)
 * 
 * @author Rudolf
 *
 */
public class FindFirstNonrepeatedChar {

	public static Character findFirstNonrepeatedChar(String s) {
		
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		
		for (char c : s.toCharArray()) {
			
			if (map.containsKey(c)) {
				
				int frequency = map.get(c);
				
				map.put(c, frequency + 1);
				
			}
			
			else {
				
				map.put(c, 1);
				
			}
		}
		
		System.out.println(map.toString());
		
		for (char c : s.toCharArray()) {
			if (map.get(c) == 1) return c;
		}
		
		return null;
	}
	
	public static void main(String[] args) {
		
		System.out.println("total: " + findFirstNonrepeatedChar("total"));
		System.out.println("teeter: " + findFirstNonrepeatedChar("teeter"));
		
	}
	
}
