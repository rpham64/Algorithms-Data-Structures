import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Given an array of strings, group anagrams together.
	
	For example, given: ["eat", "tea", "tan", "ate", "nat", "bat"], 
	
	Return:
	
	[
	  ["ate", "eat","tea"],
	  ["nat","tan"],
	  ["bat"]
	]
	
	Note: All inputs will be in lower-case.
 * 
 * Source: https://leetcode.com/problems/group-anagrams/description/
 * 
 * @author rpham
 * Date: 4/12/18
 *
 */
public class GroupAnagrams_49 {

	/**
	 * Method #1 - HashMap + Sorting String
	 * 
	 * Time: O(n * k log k) where n is the number of Strings in input strs[] and k is the max length of the Strings in strs[].
	 * Space: O(n * k) where n refers to the number of Lists in the output result and k refers to the max length of Strings in each list.
	 * 
	 * @param strs
	 * @return
	 */
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null) return new ArrayList<>();
        
        // Idea: Using a HashMap of String -> List<String> entries, take each String in strs[],
        //      Sort them, then check if the map contains the String as a key.
        //      If true, add to the list in the value.
        //      Else, add a new entry with the String as key and new list as value.
        HashMap<String, List<String>> map = new HashMap<>();  // Sorted String -> List of strings from strs[]
        
        for (String s : strs) {
            char[] letters = s.toCharArray();
            Arrays.sort(letters);
            String sortedS = new String(letters);
            
            // Check if map contains sortedS
            if (!map.containsKey(sortedS)) {
                map.put(sortedS, new ArrayList<>());
            }
            
            // Add s to list.
            map.get(sortedS).add(s);
        }
        
        return new ArrayList<>(map.values());
    }
}
