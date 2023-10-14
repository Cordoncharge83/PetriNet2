package test;

import abstraction.NbrNegatifException;
import abstraction.OutEdge;
import abstraction.Place;
import abstraction.Transition;
import junit.framework.TestCase;

public class TestOutEdge extends TestCase {
	
	/**
	 * @Test
	 * @author Mouadh
	 * Ce test permet de voir s'il y a bien une erreur si on utilise une value <=0 dans le constructeur
	 */
	public void testOutEdgeValueNullOrNegative() {
        try {
            Place place = new Place(10, "p1");
            Transition transition = new Transition("t1");
            OutEdge outEdge1 = new OutEdge(-3, "oe1", place, transition);
            OutEdge outEdge2 = new OutEdge(0, "oe2", place, transition);
            fail("NbrNegatifException expected");
        } catch (NbrNegatifException e) {
            // Exception expected
        }
    }
	
	/**
	 * @author Gabriel
	 * @Test
	 * Cette methode verifie que getTransition() renvoie bien la bonne transition
	 */
	public void testGetTransition() {
		try {
			Place place = new Place(10,"p0");
			Transition transition = new Transition("t1");
			OutEdge outEdge = new OutEdge(10,"oe1",place,transition);
			assertEquals(transition,outEdge.getTransition());
			OutEdge outEdge1 = new OutEdge(10,"oe1",place,null);
			assertTrue(outEdge1.getTransition() == null);
		} catch (NbrNegatifException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * @author Gabriel
	 * @Test
	 * Cette methode verifie que getPlace() renvoie bien la bonne place
	 */
	public void testGetPlace() {
		try {
			Place place = new Place(10,"p0");
			Transition transition = new Transition("t1");
			OutEdge outEdge = new OutEdge(10,"oe1",place,transition);
			assertEquals(place,outEdge.getPlace());
			OutEdge outEdge1 = new OutEdge(10,"oe1",null,transition);
			assertTrue(outEdge1.getPlace() == null);
		} catch (NbrNegatifException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * @author Gabriel
	 * @Test
	 * Cette methode verifie que setPlace() change bien la valeur de l'attribut place
	 * de outEdge
	 */
	public void testSetPlace() {
		try {
			Place place = new Place(10,"p0");
			OutEdge outEdge = new OutEdge(5,"oe1",null,null);
			outEdge.setPlace(place);
			assertTrue(outEdge.getPlace().equals(place));
		} catch (NbrNegatifException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * @author Gabriel
	 * @Test
	 * Cette methode verifie que setTransition() change bien la valeur de l'attribut 
	 * transition de outEdge
	 */
	public void testSetPTransition() {
		try {
			Transition transition = new Transition("t1");
			OutEdge outEdge = new OutEdge(5,"oe1",null,null);
			outEdge.setTransition(transition);
			assertTrue(outEdge.getTransition().equals(transition));
		} catch (NbrNegatifException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * @Test
	 * @author Mouadh
	 * Ce test permet de tester l'affichage de toString() quand l'OutEdge a une place et 
	 * une transition
	 */
	public void testToStringWithPlaceAndTransition() {
        Place place;
		try {
			place = new Place(5, "p1");
			Transition transition = new Transition("t1");
		    OutEdge outEdge = new OutEdge(10, "oe1", place, transition);
		    String result = outEdge.toString();
		    assertEquals("Id : oe1 Value: 10 Place : p1 Transition : t1", result);
		} catch (NbrNegatifException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("Unexpected error");
		}
    }
	
	/**
	 * @Test
	 * @author Mouadh
	 * Ce test permet de tester l'affichage de toString() quand l'OutEdge a une place et 
	 * pas de transition
	 */
	 public void testToStringWithPlaceOnly() {
	        Place place;
			try {
				place = new Place(5, "p1");
				 OutEdge outEdge = new OutEdge(10, "oe1", place, null);
			     String result = outEdge.toString();
			     assertEquals("Id : oe1 Value: 10 Place : p1", result);
			} catch (NbrNegatifException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				fail("Unexpected error");
			}
	    }
	 
	 /**
		 * @Test
		 * @author Mouadh
		 * Ce test permet de tester l'affichage de toString() quand l'OutEdge n'a pas de place et 
		 * mais est attache a une transition
		 */
	  public void testToStringWithTransitionOnly() {
	        Transition transition = new Transition("t1");
	        OutEdge outEdge;
			try {
				outEdge = new OutEdge(10, "oe1", null, transition);
				 String result = outEdge.toString();
			        assertEquals("Id : oe1 Value: 10 Transition : t1", result);
			} catch (NbrNegatifException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }
	  
	  /**
		 * @Test
		 * @author Mouadh
		 * Ce test permet de tester l'affichage de toString() quand l'OutEdge n'a ni de place ni 
		 * de transition
		 */
	  public void testToStringWithoutPlaceAndTransition() {
	        OutEdge outEdge;
			try {
				outEdge = new OutEdge(10, "oe1", null, null);
		        String result = outEdge.toString();
		        assertEquals("Id : oe1 Value: 10", result);
			} catch (NbrNegatifException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }
	  
	  /**
		 * @Test
		 * @author Mouadh
		 * Ce test permet de teste la validite de la redefinition de equals()
		 */
	  public void testEquals() {
	        try {
	            Place place = new Place(5, "p1");
	            Transition transition = new Transition("t1");
	            OutEdge outEdge1 = new OutEdge(10, "oe1", place, transition);
	            OutEdge outEdge2 = new OutEdge(10, "oe1", place, transition);
	            OutEdge outEdge3 = new OutEdge(5, "oe3", place, transition);

	            assertTrue(outEdge1.equals(outEdge2));
	            assertFalse(outEdge1.equals(outEdge3));
	        } catch (NbrNegatifException e) {
	            fail("Unexpected fail");
	        }
	    }
	  
	  /**
	   * @Test
	   * @author Mouadh
	   * Ce test permet de verfier que des jetons sont biens preleves de place lors d'une transition
	   * si value <= jeton
	   */
	  public void testTriggerJetonSupValue() {
		  Place place;
		try {
			place = new Place(5, "p1");
			Transition transition = new Transition("t1");
	        OutEdge outEdge1 = new OutEdge(3, "oe1", place, transition);
	        outEdge1.trigger();
	        //jeton - value = 2
	        assertEquals(2,place.getJeton());
	        OutEdge outEdge2 = new OutEdge(2, "oe2", place, transition);
	        outEdge2.trigger();
	        //jeton - value =0
	        assertEquals(0,place.getJeton());
		} catch (NbrNegatifException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			 fail("Unexpected error");
		}
	  }
	  
	  /**
	   * @Test
	   * @author Mouadh
	   * Ce test permet de verfier que des jetons  ne sont pas preleves de place lors d'une transition
	   * si value > jeton
	   */
	  public void testTriggerJetonInfValue() {
		  Place place;
			try {
				place = new Place(5, "p1");
				Transition transition = new Transition("t1");
		        OutEdge outEdge1 = new OutEdge(10, "oe1", place, transition);
		        outEdge1.trigger();
		        //jeton < value ==> Pas de transition
		        assertEquals(5,place.getJeton());		       
			} catch (NbrNegatifException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				 fail("Unexpected error");
			}
	  }
	  
	  /**
	     * @author Gabriel
	     * @Test
	     * On regarde si la methode ne plante pas si InEdge n'est connecte a aucune place
	     */
	    public void testTriggerWithoutPlace() {
	    	try {
				OutEdge outEdge = new OutEdge(4,"oe1",null,null);
				outEdge.trigger();
				//Si on est la c'est que trigger n'a pas bloque
				assertTrue(true);
			} catch (NbrNegatifException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }
}
