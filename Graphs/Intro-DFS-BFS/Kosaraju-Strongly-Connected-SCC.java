//User function Template for Java

// adj : Adjacency list representing the graph
// N: No of vertices


// O(V + E) Algorithm for finding strongly connected components...
class Solution
{
    
    public void printAdjacencyList(ArrayList<ArrayList<Integer> > graph) {
		
		for (int i = 0; i < graph.size() ; i++) {
			System.out.print(i);
			for (Integer edgeTo : graph.get(i)) {
				System.out.print( "-> " + edgeTo);
			}
			System.out.println("");
		}
	}
    
    public void dfsUtil(
        ArrayList<ArrayList<Integer>> adj,
        Stack<Integer> st,
        int[] visited,
        int v
        ) {
        
            visited[v] = 1;
            List<Integer> edges = adj.get(v);
            
            for (Integer edge : edges) {
                if (visited[edge] == 0) {
                    dfsUtil(adj, st, visited, edge);
                }
            }
            st.push(v); // Inserting after all the edges are proccessed..
    }
    
    public ArrayList<ArrayList<Integer>> reverse(ArrayList<ArrayList<Integer>> adj) {
        ArrayList<ArrayList<Integer>> reverse = new ArrayList<>(adj.size());
        
        for (int i=0;i<adj.size();i++)
            reverse.add(new ArrayList<Integer>());
        
        for (int i=0 ; i<adj.size();i++) {
            ArrayList<Integer> edges = adj.get(i);
            
            for (Integer edge : edges) {
                reverse.get(edge).add(i);
            }
        }
        
        return reverse;
    }
    
    public int countSCC(ArrayList<ArrayList<Integer>> reverse, Stack<Integer> st) {
        int count_scc = 0;
        int[] visited = new int[reverse.size()];
        Stack<Integer> random = new Stack<>();
        
        while (!st.empty()) {
            int vertex = st.pop();
            if (visited[vertex] == 0) {
                count_scc++;
                dfsUtil(reverse, random, visited, vertex);
            }
        }
        
        return count_scc;
    }
    
    
    public int kosaraju(ArrayList<ArrayList<Integer>> adj, int N)
    {
        // Write your code here
        Stack<Integer> st = new Stack<>();
        int[] visited = new int[N];
        
        for (int i=0;i<N;i++) {
            if (visited[i] == 0) {
                dfsUtil(adj, st, visited, i);
            }
        }
        
        
        // printAdjacencyList(adj);
        ArrayList<ArrayList<Integer>> reverseGraph = reverse(adj);
        // printAdjacencyList(reverseGraph);
        // System.out.println(st);
        
        return countSCC(reverseGraph, st);
    }
}