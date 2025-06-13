class Solution {
    int timer=0;
    public ArrayList<Integer> articulationPoints(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] vis=new boolean[V];
        int[] tin=new int[V];
        int[] low=new int[V];
        int[] mark=new int[V];
        for(int i=0;i<V;i++){
            if(!vis[i]){
                dfs(i,-1,vis,tin,low,mark,adj);
            }
        }
        ArrayList<Integer> ans=new ArrayList<>();
        for(int i=0;i<V;i++){
            if(mark[i]==1){
                ans.add(i);
            }
        }
        if(ans.size()==0) ans.add(-1);
        return ans;
    }
    void dfs(int node,int parent,boolean[]vis,int[] tin,int[]low,int[]mark,ArrayList<ArrayList<Integer>> adj){
        vis[node]=true;
        tin[node]=timer;
        low[node]=timer;
        timer++;
        int child=0;
        for(int i:adj.get(node)){
            if(i==parent) continue;
            if(!vis[i]){
                dfs(i,node,vis,tin,low,mark,adj);
                low[node]=Math.min(low[node],low[i]);
                if(low[i]>=tin[node] && parent!=-1){
                    mark[node]=1;
                }
                child++;
            }else{
                low[node]=Math.min(low[node],tin[i]);
            }
        }
        if(child>1 && parent==-1){
            mark[node]=1;
        }
    }
}
