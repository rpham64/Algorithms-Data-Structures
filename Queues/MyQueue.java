package Queues;

import java.util.Stack;

/**
 * Implement the following operations of a queue using stacks.
	
	push(x) -- Push element x to the back of queue.
	pop() -- Removes the element from in front of queue.
	peek() -- Get the front element.
	empty() -- Return whether the queue is empty.
	
	Notes:
	
	You must use only standard operations of a stack -- 
	which means only push to top, peek/pop from top, size, and is empty operations are valid.
	Depending on your language, stack may not be supported natively. 
	You may simulate a stack by using a list or deque (double-ended queue), as long as you 
	use only standard operations of a stack.
	You may assume that all operations are valid (for example, no pop or peek operations will be called on an empty queue).
 * 
 * @author Rudolf
 *
 */
public class MyQueue {
    
    /**
     * Variables:
     *      Stack<Integer> input        (handles push operations)
     *      Stack<Integer> output       (handles peek/pop operations)
     * 
     * Methods:
     *      push: Simply push to input, so that first ones are at bottom of stack
     *      pop: Check if output is empty. Pop every object from input and add to output (reverses order of input). Pop from output.
     *      peek: Same as pop, but using peek operation
     *      empty: Return input.empty() and output.empty()
     *      
     * Time Complexities: O(1) amortized for all operations, including peek() and pop()
     * 		- Reason: For loop only occurs when output is empty. It only re-occurs when we popped every object
     * 				from the output stack, so the time is not O(n).
     * Space Complexity: O(n + m) where n is size of input, m is size of output
     */
     
    Stack<Integer> input;
    Stack<Integer> output;

    /** Initialize your data structure here. */
    public MyQueue() {
        input = new Stack<>();
        output = new Stack<>();
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        input.push(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if (!output.empty()) return output.pop();
        while (!input.empty()) {
            output.push(input.pop());
        }
        return output.pop();
    }
    
    /** Get the front element. */
    public int peek() {
        if (!output.empty()) return output.peek();
        while (!input.empty()) {
            output.push(input.pop());
        }
        return output.peek();
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return input.empty() && output.empty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */