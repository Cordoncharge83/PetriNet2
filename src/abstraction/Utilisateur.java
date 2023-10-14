package abstraction;

import java.util.HashMap;

public class Utilisateur implements PetriNet{
	//id de la forme tn avec n le numero de la transition
	private HashMap<String, Transition> transitions;
	//id de la forme pn avec n le numero de la transition
	private HashMap<String, Place> places;
	
	private int nbrPlace;
	private int nbrTransition;
	//id de la forme ie + this.nbrInEdge
	private int nbrInEdge;
	//id de la forme oe + this.nbrOutEdge
	private int nbrOutEdge;
	//id de la forme ez + this.nbrEdgeZero
	private int nbrEdgeZero;
	//id de la forme ed + this.nbrEdgeDrain
	private int nbrEdgeDrain;
	
	public Utilisateur() {
		this.places = new HashMap<String,Place>();
		this.transitions = new HashMap<String,Transition>();
		
		this.nbrPlace = 0;
		this.nbrTransition = 0;
		this.nbrInEdge =0;
		this.nbrOutEdge = 0;
		this.nbrEdgeDrain = 0;
		this.nbrEdgeZero =0;
		
	}
	
	public HashMap<String, Transition> getTransitions() {
		return transitions;
	}
	
	public HashMap<String, Place> getPlaces() {
		return places;
	}
	
	/**
	 * @author Gabriel
	 * @Override
	 * @param jeton
	 * Cette methode cree une place avec un nombre de jeton egal a jeton
	 * L'id de la place est decide automatiquement
	 * Deux places n'ont jamais le meme id puisqu'on l'actualise a chaque fois
	 */
	public void createPlace(int jeton) throws NbrNegatifException {
		this.places.put("p" + this.nbrPlace,new Place(jeton,"p" + this.nbrPlace));
		this.nbrPlace+=1;

	}
	
	/**
	 * @author Gabriel
	 * @Override
	 * Cette methode cree une transition 
	 * L'id de la transition est decide automatiquement
	 * Deux transitions n'ont jamais le meme id puisqu'on l'actualise a chaque fois
	 */
	public void createTransition() {
		this.transitions.put("t" + this.nbrTransition, new Transition("t" + this.nbrTransition));
		
		this.nbrTransition +=1;
	}

	/**
	 * @author Gabriel
	 * @Override
	 * @param value
	 * @param place
	 * @param transition
	 * Cette methode cree un InEdge et le connecte a place et transition
	 * L'id de l'InEdge est calcule automatiquement de maniere a ce qu'il n'y ai jamais de doublon
	 * @throws NbrNegatifException 
	 * @throws AlreadyEdgeExistingError 
	 */
	public void createInEdge(int value, Place place, Transition transition) throws NbrNegatifException, AlreadyEdgeExistingError {
		InEdge inEdge;
		//On recupere l'ensemble des InEdges de place et de transition
		HashMap<String,InEdge> placeInEdge = place.getInEdges();
		HashMap<String,InEdge> transitionInEdge = transition.getInEdges();
		//On regarde si parmis les InEdges de place, il y en a un commun avec transition
		for(String keyPlace : placeInEdge.keySet()) {
			if(transitionInEdge.containsKey(keyPlace)) {
				//Si il y en a un commun entre place et transition on cree un erreur
				//puisqu'il ne peut avoir qu'un seul arc  dans le meme sens 
				//liant une place et une transition
				throw new AlreadyEdgeExistingError("Il existe deja un InEdge entre " 
				+ place.getId() +" et " + transition.getId());
			}
		}
		inEdge = new InEdge(value, "ie" + this.nbrInEdge,place,transition);
		place.addInEdge(inEdge);
		transition.addInEdge(inEdge);
			
		this.nbrInEdge+=1;
	}

	/**
	 * @Override
	 * @author Gabriel
	 * @param value
	 * @param place
	 * @param transition
	 * Cette methode cree un OutEdge et le connecte directement a place et tranisition
	 * @throws NbrNegatifException 
	 * @throws AlreadyEdgeExistingError 
	 */
	public void createOutEdge(int value, Place place, Transition transition) throws NbrNegatifException, AlreadyEdgeExistingError {
		//On recupere l'ensemble des OutEdges de place et de transition
		HashMap<String,OutEdge> placeOutEdge = place.getOutEdges();
		HashMap<String,OutEdge> transitionOutEdge = transition.getOutEdges();
		//On regarde si parmis les OutEdges de place, il y en a un commun avec transition
		for(String keyPlace : placeOutEdge.keySet()) {
			if(transitionOutEdge.containsKey(keyPlace)) {
				//Si il y en a un commun entre place et transition on cree un erreur
				//puisqu'il ne peut avoir qu'un seul arc  dans le meme sens 
				//liant une place et une transition
				throw new AlreadyEdgeExistingError("Il existe deja un OutEdge entre " 
				+ place.getId() +" et " + transition.getId());
			}
		}
		OutEdge outEdge;
			outEdge = new OutEdge(value, "oe" + this.nbrOutEdge,place,transition);
			//On connect l'edge a la place et a la transition
			place.addOutEdge(outEdge);
			transition.addOutEdge(outEdge);
			
			this.nbrOutEdge +=1;
	}

	/**
	 * @Override
	 * @author Gabriel
	 * @param place
	 * @param tranisiton
	 * Cette methode cree un EdgeZero et le connecte directement a place et transition
	 * @throws AlreadyEdgeExistingError 
	 */
	public void createEdgeZero(Place place, Transition transition) throws AlreadyEdgeExistingError {
		//On recupere l'ensemble des OutEdges de place et de transition
		HashMap<String,OutEdge> placeOutEdge = place.getOutEdges();
		HashMap<String,OutEdge> transitionOutEdge = transition.getOutEdges();
		//On regarde si parmis les OutEdges de place, il y en a un commun avec transition
		for(String keyPlace : placeOutEdge.keySet()) {
			if(transitionOutEdge.containsKey(keyPlace)) {
				//Si il y en a un commun entre place et transition on cree un erreur
				//puisqu'il ne peut avoir qu'un seul arc  dans le meme sens 
				//liant une place et une transition
				throw new AlreadyEdgeExistingError("Il existe deja un OutEdge entre " 
				+ place.getId() +" et " + transition.getId());
			}
		}
		OutEdge edgeZero;
		try {
			edgeZero = new EdgeZero("ez" + this.nbrEdgeZero,place,transition);
			//On connect l'edge a la place et a la transition
			place.addOutEdge(edgeZero);
			transition.addOutEdge(edgeZero);
			
			this.nbrEdgeZero+=1;
		} catch (NbrNegatifException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	/**
	 * @Override
	 * @author Gabriel
	 * @param place
	 * @param tranisiton
	 * Cette methode cree un EdgeDrain et le connecte directement a place et transition
	 * @throws AlreadyEdgeExistingError 
	 */
	public void createEdgeDrain(Place place, Transition transition) throws AlreadyEdgeExistingError {
		//On recupere l'ensemble des OutEdges de place et de transition
		HashMap<String,OutEdge> placeOutEdge = place.getOutEdges();
		HashMap<String,OutEdge> transitionOutEdge = transition.getOutEdges();
		//On regarde si parmis les OutEdges de place, il y en a un commun avec transition
		for(String keyPlace : placeOutEdge.keySet()) {
			if(transitionOutEdge.containsKey(keyPlace)) {
				//Si il y en a un commun entre place et transition on cree un erreur
				//puisqu'il ne peut avoir qu'un seul arc  dans le meme sens 
				//liant une place et une transition
				throw new AlreadyEdgeExistingError("Il existe deja un OutEdge entre " 
				+ place.getId() +" et " + transition.getId());
			}
		}
		OutEdge edgeDrain;
		try {
			edgeDrain = new EdgeDrain("ed" + this.nbrEdgeDrain,place,transition);
			//On connect l'edge a la place et a la transition
			place.addOutEdge(edgeDrain);
			transition.addOutEdge(edgeDrain);
			
			this.nbrEdgeDrain +=1;
		} catch (NbrNegatifException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @Override
	 * @author Gabriel
	 * @param inEdge
	 * Cette methode detruit inEdge. Le deconnecte de place et transiton
	 */
	public void removeInEdge(InEdge inEdge) {
		//On recupere la place connectee a l'InEdge et on detruit l'InEdge associe 
		//a cette place
		this.places.get(inEdge.getPlace().getId()).removeInEdge(inEdge);
		//Idem avec la transition
		this.transitions.get(inEdge.getTransition().getId()).removeInEdge(inEdge);
	}

	/**
	 * @Override
	 * @author Gabriel
	 * @param outEdge
	 * Cette methode detruit outEdge. Le deconnecte de place et transiton
	 */
	public void removeOutEdge(OutEdge outEdge) {
		//On recupere la place connectee a l'OutEdge et on detruit l'OutEdge associe 
		//a cette place
		this.places.get(outEdge.getPlace().getId()).removeOutEdge(outEdge);
		//Idem avec la transition
		this.transitions.get(outEdge.getTransition().getId()).removeOutEdge(outEdge);
		
	}

	/**
	 * @author Gabriel
	 * @Override
	 * @param place
	 * Cette methode permet de detruir une place
	 */
	public void removePlace(Place place) {
		//On deconnecte d'abbord les edges connectes a place avant de la detruir
		HashMap<String, InEdge> inEdges = this.places.get(place.getId()).getInEdges();
		HashMap<String, OutEdge> outEdges = this.places.get(place.getId()).getOutEdges();
		for(String inEdgeKey : inEdges.keySet()) {
			inEdges.get(inEdgeKey).setPlace(null);
		}
		for(String outEdgeKey : outEdges.keySet()) {
			outEdges.get(outEdgeKey).setPlace(null);
		}
		
		//On peux maintenant detruir la place
		this.places.remove(place.getId());
	}

	/**
	 * @author Gabriel
	 * @Override
	 * @param transition
	 * Cette methode permet de detruir une place
	 */
	public void removeTransition(Transition transition) {
		//On deconnecte d'abord les edges connectes a transition avant de la detruire
				HashMap<String, InEdge> inEdges = this.transitions.get(transition.getId()).getInEdges();
				HashMap<String, OutEdge> outEdges = this.transitions.get(transition.getId()).getOutEdges();
				for(String inEdgeKey : inEdges.keySet()) {
					inEdges.get(inEdgeKey).setTransition(null);
				}
				for(String outEdgeKey : outEdges.keySet()) {
					outEdges.get(outEdgeKey).setTransition(null);
				}
				
				//On peux maintenant detruir la place
				this.transitions.remove(transition.getId());
			}
	
	

	/**
	 * Cette methode permet de connecter transition a l'InEdge inEdge
	 * @param inEdge
	 * @param tranisition
	 */
	//On ne test pas cette methode dans TestUtilisateur puisqu'elle est deja 
	//testee dans TestInEdge
	public void connectInEdgeTransition(InEdge inEdge, Transition tranisition) {
		inEdge.setTransition(tranisition);
	}
	
	/**
	 * Cette methode permet de connecter place a l'OutEdge outEdge
	 * @param outEdge
	 * @param transition
	 */
	//On ne test pas cette methode dans TestUtilisateur puisqu'elle est deja 
	//testee dans TestOutEdge
	public void connectOutEdgeTransition(OutEdge outEdge, Transition transition) {
		outEdge.setTransition(transition);
	}
	
	/**
	 * Cette methode permet de connecter place a l'OutEdge outEdge
	 * @param outEdge
	 * @param transition
	 */
	//On ne test pas cette methode dans TestUtilisateur puisqu'elle est deja 
	//testee dans TestInEdge
	public void connectInEdgePlace(InEdge inEdge, Place place) {
		inEdge.setPlace(place);
	}
	
	/**
	 * Cette methode permet de connecter place a l'OutEdge outEdge
	 * @param outEdge
	 * @param transition
	 */
	//On ne test pas cette methode dans TestUtilisateur puisqu'elle est deja 
	//testee dans TestOutEdge
	public void connectOutEdgePlace(OutEdge outEdge, Place place) {
		outEdge.setPlace(place);
	}
	
	/**
	 * @Override
	 * @author Gabriel
	 * @param jeton
	 * @param place
	 * Cette methode permet d'ajouter jeton jetons a la Place place
	 * @throws NbrNegatifException 
	 */
	public void addJeton(Place place, int jeton) throws NbrNegatifException {
		if(jeton < 0 ) {
			throw new NbrNegatifException("Ajout de jeton negatif");
		}
		//Ajouter jeton jetons a une place revient a utiliser transit(jeton)
			this.places.get(place.getId()).transit(jeton);		
	}

	/**
	 * @Override
	 * @author Gabriel
	 * @param jeton
	 * @param place
	 * Cette methode permet de retirer jeton jetons a la Place place
	 */
	public void removeJeton(Place place, int jeton) throws NbrNegatifException {
		if(jeton > 0 ) {
			throw new NbrNegatifException("Retrait d'un nombre de jeton positif");
		}
		//Retirer jeton jetons a une place revient a utiliser transit( -jeton)
		//L'exception abs(jeton) > valeur est geree transit
		this.places.get(place.getId()).transit(jeton);		
		
	}

	/**
	 * @Override
	 * @author Gabriel
	 * @param inEdge
	 * @param value
	 * Cette methode modifie la value de l'Edge edge
	 * @throws NbrNegatifException 
	 */
	public void setValueEdge(Edge edge, int value) throws NbrNegatifException {
		edge.setValue(value);		
	}

	/**
	 * @Override
	 * @param transition
	 * @author Gabriel
	 * Cette methode declenche une le mouvement des jetons des places connectees a 
	 * transition
	 */
	//On ne test pas cette methode dans TestUtilisateur puisqu'elle est deja testee
	//dans TestTransition
	public void step(Transition transition) {
		transition.step();
		
	}

	/**@Override
	 * @author Gabriel
	 * Cette methode permet de declancher toutes les transitions
	 */
	public void stepAll() {
		HashMap<String, Transition> transitions = this.getTransitions();
		//On itere step() sur toutes les transitions existantes
		for(String keyTransition : transitions.keySet()) {
			transitions.get(keyTransition).step();
		}
		
	}

}
