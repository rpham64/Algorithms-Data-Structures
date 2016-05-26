package CrackingTheCodingInterview;

import java.util.Stack;

public class Q3_2_StackWithMin {

	private Stack<Integer> main = new Stack<>();
	private Stack<Integer> track = new Stack<>();
	
	public void push(ListNode node) {
		
		if (main.isEmpty()) {
			main.add(node.val);
			track.add(node.val);
		} else {
			
			int min = track.peek();
			
			main.add(node.val);
			track.add(Math.min(node.val, min));
		}
		
	}
	
	public Integer pop() {
		
		if (!main.isEmpty()) {
			track.pop();
			return main.pop();
		}
		
		return -1;
	}
	
	public Integer getMin() {
		return track.peek();
	}
}
