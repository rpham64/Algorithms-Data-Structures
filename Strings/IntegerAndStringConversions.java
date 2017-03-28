package Strings;

/**
 * Formula: digit (int) = char - '0'
 * 			char = digit + '0'
 * 
 * @author Rudolf
 *
 */
public class IntegerAndStringConversions {
	
	public static final int MAX_DIGITS = 10;

	/**
	 * Pseudocode:
	 * 
	 * Start counter at 0
	 * if first character is '-'
	 * 		Set negative flag to true
	 * 		Increment counter
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
		int index = 0;
		boolean isNeg = false;
		
		if (str.charAt(index) == '-') {
			isNeg = true;
			index++;
		}
		
		while (index < str.length()) {
			
			char c = str.charAt(index);
			
			number *= 10;
			number += c - '0';
			
			index++;
		}
		
		if (isNeg) {
			number *= -1;
		}
		
		return number;
	}
	
	/**
	 * Pseudocode:
	 * 
	 * If number is less than zero
	 * 		Set number to positive
	 * 		Set boolean isNeg to true
	 * Create temp char[] buffer
	 * While number is not 0
	 * 		Add '0' to num % 10 and write to buffer
	 * 		Divide num by 10
	 * Create stringbuilder
	 * 		Append '-' to builder, if isNeg is true
	 * 		Append chars from end to start in buffer	
	 * Return builder as string
	 * 
	 * @param num
	 * @return
	 */
	public static String intToStr(int num) {
		
		int i = 0;
		boolean isNeg = false;
		char[] digits = new char[MAX_DIGITS + 1];
		
		// Input Check: negative number
		if (num < 0) {
			num *= -1;		// Change to positive in case of errors using modulo
			isNeg = true;
		}
		
		do {
			digits[i++] = (char) (num % 10 + '0');
			num /= 10;
		} while (num != 0);
		
		StringBuilder builder = new StringBuilder();
		
		if (isNeg) {
			builder.append('-');
		}
		
		while (i > 0) {
			builder.append(digits[--i]);
		}
		
		return builder.toString();
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
		
		int num1 = 1;
		int num2 = 0;
		int num3 = -1;
		int num4 = 365;
		int num5 = -12345;
		
		System.out.println(num1 + " to String: " + intToStr(num1));
		System.out.println(num2 + " to String: " + intToStr(num2));
		System.out.println(num3 + " to String: " + intToStr(num3));
		System.out.println(num4 + " to String: " + intToStr(num4));
		System.out.println(num5 + " to String: " + intToStr(num5));
		
	}
	
	
	
}
