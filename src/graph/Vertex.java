/**
 * @author: ABOUHAYDAR Elias - LIAFA Departement of Distributed Algorithms and Graphs
 * 
 */

package graph;

import java.util.ArrayList;

import structure.Node;
import structure.Node2;

public class Vertex extends Node2 {
	private Classe c;
	private ArrayList<Vertex> neighbors;
	private boolean visited;

	/**
	 * Instanciate a new Vertex
	 * 
	 * @param data represents the information contained in the vertex
	 */
	public Vertex(Object data) {
		super(data);
		this.c = null;
		this.neighbors = new ArrayList<Vertex>();
		visited = false;
	}

	/**
	 * Instanciate a new Vertex and associate this vertex to a Class
	 * 
	 * @param data represents the information contained in the vertex
	 * @param c represents the Class associated to the vertex
	 */
	public Vertex(Object data,Classe c){
		super(data);
		this.c = c;
		this.neighbors = new ArrayList<Vertex>();
		visited = false;
	}

	/**
	 * 
	 * Instanciate a new Vertex
	 * 
	 * @param data represents the information contained in the vertex
	 * @param n1 previous vertex
	 * @param n2 next vertex
	 */
	public Vertex(Object data, Node2 n1, Node n2) {
		super(data, n1, n2);
	}

	public Classe getClasse() {
		return this.c;
	}

	public void setClasse(Classe c) {
		this.c = c;
	}

	public void addNeighbor(Vertex x) {
		this.neighbors.add(x);
	}

	public void removeNeighbor(Vertex x) {
		this.neighbors.remove(c.indexOf(x));
	}
	public ArrayList<Vertex> getNeighbors() {
		return this.neighbors;
	}

	public void visit(){
		visited = true;
	}

	public void unvisit(){
		visited = false;
	}
	
	public boolean visited(){
		return visited;
	}

}


