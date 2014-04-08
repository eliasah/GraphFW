/**
@author: ABOUHAYDAR Elias - LIAFA Departement of Distributed Algorithms and Graphs
 */

package algorithms;

import exceptions.InvalidIndexException;
import graph.Classe;
import graph.Graph;
import graph.Vertex;

import java.util.ArrayList;

public class LexBFS {

	/** 
	 * LexBFS of a connected graph G = (V,E) and an initial ordering P of V
	 * @param G a connected graph
	 * @param P ordered set of vertices
	 * @return 
	 */
	public static ArrayList LexBFS(Graph G, Partition P){

		ArrayList sigma = new ArrayList();

		System.out.println();
		System.out.println("STEP A: Let L be the one element ordered list (V)");
		System.out.println("L => (" + P.toString() + ")\n");

		System.out.println("STEP B: i 1 to " + G.cardV() + "\n");
		int i = 1;

		System.out.println("P => "+P.toString() + "and |P| = " +P.size() +"\n");

		while(i<=G.cardV() || P.size() < G.cardV()){
			System.out.println("STEP C"+i+": while there exists a non-singleton class in L = X1 ,...Xn do");
			System.out.println("P => "+P.toString() + "and |P| = " +P.size());
			System.out.println("------STEP D"+i+": let Xa be the last class made of non-visited vertices");
			Classe c1 = P.getClasse(i);
			Vertex pivot = c1.getVertex(1);
			pivot.visit();
			
			if (i==G.cardV()) {
				sigma.add(pivot);
				break;
			}
			System.out.print("------STEP E"+i+": remove vertex "+pivot+" from Xa, with Xa = " + pivot.getClasse());
			
			if(c1.size()>1) {
				c1.removeVertex(1);
				Classe c2 = new Classe();
				System.out.println(" and add "+pivot+"to just before X'a = "+ pivot.getClasse());
				c2.addVertex(pivot);
				try {
					P.add(c2,P.indexOf(c1));
					System.out.println("------------> X'a = {"+c2.toString()+"} added to the Partition");
				} catch (Exception e) {
					System.out.println("getmessage");
					System.out.println(e.getMessage());
					System.out.println(" ");
					System.out.println("toString");
					System.out.println(e.toString());
					System.out.println(" ");
					System.out.println("printStackTrace");
					e.printStackTrace();;
				}
			}
			if(c1.size()==1) {
				System.out.println("|Xa| = 1 : DO NOTHING ");
			}
			
			System.out.print("------STEP F"+i+": (x)  i, ");
			sigma.add(pivot);
			System.out.println("(x) = " + sigma.toString());
			System.out.println("------STEP G"+i+": i = i+1");
			i++;
			
			
			// Refine Partition
			System.out.println("STEP H"+i+": REFINE PARTITION");
			ArrayList<Vertex> S = G.atIndex(i).getNeighbors();
			try {
				P.pivots(S);
			} catch (InvalidIndexException e) {
				System.err.println("P.pivots(S) initialisation error");
				e.printStackTrace();
				break;
			}
			try {
				P.refine();
			} catch (InvalidIndexException e) {
				System.err.println("P.refine() execution error");
				e.printStackTrace();
				break;
			}

			System.out.println("P =>" + P.toString());
			System.out.println();
		}
		System.out.println("15: end while");

		System.out.println("P => "+P.toString() + "and |P| = " +P.size());

		System.out.println("(x) = " + sigma.toString());
		
		return sigma;
	}

}
