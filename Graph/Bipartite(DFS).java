class Solution
{
    public boolean isBipartite(int V, ArrayList<ArrayList<Integer>>adj)
    {
        int[] color=new int[V];
        Arrays.fill(color,-1);
        
        for(int i=0;i<V;i++){
            if(color[i]==-1){
                if(!check(i,0,color,adj)) return false;
            }
        }
        return true;
    }
    
    boolean check(int start,int ParentColour,int[] color,ArrayList<ArrayList<Integer>> adj){
        color[start]=ParentColour;
        for(int i:adj.get(start)){
            if(color[i]==-1){
                if(!check(i,1-ParentColour,color,adj)) return false;
            }
            else if(color[i]==ParentColour){
                return false;
            }
        }
        return true;
    }
}
