package acyclicgraph;

public class Vertex {
	
	private final String name;
	private int value;
	private Vertex next;
	private Vertex parent;
	
	public Vertex(String name) {
		this(name, null, 0);
	}
	
	public Vertex(String name, Vertex next, int value) {
		this.name = name;
		this.value = value;
		this.next = next;
	}
	
	public String getName() {
		return name;
	}
	
	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
	
	public Vertex getNext() {
		return next;
	}
	
	public Vertex getParent() {
		return parent;
	}

	public void setParent(Vertex parent) {
		this.parent = parent;
	}
	
	@Override
	public String toString() {
		return String.format("%s(%d)", name, value);
	}
}
