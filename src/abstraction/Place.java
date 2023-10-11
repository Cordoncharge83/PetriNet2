package abstraction;

import java.util.HashMap;
import java.util.Vector;

public class Place {
	private int jeton;
	private String id;
	private HashMap<String, OutEdge> outEdges;
	private HashMap<String, InEdge>	inEdges;
	
	public Place(int jeton, String id) {
		this.jeton = jeton;
		this.id = id;
	}
	
	/**
	 * Cette methode permet de changer le nbr de jeton au sein d'une place apres le declanchement 
	 * d'une transition
	 * @param value > 0 si on ajoute des jetons, value < 0 si on retire des jetons
	 */
	public void transit(int value) {
		this.jeton +=value;
	}
	
	/**
	 * Cette methode connecte 1 OutEdge a Place
	 * @param outEdge
	 */
	public void addOutEdge(OutEdge outEdge) {
		this.outEdges.put(outEdge.getId(), outEdge);
	}
	
	/**
	 * Cette methode connecte 1 InEdge a Place
	 * @param inEdge
	 */
	public void addInEdge(InEdge inEdge) {
		this.inEdges.put(inEdge.getId(), inEdge);
	}
	
	/**
	 * Cette methode connecte un vecteur de OutEdge a Place
	 * @param outEdge
	 */
	public void addOutEdge(Vector<OutEdge> outEdges) {
		for(OutEdge e : outEdges) {
			this.outEdges.put(e.getId(), e);
		}
	}
	
	/**
	 * Cette methode connecte un vecteur de InEdge a Place
	 * @param outEdge
	 */
	public void addInEdge(Vector<InEdge> inEdges) {
		for(InEdge e : inEdges) {
			this.inEdges.put(e.getId(), e);
		}
	}
	//ncjsdkcbnhjdsbcidsjncijdscv jdfivbfbv
}
