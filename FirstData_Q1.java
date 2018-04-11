import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/**
 * Given a very long String,
 * 		1)	Find all unique words in the string (take into account punctuation)
 * 			- Note: Assume case-insensitive
 * 		2)	Count the frequencies of each word
 * 		3)	Retrieve the string with highest frequency
 * 
 * Time: O(n)
 * Space: O(n)
 * 
 * @author rpham
 *
 */
public class FirstData_Q1 {

	public String s;
	
	public FirstData_Q1(String s) {
		this.s = s;
	}
	
	public static void main(String[] args) {
		
		String s = "Today, I went to Mountain View for an interview at First Data."
				+ "The interview was quite tough, and I feel like I should've prepared more."
				+ "The good thing is that I still have many other interviews left to do."
				+ "So many interviews before I start working and making money.";
		
		FirstData_Q1 test = new FirstData_Q1(s);
		
		String[] words = test.getUniqueWords(s);
		HashMap<String, Integer> counts = test.getCounts(words);
		
		System.out.println("Word with highest count: " + test.getWordWithHighestCount(counts));
		System.out.println("List of Words with Highest Count: " + test.getWordsWithHighestCount(s));
	}
	
	/**
	 * http://stackoverflow.com/a/10563234
	 * 
	 * \w represents [a-zA-Z_0-9]
	 * \W represents [^a-zA-Z_0-9]
	 * 
	 * Use double backslash (\\) where the first one is an escape character.
	 * 
	 * @param s
	 * @return
	 */
	public String[] getUniqueWords(String s) {
		return s.split("\\W+");
	}
	
	public HashMap<String, Integer> getCounts(String[] words) {
		
		HashMap<String, Integer> counts = new HashMap<>();
		
		for (String word : words) {
			if (counts.containsKey(word)) {
				counts.put(word, counts.get(word) + 1);
			} else {
				counts.put(word, 1);
			}
		}
		
		return counts;
	}
	
	public String getWordWithHighestCount(HashMap<String, Integer> counts) {
		
		String wordWithMaxCount = "";
		int maxCount = 0;
		
		Iterator<String> iter = counts.keySet().iterator();
		
		while (iter.hasNext()) {
			
			String current = iter.next();
			int count = counts.get(current);
			
			if (count > maxCount) {
				wordWithMaxCount = current;
				maxCount = count;
			}
		}
		
		return wordWithMaxCount;
	}
	
	/**
	 * Time: O(n + k + maxCount) where n is the number of words in s and k is the number of unique words (excluding duplicates).
	 * Space: O(n + k + maxCount)
	 * 
	 * @param s
	 * @return
	 */
	public List<String> getWordsWithHighestCount(String s) {
		if (s == null || s.length() == 0) return new ArrayList<>();
		
		// Split s by whitespaces and punctuation
		String[] words = s.split("\\W+");
		
		// Count the frequency of each word while keeping track of the max count.
		HashMap<String, Integer> map = new HashMap<>();
		int maxCount = 0;
		
		for (String word : words) {
			if (map.containsKey(word)) {
				map.put(word, map.get(word) + 1);
			} else {
				map.put(word, 1);
			}
			
			maxCount = Math.max(maxCount, map.get(word));
		}
		
		// Initialize a List of Lists of Strings where each index represents the frequency of
		// occurrence for each String in the list.
		List<List<String>> countList = new ArrayList<>(maxCount + 1);
		Iterator<String> iter = map.keySet().iterator();  // For iterating through set of keys in map.
		
		// Fill countList.
		for (int i = 0; i <= maxCount; ++i) countList.add(new ArrayList<>());
		
		while (iter.hasNext()) {
			// Add each String into its respective bucket based on its frequency.
			String current = iter.next();
			int index = map.get(current);
			countList.get(index).add(current);
		}
		
		// OPTIONAL: Print all lists of countList.
		for (int i = countList.size() - 1; i >= 0; --i) {
			System.out.print("List of Strings for index " + i + ": ");
			
			List<String> subList = countList.get(i);
			for (String word : subList) {
				System.out.print(word + " ");
			}
			System.out.println("");
		}
		
		return countList.get(maxCount);  // List of Strings with highest frequency.
	}
}
