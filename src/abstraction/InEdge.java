package abstraction;


public class InEdge extends Edge{
	private Place place;
	private Transition transition;
	/**
	 * On ne prend pas en compte les edges maintenant puisqu'on va les creer apres
	 * @param value
	 * @param id
	 * @param place
	 * @throws NbrNegatifException 
	 * @author Gabriel
	 */
	public InEdge(int value, String id, Place place, Transition transition) throws NbrNegatifException {
		super(value, id);
		// TODO Auto-generated constructor stub
		this.place = place;
		this.transition = transition;
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
	
	public void setPlace(Place place) {
		this.place = place;
	}
	
	public void setTransition(Transition transition) {
		this.transition = transition;
	}
	
	public Transition getTransition() {
		return this.transition;
	}
	/**
	 * On adapte toString() en fonction de si l'edge est connecte a une place ou non
	 * @author Gabriel
	 * @Override
	 */
	public String toString() {
		String res =super.toString();
		
		if(this.place != null) {
		res+=" Place : "+ this.place.getId();
		}
		if(this.transition != null) {
			res+= " Transition : "+ this.transition.getId();
		}
		return res;
	}
	
	/**
	 * Cette methode declanche la transition de jeton entre une transition et la place d'entree
	 * @throws NbrNegatifException 
	 * @author Gabriel
	 */
	public void trigger() {
		if(this.place != null) {
		int valeur = super.getValue();
		try {
			this.place.transit(valeur);
		} catch (NbrNegatifException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	}
	
	/**
	 * Deux InEdge sont egaux s'ils ont le meme id et la meme valeur
	 * @Override
	 * @param inEdge
	 * @author Gabriel
	 */
	public boolean equals(Object inEdge) {
		if(inEdge !=null && inEdge instanceof InEdge 
				&& this.getId().equals(((InEdge)inEdge).getId())
				&& this.getValue() == ((InEdge)inEdge).getValue()) {
			return true;
		}
		return false;
	}
}
