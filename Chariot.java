import java.io.*;
import java.util.*;

public class Chariot {

	/*
	 Invert words in a given string
	*/

	class Solution {
	  public static void main(String[] args) {
	      String input = "abc defgh  ijklmnop ";
	      String output = "cba hgfed  ponmlkji ";
	      System.out.println(Boolean.toString(revertWordsIn(input).equals(output)));
	  }
	 
	  public static String revertWordsIn(String input) {
	      List<String> words = new ArrayList<>();
	      List<String> spaces = new ArrayList<>();
	    
	      int left = 0;
	      int right = 0;
	    
	      while (right < input.length()) {
	        
	        if (input.charAt(left) != ' ') {
	          
	          // Increment right until right is at a whitespace.
	          while (right < input.length() && input.charAt(right) != ' ') right++;
	          
	          String sub = input.substring(left, right);
	          words.add(sub);
	        } else {
	          // Left char is a whitespace
	          
	          // Increment right until we find non-whitespace.
	          while (right < input.length() && input.charAt(right) == ' ') right++;
	          
	          String spacesString = input.substring(left, right);
	          spaces.add(spacesString);
	        }
	        
	        left = right;
	      }
	    
	      StringBuilder output = new StringBuilder();
	      
	      output.append(reverse(words.get(0)));  // Adds reversed first word.
	    
	      int wordsIndex = 1;
	      int spacesIndex = 0;
	    
	      while (wordsIndex < words.size() || spacesIndex < spaces.size()) {
	        String reversedWord = reverse(words.get(wordsIndex));
	        output.append(spaces.get(spacesIndex)).append(reversedWord);
	        
	        wordsIndex++;
	        spacesIndex++;
	      }
	    
	      return output.toString();
	  }
	  
	  private static String reverse(String s) {
	    return new StringBuilder(s).reverse().toString();
	  }
	}




	/*
	  public static String revertWordsIn(String input) {
	      String[] words = input.split(" ");
	      StringBuilder output = new StringBuilder();
	      
	      output.append(reverse(words[0]));  // Adds reversed first word.
	    
	      for (int i = 1; i < words.length; ++i) {
	        String reversedWord = reverse(words[i]);
	        output.append(" ").append(reversedWord);
	      }
	    
	      return output.toString();
	  }
	  
	  private static String reverse(String s) {
	    return new StringBuilder(s).reverse().toString();
	  }
	*/
}
