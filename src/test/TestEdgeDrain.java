package test;

import abstraction.EdgeDrain;
import abstraction.EdgeZero;
import abstraction.NbrNegatifException;
import abstraction.OutEdge;
import abstraction.Place;
import abstraction.Transition;
import junit.framework.TestCase;

public class TestEdgeDrain extends TestCase{
	
	/**
	 * @Test
	 * @author Gabriel
	 * Cette methode verifie qu'on vide bien la place quand le nombre de jeton est sup a 1
	 */
	public void testTriggerJetonSup1() {
		Place place;
		try {
			place = new Place(40, "p1");
			Transition transition = new Transition("t1");
	        OutEdge outEdge1 = new EdgeDrain("ed1", place, transition);
	        outEdge1.trigger();
	        //On verifie qu'il n'y a bien pas de transition
	        assertEquals(0,place.getJeton());		       
		} catch (NbrNegatifException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			 fail("Unexpected error");
		}
	}
	
	/**
	 * @Test
	 * @author Gabriel
	 * Cette methode verifie qu'il ne se passe rien si jeton = 0 
	 */
	public void testTriggerJetonInf1() {
		Place place;
		try {
			place = new Place(0, "p1");
			Transition transition = new Transition("t1");
			OutEdge outEdge1 = new EdgeDrain("ed1", place, transition);
	        outEdge1.trigger();
	        //On verifie qu'il n'y a bien pas de transition
	        assertEquals(0,place.getJeton());		       
		} catch (NbrNegatifException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			 fail("Unexpected error");
		}
	}
}
