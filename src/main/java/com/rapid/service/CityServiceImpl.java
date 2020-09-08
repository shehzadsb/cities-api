package com.rapid.service;

import java.util.LinkedList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.rapid.graph.Graph;

/*
 * Sample service to demonstrate what the API would use to get things done
 */
@Service
public class CityServiceImpl implements CityService {
	 private static final Logger log = LoggerFactory.getLogger(CityServiceImpl.class);

	 private  Graph graph = new Graph();
	 LinkedList<String> visited;
	 
	 public CityServiceImpl() {
		 	
	        
	        //creating two-way edge between Boston and New York
	        graph.addEdge("Boston", "New York");
	        graph.addEdge("New York", "Boston");
	        //creating two-way edge between Philadelphia and Newark
	        graph.addEdge("Philadelphia", "Newark");
	        graph.addEdge("Newark", "Philadelphia");
	        
	        //creating two-way edge between Newark and Boston
	        graph.addEdge("Newark", "Boston");
	        graph.addEdge("Boston", "Newark");
	        
	        //creating two-way edge between Trenton and Albany
	        graph.addEdge("Trenton", "Albany"); 
	        graph.addEdge("Albany", "Trenton"); 
	       
	        
	        
	        
	       //String  source = "Philadelphia";
	       //String  destination = "Trenton";
	       
	        
	 
	 }
	 
	 public String connected(String source, String destination) {
		 visited = new LinkedList();
		 visited.add(source);
		 boolean connected = graph.breadthFirstSearch(graph, visited, source, destination);
		 
		 if(connected) {
			 return "yes";
		 }
		 return "no";
		 
	 }
	 
}
