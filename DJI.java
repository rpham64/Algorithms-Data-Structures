
public class DJI {

	public class HashMap(){

		 private Node[] map = new Node[10];

		 public int put (String key, int value){
		    int hashCode = key.hashCode();
		    Node node = new Node(key, value);
		    
		    if (map[hashCode % 10] == null) {
		    	// No conflict, so add node
		      map[hashCode % 10] = node;
		    } else {
		    	Node current = map[hashCode % 10];
		      
		      while (current.next != null) {
		      	current = current.next;
		      }
		      
		    	node.next = current.next;
		      current.next = node;
		    }
		 }
		 
		 public int get (String key){
		 		int hashCode = key.hashCode();
		    Node current = map[hashCode % 10];
		    
		    if (current == null) return -1;  // Node not found.
		    
		    while (current.key != key) {
		      current = current.next;

		      if (current == null) return -1;  // Not found
		    }

		    return current.val;
		 }

		}

		public class Node {

			private String key;
			private int val;
		  private Node next;
		  
		  public Node(String key, int val) {
		  	this.key = key;
		    this.val = val;
		  }

		}
}
