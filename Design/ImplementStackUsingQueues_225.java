package Design;

import java.util.LinkedList;
import java.util.Queue;

public class ImplementStackUsingQueues_225 {

	private Queue<Integer> queue;

    /** Initialize your data structure here. */
    public ImplementStackUsingQueues_225() {
        queue = new LinkedList<>();
    }
    
    /** Push element x onto stack. */
    // Time: O(n)
    public void push(int x) {
        queue.offer(x);
        transfer();  // Puts x at the head of queue for O(1) peek() and pop().
    }
    
    /** Removes the element on top of the stack and returns that element. */
    // Time: O(1)
    public int pop() {
        return queue.poll();
    }
    
    /** Get the top element. */
    // Time: O(1)
    public int top() {
        return queue.peek();
    }
    
    /** Returns whether the stack is empty. */
    // Time: O(1)
    public boolean empty() {
        return queue.size() == 0;
    }
    
    private void transfer() {
        for (int i = 0; i < queue.size() - 1; ++i) {
            queue.offer(queue.poll());
        }
    }
}
