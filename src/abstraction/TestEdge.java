package abstraction;

public class TestEdge {
	public static void main(String[] args) {
		Edge edge1 = new Edge(1,"e1");
		Place place1 = new Place(3,"p1");
		
		//On test sommairement les methode de Edge
		System.out.println(edge1.toString());
		System.out.println(edge1.getId());
		System.out.println(edge1.getValue());
		System.out.println();
		//On test sommairement les methode de OutEdge
		//Pour un OutEdge value < Jeton
		OutEdge outEdge1 = new OutEdge(1,"oe1",place1);
		System.out.println(outEdge1.toString());
		System.out.println(place1.toString());
		outEdge1.trigger();
		System.out.println(place1.toString());
		System.out.println();
		//Pour un OutEdge value > jeton
		OutEdge outEdge2 = new OutEdge(4,"oe1",place1);
		System.out.println(outEdge2.toString());
		System.out.println(place1.toString());
		outEdge2.trigger();
		System.out.println(place1.toString());
		System.out.println();
		//Pour un OutEdge value > jeton
		OutEdge outEdge3 = new OutEdge(3,"oe1",place1);
		System.out.println(outEdge3.toString());
		System.out.println(place1.toString());
		outEdge3.trigger();
		System.out.println(place1.toString());
		System.out.println();
		//pour un EdgeDrain avec jeton > 0 
		OutEdge edgeZero1 = new OutEdge(1,"ez1",place1);
		System.out.println(outEdge1.toString());
		System.out.println(place1.toString());
		outEdge1.trigger();
		System.out.println(place1.toString());
		
	}
}
