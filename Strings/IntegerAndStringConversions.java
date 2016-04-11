package Strings;

public class IntegerAndStringConversions {

	/**
	 * Pseudocode:
	 * 
	 * Start number at 0
	 * if first character is '-'
	 * 		Set negative flag to true
	 * 		Increment character index
	 * for each character in string
	 * 		Multiply number by 10
	 * 		Add digit (digit char - '0') to number
	 * if negative flag is true
	 * 		Negate number
	 * return number 
	 * 
	 * @param str
	 * @return
	 */
	public static int strToInt(String str) {
		
		int number = 0;
		boolean isNeg = false;
		
		for (char digit : str.toCharArray()) {
			
			if (digit == '-') {
				isNeg = true;
				continue;
			}
			
			number *= 10;
			number += digit - '0';
		}
		
		if (isNeg) {
			number = -number;
		}
		
		return number;
	}
	
	/**
	 * Pseudocode:
	 * 
	 * Create empty string
	 * 
	 * 
	 * 
	 * @param num
	 * @return
	 */
	public static String intToStr(int num) {
		
		
		
	}
	
	public static void main(String[] args) {
		
		String str = "1";
		String str2 = "0";
		String str3 = "-1";
		String str4 = "365";
		String str5 = "-12345";
		
		System.out.println(str + " to Int: " + strToInt(str));
		System.out.println(str2 + " to Int: " + strToInt(str2));
		System.out.println(str3 + " to Int: " + strToInt(str3));
		System.out.println(str4 + " to Int: " + strToInt(str4));
		System.out.println(str5 + " to Int: " + strToInt(str5));
		
	}
	
	
	
}
