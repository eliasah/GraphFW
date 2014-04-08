/**
 * @author: ABOUHAYDAR Elias - LIAFA Departement of Distributed Algorithms and Graphs
 * 
 */

package algorithms;

import java.util.ArrayList;

import structure.DoublyLinkedList;
import exceptions.InvalidIndexException;
import graph.Classe;
import graph.Vertex;

public class Partition {

	private static final long serialVersionUID = 1L;
	private DoublyLinkedList<Classe> partition;
	private ArrayList<Vertex> pivots;

	/** 
	 * Instanciate a new Partition
	 */
	public Partition() {
		partition = new DoublyLinkedList<Classe>();
		pivots = new ArrayList<Vertex>();
	}

	/**
	 * This method adds an object to the partition
	 * 
	 * @param c
	 *            c can be a class of vertices, a clique, etc.
	 * @param i
	 *            int representing the index of the clique to add
	 * @throws InvalidIndexException
	 */
	public void add(Classe c, int i) throws InvalidIndexException {
		partition.add(c, i);
	}

	public void add(Classe c) {
		try {
			partition.add(c,partition.size());
		} catch (InvalidIndexException e) {
			e.printStackTrace();
		}
	}

	public int size() {
		return partition.size();
	}

	public void pivots(ArrayList<Vertex> S) throws InvalidIndexException {
		System.out.println("We associate every pivot vertex to its class");
		for(Vertex x : S){
			pivots.add(x);
			System.out.println(x.toString() + " => " + x.getClasse().toString());
		}
	}

	public void refine() throws InvalidIndexException{
		Classe c1, c2 = new Classe();
		ArrayList<Classe> L = new ArrayList<Classe>();
		System.out.println("--------------------------------------------------------------------------------------------");
		System.out.println("STEP 1 : ");
		
		// System.out.println("!!!! PIVOTS = " + pivots.toString() + " !!!!");
		
		for (Vertex x : pivots) {
			if (x.visited()) {
				// System.out.println(x.toString() + " visited");
				continue;
			}
			c1 = x.getClasse();
			c1.visit();
			System.out.println("VISITING " + c1.toString());
			int a = c1.indexOf(x);
			if(c1.size()==1) {
				System.out.println("|C| = 1");
				continue;
			}
			if(c1.indexOf(x)==1) {
				if (!L.contains(c1)) {
					L.add(c1);
					System.out.println("");
				}
				break;
				}
			if(c1.size()>1){
				c1.removeVertex(a);
				System.out.println(x.toString() + "is removed from " + c1.toString());
				c1.addVertex(x,1);
				System.out.println(x.toString() + "is added to " + c1.toString() + "in 1st position");
				if (!L.contains(c1)) {
					L.add(c1);
					System.out.println("");
				}
				System.out.println(c1.toString());
				System.out.println();
			}
		}

		System.out.println("STEP 2 : with L = " +  L.toString());
		for (Classe c : L) {
			System.out.println(c.toString());
			
			int i = c.visited();
			// System.out.println("i = " + i);
			c2 = new Classe();
			if (i==c.size()) { // |C| = r 
				this.add(c,partition.indexOf(c));
				c.unvisit();
			}
			else if (c.size()==1) {
				this.add(c,partition.indexOf(c));
				c.unvisit();
			}
			else {
				while(i>0){
					Vertex x = (Vertex) c.getVertices().atIndex(1);
					c.removeVertex(1);
					System.out.println(x.toString() + "is removed from " + c.toString());
					c2.addVertex(x);
					System.out.println(x.toString() + "is added to " + c2.toString());
					c.unvisit();
					i--;
				}
				// System.out.println("END WHILE with i = "+i+ " and c.size = "+c.size());
				this.add(c2, partition.indexOf(c));
			}
			System.out.println("The new class " + c2.toString() + "is added to the partition");
		}
	}

	public String toString() {
		return partition.toString();
	}

	public void initializepivot() {
		pivots = new ArrayList<Vertex>();
	}
	
	public Classe getClasse(int i){
		return (Classe) partition.atIndex(i);
	}

	public int indexOf(Classe c) throws InvalidIndexException{
		return partition.indexOf(c);
	}
	
}