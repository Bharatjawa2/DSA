class Solution {
    public int kosaraju(int V, ArrayList<ArrayList<Integer>> adj) {
        int[] vis = new int[V];
        Stack<Integer> st = new Stack<>(); 
        
        for (int i = 0; i < V; i++) {
            if (vis[i] == 0) {
                dfs(i, vis, adj, st);
            }
        }
        
        ArrayList<ArrayList<Integer>> rev = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            rev.add(new ArrayList<>());
        }
        
        for (int i = 0; i < V; i++) {
            vis[i] = 0; 
            for (Integer it : adj.get(i)) {
                rev.get(it).add(i);
            }
        }
        
        int scc = 0;
        while (!st.isEmpty()) {
            int node = st.pop();
            if (vis[node] == 0) {
                scc++;
                dfsTranspose(node, vis, rev);
            }
        }
        
        return scc;
    }
    
    void dfs(int node, int[] vis, ArrayList<ArrayList<Integer>> adj, Stack<Integer> st) {
        vis[node] = 1;
        for (Integer i : adj.get(node)) {
            if (vis[i] == 0) {
                dfs(i, vis, adj, st);
            }
        }
        st.push(node);
    }
    
    void dfsTranspose(int node, int[] vis, ArrayList<ArrayList<Integer>> rev) {
        vis[node] = 1;
        for (Integer i : rev.get(node)) {
            if (vis[i] == 0) {
                dfsTranspose(i, vis, rev);
            }
        }
    }
}
