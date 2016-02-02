package Queues;

import org.junit.Before;
import org.junit.Test;

/**
 * Unit test for BoundedQueue.
 */
public class BoundedQueueTest extends QueueTest {
    private static int CAPACITY = 60;

    @Before
    public void makeBoundedQueue() {
        q = new BoundedQueue(CAPACITY);
    }

    @Test(expected=IllegalStateException.class)
    public void testEnqueueToFullQueue() {
        for (int i = 0; i < CAPACITY; i++) {
            q.enqueue("abc");
        }
        q.enqueue("abc");
    }
}