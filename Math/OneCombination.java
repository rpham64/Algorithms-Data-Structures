package Math;

import java.util.ArrayList;
import java.util.List;

public class OneCombination {

	/**
	 * Generate a list of length 4 where the contents add up to x. Duplicates are allowed.
	 * Do not generate all combinations (very inefficient).
	 * 
	 * Example:
	 * 		x = 8
	 * 		prices = [1, 3, 5, 8, 10, 12]
	 * 		result = [1, 1, 3, 3]
	 * 
	 * @param x
	 * @return
	 */
	public boolean canSum(List<Integer> prices, int x) {
		List<Integer> result = helper(prices, x, new ArrayList<>());
		return result != null;
	}
	
	private List<Integer> helper(List<Integer> prices, int x, List<Integer> tempList) {
		
		if (tempList.size() == 4 && x == 0) {
			return tempList;
		} else if (tempList.size() < 4) {
			
			for (int i = 0; i < prices.size(); ++i) {
				
				tempList.add(prices.get(i));
				if (helper(prices, x - prices.get(i), tempList) != null) {
					return helper(prices, x - prices.get(i), tempList);
				}
				tempList.remove(tempList.size() - 1);
				
			}
			
		}
		
		return null;
	}
	
	public static void main(String[] args) {
		
		OneCombination test = new OneCombination();
		List<Integer> prices = new ArrayList<>();
		prices.add(1);
		prices.add(3);
		prices.add(5);
		prices.add(8);
		prices.add(10);
		prices.add(12);
		prices.add(14);
		
		System.out.println(test.canSum(prices, 8));
	}
}
