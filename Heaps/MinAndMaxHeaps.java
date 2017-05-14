package Heaps;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * By definition, a Priority Queue is an abstract data type similar to a regular queue and stack data structure,
 * but where each element also has a "priority" associated with it. 
 * 
 * Note: While often implemented with heaps, they're pretty different from heaps and more similar to lists and maps.
 * 
 * Time Complexity:
 * 		- Peek(), element()								=	O(1)
 * 		- Add(), offer(), remove(), poll()				=	O(log n)
 * 		- contains()									=	O(n)
 * 
 * @author Rudolf
 *
 */
public class MinAndMaxHeaps {

	public void minHeap() {
		PriorityQueue<Object> queue = new PriorityQueue<>();
	}
	
	public void maxHeap() {
		int initialCapacity = 20;
		PriorityQueue<Object> queue = new PriorityQueue<>(initialCapacity, Collections.reverseOrder());
	}
}
