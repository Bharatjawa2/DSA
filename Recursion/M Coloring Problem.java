class Solution {
    boolean graphColoring(int v, List<int[]> edges, int m) {
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<v;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] row:edges){
            int u=row[0];
            int V=row[1];
            adj.get(u).add(V);
            adj.get(V).add(u);
        }
        int[] color=new int[v];
        Arrays.fill(color,-1);
        return solve(0,v,adj,color,m);
    }
    boolean solve(int index,int v,List<List<Integer>> adj,int[] color,int m){
        if(index==v) return true;
        
        for(int i=1;i<=m;i++){
            if(isSafe(adj,color,index,i)){
                color[index]=i;
                if(solve(index+1,v,adj,color,m)) return true;
                color[index]=-1;
            }
        }
        return false;
    }
    boolean isSafe(List<List<Integer>> adj,int[] color,int index,int i){
        for(int it:adj.get(index)){
            if(color[it]==i) return false;
        }
        return true;
    }
}
