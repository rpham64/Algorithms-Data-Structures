package CrackingTheCodingInterview;

public class Q1_8_TRICKY {

	/**
	 * Idea: Given Strings s1 and s2, we want to determine if s2 is a rotation of s1.
	 * 		Normally, we'd have to find the "rotation point" in s1.
	 * 
	 * 		s1 = xy = waterbottle
	 * 		x = wat
	 * 		y = erbottle
	 * 		s2 = yx = erbottlewat
	 * 
	 * 		=>	xyxy contains yx
	 * 		=>	s1s1 contains s2
	 * 
	 * @param s1
	 * @param s2
	 * @return
	 */
	public boolean isRotation(String s1, String s2) {
		
		if (s1.length() != s2.length()) return false;
		
		return isSubstring(s1 + s1, s2);
	}
	
	private boolean isSubstring(String s1, String s2) {
		return s1.contains(s2);
	}
}
