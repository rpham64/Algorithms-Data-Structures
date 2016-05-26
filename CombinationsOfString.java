
public class CombinationsOfString {

	private StringBuilder out = new StringBuilder();
	private final String in;
	
	public CombinationsOfString(final String str) {
		in = str;
	}
	
	public void combine() {
		combine(0);
	}
	
	private void combine(int start) {
		
		for (int i = start; i < in.length(); ++i) {
			
			out.append(in.charAt(i));
			
			System.out.println(out);
			
			if (i < in.length()) {
				combine(i+1);
			}
			
			out.setLength(out.length() - 1); 
		}
		
	}
	
	public static void main(String[] args) {
		
		CombinationsOfString combinations = new CombinationsOfString("wxyz");
		
		combinations.combine();
	}
}
