import java.util.Arrays;

public class MaxProfit {
	
	public static double[] MaxProfit(double[] data) {
		// TODO Auto-generated constructor stub
		double min;
		double[] best = new double[2];	// Best = [low, high]
		
		// Set first element to min. Set best = [min, min] for profit of 0
		min = data[0];
		best[0] = min;
		best[1] = min;
		
		// Iterate from i = 1 to data.length - 1 and update min and best
		for (int i = 1; i < data.length; i++) {
			
			double current = data[i];
//			double prev = data[i-1];
			
			if (current < min) { min = current; }
			
			if (current - min > best[1] - best[0]/* && min != prev*/) {
				best[0] = min;
				best[1] = current;
			}
		}
		
		return best;
	}

	public static void main(String[] args) {
		
		double[] input = {19.35, 19.30, 18.88, 18.93, 18.95, 19.03, 19.00, 18.97, 18.97, 18.98};
		
		System.out.println("Test #1: " + Arrays.toString(input));
		
		double[] inputAnswer = MaxProfit(input);
		System.out.println("Answer to Test #1: " + Arrays.toString(inputAnswer));
		
		double[] challengeInput = {9.20, 8.03, 10.02, 8.08, 8.14, 8.10, 8.31, 8.28, 8.35, 
				8.34, 8.39, 8.45, 8.38, 8.38, 8.32, 8.36, 8.28, 8.28, 8.38, 8.48, 8.49, 
				8.54, 8.73, 8.72, 8.76, 8.74, 8.87, 8.82, 8.81, 8.82, 8.85, 8.85, 8.86, 
				8.63, 8.70, 8.68, 8.72, 8.77, 8.69, 8.65, 8.70, 8.98, 8.98, 8.87, 8.71, 
				9.17, 9.34, 9.28, 8.98, 9.02, 9.16, 9.15, 9.07, 9.14, 9.13, 9.10, 9.16, 
				9.06, 9.10, 9.15, 9.11, 8.72, 8.86, 8.83, 8.70, 8.69, 8.73, 8.73, 8.67, 
				8.70, 8.69, 8.81, 8.82, 8.83, 8.91, 8.80, 8.97, 8.86, 8.81, 8.87, 8.82, 
				8.78, 8.82, 8.77, 8.54, 8.32, 8.33, 8.32, 8.51, 8.53, 8.52, 8.41, 8.55, 
				8.31, 8.38, 8.34, 8.34, 8.19, 8.17, 8.16};
		
		System.out.println("Test #2: " + Arrays.toString(challengeInput));
		
		double[] challengeInputAnswer = MaxProfit(challengeInput);
		System.out.println("Answer to Test #2: " + Arrays.toString(challengeInputAnswer));
		
		double[] input2 = { 5, 2, 10, 3, 10, 5, 5, 1, 17, 4, 100 };
		
		System.out.println("Test #3: " + Arrays.toString(input2));
		
		double[] inputAnswer2 = MaxProfit(input2);
		System.out.println("Answer to Test #3: " + Arrays.toString(inputAnswer2));
	}

}
