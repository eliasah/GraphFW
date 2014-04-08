/**
 * @author: ABOUHAYDAR Elias - LIAFA Departement of Distributed Algorithms and Graphs
 * 
 */

package structure;

public class Node2 extends DoubleLink {
	// Attributes
	private Object data;

	// Constructors
	public Node2(Object data) {
		this.data = data;
	}

	public Node2(Object data, Node2 n1, Node n2) {
		this.data = data;
		setPrev(n1);
		setNext(n2);
	}

	// Getters
	public Object getData() {
		return data;
	}

	public Node2 getNextNode2() {
		return (Node2) getNext();
	}

	public Node2 getPrevNode2() {
		return (Node2) getPrev();
	}

	// Setters
	public void setData(Object e) {
		data = e;
	}

	public void setNextNode2(Node2 n) {
		setNext(n);
	}

	public void setPrevNode2(Node2 n) {
		setPrev(n);
	}

	@Override
	public String toString() {
		return "< " + data + " >";
	}

}
