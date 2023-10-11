package abstraction;

public class Edge {
	private int value;
	private String id;
	
	public Edge(int value, String id) {
		this.value = value;
		this.id = id;
	}

	public int getValue() {
		return value;
	}

	public String getId() {
		return id;
	}
	
	public String toString() {
		return this.getId()  + " Value: " + this.value;
	}
	
}
