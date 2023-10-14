package abstraction;

public class OutEdge extends Edge{
	private Place place;
	private Transition transition;
	
	public OutEdge(int value, String id, Place place, Transition transition) throws NbrNegatifException {
		super(value, id);
		// TODO Auto-generated constructor stub
		this.place = place;
		this.transition= transition;
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
	public void setValue(int value) throws NbrNegatifException {
		super.setValue(value);
	}
	
	public Place getPlace() {
		return this.place;
	}
	
	public Transition getTransition() {
		return this.transition;
	}
	
	public void setTransition(Transition transition) {
		this.transition = transition;
	}
	
	public void setPlace(Place place) {
		this.place = place;
	}
	
	/**
	 * @author Gabriel
	 * @Override
	 * Cette methode affiche un OutEdge
	 */
	public String toString() {
		String affichage ="";
		if(this.place !=null) {
			affichage +=super.toString() +" Place : " + this.place.getId();
		}
		else{
			affichage += super.toString();
		}
		if(transition !=null) {
			affichage += " Transition : " +transition.getId();
		}
		return affichage;
	}
	/**
	 * @author Gabriel
	 * Cette methode effectue une transition si le nombre de jeton dans une place
	 * est plus grand que la valeur de l'edge
	 */
	public void trigger() {
		if(this.place != null) {
		int jeton = this.place.getJeton();
		int valeur = super.getValue();
		//Si jeton >= valeur on peut retirer valeur jetons de Place sinon ne fait rien
		if(jeton > valeur -1) {
			try {
				this.place.transit(-valeur);
			} catch (NbrNegatifException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	}
	
	/**
	 * @author Gabriel
	 * @Override
	 * @param outEdge
	 * Deux outEdge sont egaux ssi leur id et leur valeur sont egaux
	 */
	public boolean equals(Object outEdge) {
		if(outEdge !=null && outEdge instanceof OutEdge 
				&& this.getId().equals(((OutEdge)outEdge).getId())
				&& this.getValue() == ((OutEdge)outEdge).getValue()) {
			return true;
		}
		return false;
	}
}
