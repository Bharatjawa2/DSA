class Solution {
    // Function to detect cycle in an undirected graph.
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
    
        int[] vis=new int[V];
        for(int i=0;i<V;i++){
            if(vis[i]==0){
                if(solve(i,-1,vis,adj)) return true;
            }
        }
        return false;
    }
    
    boolean solve(int src,int parent,int[] vis,ArrayList<ArrayList<Integer>> adj){
        vis[src]=1;
        
        for(int adjnode : adj.get(src)){
            if(vis[adjnode]==0){
                if(solve(adjnode,src,vis,adj)) return true;
            }
                else if(adjnode != parent) return true;
        }
        return false;
    }
}
