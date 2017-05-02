import java.util.HashMap;
import java.util.Iterator;

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
	
	public static void main(String[] args) {
		
		String s = "Today, I went to Mountain View for an interview at First Data."
				+ "The interview was quite tough, and I feel like I should've prepared more."
				+ "The good thing is that I still have many other interviews left to do."
				+ "So many interviews before I start working and making money.";
		
		FirstData_Q1 test = new FirstData_Q1(s);
		
		String[] words = test.getUniqueWords(s);
		HashMap<String, Integer> counts = test.getCounts(words);
		
//		System.out.println("Map: " + test.getCounts(words));
		System.out.println("Word with highest count: " + test.getWordWithHighestCount(counts));
	}
}
