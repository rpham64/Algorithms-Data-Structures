package Strings;

import java.util.HashMap;

/**
 * Given two strings s and t, determine if they are isomorphic.
	
	Two strings are isomorphic if the characters in s can be replaced to get t.
	
	All occurrences of a character must be replaced with another character while 
	preserving the order of characters. No two characters may map to the same character 
	but a character may map to itself.
	
	For example,
	Given "egg", "add", return true.
	
	Given "foo", "bar", return false.
	
	Given "paper", "title", return true.
	
	Note:
	You may assume both s and t have the same length.
 * 
 * @author Rudolf
 *
 */
public class IsomorphicStrings_205 {

	/**
	 * HashMap Solution
	 * 
	 * Time Complexity: O(n + m)
	 * Space Complexity: O(n + m)
	 * 
	 * @param s
	 * @param t
	 * @return
	 */
	public boolean isIsomorphic(String s, String t) {
        
        if (s == null || t == null) return s == t;
        if (s.length() != t.length()) return false;
        
        HashMap<Character, Integer> mapS = new HashMap<>();
        HashMap<Character, Integer> mapT = new HashMap<>();
        
        // Note: int isn't always valid for very long strings due to Java cache mechanism.
        //		When int is added to HashMap, it gets autoboxed to an Integer object.
        //		If the Java cache is full, the int isn't guaranteed to be the correct Integer,
        //		hence the result may not be the same.
        for (Integer i = 0; i < s.length(); ++i) {
            char charS = s.charAt(i);
            char charT = t.charAt(i);
            
            // if (mapS.containsKey(charS) || mapT.containsKey(charT)) {
            //     if (mapS.get(charS) != mapT.get(charT)) return false;
            // }
            
            // mapS.put(charS, i);
            // mapT.put(charT, i);
            
            // Trick: HashMap#put does both put and get (old value)
            if (mapS.put(charS, i) != mapT.put(charT, i)) return false;
        }
        
        return true;
    }
}
