package abstraction;

public class OutEdge extends Edge{
	public Place place;
	
	
	public OutEdge(int value, String id, Place place) {
		super(value, id);
		// TODO Auto-generated constructor stub
		this.place = place;
	}
	
	/**
	 * @author Gabriel
	 * Cette methode affiche un OutEdge
	 */
	public String toString() {
		return super.toString() +" Place : " + this.place.getId();
	}
	/**
	 * @author Gabriel
	 * Cette methode effectue une transition si le nombre de jeton dans une place
	 * est plus grand que la valeur de l'edge
	 */
	public void trigger() {
		int jeton = this.place.getJeton();
		int valeur = super.getValue();
		//On test le type d'edge que c'est pour savoir quel comportement trigger doit avoir
		if(this instanceof OutEdge) {
		//Si jeton >= valeur on peut retirer valeur jetons de Place sinon ne fait rien
		if(jeton > valeur -1) {
			this.place.transit(-valeur);
		}
		else if(this instanceof EdgeZero) {
			if(jeton ==0) {
				//On ne fait rien
				this.place.transit(0);
			}
		}
		else if(this instanceof EdgeDrain) {
			if(jeton > 0) {
				this.place.transit(-jeton);
			}
		}
		}
	}
}
