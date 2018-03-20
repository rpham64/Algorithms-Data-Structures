

/**
 * The count-and-say sequence is the sequence of integers beginning as follows:
 * 
	1, 11, 21, 1211, 111221, ...
	
	1 is read off as "one 1" or 11.
	11 is read off as "two 1s" or 21.
	21 is read off as "one 2, then one 1" or 1211.
	Given an integer n, generate the nth sequence.
	
	Note: The sequence of integers will be represented as a string.
 * 
 * @author Rudolf
 *
 */
public class CountAndSay_38 {

	/**
     * Initialize:
     *      String result = "1"
     * 
     * Loop for int i = 1 to n
     *      Set StringBuilder, counter to 0, say to first char in result
     *      Loop for char in result
     *          If char equals say, increment count
     *          Else a mismatch occured:
     *              Append counter, then say to builder
     *              Set say to current char
     *              Set counter to 1 (counting current char)
     *      In case of last char, append counter and say to builder
     *      Set result to builder.toString
     * Return result
     * 
     * 0    =>      "1"
     * 1    =>      "11"
     * 2    =>      "21"
     * 3    =>      "1211"
     * 
     * n = 3
     * i = 2
     * 
     * result = "11"
     * say = 1
     * builder = ""
     * counter = 1
     */
    public String countAndSay(int n) {
        
        String result = "1";
        
        for (int i = 1; i < n; ++i) {
            
            StringBuilder builder = new StringBuilder();
            int counter = 0;
            char say = result.charAt(0);
            
            for (char c : result.toCharArray()) {
                
                if (say == c) counter++;
                
                else {      // Mismatch
                    builder.append(counter).append(say);
                    counter = 1;
                    say = c;
                }
            }
            
            // In case of last char, append current counter and say
            builder.append(counter).append(say);
            
            result = builder.toString();
        }
        
        return result;
    }
    
    /**
     *   Algorithm
     *       Set string := "1"
     *       Set counter := 1
     *       While counter < n
     *           Print string
     *           Increment counter
     *       Return string
     *
     *   print String Algorithm (Input: String, Output: new String)
     *       Create new StringBuilder
     *       Set count := 1
     *       Set say := char(0)
     *
     *       For index i from 1 upto string.length - 1
     *           If say does not equal current char
     *               Append count and say to stringbuilder
     *               Set count := 1
     *               Set say := current char
     *           Else
     *               Increment count
     *       Append count and say to stringbuilder
     *       Return string
     */
     public String countAndSay2(int n) {
         String result = "1";
         int counter = 1;
         
         while (counter < n) {
             result = getNewResult(result);
             counter++;
         }
         
         return result;
     }
     
     private String getNewResult(String result) {
         if (result == null || result.length() == 0) return "";
         
         StringBuilder builder = new StringBuilder();
         int count = 1;
         char say = result.charAt(0);
         
         for (int i = 1; i < result.length(); ++i) {
             if (say != result.charAt(i)) {
                 builder.append(count).append(say);
                 count = 1;
                 say = result.charAt(i);
             } else {
                 count++;
             }
         }
         
         builder.append(count).append(say);
         return builder.toString();
     }
}
