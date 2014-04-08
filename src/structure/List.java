/**
 * @author: ABOUHAYDAR Elias - LIAFA Departement of Distributed Algorithms and Graphs
 * 
 */

package structure;

import exceptions.InvalidIndexException;

public interface List {

	/**
	 * Adds object o to the List at index i 
	 * @param o
	 * @param i
	 * @throws InvalidIndexException
	 */
	public void add(Object o, int i) throws InvalidIndexException;
	
	/**
	 * Returns the object at index i
	 * @param i
	 * @return the object at index i
	 * @throws InvalidIndexException
	 */
	public Object atIndex(int i) throws InvalidIndexException;

	/**
	 * Deletes the object at index i
	 * @param i
	 * @throws InvalidIndexException
	 */
	public void delete(int i) throws InvalidIndexException;

	/**
	 * Returns the size of the list
	 * @return the size of the list
	 */
	public int length();
}
