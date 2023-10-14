package test;

import abstraction.EdgeZero;
import abstraction.NbrNegatifException;
import abstraction.OutEdge;
import abstraction.Place;
import abstraction.Transition;
import junit.framework.TestCase;

public class TestEdgeZero extends TestCase{
		
	public void testTrigger() {
		Place place;
		try {
			place = new Place(0, "p1");
			Transition transition = new Transition("t1");
	        OutEdge outEdge1 = new EdgeZero("ez1", place, transition);
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
