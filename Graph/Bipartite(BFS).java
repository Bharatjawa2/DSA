class Solution
{
    public boolean isBipartite(int V , ArrayList<ArrayList<Integer>>adj)
    {
        int[] color=new int[V];
        Arrays.fill(color,-1);
        
        for(int i=0;i<V;i++){
            if(color[i]==-1){
                if(!check(i,V,color,adj)) return false;
            }
        }
        return true ;
    }
    
    boolean check(int start,int V,int[] color,ArrayList<ArrayList<Integer>> adj){
        color[start]=0;
        Queue<Integer> q=new LinkedList<>();
        q.add(start);
        while(!q.isEmpty()){
            int node=q.poll();
            for(int i:adj.get(node)){
                if(color[i]==-1){
                    color[i]=1-color[node];
                    q.add(i);
                }
                else if(color[i]==color[node]){
                    return false;
                }
            }
        }
        return true;
    }
}
