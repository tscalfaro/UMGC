/*
 * Created by: Antonio Scalfaro
 * CMSC 315
 * Project 4 - Undirected Graph GUI
 * 
 * This is the Graph class which has 2 class variables, Map<Vertex, List<Vertex>> and Set<Vertex>.
 * There are 11 public class methods:
 * Graph() - Constructor
 * addVertex(Vertex) - Adds vertex to adjacency list.
 * addEdge(Vertex, Vertex) - Adds edge between two vertices in the adjacency list
 * boolean hasCycles() - Returns true if graph has cycles, false otherwise.
 * boolean isConnected() - Returns true if graph is connected, false otherwise.
 * Set<Vertex> depthFirstSearch(Vertex) - Returns LinkedHashSet of visited vertices by depth first search starting at
 * 										  Vertex A
 * Set<Vertex> breadthFirstSearch(Vertex) - Returns LinkedHashSet of visited vertices by breadth first search starting
 * 											at Vertex A
 * Set<Vertex> getVertices() - Getter for vertices
 * List<List<Vertex>> getEdges - Returns a List of Lists for the edges of the graph
 * boolean containsVertex(String) - Returns true if vertex name is in set of vertices, false otherwise
 * Vertex getVertexByName(String) - Returns vertex if in set of vertices, otherwise null
 * There are 2 private methods:
 * boolean hasCycles(Vertex, Vertex, Set<Vertex>) - Adds each vertex to visited Set from adjacency list and returns
 * 													true if graph has cycles, false otherwise
 * dfs(Vertex, Set<Vertex>) - depth first search helper method, adds each vertex from adjacency list to visited set in 
 * 							  depth first order.
 * */

package application;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class Graph {

	private Map<Vertex, List<Vertex>> adjacencyList;
	private Set<Vertex> vertices;
	
	public Graph() {
		adjacencyList = new HashMap<>();
		vertices = new HashSet<>();
	}
	
	public void addVertex(Vertex vertex) {
		vertices.add(vertex);
		adjacencyList.putIfAbsent(vertex, new ArrayList<>());
	}
	
	public void addEdge(Vertex source, Vertex destination) {
		if (!adjacencyList.containsKey(source)) {
	        adjacencyList.put(source, new ArrayList<>());
	    }
	    if (!adjacencyList.containsKey(destination)) {
	        adjacencyList.put(destination, new ArrayList<>());
	    }
		adjacencyList.get(source).add(destination);
		adjacencyList.get(destination).add(source);
	}
	
	public boolean hasCycles() {
		Set<Vertex> visited = new HashSet<>();
		
		for(Vertex vertex : adjacencyList.keySet()) {
			if(!visited.contains(vertex) && hasCycles(vertex, null, visited)) {
				return true;
			}
		}
		return false;
	}
	
	private boolean hasCycles(Vertex vertex, Vertex parent, Set<Vertex> visited) {
		visited.add(vertex);
		for(Vertex neighbor : adjacencyList.get(vertex)) {
			if(!visited.contains(neighbor)) {
				if(hasCycles(neighbor, vertex, visited)) {
					return true;
				}
			} else if (!neighbor.equals(parent)) {
				return true;
			}
		}
		return false;
	}
	
	public boolean isConnected() {
		if(vertices.isEmpty()) {
			return true;
		}
		
		Set<Vertex> visited = depthFirstSearch(vertices.iterator().next());
		return visited.size() == vertices.size();
		
	}
	
	public Set<Vertex> depthFirstSearch(Vertex startVertex){
		Set<Vertex> visited = new LinkedHashSet<>();
		dfs(startVertex, visited);
		return visited;
	}
	
	private void dfs(Vertex vertex, Set<Vertex> visited) {
		visited.add(vertex);
		for(Vertex neighbor : adjacencyList.get(vertex)) {
			if (!visited.contains(neighbor)) {
				dfs(neighbor, visited);
			}
		}
	}
	
	public Set<Vertex> breadthFirstSearch(Vertex startVertex){
		Set<Vertex> visited = new LinkedHashSet<>();
		Queue<Vertex> queue = new LinkedList<>();
		queue.add(startVertex);
		
		while(!queue.isEmpty()) {
			Vertex current = queue.poll();
			visited.add(current);
			for(Vertex neighbor : adjacencyList.get(current)) {
				if(!visited.contains(neighbor)) {
					queue.add(neighbor);
				}
			}
		}
		
		return visited;
	}
	
	public Set<Vertex> getVertices() {
        return vertices;
    }

    public List<List<Vertex>> getEdges() {
        List<List<Vertex>> edges = new ArrayList<>();
        for (Vertex source : adjacencyList.keySet()) {
            for (Vertex destination : adjacencyList.get(source)) {
                List<Vertex> edge = new ArrayList<>();
                edge.add(source);
                edge.add(destination);
                edges.add(edge);
            }
        }
        return edges;
    }
    
    public boolean containsVertex(String vertexName) {
    	for (Vertex vertex : adjacencyList.keySet()) {
    		if (vertex.getName().equals(vertexName)) {
    			return true;
    		}
    	}
    	return false;
    }
    
    public Vertex getVertexByName(String vertexName) {
    	for (Vertex vertex : adjacencyList.keySet()) {
    		if(vertex.getName().equals(vertexName)) {
    			return vertex;
    		}
    	}
    	return null;
    }
}
