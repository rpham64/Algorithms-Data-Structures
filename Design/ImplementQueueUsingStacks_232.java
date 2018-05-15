package Design;

import java.util.Stack;

public class ImplementQueueUsingStacks_232 {

	private Stack<Integer> s1;
    private Stack<Integer> s2;

    /** Initialize your data structure here. */
    public ImplementQueueUsingStacks_232() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }
    
    /** Push element x to the back of queue. */
    // Time: O(1)
    public void push(int x) {
        s1.push(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    // Time: O(n) if s2 is empty. Else, O(1).
    public int pop() {
        if (s2.isEmpty()) {
            transfer();
        }
        return s2.pop();
    }

    /** Get the front element. */
    // Time: O(n) if s2 is empty. Else, O(1).
    public int peek() {
        if (s2.isEmpty()) {
            transfer();
        }
        return s2.peek();
    }
    
    /** Returns whether the queue is empty. */
    // Time: O(1)
    public boolean empty() {
        return s1.isEmpty() && s2.isEmpty();
    }
    
	private void transfer() {
		while (!s1.isEmpty()) {
		    s2.push(s1.pop());
		}
	}
}
