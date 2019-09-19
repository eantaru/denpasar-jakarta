package acyclicgraph.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;

import acyclicgraph.DirectedGraph;
import acyclicgraph.Vertex;

public class Test {

	private DirectedGraph graph;
	
	@Before
	public void setUp() throws Exception {
		graph = new DirectedGraph();
	}

	@After
	public void tearDown() throws Exception {
		graph = null;
	}

	@org.junit.Test
	public void testABC() {
		graph.addVertex(new Vertex("A", new Vertex("B"), 1));
		graph.addVertex(new Vertex("B", new Vertex("C"), 2));
		graph.addVertex(new Vertex("A", new Vertex("C"), 2));
		
		int expectedResult = 5;
		assertEquals(expectedResult, graph.print());
	}
	
	@org.junit.Test
	public void testZABC() {
		graph.addVertex(new Vertex("A", new Vertex("B"), 1));
		graph.addVertex(new Vertex("B", new Vertex("C"), 2));
		graph.addVertex(new Vertex("D", new Vertex("F"), 10));
		graph.addVertex(new Vertex("A", new Vertex("C"), 2));
		graph.addVertex(new Vertex("A", new Vertex("D"), 4));
		graph.addVertex(new Vertex("C", new Vertex("D"), 2));
		graph.addVertex(new Vertex("X", new Vertex("Y"), 2));
		graph.addVertex(new Vertex("Z", new Vertex("A"), 4));
		
		int expectedResult = 19;
		assertEquals(expectedResult, graph.print());
	}

}
