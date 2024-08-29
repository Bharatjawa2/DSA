class Solution
{
    //Function to return list containing vertices in Topological order. 
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) 
    {
        int[] vis=new int[V];
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<V;i++){
            if(vis[i]==0){
                solve(i,vis,adj,st);
            }
        }
        
        int[] ans=new int[V];
        int c=0;
        while(!st.isEmpty()){
            ans[c++]=st.pop();
        }
        return ans;
    }
    
    static void solve(int node,int[] vis,ArrayList<ArrayList<Integer>> adj, Stack<Integer> st){
        vis[node]=1;
        for(int i:adj.get(node)){
            if(vis[i]==0){
                solve(i,vis,adj,st);
            }
        }
        st.push(node);
    }
}
