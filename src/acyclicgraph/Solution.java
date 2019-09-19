package acyclicgraph;

public class Solution {
	
	public static void main(String[] args) {
		
		System.out.println("==graph-1==");
		DirectedGraph graph = new DirectedGraph();
		graph.addVertex(new Vertex("A", new Vertex("B"), 1));
		graph.addVertex(new Vertex("B", new Vertex("C"), 2));
		graph.addVertex(new Vertex("A", new Vertex("C"), 2));

		graph.print();
		

		System.out.println("==graph-2==");
		DirectedGraph graph2 = new DirectedGraph();
		graph2.addVertex(new Vertex("A", new Vertex("B"), 1));
		graph2.addVertex(new Vertex("B", new Vertex("C"), 2));
		graph2.addVertex(new Vertex("D", new Vertex("F"), 10));
		graph2.addVertex(new Vertex("A", new Vertex("C"), 2));
		graph2.addVertex(new Vertex("A", new Vertex("D"), 4));
		graph2.addVertex(new Vertex("C", new Vertex("D"), 2));
		graph2.addVertex(new Vertex("X", new Vertex("Y"), 2));
		graph2.addVertex(new Vertex("Z", new Vertex("A"), 4));
		
		graph2.print();
	}
}
