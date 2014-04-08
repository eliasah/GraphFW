/**
 * @author: ABOUHAYDAR Elias - LIAFA Departement of Distributed Algorithms and Graphs
 * 
 */

package structure;

public class DoubleLink extends Link {
	private Link prev;

	/**
	 * Returns previous Link
	 * 
	 * @return previous Link
	 */
	public Link getPrev() {
		return prev;
	}

	/**
	 * Sets previous Link
	 * @param l Link
	 */
	public void setPrev(Link l) {
		prev = l;
	}
}
