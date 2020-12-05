
// TODO Topological Sort or traversing the graph if we have to traverse 
// TODO dependency Traversal..

/*
ArrayList<ArrayList<>Integer>adj: to represent graph containing 'N' vertices
                                    and edges between them
N: represent number of vertices
*/
class TopologicalSort {
    
    static void topologicalUtil(ArrayList<ArrayList<Integer>> adj, int visited[], Stack<Integer> topo, int vertex) {
        visited[vertex] = 1;
        
        ArrayList<Integer> neighboors = adj.get(vertex);
        
        for (Integer edge : neighboors) {
            if (visited[edge] == 0) {
                topologicalUtil(adj, visited, topo, edge);
            }
        }
        
        topo.push(vertex);
    }
    
    
    static int[] topoSort(ArrayList<ArrayList<Integer>> adj, int N) {
        Stack<Integer> topo = new Stack<>();
        int[] visited = new int[N];
        int ans[] = new int[N];
        
        for (int i=0 ;i<N ;i++) {
            if (visited[i] == 0) {
                topologicalUtil(adj, visited, topo, i);
            }
        }
        
        int i = 0;
        while(!topo.empty()) {
            ans[i] = topo.pop();
            i++;
        }
        
        return ans;
    }
}
