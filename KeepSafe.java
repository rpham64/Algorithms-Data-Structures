
public class KeepSafe {

	interface AddSub {
	  // it adds the first half of the array to start value and substracts the 2nd half.
	  // for odd length arrays, the middle gets added.
	  int addSub(int[] arr, int startVal);
	}

	// Class solution should implement/conform to the interface AddSub.
	// we want to call addSub() from main() with out example values and print the result on console.

	static class Solution implements AddSub {
	  public static void main(String[] args) {
	    int[] arr = new int[]{1,1,2,2}; // -2
	    int startVal = 0;
	    
	    Solution solution = new Solution();
	    System.out.println("Start Value: " + solution.addSub(arr, startVal));
	    
	    String s = "2a2bc4d";
	    System.out.println("Decoded String: " + solution.decoder(s));
	  }
	  
	  public int addSub(int[] arr, int startVal) {
	    // Find middle index.
	    // Add all values from 0 to middle.
	    // Subtract all values from middle + 1 to end.
	    int mid = arr.length / 2;
	    
	    for (int i = 0; i < arr.length; ++i) {
	      int num = arr[i];
	      
	      // Case 1: If index < mid, add to startVal
	      // Case 2: If index > mid, substract from startVal
	      // Case 3: If index == mid, add if odd length, else substract (even length)
	      if (i < mid) {
	        startVal += num;
	      } else if (i > mid) {
	        startVal -= num;
	      } else {
	        // Index == mid
	        if (arr.length % 2 == 1) {
	          // Odd
	          startVal += num;
	        } else {
	          // Even
	          startVal -= num;
	        }
	      }
	    }
	    
	    return startVal;
	  }
	  
	  
	  // run length decoder
	  // 2a2bc4d --> aabcbcdddd
	  // input is guranteed to start with a number and end on a none number
	  // numbers are max one digit in size
	  String decoder(String s) {
	    
	    int count = -1;  // Number of times to repeat string
	    String sub = "";  // Substring in s to append "count" number of times
	    StringBuilder subBuilder = new StringBuilder();
	    
	    StringBuilder result = new StringBuilder();
	    
	    for (char c : s.toCharArray()) {
	      if (Character.isDigit(c) && subBuilder.length() > 0) {
	        sub = buildString(count, subBuilder.toString());
	        result.append(sub);
	        
	        subBuilder = new StringBuilder();
	        count = 0;
	        sub = "";
	      }
	      
	      // Add new count
	      // Add new sub using stringbuilder
	      if (Character.isDigit(c)) {
	        count = c - '0';
	      } else {
	        subBuilder.append(c);
	      }
	    }
	    
	    sub = buildString(count, subBuilder.toString());
	    result.append(sub);
	    
	    return result.toString();
	  }
	                      
	  private String buildString(int count, String sub) {
	    StringBuilder builder = new StringBuilder();
	    
	    for (int i = 0; i < count; ++i) {
	      builder.append(sub);
	    }
	    
	    return builder.toString();
	  }                      
	}
}
