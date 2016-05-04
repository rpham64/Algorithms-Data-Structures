import java.util.Stack;

/**
 * Objective: In a Stack, keep track of maximum value in it. 
 * It might be the top element in the stack but once it is 
 * popped out, the maximum value should be from the 
 * rest of the elements in the stack.
 * 
 * Reference: http://algorithms.tutorialhorizon.com/track-the-maximum-element-in-a-stack/
 * 
 * Companies: Amazon, Yahoo, Fitbit
 * 
 * @author Rudolf
 *
 */
public class TrackMaxElementInStack {

	// Idea: create two stacks and keep track of the maximum in the second stack. 
	// Note that both stacks are always the same size.
	Stack<Integer> main = new Stack<Integer>();
	Stack<Integer> track = new Stack<Integer>();
	
	public void insert(int x) {
		
		if (main.isEmpty()) {
			
			main.add(x);
			track.add(x);
			
		} else {
			
			int max = track.peek();
			
			main.add(x);
			track.add(Math.max(x, max));
		}
		
	}
	
	public int remove() {
		
		if (!main.isEmpty()) {
			track.pop();
			return main.pop();
		}
		
		return 0;
	}
	
	public int getMax() {
		return track.peek();
	}
}
