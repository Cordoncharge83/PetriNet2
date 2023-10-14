package test;

import java.util.HashMap;

import abstraction.AlreadyEdgeExistingError;
import abstraction.EdgeDrain;
import abstraction.EdgeZero;
import abstraction.InEdge;
import abstraction.NbrNegatifException;
import abstraction.OutEdge;
import abstraction.Place;
import abstraction.Transition;
import abstraction.Utilisateur;
import junit.framework.TestCase;

public class TestUtilisateur extends TestCase {
	
	/**
	 * @author Gabriel
	 * @Test
	 * Ce methode verifie que l'on arrive bien a creeer des places
	 * et que leurs id s'incrementent automatiquement
	 */
	public void testCreatePlace() {
		Utilisateur utilisateur = new Utilisateur();
		try {
			utilisateur.createPlace(10);
			utilisateur.createPlace(0);
			Place place = new Place(10,"p0");
			Place place1 = new Place(0,"p1");
			HashMap<String, Place> places = utilisateur.getPlaces();
			assertTrue((places.get("p0")).equals(place));
			assertTrue(places.get("p1").equals(place1));
		} catch (NbrNegatifException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	/**
	 * @author Gabriel
	 * @Test
	 * Ce methode verifie que l'on arrive bien a creeer des places
	 * et que leurs id s'incrementent automatiquement
	 */
	public void testCreatePlaceNegativeJeton() {
		Utilisateur utilisateur = new Utilisateur();
		try {
			utilisateur.createPlace(-1);
			fail("Expected NbrNegatifException");
		} catch (NbrNegatifException e) {
			
		}
		}
		
	
	/**
	 * @author Gabriel
	 * @Test
	 * Ce methode verifie que l'on arrive bien a creeer des transitions
	 * et que leurs id s'incrementent automatiquement
	 */
	public void testCreateTransition() {
		Utilisateur utilisateur = new Utilisateur();
		Transition transition = new Transition("t0");
		Transition transition1 = new Transition("t1");
		utilisateur.createTransition();
		utilisateur.createTransition();
		HashMap<String,Transition> transitions = utilisateur.getTransitions();
		assertTrue(transitions.get("t0").equals(transition));
		assertTrue(transitions.get("t1").equals(transition1));
	}
	
	/**
	 * @author Gabriel
	 * @Test
	 * Cette methode permet de voir si on arrive bien a creer un InEdge
	 * Elle teste aussi si les indices s'incrementent automatiquement et si
	 * les InEdge sont bien connectes aux places et transitions (on y a bien acces
	 * du cote des places et des transitions)
	 */
	public void testCreateInEdge() {
		Utilisateur utilisateur = new Utilisateur();
		try {
			try {
				utilisateur.createPlace(10);
				utilisateur.createPlace(5);
				utilisateur.createTransition();
				utilisateur.createTransition();
				Place place = new Place(10,"p0");
				Place place1 = new Place(5,"p1");
				Transition transition = new Transition("t0");
				Transition transition1 = new Transition("t1");
				
				//On essaie createInEdge()
				utilisateur.createInEdge(4, utilisateur.getPlaces().get("p0")
						, utilisateur.getTransitions().get("t0"));
				utilisateur.createInEdge(4, utilisateur.getPlaces().get("p1")
						, utilisateur.getTransitions().get("t1"));
				
				//On cree les InEdge qu'on est cense avoir cree avec createInEdge()
				InEdge inEdge = new InEdge(4,"ie0",place,transition);
				InEdge inEdge1 = new InEdge(4,"ie1",place1,transition1);
				
				//On verifie que les InEdge theoriques et experimentaux sont egaux et
				//qu'on y a bien acces a partir des places et des transitions
				assertTrue(utilisateur.getTransitions().get("t0").getInEdges().get("ie0").equals(inEdge));
				assertTrue(utilisateur.getPlaces().get("p1").getInEdges().get("ie1").equals(inEdge1));
			
			} catch (AlreadyEdgeExistingError e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (NbrNegatifException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * @author Gabriel
	 * @Test
	 * Cette methode permet de voir si createInEdge plante si on veut creer un InEdge
	 * entre place et transition s'il en existe deja un
	 */
	public void testCreateDuplicateInEdge() {
		Utilisateur utilisateur = new Utilisateur();
		try {
			try {
				utilisateur.createPlace(10);
				utilisateur.createPlace(5);
				utilisateur.createTransition();
				
				//On essaie createInEdge()
				utilisateur.createInEdge(4, utilisateur.getPlaces().get("p0")
						, utilisateur.getTransitions().get("t0"));
				utilisateur.createInEdge(4, utilisateur.getPlaces().get("p0")
						, utilisateur.getTransitions().get("t0"));
				fail("AlreadyExistingEdgeErros expected");
			} catch (AlreadyEdgeExistingError e) {
				
			}
		} catch (NbrNegatifException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * @author Gabriel
	 * @Test
	 * Cette methode permet de voir si on arrive bien a creer un OuEdge
	 * Elle teste aussi si les indices s'incrementent automatiquement et si
	 * les OutEdge sont bien connectes aux places et transitions (on y a bien acces
	 * du cote des places et des transitions)
	 */
	public void testCreateOutEdge() {
		Utilisateur utilisateur = new Utilisateur();
		try {
			utilisateur.createPlace(10);
			utilisateur.createPlace(5);
			utilisateur.createTransition();
			utilisateur.createTransition();
			Place place = new Place(10,"p0");
			Place place1 = new Place(5,"p1");
			Transition transition = new Transition("t0");
			Transition transition1 = new Transition("t1");
			
			//On essaie createOutEdge()
			utilisateur.createOutEdge(4, utilisateur.getPlaces().get("p0")
					, utilisateur.getTransitions().get("t0"));
			utilisateur.createOutEdge(4, utilisateur.getPlaces().get("p1")
					, utilisateur.getTransitions().get("t1"));
			
			//On cree les InEdge qu'on est cense avoir cree avec createOutEdge()
			OutEdge outEdge = new OutEdge(4,"oe0",place,transition);
			OutEdge outEdge1 = new OutEdge(4,"oe1",place1,transition1);
			
			//On verifie que les OutEdge theoriques et experimentaux sont egaux et
			//qu'on y a bien acces a partir des places et des transitions
			assertTrue(utilisateur.getTransitions().get("t0").getOutEdges().get("oe0").equals(outEdge));
			assertTrue(utilisateur.getPlaces().get("p1").getOutEdges().get("oe1").equals(outEdge1));
		} catch (NbrNegatifException | AlreadyEdgeExistingError e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * @author Gabriel
	 * @Test
	 * Cette methode permet de voir si createOutEdge plante bien s'il exite deja
	 * un OutEdge reliant place et transition (quel que soit l'Edge de sorti)
	 */
	public void testCreateDuplicateOutEdge() {
		Utilisateur utilisateur = new Utilisateur();
		try {
			utilisateur.createPlace(10);
			utilisateur.createPlace(5);
			utilisateur.createTransition();
			utilisateur.createTransition();
			
			//On essaie createOutEdge()
			utilisateur.createOutEdge(4, utilisateur.getPlaces().get("p0")
					, utilisateur.getTransitions().get("t0"));
			utilisateur.createOutEdge(4, utilisateur.getPlaces().get("p0")
					, utilisateur.getTransitions().get("t0"));
			utilisateur.createEdgeDrain( utilisateur.getPlaces().get("p0")
					, utilisateur.getTransitions().get("t0"));
			utilisateur.createEdgeZero( utilisateur.getPlaces().get("p0")
					, utilisateur.getTransitions().get("t0"));
			fail("AlreadyExistingEdgeErros expected");
		} catch (NbrNegatifException | AlreadyEdgeExistingError e) {
		}
	}
	
	
	/**
	 * @author Gabriel
	 * @Test
	 * Cette methode permet de voir si la methode createOutEdge() renvoie une erreur
	 * quand on l'utilise avec une value <=0
	 */
	public void testCreateOutEdgeValueNullNegetive() {
		Utilisateur utilisateur = new Utilisateur();
		try {
			utilisateur.createPlace(10);
			utilisateur.createTransition();
			
			//On essaie createOutEdge()
			utilisateur.createOutEdge(0, utilisateur.getPlaces().get("p0")
					, utilisateur.getTransitions().get("t0"));	
			//On essaie createOutEdge()
			utilisateur.createOutEdge(-1, utilisateur.getPlaces().get("p0")
					, utilisateur.getTransitions().get("t0"));	
			fail("Expected NbrNegatifException");
		} catch (NbrNegatifException | AlreadyEdgeExistingError e) {
		}
	}
	

	/**
	 * @author Gabriel
	 * @Test
	 * Cette methode permet de voir si la methode createInEdge() renvoie une erreur
	 * quand on l'utilise avec une value <=0
	 */
	public void testCreateInEdgeValueNullNegetive() {
		Utilisateur utilisateur = new Utilisateur();
		try {
			utilisateur.createPlace(10);
			utilisateur.createTransition();
			
			//On essaie createOutEdge()
			utilisateur.createInEdge(0, utilisateur.getPlaces().get("p0")
					, utilisateur.getTransitions().get("t0"));	
			//On essaie createOutEdge()
			utilisateur.createInEdge(-1, utilisateur.getPlaces().get("p0")
					, utilisateur.getTransitions().get("t0"));	
			fail("Expected NbrNegatifException");
		} catch (NbrNegatifException e) {
		} catch (AlreadyEdgeExistingError e) {
		}
	}
	
	/**
	 * @author Gabriel
	 * @Test
	 * Cette methode permet de voir si on arrive bien a creer un EdgeZero
	 * Elle teste aussi si les indices s'incrementent automatiquement et si
	 * les EdgeZero sont bien connectes aux places et transitions (on y a bien acces
	 * du cote des places et des transitions)
	 */
	public void testCreateEdgeZero() {
		Utilisateur utilisateur = new Utilisateur();
		try {
			utilisateur.createPlace(10);
			utilisateur.createPlace(5);
			utilisateur.createTransition();
			utilisateur.createTransition();
			Place place = new Place(10,"p0");
			Place place1 = new Place(5,"p1");
			Transition transition = new Transition("t0");
			Transition transition1 = new Transition("t1");
			
			//On essaie createEdgeZero()
			utilisateur.createEdgeZero(utilisateur.getPlaces().get("p0")
					, utilisateur.getTransitions().get("t0"));
			utilisateur.createEdgeZero(utilisateur.getPlaces().get("p1")
					, utilisateur.getTransitions().get("t1"));
			
			//On cree les EdgeZero qu'on est cense avoir cree avec createEdgeZero()
			EdgeZero edgeZero = new EdgeZero("ez0",place,transition);
			EdgeZero edgeZero1 = new EdgeZero("ez1",place1,transition1);
			
			//On verifie que les EdgeZero theoriques et experimentaux sont egaux et
			//qu'on y a bien acces a partir des places et des transitions
			assertTrue(utilisateur.getTransitions().get("t0").getOutEdges().get("ez0").equals(edgeZero));
			assertTrue(utilisateur.getPlaces().get("p1").getOutEdges().get("ez1").equals(edgeZero1));
		} catch (NbrNegatifException | AlreadyEdgeExistingError e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * @author Gabriel
	 * @Test
	 * Cette methode permet de voir si createEdgeZero() plante bien s'il exite deja
	 * un OutEdge reliant place et transition (quel que soit l'Edge de sorti)
	 */
	public void testCreateDuplicateEdgeZero() {
		Utilisateur utilisateur = new Utilisateur();
		try {
			utilisateur.createPlace(10);
			utilisateur.createPlace(5);
			utilisateur.createTransition();
			utilisateur.createTransition();
			
			//On essaie de creer plusieurs Edge de sortie entre place et transition
			utilisateur.createEdgeZero( utilisateur.getPlaces().get("p0")
					, utilisateur.getTransitions().get("t0"));
			utilisateur.createEdgeZero(utilisateur.getPlaces().get("p0")
					, utilisateur.getTransitions().get("t0"));
			utilisateur.createOutEdge(4, utilisateur.getPlaces().get("p0")
					, utilisateur.getTransitions().get("t0"));
			utilisateur.createEdgeDrain( utilisateur.getPlaces().get("p0")
					, utilisateur.getTransitions().get("t0"));
			fail("AlreadyExistingEdgeErros expected");
		} catch (NbrNegatifException | AlreadyEdgeExistingError e) {
		}
	}
	
	/**
	 * @author Gabriel
	 * @Test
	 * Cette methode permet de voir si on arrive bien a creer un EdgeDrain
	 * Elle teste aussi si les indices s'incrementent automatiquement et si
	 * les EdgeDrain sont bien connectes aux places et transitions (on y a bien acces
	 * du cote des places et des transitions)
	 */
	public void testCreateEdgeDrain() {
		Utilisateur utilisateur = new Utilisateur();
		try {
			utilisateur.createPlace(10);
			utilisateur.createPlace(5);
			utilisateur.createTransition();
			utilisateur.createTransition();
			Place place = new Place(10,"p0");
			Place place1 = new Place(5,"p1");
			Transition transition = new Transition("t0");
			Transition transition1 = new Transition("t1");
			
			//On essaie createEdgeDrain()
			utilisateur.createEdgeDrain(utilisateur.getPlaces().get("p0")
					, utilisateur.getTransitions().get("t0"));
			utilisateur.createEdgeDrain(utilisateur.getPlaces().get("p1")
					, utilisateur.getTransitions().get("t1"));
			
			//On cree les EdgeDrain qu'on est cense avoir cree avec createEdgeDrain()
			EdgeDrain edgeDrain = new EdgeDrain("ed0",place,transition);
			EdgeDrain edgeDrain1 = new EdgeDrain("ed1",place1,transition1);
			
			//On verifie que les EdgeDrain theoriques et experimentaux sont egaux et
			//qu'on y a bien acces a partir des places et des transitions
			assertTrue(utilisateur.getTransitions().get("t0").getOutEdges().get("ed0").equals(edgeDrain));
			assertTrue(utilisateur.getPlaces().get("p1").getOutEdges().get("ed1").equals(edgeDrain1));
		} catch (NbrNegatifException | AlreadyEdgeExistingError e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * @author Gabriel
	 * @Test
	 * Cette methode permet de voir si createEdgeDrain() plante bien s'il exite deja
	 * un OutEdge reliant place et transition (quel que soit l'Edge de sorti)
	 */
	public void testCreateDuplicateEdgeDrain() {
		Utilisateur utilisateur = new Utilisateur();
		try {
			utilisateur.createPlace(10);
			utilisateur.createPlace(5);
			utilisateur.createTransition();
			utilisateur.createTransition();
			
			//On essaie de creer plusieurs Edge de sortie entre place et transition
			utilisateur.createEdgeDrain( utilisateur.getPlaces().get("p0")
					, utilisateur.getTransitions().get("t0"));
			utilisateur.createEdgeZero(utilisateur.getPlaces().get("p0")
					, utilisateur.getTransitions().get("t0"));
			utilisateur.createOutEdge(4, utilisateur.getPlaces().get("p0")
					, utilisateur.getTransitions().get("t0"));
			utilisateur.createEdgeDrain( utilisateur.getPlaces().get("p0")
					, utilisateur.getTransitions().get("t0"));
			fail("AlreadyExistingEdgeErros expected");
		} catch (NbrNegatifException | AlreadyEdgeExistingError e) {
		}
	}
	
	/**
	 * @author Gabriel
	 * @Test
	 * Cette verifie que removeInEdge() deconnecte bien inEdge de place et de transition
	 * avant de le detruire
	 */
	public void testRemoveInEdge() {
		Utilisateur utilisateur = new Utilisateur();
		try {
			utilisateur.createPlace(10);
			utilisateur.createPlace(5);
			utilisateur.createTransition();
			utilisateur.createTransition();
			
			//On crees des inEdge
			utilisateur.createInEdge(10,utilisateur.getPlaces().get("p0")
					, utilisateur.getTransitions().get("t0"));
			utilisateur.createInEdge(15,utilisateur.getPlaces().get("p1")
					, utilisateur.getTransitions().get("t1"));
			
			//On detruit le premier inEdge (celui avec l'id ie0)
			utilisateur.removeInEdge(new InEdge(10,"ie0",utilisateur.getPlaces().get("p0")
					, utilisateur.getTransitions().get("t0")));
			
			//On verifie que la place et la transition ne sont plus attachees entre 
			//entre elles via inEdge
			assertFalse(utilisateur.getPlaces().get("p0").getInEdges().containsKey("ie0"));
			assertFalse(utilisateur.getTransitions().get("t0").getInEdges().containsKey("ie0"));
			
		} catch (NbrNegatifException | AlreadyEdgeExistingError e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * @author Gabriel
	 * @Test
	 * Cette verifie que removeInEdge() deconnecte bien inEdge de place et de transition
	 * avant de le detruire
	 */
	public void testRemoveOutEdge() {
		Utilisateur utilisateur = new Utilisateur();
		try {
			utilisateur.createPlace(10);
			utilisateur.createPlace(5);
			utilisateur.createTransition();
			utilisateur.createTransition();
			
			//On crees des inEdge
			utilisateur.createOutEdge(10,utilisateur.getPlaces().get("p0")
					, utilisateur.getTransitions().get("t0"));
			utilisateur.createOutEdge(15,utilisateur.getPlaces().get("p1")
					, utilisateur.getTransitions().get("t1"));
			
			//On detruit le premier outEdge (celui avec l'id oe0)
			utilisateur.removeOutEdge(new OutEdge(10,"oe0",utilisateur.getPlaces().get("p0")
					, utilisateur.getTransitions().get("t0")));
			
			//On verifie que la place et la transition ne sont plus attachees entre 
			//entre elles via inEdge
			assertFalse(utilisateur.getPlaces().get("p0").getOutEdges().containsKey("oe0"));
			assertFalse(utilisateur.getTransitions().get("t0").getOutEdges().containsKey("oe0"));
			
		} catch (NbrNegatifException | AlreadyEdgeExistingError e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * @author Gabriel
	 * @Test
	 * On verifie que cette methode detruise bien la Place place
	 * apres avoir deconnecte les edges de la place
	 */
	public void testRemovePlace() {
		Utilisateur utilisateur = new Utilisateur();
		try {
			utilisateur.createPlace(10);
			utilisateur.createTransition();
			utilisateur.createTransition();
			
			//On crees des inEdge
			utilisateur.createOutEdge(10,utilisateur.getPlaces().get("p0")
					, utilisateur.getTransitions().get("t0"));
			utilisateur.createInEdge(15,utilisateur.getPlaces().get("p0")
					, utilisateur.getTransitions().get("t1"));
			
			//On detruit la place (celle avec l'id p0)
			utilisateur.removePlace(utilisateur.getPlaces().get("p0"));
			
			//On verifie que les edge sont deconnectes de place 
			assertFalse(utilisateur.getTransitions().get("t0").getOutEdges().get("oe0").getPlace() != null);
			assertFalse(utilisateur.getTransitions().get("t1").getInEdges().get("ie0").getPlace() != null);
			
		} catch (NbrNegatifException | AlreadyEdgeExistingError e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * @author Gabriel
	 * @Test
	 * On verifie que cette methode detruise bien la Transition transition
	 * apres avoir deconnecte les edges de la transition
	 */
	public void testRemoveTransition() {
		Utilisateur utilisateur = new Utilisateur();
		try {
			utilisateur.createPlace(10);
			utilisateur.createPlace(24);
			utilisateur.createTransition();
			
			//On crees des edges
			utilisateur.createOutEdge(10,utilisateur.getPlaces().get("p0")
					, utilisateur.getTransitions().get("t0"));
			utilisateur.createInEdge(15,utilisateur.getPlaces().get("p1")
					, utilisateur.getTransitions().get("t0"));
			
			//On detruit la place (celle avec l'id p0)
			utilisateur.removeTransition(utilisateur.getTransitions().get("t0"));
			
			//On verifie que les edge sont deconnectes de place 
			assertFalse(utilisateur.getPlaces().get("p0").getOutEdges().get("oe0").getTransition()!= null);
			assertFalse(utilisateur.getPlaces().get("p1").getInEdges().get("ie0").getTransition() != null);
			
		} catch (NbrNegatifException | AlreadyEdgeExistingError e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * @author Gabriel
	 * @Test
	 * Cette methode verifie que addJeton() ajoute bien le bon nombre de jeton
	 * pour un nombre de jeton >= 0 
	 */
	public void testAddJeton() {
		Utilisateur utilisateur = new Utilisateur();
		try {
			utilisateur.createPlace(0);
			utilisateur.addJeton(utilisateur.getPlaces().get("p0"), 10);
			assertEquals(10,utilisateur.getPlaces().get("p0").getJeton());
		} catch (NbrNegatifException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * @author Gabriel
	 * @Test
	 * Cette methode verifie que addJeton() plante si on ajoute un nbr de jeton < 0 
	 */
	public void testAddJetonNegatif() {
		Utilisateur utilisateur = new Utilisateur();
		try {
			utilisateur.createPlace(0);
			utilisateur.addJeton(utilisateur.getPlaces().get("p0"), -1);
			fail("Expected NbrNegatifException");
		} catch (NbrNegatifException e) {

		}
	}
	
	/**
	 * @author Gabriel
	 * @Test
	 * Cette methode verifie que removeJeton() retire bien le bon nombre de jeton
	 * pour un nombre de jeton <= 0 
	 */
	public void testRemoveJeton() {
		Utilisateur utilisateur = new Utilisateur();
		try {
			utilisateur.createPlace(100);
			utilisateur.removeJeton(utilisateur.getPlaces().get("p0"), -10);
			assertEquals(90,utilisateur.getPlaces().get("p0").getJeton());
		} catch (NbrNegatifException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * @author Gabriel
	 * @Test
	 * Cette methode verifie que removeJeton() plante pour un nombre de jeton > 0 
	 */
	public void testRemoveJetonPositif() {
		Utilisateur utilisateur = new Utilisateur();
		try {
			utilisateur.createPlace(100);
			utilisateur.removeJeton(utilisateur.getPlaces().get("p0"), 10);
			fail("Expected NbrNegatifException");
		} catch (NbrNegatifException e) {

		}
	}
	
	/**
	 * @author Gabriel
	 * @Test
	 * Cette methode verifie que removeJeton() plante pour un nombre de jeton trop 
	 * grand en valeur absolue 
	 */
	public void testRemoveJetonTooBig() {
		Utilisateur utilisateur = new Utilisateur();
		try {
			utilisateur.createPlace(10);
			utilisateur.removeJeton(utilisateur.getPlaces().get("p0"), -11);
			fail("Expected NbrNegatifException");
		} catch (NbrNegatifException e) {

		}
	}
	
	/**
	 * @author Gabriel
	 * @Test
	 * Cette methode verifie que setValue() change bien la value de l'edge choisit
	 * Cette methode s'assure aussi que le changement se voit du cote de la transition
	 * et de la place
	 */
	public void testSetValueEdge() {
		Utilisateur utilisateur = new Utilisateur();
		try {
			utilisateur.createPlace(10);
			utilisateur.createPlace(24);
			utilisateur.createTransition();
			utilisateur.createTransition();
			
			//On crees des edges
			utilisateur.createOutEdge(10,utilisateur.getPlaces().get("p0")
					, utilisateur.getTransitions().get("t0"));
			utilisateur.createInEdge(15,utilisateur.getPlaces().get("p1")
					, utilisateur.getTransitions().get("t1"));
			
			//On change la value de l'inEdge et de l'outEdge
			utilisateur.setValueEdge(utilisateur.getPlaces().get("p0").getOutEdges().get("oe0"), 9);
			utilisateur.setValueEdge(utilisateur.getTransitions().get("t1").getInEdges().get("ie0"),20);
			
			//On verifie que les values des edges ont ete changees des deus cotes
			assertEquals(utilisateur.getPlaces().get("p0").getOutEdges().get("oe0").getValue(),9);
			assertEquals(utilisateur.getTransitions().get("t0").getOutEdges().get("oe0").getValue(),9);
			assertEquals(utilisateur.getPlaces().get("p1").getInEdges().get("ie0").getValue(),20);
			assertEquals(utilisateur.getTransitions().get("t1").getInEdges().get("ie0").getValue(),20);
			
		} catch (NbrNegatifException | AlreadyEdgeExistingError e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * @author Gabriel
	 * @Test
	 * Cette methode verifie que setValue() plante si value <=0
	 */
	public void testSetValueEdgeNegativeOrNull() {
		Utilisateur utilisateur = new Utilisateur();
		try {
			utilisateur.createPlace(10);
			utilisateur.createTransition();
			
			//On crees des edges
			utilisateur.createOutEdge(10,utilisateur.getPlaces().get("p0")
					, utilisateur.getTransitions().get("t0"));
			
			//On change la value de l'outEdge
			utilisateur.setValueEdge(utilisateur.getPlaces().get("p0").getOutEdges().get("oe0"), 0);
			utilisateur.setValueEdge(utilisateur.getPlaces().get("p0").getOutEdges().get("oe0"), -152);
			
			fail("Expected NbrNegatifException");
			
		} catch (NbrNegatifException | AlreadyEdgeExistingError e) {
		}
	}
	
	/**
	 * @author Gabriel
	 * @Test
	 * Cette methode permet de s'assurer que tout notre Petri fonctionne correctement
	 */
	public void testStepAll() {
		Utilisateur utilisateur = new Utilisateur();
		try {
			//Places de sorties de jetons
			utilisateur.createPlace(10);
			utilisateur.createPlace(5);
			utilisateur.createPlace(3);
			utilisateur.createPlace(1);
			//Place d'entree de jeton
			utilisateur.createPlace(1);
			utilisateur.createPlace(10);
			//Transitions faisant le lien entre les 2
			utilisateur.createTransition();
			utilisateur.createTransition();
			
			//On crees des OutEdges
			utilisateur.createOutEdge(10,utilisateur.getPlaces().get("p0")
					, utilisateur.getTransitions().get("t0"));
			utilisateur.createEdgeDrain(utilisateur.getPlaces().get("p1")
					, utilisateur.getTransitions().get("t0"));
			utilisateur.createOutEdge(10,utilisateur.getPlaces().get("p2")
					, utilisateur.getTransitions().get("t1"));
			utilisateur.createEdgeZero(utilisateur.getPlaces().get("p3")
					, utilisateur.getTransitions().get("t1"));
			
			//On cree les InEdges
			utilisateur.createInEdge(10,utilisateur.getPlaces().get("p4")
					, utilisateur.getTransitions().get("t0"));
			utilisateur.createInEdge(10,utilisateur.getPlaces().get("p5")
					, utilisateur.getTransitions().get("t1"));
			
			//On declanche les transitions
			utilisateur.stepAll();
			
			//On verifie les valeurs des places de sortie
			assertEquals(utilisateur.getPlaces().get("p0").getJeton(),0);
			assertEquals(utilisateur.getPlaces().get("p1").getJeton(),0);
			assertEquals(utilisateur.getPlaces().get("p2").getJeton(),3);
			assertEquals(utilisateur.getPlaces().get("p3").getJeton(),1);
			
			//On verifie les valeurs des places d'entree
			assertEquals(utilisateur.getPlaces().get("p4").getJeton(),11);
			assertEquals(utilisateur.getPlaces().get("p5").getJeton(),20);
		} catch (NbrNegatifException | AlreadyEdgeExistingError e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
