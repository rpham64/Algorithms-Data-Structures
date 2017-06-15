package Numbers;

public class FindTheClosestPalindrome_564 {

	public String nearestPalindromic(String n) {
        
        int num = Integer.valueOf(n);
        
        String upperS = n;
        String lowerS = n;
        int upper = Integer.valueOf(upperS);
        int lower = Integer.valueOf(lowerS);
        
        while (!isPalindrome(upperS)) {
            upperS = String.valueOf(++upper);
            System.out.println(upper);
        }
        while (!isPalindrome(lowerS)) {
            lowerS = String.valueOf(--lower);
            System.out.println(lower);
        }
        
        if (!upperS.equals(num) && Math.abs(num - upper) < Math.abs(num - lower)) {
            return upperS;
        } else {
            return lowerS;
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
    
    public static void main(String[] args) {
    	FindTheClosestPalindrome_564 test = new FindTheClosestPalindrome_564();
    	System.out.println(test.nearestPalindromic("1"));
    }
}
