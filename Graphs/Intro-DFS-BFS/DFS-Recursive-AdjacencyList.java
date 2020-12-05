// used a void function and call by reference advantage..
// Actually want to do it in a better way.
// You can always define a Graph data structure which contains number of nodes
// And Any specific representation of the Graph.

class Traversal
{
    public static void dfs_recursive(
        ArrayList<ArrayList<Integer>> g, 
        ArrayList<Integer> dfs_ans,
        int[] visited,
        int v
    ) {
        dfs_ans.add(v);
        List<Integer> edges = g.get(v);
        for (Integer edge : edges) {
            if (visited[edge] != 1) {
                visited[edge] = 1;
                dfs_recursive(g, dfs_ans, visited, edge);
            }
        }
    }
    
    
    static ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> g, int N)
    {
       // add your code here
       ArrayList<Integer> dfs_ans = new ArrayList<>();
       int[] visited = new int[N];
       visited[0] = 1;
       
       dfs_recursive(g, dfs_ans, visited, 0);
       return dfs_ans;
    }
}
