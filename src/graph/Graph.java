/**
@author: ABOUHAYDAR Elias - LIAFA Departement of Distributed Algorithms and Graphs
*/

package graph;

import java.util.ArrayList;

import structure.DoublyLinkedList;
import exceptions.InvalidIndexException;

public class Graph {
	private final int vertices;
	private int edges;
	private DoublyLinkedList<Vertex> map;
	private Classe c;
	
	/**
	 * Instanciate a graph with a defined number of vertices and no edges
	 */
	public Graph(int vertices){
		map = new DoublyLinkedList<Vertex>();
		this.vertices = vertices; 
		edges = 0;
		c = null;
	}
	
	/**
	 * Returns the number of vertices in the graph
	 * 
	 * @return number of vertices in the graph
	 */
	public int cardV() {
		return vertices;
	}
	
	/**
	 * Returns the numbers of edges in the graph
	 * 
	 * @return number of edges in the graph
	 */
	public int cardE() {
		return edges;
	}
	
	/**
	 * Adds a vertex to the graph
	 * @param x Represents the vertex objet that will be added the graph
	 */
	public void addVertex(Vertex x) {
		try {
			map.add(x, map.size());
			x.setClasse(null);
		} catch (InvalidIndexException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * Defines a edge or a way between two vertices, doesn't allow doubles
	 * @param x1 first vertex
	 * @param x2 second vertex
	 */
	public void addEdge(Vertex x1,Vertex x2) {
		x1.addNeighbor(x2);
		x2.addNeighbor(x1);
		edges++;
	}
	
	/** 
	 * Returns a string representation of this collection. The string representation consists of a list of the collection's elements in the order they are returned by its iterator, enclosed in square brackets ("[]"). Adjacent elements are separated by the characters ", " (comma and space). Elements are converted to strings as by String.valueOf(Object). 
	 * This implementation creates an empty string buffer, appends a left square bracket, and iterates over the collection appending the string representation of each element in turn. After appending each element except the last, the string ", " is appended. Finally a right bracket is appended. A string is obtained from the string buffer, and returned.
	 * 
	 * Override : toString in class Object
	 * 
	 * @return a string representation of this collection
	 *
	 *
	 */
	@Override
	public String toString() {
		return map.toString();
	}
	
	/**
	 * Returns the vertex at index i 
	 * @param i index of the vertex needed
	 * @return the vertex at index i
	 */
	public Vertex atIndex(int i){
		return (Vertex) map.atIndex(i);
	}
	
}