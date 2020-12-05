import java.util.*;
import java.lang.*;

// UnDirected Graph -> if an edge is added it need to be added in both of the AdjacencyList.
// When you created a List you need to add vertices number of lists into it right. You just 
// Trying to get from the list without adding stuff to it.
class Solution {

	private static Scanner in = new Scanner(System.in);

	public static void printAdjacencyList(List<List<Integer> > graph) {
		
		for (int i = 0; i < graph.size() ; i++) {
			System.out.print(i);
			for (Integer edgeTo : graph.get(i)) {
				System.out.print( "-> " + edgeTo);
			}
			System.out.println("");
		}
	}

	public static void main(String[] args) {
		// Need to take input and represent graph in the two ways you studied about
		// Adjacency Matrix Representation
		// Adjacency List Representation.
		int t = in.nextInt();
		while (t > 0) {
			int V = in.nextInt();
			int E = in.nextInt();

			// v vertices -> So v sized Adjacency List.
			List<List<Integer> > adjacencyGraphRepre = new ArrayList<>(V);

			for (int i = 0 ;i < V; i++) {
				adjacencyGraphRepre.add(new ArrayList<Integer>());
			}

			// e edges so add them to the Adjacency List
			// You are tring to get and added but Nothing is added to the ArrayList right now 
			// Need to add vertices number of ArrayList.
			for (int i = 0 ;i < E;i++) {
			    int u = in.nextInt();
			    int v = in.nextInt();
			    // Adding Edges..
				adjacencyGraphRepre.get(u).add(v);
				adjacencyGraphRepre.get(v).add(u);
			}

			printAdjacencyList(adjacencyGraphRepre);
			t--;
		}
	}

}