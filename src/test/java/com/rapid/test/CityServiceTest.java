package com.rapid.test;
import static org.junit.Assert.assertEquals;

import java.util.LinkedList;


import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import com.rapid.graph.Graph;
import com.rapid.rest.CityServiceController;
import com.rapid.service.CityService;


@SpringBootTest(classes = {CityService.class})
public class CityServiceTest {
	
	@Autowired
    CityService cityService;
	
	@InjectMocks
    CityServiceController controller;
	
	
	private MockMvc mvc;
	
	@Before
    public void initTests() {
        MockitoAnnotations.initMocks(this);
        //mvc = MockMvcBuilders.webAppContextSetup(context).build();
    }
	
	LinkedList<String> visited;
	Graph graph ;
	
	public CityServiceTest() {
		 graph = new Graph();
		 visited = new LinkedList();
	        
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
	       
	         
	        
	        
	}
	
	
	 @Test
	 public void verifyConnected_False1() throws Exception {
		 
		
	       String  source = "Philadelphia";
	       String  destination = "Trenton";
	       
	        visited.add(source);
	        boolean result = new Graph().
	        		breadthFirstSearch(graph, visited,source, destination );
	        
	       assertEquals(false, result);
	       
	       
		 
	 }
	 @Test
	 public void verifyConnected_False2() throws Exception {
		 
		
	       String  source = "Trenton";
	       String  destination = "Philadelphia";
	       
	        visited.add(source);
	        boolean result = new Graph().
	        		breadthFirstSearch(graph, visited,source, destination );
	        
	       assertEquals(false, result);
	       
	       
		 
	 }
	
	 @Test
	 public void verifyConnected_True1() throws Exception {
		 
		
	       String  source = "Boston";
	       String  destination = "Philadelphia";
	       
	        visited.add(source);
	        boolean result = new Graph().
	        		breadthFirstSearch(graph, visited,source, destination );
	        
	       assertEquals(true, result);
	       
	       
		 
	 }
	 
	 @Test
	 public void verifyConnected_True2() throws Exception {
		 
		
	       String  source = "Philadelphia";
	       String  destination = "Boston";
	       
	        visited.add(source);
	        boolean result = new Graph().
	        		breadthFirstSearch(graph, visited,source, destination );
	        
	       assertEquals(true, result);
	       
	       
		 
	 }
	 
	 @Test
	 public void verifyConnected_FalseForInvalidInput() throws Exception {
		 
		
	       String  source = "Philadelphia";
	       String  destination = "Bos";
	       
	        visited.add(source);
	        boolean result = new Graph().
	        		breadthFirstSearch(graph, visited,source, destination );
	        
	       assertEquals(false, result);
	       
	       
		 
	 }
	 
	 
	 /*
	 @Test
	 public void verifyService_WhenConnected() throws Exception {
		 
		
	       String  source = "Philadelphia";
	       String  destination = "Trenton";
	       
	       String actualString = cityService.connected(source, destination);
	        
	       assertEquals("no", actualString);
	       
	       
		 
	 }
    */

}
