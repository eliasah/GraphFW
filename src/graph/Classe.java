/**
@author: ABOUHAYDAR Elias - LIAFA Departement of Distributed Algorithms and Graphs
*/

package graph;

import java.util.ArrayList;

import structure.DoublyLinkedList;
import structure.Node2;
import exceptions.InvalidIndexException;

public class Classe<E> extends Node2 {
	private DoublyLinkedList<Vertex> vertices;
	private int size;
	private int visited;

	public Classe() {
		super(0);
		vertices = new DoublyLinkedList<Vertex>();
		size = 0;
		visited = 0;
	}

	public void addVertex(Vertex x) {
		try {
			vertices.add(x, vertices.size());
			x.setClasse(this);
			size++;
		} catch (InvalidIndexException e) {
			e.printStackTrace();
		}
	}
	
	public void addVertex(Vertex x,int i) throws InvalidIndexException {
		vertices.add(x, i);
		x.setClasse(this);
		size++;
	}
	
	
	/**
	 * This method removes a vertex from the Class.
	 * @param i
	 * @throws InvalidIndexException
	 */
	public void removeVertex(int i){
		try {
			vertices.delete(i);
		} catch (InvalidIndexException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public int size() {
		return vertices.size();
	}

	public String toString(){
		String str = "C = ";
		if (vertices.size()> 0){
			str+=" " + vertices.toString();
		}
		return str;
	}

	public int indexOf(Vertex x) {
		try {
			return vertices.indexOf(x);
		} catch (InvalidIndexException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return -1;
	}
	
	public DoublyLinkedList<Vertex> getVertices() {
		return vertices;
	}
	
	public void visit() {
		visited++;
	}
	
	public int visited() {
		return visited;
	}
	
	public void unvisit() {
		visited--;
	}
	
	public void rasvisit() {
		visited = 0;
	}
	
	public Vertex getVertex(int i) {
		return (Vertex) vertices.atIndex(i);
	}
}
