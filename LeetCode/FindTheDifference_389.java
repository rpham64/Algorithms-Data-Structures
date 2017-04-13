package LeetCode;

public class FindTheDifference_389 {

	/**
     * Assumptions:
     *      1)  Duplicates
     * 
     * Solutions:
     *      1)  Brute Force: Compare every char in s and t. If char in t does not exist in s, return that char. 
     *              - Time Complexity: O(nm)
     *              - Space Complexity: O(1)
     *      2)  Counting array/hashmap: Iterate through both s and t, storing the frequencies of each char into an array/hashmap.
     *                                  Check which entry in the array/hashmap differ and return the corresponding char.
     *              - Time Complexity: O(n + m) where n is length of s, m is length of t
     *              - Space Complexity: O(1) since an array of size 256 is constant and doesn't change with different input sizes
     *      3)  Counting Array 2: Iterate through s, incrementing count in array. Then, iterate through t and decrement each count.
     *                          If count is 0, this means current char is in t but not in s. Return current char as a result.
     *              - Time Complexity: O(n + m)
     *              - Space Complexity: O(1)
     *      4)  Binary Search/String#indexOf: Iterate through t and use binary search or String#indexOf to find the index of current
     *                                      char in s. If index returns -1 (does not exist in s), return current char.
     *              - Time Complexity: O(m + log n)
     *              - Space Complexity: O(1)
     *      5)  Character Sum: Create two sums for s and t. Convert all chars in s and t and add to their respective sums.
     *                      Take the different of sums t and s and convert to char. Return the char difference.
     *              - Time Complexity: O(n + m)
     *              - Space Complexity: O(1)
     * 
     * Variables:
     *      int sumT = 0
     *      int sumS = 0
     * 
     * Algorithm:
     *      Iterate through s, converting each char to int and adding to sumS
     *      Iterate through t, converting each char to int and adding to sumT
     *      Return (char) sumT - sumS
     * 
     */
    public char findTheDifference5(String s, String t) {
        
        // Solution #5
        
        int sumS = 0;
        int sumT = 0;
        
        for (char charS : s.toCharArray()) sumS += (int) charS;
        for (char charT : t.toCharArray()) sumT += (int) charT;
        
        return (char)(sumT - sumS);
    }
}
