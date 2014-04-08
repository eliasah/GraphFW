/**
 * @author: ABOUHAYDAR Elias - LIAFA Departement of Distributed Algorithms and Graphs
 * 
 */

package structure;

public class Node extends Link {
	private Object data;

	public Node(Object data) {
		this.data = data;
	}

	public Node(Object data, Node n) {
		this.data = data;
		setNext(n);
	}

	public Object getData() {
		return data;
	}

	public Node getNextNode() {
		return (Node) getNext();
	}

	public void setData(Object data) {
		this.data = data;
	}

	public void setNextNode(Node n) {
		setNext(n);
	}

	@Override
	public String toString() {
		return "Node [data=" + data + "]";
	}

}
