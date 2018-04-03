
public class StackOverflow_StackUnderflow {

	public static void main(String[] args) {
		System.out.println("Integer min: " + Integer.MIN_VALUE);  // Print MIN value of integer
		System.out.println("Integer max: " + Integer.MAX_VALUE);  // Print MAX value of integer
		
		System.out.println("Integer min - 1: " + (Integer.MIN_VALUE - 1));  // Stack underflows from Integer.MIN to Integer.MAX
		System.out.println("Integer max + 1: " + (Integer.MAX_VALUE + 1));  // Stack overflows from Integer.MAX to Integer.MIN
		
		// Operations with Integer.MIN_VALUE
		System.out.println("Integer.MIN + Integer.MIN: " + (Integer.MIN_VALUE + Integer.MIN_VALUE));  // Underflows to Integer.MAX, then continues dropping to 0.
		System.out.println("Integer.MIN - Integer.MIN: " + (Integer.MIN_VALUE - Integer.MIN_VALUE));  // Both values cancel each other out, resulting in 0.
		
		// Operations with Integer.MAX_VALUE
		System.out.println("Integer.MAX + Integer.MAX: " + (Integer.MAX_VALUE + Integer.MAX_VALUE));  // Overflows to Integer.MIN, then keeps adding to -2. (?)
		System.out.println("Integer.MAX - Integer.MAX: " + (Integer.MAX_VALUE - Integer.MAX_VALUE));  // Both values cancel each other out, resulting in 0.
	}
}
