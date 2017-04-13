package Strings;

import java.util.ArrayList;
import java.util.List;

/**
 * Generates all permutations of a given string.
 * 
 * Explanation (from CTCI): 
 * 
 * We generate all permutations of a string S1...Sn by "chopping off" the last character and
 * generating all permutations of S1...Sn-1 Once we have the list of all permutations of
 * S1...Sn-1, we iterate through this list, and for each string in it, we insert last character into every
 * location of the string.
 * 
 * Example:
 * 		1)	s = "a"
 * 			permutations = {a}
 * 		2)	s = "ab"
 * 			permutations = {ab, ba}
 * 		3)	s = "abc"
 * 			permutations = {cab, acb, abc, cba, bca, bac}
 * 
 * Source: http://stackoverflow.com/a/19624586
 * 
 * @author Rudolf
 *
 */
public class Permutations {

	public static void main(String[] args) {
		Permutations test = new Permutations();
		String s = "abcd";
		List<String> permutationsOfS = test.permutations(s);
		
		for (String str : permutationsOfS) {
			System.out.println(str);
		}
		
		System.out.println("Size of permutations list: " + permutationsOfS.size());
	}
	
	/**
	 * Idea: Take away last char, recursively generate permutations of rest of string.
	 * 		Using last char and permutations of rest, generate strings with char in every position in
	 * 		each permutation of rest. Merge the results and return.
	 * 
	 * Variables:
	 * 		List<String> result		(list of all permutations of s)
	 * 		char lastChar			(last char in s)
	 * 		String rest				(rest of chars in s, minus lastChar)
	 * 
	 * Algorithm:
	 * 		1)	Create List result
	 * 		2)	If length of s is 1, add s to result and return
	 * 		3)	Else, create char lastChar and String rest
	 * 				Call merge helper function and add to List result
	 * 
	 * Helper Functions:
	 * 		1)	merge(List<String> permutationsOfRest, char lastChar)
	 * 
	 * Helper Algorithm:
	 * 		1)	For each string, add lastChar to every position (0 to s.length)
	 * 			and add generated string to List:
	 * 				Loop for String s in permutationsOfRest
	 * 					Loop for int i from 0 to s.length (inclusive)
	 * 						Create StringBuilder and insert lastChar at i
	 * 						Add string to List
	 * 				
	 * 
	 * Cases:
	 * 		1)	Null or empty string (return empty list)
	 * 		2)	Length 1 (add s to list and return)
	 * 		3)	Length 2+ (see algorithm)
	 * 
	 * @param s
	 * @return
	 */
	public List<String> permutations(String s) {
		
		List<String> result = new ArrayList<>();
		
		// Case 1
		if (s == null || s.length() == 0) return result;
		
		// Case 2
		if (s.length() == 1) {
			result.add(s);
			return result;
		}
		
		// Case 3
		int lastIndex = s.length() - 1;
		char lastChar = s.charAt(lastIndex);
		String rest = s.substring(0, lastIndex);
		
		// Perform permutations on rest of string and merge result with last character
		result.addAll(merge(permutations(rest), lastChar));
		
		return result;
	}
	
	private List<String> merge(List<String> permutationsOfRest, char lastChar) {
		
		List<String> merged = new ArrayList<>();
		
		for (String s : permutationsOfRest) {
			
			// For each string, insert lastChar to all possible positions and add them to the merged list
			for (int i = 0; i <= s.length(); ++i) {
				
				String sub = new StringBuilder(s).insert(i, lastChar).toString();
				merged.add(sub);
				
			}
			
		}
		
		return merged;
	}

}
