package abstraction;

public class EdgeDrain extends OutEdge{

	public EdgeDrain(String id, Place place) {
		//ici value n'a aucun interet et on l'utilisera pas.
		//Par default on la fixe a 1 puisque  le trigger se declenche si la place
		//a plus d'un jeton
		super(1, id, place);	
	}
	
}
