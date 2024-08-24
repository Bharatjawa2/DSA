class Solution {

    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> dfs=new ArrayList<>();
        boolean vis[] =new boolean[V];
        vis[0]=true;
        solve(0,vis,adj,dfs);
        return dfs;
    }
    public static void solve(int node,boolean[] vis,ArrayList<ArrayList<Integer>> adj,ArrayList<Integer> dfs){
        vis[node]=true;
        dfs.add(node);
        
        for(Integer i:adj.get(node)){
            if(vis[i]==false){
                solve(i,vis,adj,dfs);
            }
        }
    }
}
