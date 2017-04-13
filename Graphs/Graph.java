package Graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class Graph {

	private int numVertices;						// Number of Vertices
	private int[][] adjMatrix;						// Adjacency Matrix
	private HashMap<Integer, List<Integer>> adjList;		// Adjacency List
	
	/**
	 * Pros of using Adjacency Matrix: 
	 * 		- Lookup, Insertion (edge), Deletion (edge) all take O(1) time.
	 * 
	 * Cons of using Adjacency Matrix:
	 * 		- Takes O(V^2) space, where V is the number of vertices
	 * 		- Inserting/Deleting a vertex takes O(V^2) time, because arrays aren't dynamic and we'd
	 * 		  have to create a new matrix with different size
	 */
	
	/**
	 * Pros of using Adjacency Lists:
	 * 		- Takes less space O(|V| + |E|) 
	 * 		- Adding/Deleting vertex is easier
	 * 
	 * Cons of using Adjacency Lists:
	 * 		- Queries, such as lookup, insertion, or deletion, are inefficient and take up to O(V)
	 * 			- Reason: To find edge from vertex u to v, find u in array of vertices (O(1)), then 
	 * 					  iterate through the LinkedList storing the edges of u (O(V))
	 * 
	 */
	
	public Graph(int num) {
		numVertices = num;
		adjMatrix = new int[num][num];
		adjList = new HashMap<>();
		
		for (int i = 0; i < num; ++i) {
			adjList.put(i, new ArrayList<>());
		}
	}
	
	public int size() {
		return numVertices;
	}
	
	public void addEdge(int src, int dest) {
		adjList.get(src).add(dest);
	}
	
	public List<Integer> getNeighbors(int src) {
		return adjList.get(src);
	}
	
	/**
	 * Prints out BFS traversal from given src
	 * 
	 * @param src
	 */
	public void BFS(int src) {
		
		Queue<Integer> queue = new LinkedList<>();
		HashSet<Integer> visited = new HashSet<>();
		
		queue.offer(src);
		visited.add(src);
		
		while (!queue.isEmpty()) {
			
			Integer current = queue.poll();
			
			System.out.print(current + " ");
			
			// Add current's neighbors to queue
			List<Integer> srcNeighbors = getNeighbors(current);
			
			for (int i = 0; i < srcNeighbors.size(); ++i) {
				
				int neighbor = srcNeighbors.get(i);
				
				// If node has not been visited, add it to the visited hashset and queue
				// This prevents cycles from causing an infinite loop
				if (!visited.contains(neighbor)) {
					visited.add(neighbor);
					queue.offer(neighbor);
				}
			}
		}
		
	}
	
	/**
	 * Prints out DFS traversal from given src
	 * 
	 * @param src
	 */
	public void DFS(int src) {
		
		Stack<Integer> stack = new Stack<>();
		HashSet<Integer> visited = new HashSet<>();
		
		stack.push(src);
		visited.add(src);
		
		while (!stack.isEmpty()) {
			
			int current = stack.pop();
			
			System.out.print(current + " ");
			
			List<Integer> neighbors = getNeighbors(current);
			
			for (int i = 0; i < neighbors.size(); ++i) {
				
				int neighbor = neighbors.get(i);
				
				if (!visited.contains(neighbor)) {
					visited.add(neighbor);
					stack.push(neighbor);
				}
			}
		}
	}
	
	public static void main(String[] args) {
		
		/**
		 * Graph Image: http://www.geeksforgeeks.org/breadth-first-traversal-for-a-graph/
		 */
		Graph graph = new Graph(4);
		graph.addEdge(0, 1);
		graph.addEdge(0, 2);
		graph.addEdge(1, 2);
		graph.addEdge(2, 0);
		graph.addEdge(2, 3);
		graph.addEdge(3, 3);
		
//		for (int i = 0; i < graph.size(); ++i) {
//			System.out.println("Node " + i + "'s neighbors: " + graph.getNeighbors(i));
//		}
//		graph.BFS(2);
		graph.DFS(2);
	}
}
