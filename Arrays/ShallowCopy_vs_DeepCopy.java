package Arrays;

public class ShallowCopy_vs_DeepCopy {

	public static void main(String[] args) {
		
		int[] values = {-5, 12, 0};
		
		// Shallow Copy (two objects reference the same data)
		int[] shallowCopy = values;
		
		// Deep Copy (two objects contain the same data. They do not reference the same data)
		int[] deepCopy = new int[values.length];
		
		for (int i = 0; i < values.length; ++i) {
			deepCopy[i] = values[i];
		}
	}
}
