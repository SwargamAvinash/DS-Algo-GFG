// User function Template for Java

/*
*  g[]: adj list of the graph
*  N : number of vertices
*/
class Traversal {
    static ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> g, int N) {
        // add your code here
        int[] visited = new int[N];
        Queue<Integer> queue = new LinkedList<>();
        
        ArrayList<Integer> ans = new ArrayList<>();
        queue.add(0);
        
        while (!queue.isEmpty()) {
            int vertex = queue.remove();
            ans.add(vertex);
			
            List<Integer> edges = g.get(vertex);
            for (Integer v : edges) {
                if (visited[vertex] != 1) {
					queue.add(v);
                	visited[vertex] = 1;
				}
            }
        }
        return ans;
    }
}
