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