package abstraction;

public class Edge {
	private int value;
	private String id;
	
	public Edge(int value, String id) throws NbrNegatifException {
		// <=> value <=0
		if(value < 1 ) {
			throw new NbrNegatifException("Valeur d'entree negative ou null");
		}
		this.value = value;
		this.id = id;
	}

	public int getValue() {
		return value;
	}
	
	public void setValue(int value) throws NbrNegatifException {
		if(value <1 ) {
			throw new NbrNegatifException("Valeur d'entree negative ou null");
		}
		this.value = value;
	}

	public String getId() {
		return id;
	}
	
	public String toString() {
		return "Id : "+this.getId()  + " Value: " + this.value;
	}
	
}
