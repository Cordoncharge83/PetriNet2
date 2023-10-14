package test;

import java.util.Vector;

import abstraction.EdgeDrain;
import abstraction.EdgeZero;
import abstraction.InEdge;
import abstraction.NbrNegatifException;
import abstraction.OutEdge;
import abstraction.Place;
import abstraction.Transition;
import junit.framework.TestCase;

public class TestTransition extends TestCase{
	
	/**
	 * @author Mouadh
	 * Cette methode test que ce qui est renvoye par getId() est bien l'id
	 */
	public void testGetId() {
		Transition transition = new Transition("t1");
		assertEquals("t1", transition.getId());
	}
	
	public void testEquals() {
		Transition transition = new Transition("t1");
		Transition transition1 = new Transition("t1");
		assertTrue(transition.equals(transition1));
	}
	/**
	 * @author Mouadh
	 * Cette methode test que ce qui est renvoye par getOutEdges() est bien l'ensemble des OutEdges
	 */
	public void testGetOutEdges() {
		 Transition transition = new Transition("t1");
	     OutEdge outEdge;
			try {
				outEdge = new OutEdge(5, "oe1", null, transition);
		        transition.addOutEdge(outEdge);
		        //outEdge est censer etre le seul outEdge de transition
		        for(String key : transition.getOutEdges().keySet()) {
		        	assertEquals(outEdge, transition.getOutEdges().get("oe1"));
		        }
			} catch (NbrNegatifException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				fail("Unexpected error");
			}
	}
	
	/**
	 * @author Mouadh
	 * Cette methode test que ce qui est renvoye par getInEdges() est bien l'ensemble des InEdges
	 */
	public void testGetInEdges() {
		 Transition transition = new Transition("t1");
	     InEdge inEdge;
			try {
				inEdge = new InEdge(5, "ie1", null, transition);
		        transition.addInEdge(inEdge);
		        //inEdge est censer etre le seul outEdge de transition
		        for(String key : transition.getInEdges().keySet()) {
		        	assertEquals(inEdge, transition.getInEdges().get("ie1"));
		        }
			} catch (NbrNegatifException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				fail("Unexpected error");
			}
	}
	
	/**
	 * @Test 
	 * @author Mouadh
	 * Cette methode regarde si on arrive bien a connecter un OutEdge a une transition
	 */
	public void testAddOutEdge() {
        Transition transition = new Transition("t1");
        OutEdge outEdge;
		try {
			outEdge = new OutEdge(5, "oe1", null, transition);
	        transition.addOutEdge(outEdge);
	        assertEquals(outEdge, transition.getOutEdges().get("oe1"));
		} catch (NbrNegatifException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("Unexpected error");
		}
    }
	
	/**
	 * @Test 
	 * @author Mouadh
	 * Cette methode regarde si on arrive bien a connecter un InEdge a une transition
	 */
	public void testAddInEdge() {
        Transition transition = new Transition("t1");
        InEdge inEdge;
		try {
			inEdge = new InEdge(5, "ie1", null, transition);
	        transition.addInEdge(inEdge);
	        assertEquals(inEdge, transition.getInEdges().get("ie1"));
		} catch (NbrNegatifException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("Unexpected error");
		}
    }
	
	/**
	 * @Test
	 * @author Mouadh
	 * Cette methode verifie que nous arrivons bien a connecter plusieurs OutEdge d'un coup a une
	 * transition
	 */
	public void testAddOutEdges() {
        Transition transition = new Transition("t1");
        OutEdge outEdge2;
		try {
			outEdge2 = new OutEdge(10, "oe2", null, transition);
	        OutEdge outEdge1 = new OutEdge(5, "oe1", null, transition);
	        Vector<OutEdge> outEdges = new Vector<OutEdge>();
	        outEdges.add(outEdge1);
	        outEdges.add(outEdge2);
	        transition.addOutEdge(outEdges);
	        assertEquals(outEdge1, transition.getOutEdges().get("oe1"));
	        assertEquals(outEdge2, transition.getOutEdges().get("oe2"));
		} catch (NbrNegatifException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("Unexpected error");
		}
    }
	
	/**
	 * @Test
	 * @author Mouadh
	 * Cette methode verifie que nous arrivons bien a connecter plusieurs InEdge d'un coup a une
	 * transition
	 */
	public void testAddInEdges() {
        Transition transition = new Transition("t1");
        InEdge inEdge1;
		try {
			inEdge1 = new InEdge(5, "ie1", null, transition);
	        InEdge inEdge2 = new InEdge(10, "ie2", null, transition);
	        Vector<InEdge> inEdges = new Vector<InEdge>();
	        inEdges.add(inEdge1);
	        inEdges.add(inEdge2);
	        transition.addInEdge(inEdges);
	        assertEquals(inEdge1, transition.getInEdges().get("ie1"));
	        assertEquals(inEdge2, transition.getInEdges().get("ie2"));
		} catch (NbrNegatifException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("Unexpected error");
		}
    }
	
	/**
	 * @Test
	 * @author Mouadh
	 * On verifie que removeInEdge() retire bien le inEdge voulu
	 */
	public void testRemoveInEdge() {
		Transition transition = new Transition("t1");
        InEdge inEdge1;
		try {
			inEdge1 = new InEdge(5, "ie1", null, transition);
	        InEdge inEdge2 = new InEdge(10, "ie2", null, transition);
	        Vector<InEdge> inEdges = new Vector<InEdge>();
	        inEdges.add(inEdge1);
	        inEdges.add(inEdge2);
	        transition.addInEdge(inEdges);
	        //On essaie de retirer inEdge1
	        transition.removeInEdge(inEdge1);
	        assertTrue(transition.getInEdges().containsKey(inEdge2.getId()));
	        assertFalse(transition.getInEdges().containsKey(inEdge1.getId()));
		} catch (NbrNegatifException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("Unexpected error");
		}
	}
	
	/**
	 * @Test
	 * @author Mouadh
	 * On verifie que removeOutEdge() retire bien le OutEdge voulu
	 */
	public void testRemoveOutEdge() {
		Transition transition = new Transition("t1");
		OutEdge outEdge1;
		try {
			outEdge1 = new OutEdge(5, "oe1", null, transition);
	        OutEdge outEdge2 = new OutEdge(10, "oe2", null, transition);
	        Vector<OutEdge> outEdges = new Vector<OutEdge>();
	        outEdges.add(outEdge1);
	        outEdges.add(outEdge2);
	        transition.addOutEdge(outEdges);
	        //On essaie de retirer outEdge1
	        transition.removeOutEdge(outEdge1);
	        assertTrue(transition.getOutEdges().containsKey(outEdge2.getId()));
	        assertFalse(transition.getOutEdges().containsKey(outEdge1.getId()));
		} catch (NbrNegatifException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("Unexpected error");
		}
	}
	
	
	/**
	 * @author Gabriel
	 * @Test
	 * Cette methode permet de verifier que l'affichage de toString() soit bien celui voulu
	 */
	public void testToString() {
        Transition transition = new Transition("t1");
        String result = transition.toString();
        assertEquals("ID : t1", result);
    }
	
	/**
	 * @author Gabriel
	 * @Test
	 * Cette methode permet de verifier que l'affichage de toStringInEdges() soit celui voulu
	 */
	 public void testToStringInEdges() {
	        Transition transition = new Transition("t1");
	        InEdge inEdge1;
			try {
				inEdge1 = new InEdge(5, "ie1", null, transition);
		        InEdge inEdge2 = new InEdge(10, "ie2", null, transition);
		        transition.addInEdge(inEdge1);
		        transition.addInEdge(inEdge2);
		        String result = transition.toStringInEdges();
		        assertEquals("Ensemble des InEdge : {Id : ie1 Value: 5 Transition : t1,\nId : ie2 Value: 10 Transition : t1,\n}", result);
			} catch (NbrNegatifException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				fail("Unexpected error");
			}
	    }
	 
	 /**
		 * @author Gabriel
		 * @Test
		 * Cette methode permet de verifier que l'affichage de toStringInEdges() soit celui voulu
		 */
		 public void testToStringOutEdges() {
		        Transition transition = new Transition("t1");
		        OutEdge outEdge1;
				try {
					outEdge1 = new OutEdge(5, "ie1", null, transition);
					OutEdge outEdge2 = new OutEdge(10, "ie2", null, transition);
			        transition.addOutEdge(outEdge1);
			        transition.addOutEdge(outEdge2);
			        String result = transition.toStringOutEdges();
			        assertEquals("Ensemble des OutEdge : {Id : ie1 Value: 5 Transition : t1,\nId : ie2 Value: 10 Transition : t1,\n}", result);
				} catch (NbrNegatifException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					fail("Unexpected error");
				}
		    }
		 
		 /**
		  * @Test
		  * @author Gabriel
		  * Cette methode regarde si la methode step() declenche bien un mouvement de jeton de toutes
		  * les places connectees a transition
		  */
		 public void testStep() {
			 try {
				//On cree les differents acteur de notre Petri
				Place place1 = new Place(5,"p1");
				Place place2 = new Place(4,"p2");
				Place place3 = new Place(0,"p3");
				Place inPlace = new Place(1,"p4");
				Transition transition = new Transition("t1");
				OutEdge outEdge = new OutEdge(3,"oe1",place1,transition);
				OutEdge edgeDrain = new EdgeDrain("ed1",place2,transition);
				OutEdge edgeZero = new EdgeZero("ez1",place3,transition);
				InEdge inEdge = new InEdge(6,"ie1",inPlace,transition);
				//On connect les edge aux places/transition
				transition.addOutEdge(outEdge);
				transition.addOutEdge(edgeDrain);
				transition.addOutEdge(edgeZero);
				transition.addInEdge(inEdge);
				place1.addOutEdge(outEdge);
				place2.addOutEdge(edgeDrain);
				place3.addOutEdge(edgeZero);
				inPlace.addInEdge(inEdge);
				//On active la methode step
				transition.step();
				//On verifie que les jetons ont bien bouge
				assertEquals(place1.getJeton(),2);
				assertEquals(place2.getJeton(),0);
				assertEquals(place3.getJeton(),0);
				assertEquals(inPlace.getJeton(),7);
			} catch (NbrNegatifException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 }
}
