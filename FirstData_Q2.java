import java.util.ArrayList;
import java.util.List;

/**
 * Basic Calculator Problem
 * 
 * Q: Given a String of digits and operators (+, -, *, /), evaluate the expression.
 * 
 * Examples:
 * 		1)	"35+7*"		=>	(3+5) * 7 = 56
 * 		2)	"2357+*-"	=>	((5+7)*3)-2 = 34
 * 
 * @author rpham
 *
 */
public class FirstData_Q2 {

	public int getValue(String s) {
		
		List<Integer> digits = new ArrayList<>();
		
		for (char c : s.toCharArray()) {
			if (c >= '0' && c <= '9') {
				digits.add(Integer.valueOf(c));
			} else {	// Operator
				
				int val;
				int d1 = digits.get(digits.size() - 1);
				int d2 = digits.get(digits.size() - 2);
				
				digits.remove(digits.size() - 1);
				digits.remove(digits.size() - 2);
				
				if (c == '+') {
					val = d1 + d2;
				} else if (c == '-') {
					val = d1 - d2;
				} else if (c == '*') {
					val = d1*d2;
				} else {
					val = d1/d2;
				}
				
				digits.add(val);
			}
		}
		
		return digits.get(0);		// Only 1 num left
	}
}
