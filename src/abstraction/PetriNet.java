package abstraction;

public interface PetriNet {
	
	/**
	 * Cette methode cree une Place possedant jeton jetons. Un identifiant lui est associee
	 * automatiquement
	 * @param jeton
	 * @throws JetonNegatifException 
	 */
	public void createPlace(int jeton) throws NbrNegatifException;
	
	/**
	 * Cette methode cree une Transition. Un identifiant lui est associee
	 * automatiquement
	 */
	public void createTransition();
	
	/**
	 * Cette methode cree un InEdge de valeur valeur. Un identifiant lui est associe
	 * automatiquement. Relie directement place et transition a l'edge
	 * @param value
	 * @param place
	 * @param transition
	 * @throws NbrNegatifException 
	 * @throws AlreadyEdgeExistingError 
	 */
	public void createInEdge(int value, Place place, Transition transition) throws NbrNegatifException, AlreadyEdgeExistingError;
	
	/**
	 * Cette methode cree un OutEdge de valeur valeur. Un identifiant lui est associe
	 * automatiquement. Relie directement place et transition a l'edge
	 *	@param value
	 * @param place
	 * @param transition
	 * @throws NbrNegatifException 
	 * @throws AlreadyEdgeExistingError 
	 */
	public void createOutEdge(int value, Place place, Transition transition) throws NbrNegatifException, AlreadyEdgeExistingError;
	
	/**
	 * Cette methode cree un EdgeZero de valeur 0 par default. Un identifiant lui est associe
	 * automatiquement. Relie directement place et transition a l'edge
	 * @param place
	 * @param transition
	 * @throws AlreadyEdgeExistingError 
	 */
	public void createEdgeZero(Place place, Transition transition) throws AlreadyEdgeExistingError;
	
	/**
	 * Cette methode cree un EdgeDrain de valeur 1 par default. Un identifiant lui est associe
	 * automatiquement. Relie directement place et transition a l'edge
	 * @param value
	 * @param place
	 * @param transition
	 * @throws AlreadyEdgeExistingError 
	 */
	public void createEdgeDrain(Place place, Transition transition) throws AlreadyEdgeExistingError;
	
	/**
	 * Cette methode detruit l'InEdge inEdge. Deconnecte la place et la transition de cette arc avant
	 * @param inEdge
	 */
	public void removeInEdge(InEdge inEdge);
	
	/**
	 * Cette methode detruit l'OutEdge outEdge. Deconnecte la place et la transition de cette arc avant
	 * @param inEdge
	 */
	public void removeOutEdge(OutEdge outEdge);
	
	/**
	 * Cette methode detruit une place. Deconnect les arcs connectes a cette place. 
	 * L'utilisateur doit trouver une nouvelle place a laquelle connecter l'arc apres
	 * @param place
	 */
	public void removePlace(Place place);
	
	/**
	 * Cette methode detruit une transition. Deconnect les arcs connectes a cette transition. 
	 * L'utilisateur doit trouver une nouvelle transition a laquelle connecter l'arc apres
	 * @param transition
	 */
	public void removeTransition(Transition transition);
	
	/**
	 * Cette methode ajoute jeton au nombre deja existant de jeton dans place
	 * @param place
	 * @param jeton
	 * @throws NbrNegatifException 
	 */
	public void addJeton(Place place, int jeton) throws NbrNegatifException;
	
	/**
	 * Cette methode retire jeton au nombre deja existant de jeton dans place
	 * @param place
	 * @param jeton
	 * @throws NbrNegatifException 
	 */
	public void removeJeton(Place place, int jeton) throws NbrNegatifException;
	
	/**
	 * Cette methode permet de connecter transition a l'InEdge inEdge
	 * @param inEdge
	 * @param tranisition
	 */
	public void connectInEdgeTransition(InEdge inEdge, Transition tranisition);
	
	/**
	 * Cette methode permet de connecter place a l'OutEdge outEdge
	 * @param outEdge
	 * @param transition
	 */
	public void connectOutEdgeTransition(OutEdge outEdge, Transition transition);
	
	/**
	 * Cette methode permet de connecter place a l'OutEdge outEdge
	 * @param outEdge
	 * @param transition
	 */
	public void connectInEdgePlace(InEdge inEdge, Place place);
	
	/**
	 * Cette methode permet de connecter place a l'OutEdge outEdge
	 * @param outEdge
	 * @param transition
	 */
	public void connectOutEdgePlace(OutEdge outEdge, Place place);
	
	/**
	 * Cette methode echange la valeur actuelle de edge avec value
	 * @param inEdge
	 * @param value
	 * @throws NbrNegatifException 
	 */
	public void setValueEdge(Edge edge, int value) throws NbrNegatifException;
	
	/**
	 * Cette methode permet de declancher le transfert de jeton entre toutes les places connectees
	 * a transition
	 * @param t
	 */
	public void step(Transition transition);
	
	/**
	 * Cette methode permet de declancher toutes les transitions
	 */
	public void stepAll();
}
