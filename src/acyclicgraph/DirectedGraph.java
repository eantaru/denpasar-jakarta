package acyclicgraph;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

/**
 * 
 * @author Reyhan_FR879
 *
 * Direct Graph, capture optimal directed graph using Map and head name as key of its map
 */
public class DirectedGraph {
	
	// collection of vertexes
	private final Map<String, LinkedList<Vertex>> list;
	
	public DirectedGraph() {
		list = new HashMap<String, LinkedList<Vertex>>();
	}
	
	// create new vertexes if not exist or add to existing vertexes
	public void addVertex(Vertex v) {
		if(list.containsKey(v.getName())) {
			LinkedList<Vertex> ls = list.get(v.getName());
			Vertex next = v.getNext();
			next.setValue(v.getValue());
			ls.add(next);
		}
		else {
			createNewList(v);
		}
	}

	// insert new list of vertexes and set parent of its vertex to easier capture all nodes
	private void createNewList(Vertex v) {
		Vertex next = v.getNext();
		next.setParent(v);
		list.put(v.getName(), new LinkedList<Vertex>(Arrays.asList(next)));
	}
	
	// show origin vertexes and its next/neighbor 
	public int print() {
		Set<String> keys = list.keySet();
		
		int optimal = 0;
		
		// loop vertexes to make new collection of optimal path
		for(String key : keys) {
			LinkedList<Vertex> vertexes = list.get(key);
			Iterator<Vertex> it = vertexes.iterator();
			
			Vertex vertex = it.next();

			// each vertex shall has parent & collect
			Vertex head = vertex.getParent();
			System.out.print(head);
			
			int value = head.getValue();
			
			while(list.containsKey(vertex.getName())) {
				vertex = list.get(vertex.getName()).get(0);
				
				System.out.print(" -> " + vertex.getParent());
				
				value += vertex.getParent().getValue();
			}
			
			// last loop, look for tail if it has related with head
			if(list.containsKey(head.getName())) {
				LinkedList<Vertex> children = list.get(head.getName());
				for(Vertex vx : children) {
					if(vx.getName().equals(vertex.getName())) {
						vertex.setValue(vx.getValue());
						value += vertex.getValue();
					}
				}
			}
			
			if(optimal < value) {
				optimal = value;
			}
			
			System.out.println(String.format(" -> %s, total = %d", vertex, value));
			
		}
		
		System.out.println("final result: " + optimal);
		return optimal;
	}
}
