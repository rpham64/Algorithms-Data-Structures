package Strings;

public class DetectCapital_520 {

	/**
     * Cases:
     *      1) All capitals
     *          - If word equals word.toUpperCase, return true
     *      2) All non-capital
     *          - If word equals word.toLowerCase, return true
     *      3) First letter is capital, rest are lowercase
     *          - Else if first letter is capital
     *              Iterate through index i = 1 to end, checking if isLowerCase
     *                  If not, return false
     *      4) Default (return false)
     */
    public boolean detectCapitalUse(String word) {
        
        // Case 1
        if (word.equals(word.toUpperCase())) return true;
        
        // Case 2
        if (word.equals(word.toLowerCase())) return true;
        
        // Case 3
        if (Character.isUpperCase(word.charAt(0))) {
            for (int i = 1; i < word.length(); ++i) {
                if (!Character.isLowerCase(word.charAt(i))) return false;
            }
            return true;    // No problems with i = 1 to end being lowercase, so return true
        }
        
        // Case 4
        return false;       // Fails first three cases
    }
    
    /**
     * Slightly faster solution
     * 
     * Cases:
     *      1) All capitals
     *          - If word equals word.toUpperCase, return true
     *      2) All non-capital
     *          - If word equals word.toLowerCase, return true
     *      3) First letter is capital, rest are lowercase
     *          - If first letter is capital AND substring from i=1 to end is lowercase, return true
     *      4) Default (return false)
     */
    public boolean detectCapitalUse2(String word) {
        
        // Case 1
        if (word.equals(word.toUpperCase())) return true;
        
        // Case 2
        if (word.equals(word.toLowerCase())) return true;
        
        // Case 3
        if (Character.isUpperCase(word.charAt(0)) && word.substring(1).equals(word.substring(1).toLowerCase())) return true;
        
        // Case 4
        return false;       // Fails first three cases
    }
}
