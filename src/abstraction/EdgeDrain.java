package abstraction;

public class EdgeDrain extends OutEdge{

	public EdgeDrain(String id, Place place, Transition transition) throws NbrNegatifException {
		//ici value n'a aucun interet et on l'utilisera pas.
		//Par default on la fixe a 1 puisque  le trigger se declenche si la place
		//a plus d'un jeton
		super(1, id, place, transition);	
	}
	
	@Override
	public int getValue() {
		return super.getValue();
	}
	
	@Override
	public String getId() {
		return super.getId();
	}
	@Override
	public Place getPlace() {
		return super.getPlace();
	}
	
	@Override
	public Transition getTransition() {
		return super.getTransition();
	}
	@Override
	public void setTransition(Transition transition) {
		super.setTransition(transition);
	}
	
	@Override
	public void setPlace(Place place) {
		super.setPlace(place);
	}
	
	/**
	 * @Override
	 * @author Gabriel
	 * Si les jetons sont superieurs a 1 vide la place, sinon on ne fait rien
	 */
	public void trigger() {
		if(this.getPlace()!=null) {
		int jeton = this.getPlace().getJeton();
		if(jeton > 0) {
			try {
				this.getPlace().transit(-jeton);
			} catch (NbrNegatifException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		}
	}
	
	/**
	 * @Override
	 * @author Gabriel
	 */
	public String toString() {
		return super.toString();
	}
}
