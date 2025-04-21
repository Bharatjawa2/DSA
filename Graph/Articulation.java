class Solution {
    int timer = 1;
    
    public ArrayList<Integer> articulationPoints(int V, ArrayList<ArrayList<Integer>> adj) {
        int[] vis = new int[V];
        int[] tin = new int[V];
        int[] low = new int[V];
        int[] mark = new int[V];
        
        for (int i = 0; i < V; i++) {
            if (vis[i] == 0) { 
                dfs(i, -1, vis, tin, low, mark, adj);
            }
        }
        
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            if (mark[i] == 1) {
                ans.add(i);
            }
        }
        
        if (ans.size() == 0) {
            ans.add(-1);
        }
        return ans;
    }
    
    void dfs(int node, int parent, int[] vis, int[] tin, int[] low, int[] mark, ArrayList<ArrayList<Integer>> adj) {
        vis[node] = 1;
        tin[node] = low[node] = timer++;
        int child = 0;
        
        for (Integer i : adj.get(node)) {
            if (i == parent) continue;
            if (vis[i] == 0) {
                dfs(i, node, vis, tin, low, mark, adj);
                low[node] = Math.min(low[node], low[i]);
                if (low[i] >= tin[node] && parent != -1) {
                    mark[node] = 1;
                }
                child++;
            } else {
                low[node] = Math.min(low[node], tin[i]);
            }
        }
        
        if (child > 1 && parent == -1) mark[node] = 1;
    }
}
