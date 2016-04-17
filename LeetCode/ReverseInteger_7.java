package LeetCode;

public class ReverseInteger_7 {

	public static int reverse(int x) {
        
		long reversed = 0;  // long in case of stack overflow
        
        // Build reversed long
        while (x != 0) {
            int lastDigit = x % 10;
            reversed *= 10;
            reversed += lastDigit;
            x /= 10;
        }
        
        // Overflow Check: if reversed is out of integer bounds, return 0
        if (reversed > Integer.MAX_VALUE || reversed < Integer.MIN_VALUE) return 0;
        
        return (int) reversed;
    }
	
	public static void main(String[] args) {
		
		int test1 = 0;
		int test2 = 123;
		int test3 = -123;
		
		System.out.println("Test 1: " + test1);
		System.out.println("Reversed: " + reverse(test1));
		
		System.out.println("Test 2: " + test2);
		System.out.println("Reversed: " + reverse(test2));
		
		System.out.println("Test 3: " + test3);
		System.out.println("Reversed: " + reverse(test3));
	}
	
}
