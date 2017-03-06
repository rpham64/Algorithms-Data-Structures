package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * Write a program that outputs the string representation of numbers from 1 to n.

	But for multiples of three it should output ¡§Fizz¡¨ instead of the number and 
	for the multiples of five output ¡§Buzz¡¨. 
	For numbers which are multiples of both three and five output ¡§FizzBuzz¡¨.
	
	Example:
	
	n = 15,
	
	Return:
	
	[
	    "1",
	    "2",
	    "Fizz",
	    "4",
	    "Buzz",
	    "Fizz",
	    "7",
	    "8",
	    "Fizz",
	    "Buzz",
	    "11",
	    "Fizz",
	    "13",
	    "14",
	    "FizzBuzz"
	]
 * 
 * @author Rudolf
 *
 */
public class FizzBuzz_412 {

    public List<String> fizzBuzz(int n) {
        
        List<String> result = new ArrayList<>();
        
        for (int i = 1; i <= n; ++i) {
            
            String num;
            
            if (i % 3 == 0 && i % 5 == 0) {
                num = "FizzBuzz";
            } else if (i % 3 == 0) {
                num = "Fizz";
            } else if (i % 5 == 0) {
                num = "Buzz";
            } else {
                num = String.valueOf(i);
            }
            
            result.add(num);
        }
        
        return result;
    }
}
