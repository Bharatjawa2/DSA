class Solution {
    // Function to detect cycle in a directed graph.
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        
        int[] vis=new int[V];
        int[] PathVis=new int[V];
        for(int i=0;i<V;i++){
            if(vis[i]==0){
                if(solve(i,V,vis,PathVis,adj)) return true;
            }
        }
        return false;
    }
    
    boolean solve(int node,int V,int[] vis,int[] PathVis,ArrayList<ArrayList<Integer>> adj){
        vis[node]=1;
        PathVis[node]=1;
        for(int i:adj.get(node)){
            if(vis[i]==0){
                if(solve(i,V,vis,PathVis,adj)) return true;
            }
            else if(PathVis[i]==1) return true;
        }
        
        PathVis[node]=0;
        return false;
    }
}
