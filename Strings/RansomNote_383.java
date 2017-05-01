package Strings;

/**
 * Given an arbitrary ransom note string and another string containing letters 
 * from all the magazines, write a function that will return true if the ransom note 
 * can be constructed from the magazines ; otherwise, it will return false.
	
	Each letter in the magazine string can only be used once in your ransom note.
	
	Note:
	You may assume that both strings contain only lowercase letters.
	
	canConstruct("a", "b") -> false
	canConstruct("aa", "ab") -> false
	canConstruct("aa", "aab") -> true
 * 
 * @author Rudolf
 *
 */
public class RansomNote_383 {

	/**
     * Idea: Count all characters in magazine via their frequencies. Iterate through randomNote and check if count >= 0.
     *      If all chars in ransomNote are checked, return true (magazine has all chars of ransomNote, so it's possible).
     *      Else, if count of current char <= 0, return false.
     * 
     * Solutions:
     *      1)  Brute Force + Sort: Sort both strings. Then, iterate through ransomNote and use indexOf to track char in magazine.
     *                          Return false if char not found in magazine.
     *          - Time Complexity: O(n log n)
     *          - Space Complexity: O(log n)
     *      2)  Counting Array/HashMap: Count each char in magazine, then iterate through ransomNote and decrement count if it exists.
     *                                  Return true if each char in ransomNote is in counting ds, else return false.
     *          - Time Complexity: O(m + n) where m is length of ransomNote, n is length of magazine
     *          - Space Complexity: O(256) = O(1) assuming ASCII
     */
    public boolean canConstruct(String ransomNote, String magazine) {
        
        int[] count = new int[256];
        
        for (char c : magazine.toCharArray()) count[c]++;
        for (char c : ransomNote.toCharArray()) {
            count[c]--;
            if (count[c] < 0) return false;
        }
        
        return true;
    }
}
