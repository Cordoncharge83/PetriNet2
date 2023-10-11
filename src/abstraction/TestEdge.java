package abstraction;

public class TestEdge {
	public static void main(String[] args) {
		Edge edge1 = new Edge(1,"e1");
		Place place1 = new Place(3,"p1");
		
		//On test sommairement les methode de Edge
		System.out.println(edge1.toString());
		System.out.println(edge1.getId());
		System.out.println(edge1.getValue());
		
		//On test sommairement les methode de OutEdge
		OutEdge outEdge1 = new OutEdge(1,"oe1",place1);
		
	}
}
