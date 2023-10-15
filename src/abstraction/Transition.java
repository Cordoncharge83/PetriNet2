package abstraction;

import java.util.HashMap;
import java.util.Set;
import java.util.Vector;

public class Transition {
	private String id;
	private HashMap<String, OutEdge> outEdges;
	private HashMap<String, InEdge>	inEdges;
	
	public Transition(String id) {
		this.id = id;
		this.outEdges = new HashMap<String, OutEdge>();
		this.inEdges = new HashMap<String,InEdge>();
	}
	
	public HashMap<String, OutEdge> getOutEdges(){
		// TODO Auto-generated method stub
		return this.outEdges;
	}
	
	public HashMap<String, InEdge> getInEdges() {
		// TODO Auto-generated method stub
		return this.inEdges;
	}
	
	public String getId() {
		// TODO Auto-generated method stub
		return this.id;
	}
	
	/**
	 * @author Mouadh
	 * @Override
	 * Deux transitions sont egales ssi leurs id le sont
	 */
	public boolean equals(Object o) {
		if(o != null && o instanceof Transition 
				&& ((Transition)o).getId().equals(this.getId())) {
			return true;
		}
		return false;
	}
	
	/**
	 * Cette methode connecte 1 OutEdge a this
	 * @param outEdge
	 * @author Mouadh
	 */
	public void addOutEdge(OutEdge outEdge) {
		this.outEdges.put(outEdge.getId(), outEdge);
	}
	
	/**
	 * Cette methode connecte 1 InEdge a this
	 * @param inEdge
	 * @author Mouadh
	 */
	public void addInEdge(InEdge inEdge) {
		this.inEdges.put(inEdge.getId(), inEdge);
	}
	
	/**
	 * Cette methode connecte un vecteur de OutEdge a this
	 * @param outEdge
	 * @author Mouadh
	 */
	public void addOutEdges(Vector<OutEdge> outEdges) {
		for(OutEdge e : outEdges) {
			this.outEdges.put(e.getId(), e);
		}
	}
	
	/**
	 * Cette methode connecte un vecteur de InEdge a this
	 * @param outEdge
	 * @author Mouadh
	 */
	public void addInEdges(Vector<InEdge> inEdges) {
		for(InEdge e : inEdges) {
			this.inEdges.put(e.getId(), e);
		}
	}
	
	/**
	 * Cette methode detruit l'InEdge inEdge connecte a this
	 * @param inEdge
	 * @author Mouadh
	 */
	public void removeInEdge(InEdge inEdge) {
		this.inEdges.remove(inEdge.getId());
	}
	
	/**
	 * Cette methode detruit l'OutEdge outEdge connecte a this
	 * @param outEdge
	 * @author Mouadh
	 */
	public void removeOutEdge(OutEdge outEdge) {
		this.outEdges.remove(outEdge.getId());
	}
	
	/**
	 * @author Gabriel
	 * Cette methode permet d'effectuer une transition de jeton entre les places connectees a 
	 * transition
	 * @author Mouadh
	 */
	public void step() {
		Set<String> outEdgeKeys = this.outEdges.keySet();
		//on parcours l'ensemble des OutEdge et on preleve les jetons si possibles
		for(String outKey : outEdgeKeys) {
			this.outEdges.get(outKey).trigger();
		}
		//On fait la meme chose avec les arcs entrant cette fois
		Set<String> inEdgeKeys = this.inEdges.keySet();
		for(String inKey : inEdgeKeys) {
			this.inEdges.get(inKey).trigger();
		}
		
	}
	
	/**
	 * Cette methode affiche une transition en affichant uniquement son id
	 * id sous la forme tn avec n le numero de la transition
	 * @author Mouadh
	 */
	public String toString() {
		return "ID : "+ this.id;
	}
	
	/**
	 * @author Mouadh
	 * Cette methode renvoie l'ensemble des InEdge connecte a la transition
	 * @return affichage
	 */
	public String toStringInEdges() {
		Set<String> inEdgeKeys = this.inEdges.keySet();
		String affichage = "Ensemble des InEdge : {";
		for(String inKey : inEdgeKeys) {
			affichage +=  this.inEdges.get(inKey).toString() + "," + "\n";
		}
		affichage += "}";
		return affichage;
	}
	
	
	/**
	 * @author Mouadh
	 * Cette methode renvoie l'ensemble des OutEdge connecte a la transition
	 * @return affichage
	 */
	public String toStringOutEdges() {
		Set<String> ouEdgeKeys = this.outEdges.keySet();
		String affichage = "Ensemble des OutEdge : {";
		for(String inKey : ouEdgeKeys) {
			affichage +=  this.outEdges.get(inKey).toString() + "," + "\n";
		}
		affichage += "}";
		return affichage;
	}
}
