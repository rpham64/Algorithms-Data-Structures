package Queues;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.NoSuchElementException;

import org.junit.Test;

/**
 * Base test for any class that implements the Queue interface.
 */
public abstract class QueueTest {

    /**
     * The queue to use in all the tests: set this in subclasses.
     */
    protected Queue q;

    @Test
    public void testNewQueueIsEmpty() {
        assertTrue(q.isEmpty());
        assertEquals(q.size(), 0);
    }

    @Test
    public void testInsertsToEmptyQueue() {
        int numberOfInserts = 6;
        for (int i = 0; i < numberOfInserts; i++) {
            q.enqueue("zzz");
        }
        assertTrue(!q.isEmpty());
        assertEquals(q.size(), numberOfInserts);
    }

    @Test
    public void testEnqueueThenDequeue() {
        String message = "hello";
        q.enqueue(message);
        assertEquals(q.dequeue(), message);
    }

    @Test
    public void testEnqueueThenPeek() {
        String message = "hello";
        q.enqueue(message);
        int size = q.size();
        assertEquals(q.peek(), message);
        assertEquals(q.size(), size);
    }

    @Test
    public void testFiftyInThenFiftyOut() {
        for (int i = 0; i < 50; i++) {
            q.enqueue(i);
        }
        for (int i = 0; i < 50; i++) {
            assertEquals(((Integer)q.dequeue()).intValue(), i);
        }
    }

    @Test
    public void testRemovingDownToEmpty() {
        int numberOfRemoves = (int)(Math.random() * 20 + 1);
        for (int i = 0; i < numberOfRemoves; i++) {
            q.enqueue("zzz");
        }
        for (int i = 0; i < numberOfRemoves; i++) {
            q.dequeue();
        }
        assertTrue(q.isEmpty());
        assertEquals(q.size(), 0);
    }

    @Test(expected=NoSuchElementException.class)
    public void testRemoveOnEmptyQueue() {
        assertTrue(q.isEmpty());
        q.dequeue();
    }

    @Test(expected=NoSuchElementException.class)
    public void testPeekIntoEmptyQueue() {
        assertTrue(q.isEmpty());
        q.dequeue();
    }
}