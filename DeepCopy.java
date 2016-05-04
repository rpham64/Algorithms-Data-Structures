import java.io.*;
import java.util.*;

/**
    Given a linked list data structure with internal nodes like:
    
    public class ListNode extends Object {
        int data;
        ListNode next;
    }
    
    Implement a deep copy method for a list built out of this data structure.
    Specifically, you will be creating an implementation for the following interface:

    ListNode deepCopy( ListNode head);    
    
    Which will be passed the head node of a list, and should return the head node of your new copy of this list.
 */

public class DeepCopy {

  /**
   * ListNode class
   */
    public static class ListNode extends Object {
        public int data;
        public ListNode next;
    }
  
  /**
   * Simple example test main.
   */
  public static void main(String[] args) {
    
    // Test list
    ListNode node1 = new ListNode();
    ListNode node2 = new ListNode();
    ListNode node3 = new ListNode();
    ListNode node4 = new ListNode();
    node1.data = 1;
    node2.data = 2;
    node3.data = 3;
    node4.data = 4;
    node1.next = node2;
    node2.next = node3;
    node3.next = node4;
      
    ListNode head = node1;
    ListNode copy = deepCopy(head); // Calls your code
    
    // Print out copy list
    while (copy != null) {
      
      System.out.print(copy.data + " ");
      copy = deepCopy(copy.next);
      
    }
    
  }
  
  /**
   * Implement me!
   
   Head = 1
   currentNode = 1 (copy)
   
   Original: 1 -> 2 -> 3 -> 4 -> NULL
   Copy: 1
   
   First while loop:
   
   Mixed List: 1 (original) -> 1 (copy) -> 2 (original) -> 2 (copy) -> ... -> NULL
   
   Second While Loop:
   
   Mixed List: 1 (original) -> 1 (copy) -> 2 (copy) -> 3 (copy) -> 4 (copy) -> NULL
   
   Last Step: head to 1 (copy)
   */
  public static ListNode deepCopy(ListNode head) 
  {
    
    // Input Check: empty list
    if (head == null) return head;
    
    ListNode currentNode = head;
    
    // Traverse original list and copy into new list
    while (currentNode != null) {
      
      ListNode copy = new ListNode();
      copy.data = currentNode.data;
      copy.next = currentNode.next;
      currentNode.next = copy;
      currentNode = copy.next;
      
    }
    
    // Re-assign copy.next to copy.next.next
    currentNode = head.next;  // Start of copy list
    
    while (currentNode.next != null) {
      
      currentNode.next = currentNode.next.next;
      currentNode = currentNode.next;
      
    }
    
    // Re-assign head to start of copy list
    head = head.next;
    
    return head;  // Head of copy list
  }
}
