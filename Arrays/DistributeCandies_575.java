package Arrays;

import java.util.HashSet;

/**
 * Given an integer array with even length, where different numbers in this array 
 * represent different kinds of candies. Each number means one candy of the corresponding kind. 
 * You need to distribute these candies equally in number to brother and sister. 
 * Return the maximum number of kinds of candies the sister could gain.
	
	Example 1:
	
	Input: candies = [1,1,2,2,3,3]
	Output: 3
	
	Explanation:
	There are three different kinds of candies (1, 2 and 3), and two candies for each kind.
	Optimal distribution: The sister has candies [1,2,3] and the brother has candies [1,2,3], too. 
	The sister has three different kinds of candies. 
	
	Example 2:
	
	Input: candies = [1,1,2,3]
	Output: 2
	
	Explanation: For example, the sister has candies [2,3] and the brother has candies [1,1]. 
	The sister has two different kinds of candies, the brother has only one kind of candies. 
	
	Note:
	
	The length of the given array is in range [2, 10,000], and will be even.
	The number in given array is in range [-100,000, 100,000].
 * 
 * @author Rudolf
 *
 */
public class DistributeCandies_575 {

	/**
     * 1) [1, 1, 2, 2, 3, 3]    =>  numPairs = 3, size of HashSet = 0    =>  3
     * 2) [1, 1, 2, 3]          =>  numPairs = 1, size of HashSet = 2    =>  2
     * 3) [1, 1, 2, 3, 4, 5]    =>  numPairs = 1, size of HashSet = 4    =>  3
     * 
     */
    public int distributeCandies(int[] candies) {
        
        HashSet<Integer> kinds = new HashSet<>();
        
        for (int candy : candies) kinds.add(candy);
        
        // Since max number of candies/types the sister can get is candies.length / 2,
        // if there are more types of candies than length / 2, sister gets the max (length / 2).
        // Else, she'll get the number of kinds and leave the pairs to the brother.
        return kinds.size() >= candies.length / 2 ? candies.length / 2 : kinds.size();
    }
}
