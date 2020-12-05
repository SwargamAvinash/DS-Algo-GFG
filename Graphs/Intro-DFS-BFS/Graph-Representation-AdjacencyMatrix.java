import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
	
	public static Scanner in = new Scanner(System.in);

	public static void printGraph(int graph[][], int v, int e) {
		for (int i =0 ;i < v;i++) {
			System.out.print(i + " -> ");
			for (int j = 0 ;j < v ; j++) {
				System.out.print(graph[i][j] + "\t");
			}
			System.out.println("");
		}
	}

	public static void main(String[] args) {
		int t = in.nextInt();

		while (t > 0) {
			int vertices = in.nextInt();
			int edges = in.nextInt();

			// Matrix Representation of a Graph
			int[][] graphEdges = new int[vertices][vertices];

			// Adding Edges 
			for (int i=0; i<edges ;i++) {
				int u = in.nextInt();
				int v = in.nextInt();

				graphEdges[u][v] = 1;
				graphEdges[v][u] = 1;
			}

			printGraph(graphEdges, vertices, edges);
			t--;
		}
	}
}