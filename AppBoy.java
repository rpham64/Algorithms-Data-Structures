import java.util.Random;

public class AppBoy {
	
	static class Tuple {
		String color;
		int weight;
		
		public Tuple(String color, int weight) {
			this.color = color;
			this.weight = weight;
		}
	}
	
	public static void main(String[] args) {
		
		AppBoy test = new AppBoy();
		
		Tuple[] colors = new Tuple[3];
		colors[0] = new Tuple("red", 10);
		colors[1] = new Tuple("green", 20);
		colors[2] = new Tuple("blue", 30);
		
		System.out.println("Color: " + test.getRandomColor(colors).color);
	}

	// Write a function that takes an array of Tuples of the form ((string) color, (int) weight), and returns a single random color
	// in proportion to it's weight.  So if the function was given [(red, 10), (green, 20), (blue, 30)], it would return red 1/6 
	// of the time, green 1/3, and blue 1/2.

	// Input: array of Tuples where each Tuple has an string color and int weight
	// Output: Tuple 

	// Variables:
//	    Random random 
//	    int randNumber = random.nextInt(59)
//	    int weightSum = 0
//	    Tuple[] randomColors         (size = weightSum)

	// Algorithm:
//	    Initialize variables
//	    Loop for Tuple in array of Tuples
//	        weightSum += Tuple.weight
//	    Create randomColors[] with size = weightSum
//	    Iterate through array of Tuples
//	        For index 1 to weight, add to randomColors[]
//	    Return randomColors[randNumber]

	public Tuple getRandomColor(Tuple[] colors) {

	    int weightSum = 0;

	    // Calculate weightSum
	    for (Tuple color : colors) {
	        weightSum += color.weight;
	    }
	    
	    Random random = new Random();
	    int randNumber = random.nextInt(weightSum - 1);
	    
	    // Create randomColors[]
	    Tuple[] randomColors = new Tuple[weightSum];        // 0 to 59 with size 60
	    int index = 0;
	    
	    // Add colors to randomColors[]
	    for (Tuple color : colors) {
	        for (int i = 1; i <= color.weight; ++i) {
	            randomColors[index++] = color;
	        }
	    }
	    
	    return randomColors[randNumber];
	}
}
