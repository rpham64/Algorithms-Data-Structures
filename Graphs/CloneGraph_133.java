import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Clone an undirected graph. Each node in the graph contains a label and a list of its neighbors.
	
	
	OJ's undirected graph serialization:
	Nodes are labeled uniquely.
	
	We use # as a separator for each node, and , as a separator for node label and each neighbor of the node.
	As an example, consider the serialized graph {0,1,2#1,2#2,2}.
	
	The graph has a total of three nodes, and therefore contains three parts as separated by #.
	
	First node is labeled as 0. Connect node 0 to both nodes 1 and 2.
	Second node is labeled as 1. Connect node 1 to node 2.
	Third node is labeled as 2. Connect node 2 to node 2 (itself), thus forming a self-cycle.
	
	Visually, the graph looks like the following:
	
	       1
	      / \
	     /   \
	    0 --- 2
	         / \
	         \_/
 * 
 * Source: https://leetcode.com/problems/clone-graph/description/
 * 
 * @author Rudolf
 *
 */
public class CloneGraph_133 {
	
	class UndirectedGraphNode {
		int label;
		List<UndirectedGraphNode> neighbors;
		
		UndirectedGraphNode(int x) {
			label = x;
			neighbors = new ArrayList<>();
		}
	}

    // Can also make this map local by adding a helper method called
    // clone(UndirectedGraphNode node, HashMap<UndirectedGraphNode, UndirectedGraphNode> map)
    private HashMap<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();  // Node -> Copy
    
    /**
     * Memoization + DFS Solution
     * 
     * Time: O(|V| + |E|) where |V| is the number of vertices, |E| is the number of edges.
     * Space: O(|V|) where |V| is the number of nodes in the graph.
     * 
     * @param node
     * @return
     */
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) return null;
        
        // If node already has copy in map, return that copy.
        if (map.containsKey(node)) return map.get(node);
        
        // Else, create a new copy using node's label and neighbors.
        UndirectedGraphNode copy = new UndirectedGraphNode(node.label);
        map.put(node, copy);  // Required, else map throws a StackOverflowError for infinite recursion loop.
        
        for (UndirectedGraphNode neighbor : node.neighbors) {
            UndirectedGraphNode copyNeighbor = cloneGraph(neighbor);
            copy.neighbors.add(copyNeighbor);
        }
        
        return copy;
    }
}
