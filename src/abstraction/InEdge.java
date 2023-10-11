package abstraction;

import java.util.HashMap;

public class InEdge extends Edge{
	private Place place;
	
	/**
	 * On ne prend pas en compte les edges maintenant puisqu'on va les creer apres
	 * @param value
	 * @param id
	 * @param place
	 */
	public InEdge(int value, String id, Place place) {
		super(value, id);
		// TODO Auto-generated constructor stub
		this.place = place;
	}
	
	@Override
	public String toString() {
		return super.toString()+" Place : "+ this.place.toString();
	}
}
