package abstraction;

public class TestPlace {
	public static void main(String[] args) {
		Place p = new Place(5,"01");
		System.out.println(p.toString());
		System.out.println(p.getJeton());
		p.transit(8);
		System.out.println(p.getJeton());
		p.transit(-9);
		System.out.println(p.getJeton());
		p.transit(-10);
		System.out.println(p.toString());
	}

}
