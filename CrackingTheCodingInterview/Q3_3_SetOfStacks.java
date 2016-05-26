package CrackingTheCodingInterview;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Q3_3_SetOfStacks {

	public List<Stack> stacks = new ArrayList<Stack>();
	
	/**
	 * Adds integer to last stack in stacks.
	 * If stack is full, creates new stack and adds the integer.
	 * 
	 * @param x
	 */
	public void push(int x) {
		
		Stack<Integer> last = stacks.get(stacks.size() - 1);
		
		if (last != null && !last.isFull) {
			
			last.push(x);
			
		} else {
			
			Stack<Integer> stack = new Stack<>();
			stack.push(x);
			stacks.add(stack);
			
		}
		
	}
	
	public int pop() {
		
		Stack<Integer> last = stacks.get(stacks.size() - 1);
		
		int x = last.pop();
		
		if (last.size() == 0) {
			stacks.remove(stacks.size() - 1);
		}
		
		return x;
	}
}
