class Pair{
    int first;
    int second;
    Pair(int first,int second){
        this.first=first;
        this.second=second;
    }
}
class Solution {
    // Function to detect cycle in an undirected graph.
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] vis=new boolean[V];
        for(int i=0;i<V;i++){
            vis[i]=false;
        }
        for(int i=0;i<V;i++){
            if(vis[i]==false){
                if(solve(i,vis,adj)) return true;
            }
        }
        return false;
    }
    boolean solve(int src,boolean[] vis,ArrayList<ArrayList<Integer>> adj){
        vis[src]=true;
        Queue<Pair> q=new LinkedList<>();
        q.add(new Pair(src,-1));
        
        while(!q.isEmpty()){
            int node=q.peek().first;
            int parent=q.peek().second;
            q.remove();
            for(int adjnode : adj.get(node)){
                if(vis[adjnode]==false){
                    vis[adjnode]=true;
                    q.add(new Pair(adjnode,node));
                }
                else if(adjnode != parent){
                    return true;
                }
            }
        }
        return false;
    }
}
