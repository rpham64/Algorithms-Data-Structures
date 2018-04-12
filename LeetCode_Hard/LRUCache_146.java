package LeetCode_Hard;

import java.util.HashMap;

/**
 * Design and implement a data structure for Least Recently Used (LRU) cache. 
 * It should support the following operations: get and put.
 * 
 * get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
 * put(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, 
 * 					it should invalidate the least recently used item before inserting a new item.

	Follow up:
	Could you do both operations in O(1) time complexity?
 * 
 * @author rpham
 * Date: 4/11/18
 *
 */
public class LRUCache_146 {
	
	/**
	*   Hint: LRUCaches are typically based on LinkedHashMaps, which are HashMaps 
	*         with doubly-linked lists for the key set.
	*
	*   Here, we will set the least recently used node to be at the TAIL of the list.
	*/
	
	/**
	 * Doubly Linked List Node with key and value.
	 */
	class Node {
        private int key;
        private int val;
        private Node prev;
        private Node next;

        public Node(int key, int value) {
            this.key = key;
            this.val = value;
            this.prev = null;
            this.next = null;
        }
    }

    private int maxSize;  // Max capacity of LRUCache
    private HashMap<Integer, Node> map;  // Map of Key -> Node entries
    private Node head;  // Head of LRUCache
    private Node tail;  // Tail of LRUCache
    
    public LRUCache_146(int capacity) {
        maxSize = capacity;
        map = new HashMap<>();
        head = null;
        tail = null;
    }
    
    /**
    *   Given a key, returns the respective node's value.
    *   If it does not exist, returns -1;
    */
    public int get(int key) {
        // Node not found in map, so return -1.
        if (!map.containsKey(key)) return -1;
        
        // Store old node's value.
        Node oldNode = map.get(key);
        
        // Since we're accessing this node, remove it from the list and set it as the head.
        remove(oldNode);
        setAsHead(oldNode);
        
        // Return stored node's value.
        return oldNode.val;
    }
    
    /**
    *   Adds key and value to map, if it doesn't exist.
    *   If so, overrides the old entry and moves the old entry to the head of list.
    */
    public void put(int key, int value) {        
        if (map.containsKey(key)) {
            // Override old node with new value.
            Node oldNode = map.get(key);
            oldNode.val = value;
            
            // Remove old node and set as head.      
            remove(oldNode);
            setAsHead(oldNode);
            
        } else {
            // If size exceeds capacity, remove the tail node.
            if (map.size() >= maxSize) {
                map.remove(tail.key);
                remove(tail);
            }
            
            // Create new node.
            Node node = new Node(key, value);
            
            // Add to map and head of cache.
            map.put(key, node);
            setAsHead(node);
        }
    }
    
    /**
    *   Removes the node from the list.
    *   
    *   If head of list:
    *   	head = node.next
    *   If tail of list:
    *   	tail = node.prev
    *   
    *   If middle of list:
    *   	node.prev.next = node.next
    *   	node.next.prev = node.prev
    *
    *   Time (for doubly linked list): O(1) since you re-assign pointers for node's prev and next nodes.
    *   Time (for singly linked list): O(n) since you need to iterate from head to find node.
    */
    public void remove(Node node) {
        if (node.prev == null) {
            // Currently head, so remove and re-assign the head.
            head = node.next;
        } else {
            // In middle of list. Set prev.next pointer to next.
            node.prev.next = node.next;
        }
        
        if (node.next == null) {
            // Currently tail, so remove and re-assign the tail.
            tail = node.prev;
        } else {
            // In middle of list, so set next.prev to prev.
            node.next.prev = node.prev;
        }
        
        // map.remove(node.key);  // PASS BY VALUE SHIT
    }
    
    /**
    *   Sets given node as the head of the list.
    */
    public void setAsHead(Node node) {
        node.next = head;
        node.prev = null;
        
        // Set head.prev if head already exists.
        if (head != null) {
            head.prev = node;
        }
        
        head = node;
        
        // Set tail if this is the first node in the list.
        if (tail == null) {
            tail = node;
        }
    }

	/**
	 * Your LRUCache object will be instantiated and called as such:
	 * LRUCache obj = new LRUCache(capacity);
	 * int param_1 = obj.get(key);
	 * obj.put(key,value);
	 */
}
