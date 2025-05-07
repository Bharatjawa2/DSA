class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n=graph.length;
        int[] vis=new int[n]; // 0:unvisited , 1:visiting , 2:safe
        List<Integer> list=new ArrayList<>();
        for(int i=0;i<n;i++){
            if(dfs(i,graph,vis)){
                list.add(i);
            }
        }
        return list;
    } 
    boolean dfs(int node,int[][] graph,int[] vis){
        if(vis[node]>0) return vis[node]==2;
        vis[node]=1;
        for(int i:graph[node]){
            if(vis[i]==1 || !dfs(i,graph,vis)) return false;
        }
        vis[node]=2;
        return true;
    }
}
