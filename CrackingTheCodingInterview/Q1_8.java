package CrackingTheCodingInterview;

public class Q1_8 {

	public boolean isSubstring(String s1, String s2) {
		
		if (s1 == null || s2 == null && (s1 != s2) || s1.length() != s2.length()) return false;
		
		// Find middle index
		int mid = 0;
		
		for (int i = 0; i < s2.length(); ++i) {
			if (s1.contains(s2.substring(0, i+1))) {
				mid = i;
			} else {
				break;
			}
		}
		
		if (mid == s2.length() - 1) return true;		// Same string
		
		char[] chars = s2.toCharArray();
		
		reverse(chars, 0, mid);
		reverse(chars, mid+1, s2.length() - 1);
		reverse(chars, 0, s2.length() - 1);
		
		s2 = new String(chars);
		return s1.equals(s2);
	}
	
	private void reverse(char[] chars, int left, int right) {
		while (left < right) {
			char temp = chars[left];
			chars[left] = chars[right];
			chars[right] = temp;
			left++;
			right--;
		}
	}
	
	public static void main(String[] args) {
		
		Q1_8 test = new Q1_8();
		
		String s1 = "waterbottle";
		String s2 = "erbottlewat";
		
		System.out.println(test.isSubstring(s1, s2));
	}
}
