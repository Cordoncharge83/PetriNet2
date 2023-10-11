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
		return super.toString() +" Place : " + this.place.toString();
	}
	/**
	 * @author Gabriel
	 * Cette methode effectue une transition si le nombre de jeton dans une place
	 * est plus grand que la valeur de l'edge
	 */
	public void trigger() {
		int jeton = this.place.getJeton();
		int valeur = super.getValue();
		//Si jeton >= valeur on peut retirer valeur jetons de Place sinon ne fait rien
		if(jeton > valeur || jeton == valeur) {
			this.place.transit(valeur);
		}
	}
}
