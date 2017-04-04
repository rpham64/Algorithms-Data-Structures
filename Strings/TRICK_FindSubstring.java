package Strings;

/**
 * A template that can solve most "find substring satisfying some restriction from a larger string".
 * 
 * Source: https://discuss.leetcode.com/topic/30941/here-is-a-10-line-template-that-can-solve-most-substring-problems
 * 
 * @author Rudolf
 *
 */
public class TRICK_FindSubstring {

	/**
	 * Idea: Use either a counting HashMap or Array and two pointers: start, end
	 * 
	 * @param s
	 * @param t
	 * @return shortest substring satisfying some condition
	 */
	public String minWindow(String s, String t) {
		
		int[] count = new int[128];				// Assume standard ASCII (0-127)
		int start = 0;							// Left bound
		int end = 0;							// Right bound
		int minStart = 0;						// Guaranteed left bound
		int minLength = Integer.MAX_VALUE;		// Minimum length of substring
		int counter = t.length();				// Number of valid characters in window (s.length > t.length)
		
		// Step 1: Fill count array using String t
		for (char c : t.toCharArray()) count[c]++;
		
		// Step 2: Iterate through s and find the appropriate window for a valid substring
		//			Extend end first, then start.
		while (end < s.length()) {
			
			char charEnd = s.charAt(end);
			
			// Found valid char that exists in both s and t, so decrement its count
			if (count[charEnd] > 0) counter--;
			
			// Default: Valid chars always remain at 0 or above, while non-valid go negative
			count[charEnd]--;
			end++;
			
			// This occurs if we run into enough valid characters in our window 
			while (counter == 0) {
				
				// Checks if we found a smaller valid window
				// Only changes minStart and minLength if length is less
				if (end - start < minLength) {
					minStart = start;
					minLength = end - start;
				}
				
				char charStart = s.charAt(start);
				
				count[charStart]++;
				
				// If char exists in t, increase counter.
				// If invalid char, this keeps counter at 0 to tighten the window.
				if (count[charStart] > 0) counter++;
				
				start++;
			}
		}
		
		if (minLength == Integer.MAX_VALUE) return "";
		
		return s.substring(minStart, minStart + minLength);
	}
	
	/**
	 * Template for finding a substring
	 */
	
//	int findSubstring(string s){
//        vector<int> map(128,0);
//        int counter; // check whether the substring is valid
//        int begin=0, end=0; //two pointers, one point to tail and one  head
//        int d; //the length of substring
//
//        for() { /* initialize the hash map here */ }
//
//        while(end<s.size()){
//
//            if(map[s[end++]]-- ?){  /* modify counter here */ }
//
//            while(/* counter condition */){ 
//                 
//                 /* update d here if finding minimum*/
//
//                //increase begin to make it invalid/valid again
//                
//                if(map[s[begin++]]++ ?){ /*modify counter here*/ }
//            }  
//
//            /* update d here if finding maximum*/
//        }
//        return d;
//	}
}
