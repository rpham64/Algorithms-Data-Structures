import java.util.Arrays;

public class HealthTap_Closest_Palindrome {

	// This is the text editor interface. 
	// Anything you type or change here will be seen by the other person in real time.

	//racecar
	//tacocat 

	//Given a number, find its nearest palindrome
	//ex: 1990 -> 1991
	//ex: 1993 -> 1991
	//ex: 1999 -> 2002

	//ludo@healthtap.com

	public int getNearestPalindrome(int num) {
	    
        if (isPalindrome(String.valueOf(num))) {
            return num;
        } else {        // Not palindrome, so change num
            int upper = num;  // Nearest palin greater
            int lower = num;  // Nearest palin lower
            
            // construct upper and lower
            while (!isPalindrome(String.valueOf(upper))) {
                upper++;
            }
            while (!isPalindrome(String.valueOf(lower))) {
                lower--;
            }
            
            if (Math.abs(num - upper) <= Math.abs(num - lower)) {
                return upper;
            } else {
                return lower;
            }
    }
}

    private boolean isPalindrome(String s) {
    
        int left = 0;
        int right = s.length() - 1;
        
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        
        return true;
    }
    
    public int nearestPalindromic(int num) {
    	
    	int big = findHigherPalindrome(num + 1);		// Lower Bound of big is num + 1
    	int small = findLowerPalindrome(num - 1);		// Upper Bound of small is num - 1
        
        System.out.println("Big: " + big);
        System.out.println("Small: " + small);
        
        return Math.abs(num - small) > Math.abs(big - num) ? big : small;
    }
    
    public int findHigherPalindrome(int limit) {
    	
        String limitS = String.valueOf(limit);
        int length = limitS.length();
        char[] limitChars = limitS.toCharArray(); 							// lower limit (the original input num)
        char[] bigChars = Arrays.copyOf(limitChars, limitS.length()); 		// higher palindrome number (in char array form)
        
        // Mirror front half by changing the back half
        for (int i = 0; i < length / 2; i++) {
            bigChars[length - 1 - i] = bigChars[i];		
        }
        
        for (int i = 0; i < length; i++) {
        	
            if (limitChars[i] < bigChars[i]) {
            	
            	// Found upper palindrome, so convert palChars[] to int and return
            	int higherPalindrome = 0;
            	
            	for (int index = bigChars.length - 1; index >= 0; --index) {
            		higherPalindrome *= 10;
            		higherPalindrome += bigChars[index];
            	}
            	
                return higherPalindrome;
                		
            } else if (limitChars[i] > bigChars[i]) { 		// Limit has higher digit value, so increment digit of bigChars to make it bigger than limit
                for (int j = (length - 1) / 2; j >= 0; j--) {
                    if (++bigChars[j] > '9') {
                    	bigChars[j] = '0';
                    } else {
                        break;
                    }
                }
                // make it palindromic again
                for (int k = 0; k < length / 2; k++) {
                	bigChars[length - 1 - k] = bigChars[k];
                }
                return Long.parseLong(String.valueOf(t)); 
            }
        }
        return Long.parseLong(String.valueOf(t));    
    }
    
    public Long findLowerPalindrome(Long limit) {
        String n = Long.toString(limit);
        char[] s = n.toCharArray();
        int m = s.length;
        char[] t = Arrays.copyOf(s, m);
        for (int i = 0; i < m / 2; i++) {
            t[m - 1 - i] = t[i];
        }
        for (int i = 0; i < m; i++) {
            if (s[i] > t[i]) {
                return Long.parseLong(String.valueOf(t)); 
            } else if (s[i] < t[i]) {
                for (int j = (m - 1) / 2; j >= 0; j--) {
                    if (--t[j] < '0') {
                        t[j] = '9';
                    } else {
                        break;
                    }
                }
                if (t[0] == '0') {
                    char[] a = new char[m - 1];
                    Arrays.fill(a, '9');
                    return Long.parseLong(String.valueOf(a)); 
                }
                // make it palindrome again
                for (int k = 0; k < m / 2; k++) {
                    t[m - 1 - k] = t[k];
                }
                return Long.parseLong(String.valueOf(t)); 
            }
        }
         return Long.parseLong(String.valueOf(t));  
    }
    
    public static void main(String[] args) {
        HealthTap_Closest_Palindrome test = new HealthTap_Closest_Palindrome();
        
        int num1 = 1990;	// 1991
        int num2 = 1993;	// 1991
        int num3 = 1999;	// 2002
        
        String p1 = test.nearestPalindromic(String.valueOf(num1));
        String p2 = test.nearestPalindromic(String.valueOf(num2));
        String p3 = test.nearestPalindromic(String.valueOf(num3));
        
        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p3);
    }
}
