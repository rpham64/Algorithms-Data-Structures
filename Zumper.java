import java.util.Arrays;

public class Zumper {

	public static void main(String[] args) {
	    
	    // given 2 sorted arrays
	    Integer[] a = new Integer[] {1,7,9,10};
	    Integer[] b = new Integer[] {2,3,4,10,12};
	    
	    // and an expected result
	    Integer[] expected = new Integer[] {1,2,3,4,7,9,10,10,12};

	    
	    // fill in the merge() implementation such that:

	    // this prints true
	    System.out.println(Arrays.equals(expected, merge(a,b)));
	  }
	  
	  /**
	  *  Initialize:
	  *    int leftIndex = 0
	  *    int rightIndex = 0
	       int resultIndex = 0
	  *    Integer[] result
	  *
	  *  Loop while leftIndex < left.length AND rightIndex < right.length
	        if left Integer is less than right,
	            Add left Integer to result
	            Increment leftIndex AND resultIndex
	        else if left Integer is greater than right,
	            Add right Integer to result
	            Increment rightIndex AND resultIndex
	            
	      if leftIndex < left.length, add rest of Integers from left to result
	      if rightIndex < right.length, add rest of Integers from right to result
	      
	      return result
	  */
	  static Integer[] merge(Integer[] left, Integer[] right) {
	    
	    int leftIndex = 0;
	    int rightIndex = 0;
	    int resultIndex = 0;
	    Integer[] result = new Integer[left.length + right.length];
	    
	    // Null Check: left OR right is empty, return the other non-empty array
	    if (left.length == 0) return right;
	    if (right.length == 0) return left;
	    
	    // Start while loop to compare Integers from left and right
	    while (leftIndex < left.length && rightIndex < right.length) {
	      
	      if (left[leftIndex] <= right[rightIndex]) {
	        result[resultIndex++] = left[leftIndex++];
	      } else {
	        result[resultIndex++] = right[rightIndex++];
	      }
	    }
	    
	    // Add the remaining Integers from whichever array still has Integers
	    while (leftIndex < left.length) {
	      result[resultIndex++] = left[leftIndex++];
	    }
	    while (rightIndex < right.length) {
	      result[resultIndex++] = right[rightIndex++];
	    }
	    
	    return result;
	  }
}
