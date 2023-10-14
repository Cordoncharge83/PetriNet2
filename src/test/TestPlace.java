package test;

import java.util.Vector;


import abstraction.InEdge;
import abstraction.NbrNegatifException;
import abstraction.OutEdge;
import abstraction.Place;
import abstraction.Transition;
import junit.framework.TestCase;

public class TestPlace extends TestCase{
	
	/**
	 * @Test
	 * @author Gabriel
	 * Ce methode s'assure qu'on ne puisse creer une place avec un nombre de jeton negatif
	 */
	public void testConstructeur() {
		try {
			Place place = new Place(-3,"p1");
			fail("JetonNegatifException expected");
		} catch (NbrNegatifException e) {
			// TODO Auto-generated catch block
		}
		
	}
	/**
	 * @Test
	 * @BeforeAll
	 * @author Gabriel
	 * Cette methode teste si l'id renvoye est bien celui de place
	 */
	public void testGetId() {
		Place place;
		try {
			place = new Place(3,"p1");
			assertEquals("p1", place.getId());
		} catch (NbrNegatifException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("NbrNegatifException not expected");
		}
	}
	
	/**
	 * @Test
	 * @BeforeAll
	 * @author Gabriel
	 * Cette methode test si getJeton() renvoie la bonne valeur
	 */
	public void testGetJeton() {
		Place place;
		try {
			place = new Place(3,"p1");
			assertEquals(3, place.getJeton());
		} catch (NbrNegatifException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("NbrNegatifException not expected");
		}
	}
	
	/**
	 * @Test
	 * @author Gabriel
	 * Cette methode teste si transit transfert bien le bon nombre de jeton
	 * et qu'elle ne fonctionne pas si on veut retirer un nombre de jeton trop grand
	 */
	public void testTransit() {
		Place place;
		try {
			place = new Place(3,"p1");
			//On ajoute 5 jetons ==> jeton = 8
			place.transit(5);
			assertEquals(8, place.getJeton());
			//On retire 4 jetons ==> jeton = 4
			place.transit(-4);
			assertEquals(4,place.getJeton());
		} catch (NbrNegatifException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("NbrNegatifException not expected");
		}
	}
	
	/**
	 * @Test
	 * @author Gabriel
	 * Cette methode test si on a bien une exception si on retire trop de jeton
	 */
	public void testTransitException() {
		try {
			Place place = new Place(3,"p1");
			//On essaie de retirer trop de jetons
			place.transit(-10);
			fail("NbrNegatifException expected");
		} catch (NbrNegatifException e) {
			// TODO Auto-generated catch block
		}
	}
	
	/**
	 * @Test
	 * @author Gabriel
	 * Cette methode permet de tester la methode addOutEdge
	 */
	public void testAddOutEdge() {
		try {
			Place place = new Place(3,"p1");
			Transition transition = new Transition("t1");
			OutEdge outEdge = new OutEdge(2,"oe1",place,transition);
			place.addOutEdge(outEdge);
			assertTrue(outEdge.equals(place.getOutEdges().get("oe1")));
		} catch (NbrNegatifException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("Unexpected problem");
		}
	}
	
	/**
	 * @Test
	 * @Before
	 * @author Gabriel
	 * Cette methode permet de tester la validite de la methode addOutEdges(Vector<OutEdge> e)
	 *  de place
	 */
	public void testAddOutEdges() {
		Place place;
		try {
			place = new Place(3,"p1");
			Transition transition = new Transition("t1");
			OutEdge outEdge1 = new OutEdge(2,"oe1",place,transition);
			OutEdge outEdge2 = new OutEdge(2,"oe2",place,transition);
			Vector<OutEdge> vecOutEdge = new Vector<OutEdge>();
			vecOutEdge.add(outEdge1);
			vecOutEdge.add(outEdge2);
			place.addOutEdges(vecOutEdge);
			//On verifie que tous les outEdges dans notre vecteur sont bien dans l'attribut
			//outEdges de place
			for(OutEdge outEdge : vecOutEdge) {
				assertTrue(place.getOutEdges().containsKey(outEdge.getId()));
			}
		} catch (NbrNegatifException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("Unexpected problem");
		}
	}
	
	/**
	 * @Test
	 * @author Gabriel
	 * Cette methode permet de tester la methode addInEdge() de place
	 */
	public void testAddInEdge() {
		try {
			Place place = new Place(3,"p1");
			Transition transition = new Transition("t1");
			InEdge outEdge = new InEdge(2,"ie1",place,transition);
			place.addInEdge(outEdge);
			assertTrue(outEdge.equals(place.getInEdges().get("ie1")));
		} catch (NbrNegatifException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("Unexpected problem");
		}
	}
	
	/**
	 * @Test
	 * @Before
	 * @author Gabriel
	 * Cette methode permet de tester la validite de la methode addInEdges(Vector<InEdge> e)
	 *  de place
	 */
	public void testAddInEdges() {
		Place place;
		try {
			place = new Place(3,"p1");
			Transition transition = new Transition("t1");
			InEdge inEdge1 = new InEdge(2,"ie1",place,transition);
			InEdge inEdge2 = new InEdge(2,"ie2",place,transition);
			Vector<InEdge> vecInEdge = new Vector<InEdge>();
			vecInEdge.add(inEdge1);
			vecInEdge.add(inEdge2);
			place.addInEdges(vecInEdge);
			//On verifie que tous les outEdges dans notre vecteur sont bien dans l'attribut
			//outEdges de place
			for(InEdge inEdge : vecInEdge) {
				assertTrue(place.getInEdges().containsKey(inEdge.getId()));
			}
		} catch (NbrNegatifException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("Unexpected problem");
		}
	}
	
	/**
	 * @Test
	 * @author Gabriel
	 * Cette methode verifie que la methode toString() affiche comme on veut une place
	 */
	public void testToString() {
		try {
			Place place = new Place(3,"p1");
			assertEquals(place.toString(),"ID : p1, nbr jetons : 3");
		} catch (NbrNegatifException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("Unexpected problem");
		}
	}
	
	/**
	 * Cette methode verifie que removeInEdge() fonctionne correctement
	 * @Test
	 * @author Gabriel
	 */
	public void testRemoveInEdge() {
		try {
			Place place = new Place(3,"p1");
			Transition transition = new Transition("t1");
			InEdge inEdge1 = new InEdge(2,"ie1",place,transition);
			InEdge inEdge2 = new InEdge(2,"ie2",place,transition);
			InEdge inEdge3 = new InEdge(4,"ie3",place,transition);
			Vector<InEdge> vecInEdge = new Vector<InEdge>();
			vecInEdge.add(inEdge1);
			vecInEdge.add(inEdge2);
			place.addInEdges(vecInEdge);
			//On essaie de supprimer un InEdge qui n'est pas connecte a place
			place.removeInEdge(inEdge3);
			for(InEdge inEdge : vecInEdge) {
				assertTrue(place.getInEdges().containsKey(inEdge.getId()));
			}
			//On supprime inEdge2
			place.removeInEdge(inEdge2);
			assertTrue(place.getInEdges().containsKey(inEdge1.getId()));
			assertFalse(place.getInEdges().containsKey(inEdge2.getId()));
			
		} catch (NbrNegatifException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("Unexpected problem");
		}
	}
	
	/**
	 * Cette methode verifie que removeOutEdge() fonctionne correctement
	 * @Test
	 * @author Gabriel
	 */
	public void testRemoveOutEdge() {
		try {
			Place place = new Place(3,"p1");
			Transition transition = new Transition("t1");
			OutEdge outEdge1 = new OutEdge(2,"oe1",place,transition);
			OutEdge outEdge2 = new OutEdge(2,"oe2",place,transition);
			OutEdge outEdge3 = new OutEdge(4,"oe3",place,transition);
			Vector<OutEdge> vecOutEdge = new Vector<OutEdge>();
			vecOutEdge.add(outEdge1);
			vecOutEdge.add(outEdge2);
			place.addOutEdges(vecOutEdge);
			//On essaie de supprimer un InEdge qui n'est pas connecte a place
			place.removeOutEdge(outEdge3);
			for(OutEdge inEdge : vecOutEdge) {
				assertTrue(place.getOutEdges().containsKey(inEdge.getId()));
			}
			//On supprime inEdge2
			place.removeOutEdge(outEdge2);
			assertTrue(place.getOutEdges().containsKey(outEdge1.getId()));
			assertFalse(place.getOutEdges().containsKey(outEdge2.getId()));
			
		} catch (NbrNegatifException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("Unexpected problem");
		}
	}
	
	/**
	 * @Test
	 * @author Gabriel
	 * Ce test verifie la methode equals() de place
	 */
	public void testEquals() {
		try {
			Place place1 = new Place(3,"p0");
			Place place2 = new Place(3,"p0");
			Place place3 = new Place(4,"p0");
			Place place4 = new Place(3,"p1");
			assertEquals(place1,place2);
			assertFalse(place1.equals(place3));
			assertFalse(place1.equals(place4));
		} catch (NbrNegatifException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}


