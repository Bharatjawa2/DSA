class Solution {

    List<Integer> eventualSafeNodes(int V, List<List<Integer>> adj) {

        int[] vis=new int[V];
        int[] path=new int[V];
        int[] check=new int[V];
        for(int i=0;i<V;i++){
            if(vis[i]==0){
                solve(i,adj,vis,path,check);
            }
        }
        List<Integer> safe=new ArrayList<>();
        for(int i=0;i<V;i++){
            if(check[i]==1) safe.add(i);
        }
        return safe;
    }
    
    boolean solve(int node,List<List<Integer>> adj,int[] vis,int[] path,int[] check){
        vis[node]=1;
        path[node]=1;
        check[node]=0;
        for(int i:adj.get(node)){
            if(vis[i]==0){
                if(solve(i,adj,vis,path,check)) return true;
            }
            else if(path[i]==1) return true;
        }
        
        path[node]=0;
        check[node]=1;
        return false;
    }
}
