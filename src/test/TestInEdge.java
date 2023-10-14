package test;

import abstraction.InEdge;
import abstraction.NbrNegatifException;
import abstraction.Place;
import abstraction.Transition;
import junit.framework.TestCase;

public class TestInEdge extends TestCase{
	
	/**
	 * @Test
	 * @author Gabriel
	 * Ce test permet de savoir si on leve bien d'une erreur si l'edge a une valeur <=0 
	 */
	public void testInEdgeValueNullOrNegative() {
		 Place place;
		try {
			place = new Place(10,"p1");
			Transition transition = new Transition("t1");
			InEdge inedge = new InEdge(-3,"ie1",place,transition);
			InEdge inedge1 = new InEdge(0,"ie2",place,transition);
			fail("NbrNegatifException expected");
		} catch (NbrNegatifException e) {
			// TODO Auto-generated catch block
		}
	 }
	 
	/**
	 * @Test
	 * @author Gabriel
	 * Ce test permet de savoir si on obtient bien la place connecte a l'InEdge
	 */
	public void testGetPlace() {
		try {
			Place place = new Place(10,"p0");
			Transition transition = new Transition("t1");
			InEdge inEdge = new InEdge(10,"ie1",place,transition);
			assertEquals(place,inEdge.getPlace());
			InEdge inEdge1 = new InEdge(10,"ie1",null,transition);
			assertTrue(inEdge1.getPlace() == null);
		} catch (NbrNegatifException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * @Test
	 * @author Gabriel
	 * Ce test permet de savoir si on obtient bien la transition connecte a l'InEdge
	 */
	public void testGetTransition() {
		try {
			Place place = new Place(10,"p0");
			Transition transition = new Transition("t1");
			InEdge inEdge = new InEdge(10,"ie1",place,transition);
			assertEquals(transition,inEdge.getTransition());
			InEdge inEdge1 = new InEdge(10,"ie1",place,null);
			assertTrue(inEdge1.getTransition() == null);
		} catch (NbrNegatifException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * @Test
	 * @author Gabriel
	 * Ce test verifie que setPlace() change bien la place connectee a inEdge
	 */
	 public void testSetPlace() {
		 try {
			Place place = new Place(10,"p0");
			InEdge inEdge = new InEdge(5,"ie1",null,null);
			inEdge.setPlace(place);
			assertTrue(inEdge.getPlace().equals(place));
		} catch (NbrNegatifException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 }
	 
	 /**
		 * @Test
		 * @author Gabriel
		 * Ce test verifie que setTransition() change bien la transition
		 * connectee a inEdge
		 */
		 public void testSetTransition() {
			 try {
				Transition transition = new Transition("t1");
				InEdge inEdge = new InEdge(5,"ie1",null,null);
				inEdge.setTransition(transition);
				assertTrue(inEdge.getTransition().equals(transition));
			} catch (NbrNegatifException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 }
		 
	 /**
	  * @Test
	  * @author Gabriel
	  * Cette methode veridie que l'affichage de toString() soit bien celui desire avec une place
	  * et une transition
	  */
	 public void testToStringWithPlace() {
	        Place place;
			try {
				place = new Place(5, "p1");
				Transition transition = new Transition("t1");
			    InEdge inEdge = new InEdge(10, "ie1", place, transition);
			    String result = inEdge.toString();
			    assertEquals("Id : ie1 Value: 10 Place : p1 Transition : t1", result);
			} catch (NbrNegatifException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				fail("Unexpected fail");
			}
	    }

	 /**
	  * @Test
	  * @author Gabriel
	  * Cette methode veridie que l'affichage de toString() soit bien celui desire sans place
	  * mais avec une transition
	  */
	    public void testToStringWithoutPlace() {
	        Transition transition = new Transition("t1");
	        InEdge inedge;
			try {
				inedge = new InEdge(10, "ie1", null, transition);
				String result = inedge.toString();
		        assertEquals("Id : ie1 Value: 10 Transition : t1", result);
			} catch (NbrNegatifException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				fail("Unexpected fail");
			}
	    }
	    
	    /**
		 * @Test
		 * @author Gabriel
		 * Cette methode veridie que l'affichage de toString() soit bien celui desire sans place
		 * et sans transition
		 */
		 public void testToStringWithoutTranstionWithoutPlace() {
		     InEdge inedge;
				try {
					inedge = new InEdge(10, "ie1", null,null);
					String result = inedge.toString();
			        assertEquals("Id : ie1 Value: 10", result);
				} catch (NbrNegatifException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					fail("Unexpected fail");
				}
		    }
		 
		 /**
		   * @Test
		   * @author Gabriel
		   * Cette methode veridie que l'affichage de toString() soit bien celui desire sans place
		   * et sans transition
		   */
			 public void testToStringWithoutTranstion() {
			     InEdge inedge;
					try {
						Place place = new Place(3,"p1");
						inedge = new InEdge(10, "ie1", place,null);
						String result = inedge.toString();
				        assertEquals("Id : ie1 Value: 10 Place : p1", result);
					} catch (NbrNegatifException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						fail("Unexpected fail");
					}
			    } 
    /**
     * @Test
     * @author Gabriel
     * Cette methode test la validite de la mthode redefinissant equals
     */
    public void testEquals() {
        Place place;
		try {
			place = new Place(5, "p1");
			 Transition transition = new Transition("t1");
		     InEdge edge1 = new InEdge(10, "ie1", place, transition);
		     InEdge edge2 = new InEdge(10, "ie1", place, transition);
		     InEdge edge3 = new InEdge(5, "ie3", place, transition);

		     assertTrue(edge1.equals(edge2));
		     assertFalse(edge1.equals(edge3));
		} catch (NbrNegatifException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("Unexpected fail");
		}
    }
    
    /**
     * @Test
     * @author Gabriel
     * On verifie bien que dans tous les cas on transfert un nombre de jeton a place egale a value de
     * inEdge
     */
    public void testTrigger() {
    	try {
			Place place = new Place(5,"p1");
			Transition transition = new Transition("t1");
			InEdge inEdge = new InEdge(3,"ie1",place,transition);
			//jeton +=3
			inEdge.trigger();
			assertEquals(8,place.getJeton());
			InEdge inEdge2 = new InEdge(1,"ie2",place,transition);
			//jeton +=1
			inEdge2.trigger();
			assertEquals(9,place.getJeton());
		} catch (NbrNegatifException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    /**
     * @author Gabriel
     * @Test
     * On regarde si la methode ne plante pas si InEdge n'est connecte a aucune place
     */
    public void testTriggerWithoutPlace() {
    	try {
			InEdge inEdge = new InEdge(4,"ie1",null,null);
			inEdge.trigger();
			//Si on est la c'est que trigger n'a pas bloque
			assertTrue(true);
		} catch (NbrNegatifException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}

