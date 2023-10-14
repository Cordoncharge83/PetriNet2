package test;


import abstraction.Edge;
import abstraction.NbrNegatifException;
import junit.framework.TestCase;

public class TestEdge extends TestCase{
	
	/**
	 * @Test
	 * Cette methode s'assure que la valeur d'un edge ne peut etre negative
	 */
	public void testEdgeValueNegative() {
		try {
			Edge edge = new Edge(-1,"e1");
			fail("Valeur de l'arc negative");
		} catch (NbrNegatifException e) {
			// TODO Auto-generated catch block

		}
	}
	
	/**
	 * @Test
	 * Cette methode s'assure que la valeur d'un edge ne peut etre nulle
	 */
	public void testEdgeNullValue() {
		try {
			Edge edge = new Edge(0,"e1");
			fail("Valeur de l'arc null");
		} catch (NbrNegatifException e) {
			// TODO Auto-generated catch block

		}
	}
	
	/**
	 * @Test
	 * Cette methode s'assure que la valeur donnee par getValue() est bien la value d'un edge
	 */
    public void testGetValue() {
		Edge edge;
		try {
			edge = new Edge(4,"e1");
			assertEquals(4, edge.getValue());
		} catch (NbrNegatifException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("Unexpected fail");
		}
    }

    /**
     * @Test
     * Cette methode s'assure que l'on arrive bien a changer la value d'un edge
     */
    public void testSetValue() {
    	Edge edge;
		try {
			edge = new Edge(4,"e1");
			edge.setValue(42);
	        assertEquals(42, edge.getValue());
		} catch (NbrNegatifException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("Unexpected fail");
		}
    }
    
    public void testSetValueNegativeOrNull() {
    	Edge edge;
		try {
			edge = new Edge(4,"e1");
			edge.setValue(0);
			edge.setValue(-1);
			fail("Excpected NbrNegatifException");
		} catch (NbrNegatifException e) {

		}
    }
    
    /**
     * @Test
     * Cette methode s'assure que l'identifiant renvoye est bien celui de edge
     */
    public void testGetId() {
    	Edge edge;
		try {
			edge = new Edge(4,"e1");
			assertEquals("e1", edge.getId());
		} catch (NbrNegatifException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("Unexpected fail");
		}
    }

    /**
     * @Test
     * Cette methode s'assure que l'affichage de toString() correspond bien a celui desire
     */
    public void testToString() {
    	Edge edge;
		try {
			edge = new Edge(4,"e1");
		     assertEquals("Id : e1 Value: 4", edge.toString());
		} catch (NbrNegatifException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("Unexpected fail");
		}
    }
}

