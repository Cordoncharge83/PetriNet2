package abstraction;

import java.util.HashMap;
import java.util.Vector;

public class Place {
	private int jeton;
	private String id;
	private HashMap<String, OutEdge> outEdges;
	private HashMap<String, InEdge>	inEdges;
	
	/**
	 * @author Mouadh
	 * @param jeton
	 * @param id
	 * @throws JetonNegatifException
	 */
	public Place(int jeton, String id) throws NbrNegatifException {
		this.jeton = jeton;
		this.id = id;
		this.outEdges = new HashMap<String, OutEdge>();
		this.inEdges = new HashMap<String, InEdge>();
		if (jeton < 0) {
			throw new NbrNegatifException("Le nombre de jetons doit être positif");
		}
	}
	
	public String getId() {
		return this.id;
	}
	public int getJeton() {
		return this.jeton;
	}
	
	public HashMap<String, OutEdge> getOutEdges() {
		return outEdges;
	}

	public HashMap<String, InEdge> getInEdges() {
		return inEdges;
	}
	
	/**
	 * Cette methode permet de changer le nbr de jeton au sein d'une place apres le declanchement 
	 * d'une transition
	 * @param value > 0 si on ajoute des jetons, value < 0 si on retire des jetons
	 * @throws JetonNegatifException 
	 * @author Mouadh
	 */
	public void transit(int value) throws NbrNegatifException {
		if(value < 0 && Math.abs(value) > jeton) {
			throw new NbrNegatifException("Le nombre de jetons doit être positif");
		}
		else {
		this.jeton +=value;
		}
	}
	
	/**
	 * Cette methode connecte 1 OutEdge a Place
	 * @param outEdge
	 * @author Mouadh
	 */
	public void addOutEdge(OutEdge outEdge) {
		this.outEdges.put(outEdge.getId(), outEdge);
	}
	
	/**
	 * Cette methode connecte 1 InEdge a Place
	 * @param inEdge
	 * @author Mouadh
	 */
	public void addInEdge(InEdge inEdge) {
		this.inEdges.put(inEdge.getId(), inEdge);
	}

	/**
	 * Cette methode connecte un vecteur de OutEdge a Place
	 * @param outEdge
	 * @author Mouadh
	 */
	public void addOutEdges(Vector<OutEdge> outEdges) {
		for(OutEdge e : outEdges) {
			this.outEdges.put(e.getId(), e);
		}
	}

	/**
	 * Cette methode retire de la HashMap des OutEdges outEdge en supprimant sa clef
	 * @param outEdge
	 * @author Mouadh
	 */
	public void removeOutEdge(OutEdge outEdge) {
		this.outEdges.remove(outEdge.getId());
	}
	
	public void removeInEdge(InEdge inEdge) {
		this.inEdges.remove(inEdge.getId());
	}
	
	/**
	 * Cette methode connecte un vecteur de InEdge a Place
	 * @param outEdge
	 * @author Mouadh
	 */
	public void addInEdges(Vector<InEdge> inEdges) {
		for(InEdge e : inEdges) {
			this.inEdges.put(e.getId(), e);
		}
	}
	/**
	 * @author Mouadh
	 */
	@Override
	public String toString() {
		return ("ID : "+ this.id+ ", nbr jetons : "+ this.getJeton());
	}
	
	/**
	 * @author Gabriel
	 * @Test
	 * @Override
	 * Deux places sont egales ssi leurs id et nbrJeton sont egaux
	 */
	public boolean equals(Object o) {
		if(o != null && o instanceof Place 
				&& this.getJeton() == ((Place)o).getJeton()
				&& this.getId().equals(((Place)o).getId())) {
			return true;
		}
		return false;
	}
}
