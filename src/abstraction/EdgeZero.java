package abstraction;

public class EdgeZero extends OutEdge{

	public EdgeZero(String id, Place place,Transition transition) throws NbrNegatifException {
		//On met 1 par default mais on se sert jamais de cette valeur
		super(1, id, place, transition);
		// TODO Auto-generated constructor stub
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
	 * On redefinie la methode trigger(). Cette methode ne fait rien quand elle est active
	 * Cependant on ecrit du code pour que quand l'information lit la fonction, il comprenne
	 * pourquoi elle ne fait rien
	 */
	public void trigger() {
		if(this.getPlace() !=null) {
		int jeton = this.getPlace().getJeton();
		if(jeton ==0) {
			//On ne fait rien
			try {
				this.getPlace().transit(0);
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
