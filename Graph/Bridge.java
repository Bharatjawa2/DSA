class Solution {
    int timer=1;
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        ArrayList<ArrayList<Integer>> adj=new ArrayList<ArrayList<Integer>>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }

        for(List<Integer> it:connections){
            int u=it.get(0);
            int v=it.get(1);
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        int[] vis=new int[n];
        int[] tim=new int[n];
        int[] low=new int[n];
        List<List<Integer>> bridge=new ArrayList<>();
        dfs(0,-1,vis,tim,low,adj,bridge);
        return bridge;
    }


    void dfs(int node,int parent,int[] vis,int[] tim,int[] low, ArrayList<ArrayList<Integer>> adj, List<List<Integer>> bridge){
        vis[node]=1;
        tim[node]=low[node]=timer;
        timer++;

        for(Integer i:adj.get(node)){
            if(i==parent) continue;
            if(vis[i]==0){
                dfs(i,node,vis,tim,low,adj,bridge);
                low[node]=Math.min(low[node],low[i]);

                if(low[i]>tim[node]){
                    bridge.add(Arrays.asList(node,i));
                }
            }
            else{
                low[node]=Math.min(low[node],tim[i]);
            }
        }
    }
}
