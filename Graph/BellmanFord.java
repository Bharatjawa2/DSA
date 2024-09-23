class Solution {
    static int[] bellman_ford(int V, ArrayList<ArrayList<Integer>> edges, int S) {
        int[] dist=new int[V];
        for(int i=0;i<V;i++) dist[i]=(int)(1e8);
        dist[S]=0;
        
        for(int j=0;j<V-1;j++){
            for(ArrayList<Integer> i:edges){
                int u=i.get(0);
                int v=i.get(1);
                int wt=i.get(2);
                if(dist[u]!=(1e8) && dist[u] + wt<dist[v]){
                    dist[v]=dist[u]+wt;
                }
            }
        }
        
        for(ArrayList<Integer> i : edges){
            int u=i.get(0);
            int v=i.get(1);
            int wt=i.get(2);
            if(dist[u]!=1e8 && dist[u]+wt<dist[v]){
                int[] temp=new int[1];
                temp[0]=-1;
                return temp;
            }
        }
        return dist;
    }
}
