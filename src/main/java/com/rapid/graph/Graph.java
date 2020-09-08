package com.rapid.graph;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Map;

public class Graph {
	private Map<String, LinkedHashSet<String>> map = new HashMap();
	 
	private boolean connected;
	
    public void addEdge(String node1, String node2)
    {
        LinkedHashSet<String> adjacent = map.get(node1); //set of adjacent vertices
        if (adjacent == null)
        {
            adjacent = new LinkedHashSet();
            map.put(node1, adjacent);
        }
        adjacent.add(node2);
    }
 
    public void addTwoWayVertex(String node1, String node2)
    {
        addEdge(node1, node2);
        addEdge(node2, node1); //since graph is undirected
    }
    
 
   //just return the adjacent vertices from the node
    public LinkedList<String> adjacentVertices(String last)
    {
        LinkedHashSet<String> adjacent = map.get(last);
        if (adjacent == null)
        {
            return new LinkedList();
        }
        return new LinkedList<String>(adjacent);
    }
    
  
	
	public  boolean breadthFirstSearch(Graph graph,
			LinkedList<String> visited, String source, String destination)
   {
		connected = false;
		//just return the adjacent vertices from the node
		LinkedList<String> vertices = graph.adjacentVertices(visited.getLast());
		 
        for (String vertex : vertices)
        {
        	//check if the vertices has been seen before. if yes continue
            if (visited.contains(vertex))
            {
                continue;
            }
            if (vertex.equals(destination))
            {
                visited.add(vertex); //process and visit the node
                connected = true;
                visited.removeLast();
                break;
            }
        }
 
        for (String vertex : vertices)
        {
            if (visited.contains(vertex) || vertex.equals(destination))
            {
                continue;
            }
            visited.addLast(vertex);
            breadthFirstSearch(graph, visited,  source, destination);
            visited.removeLast();
        }
        
        
        return connected;
       

   }

	private void printPath(LinkedList<String> visited, String source, String destination)
    {
        if (connected == false) {
            System.out.println("Yes there exists a path between " + source
                    + " and " + destination);
 
	        for (String vertex : visited)
	        {
	            System.out.print(vertex);
	            System.out.print(" ");
	        }
	        System.out.println();
        } 
    }

}
