
class Solution {
    static int numProvinces(ArrayList<ArrayList<Integer>> adj, int V) {
        ArrayList<ArrayList<Integer>> list=new ArrayList<ArrayList<Integer>>();
        for(int i=0;i<V;i++){
            list.add(new ArrayList<Integer>());
        }
        for(int i=0;i<V;i++){
            for(int j=0;j<V;j++){
                if(adj.get(i).get(j)==1 && i!=j){
                    list.get(i).add(j);
                    list.get(j).add(i);
                }
            }
        }
        boolean vis[]=new boolean[V];
        int c=0;
        for(int i=0;i<V;i++){
            if(vis[i]==false){
                c++;
                bfs(i,list,V,vis);
                // dfs(i, list, vis);
            }
        }
        return c;
    }
    public static void bfs(int x,ArrayList<ArrayList<Integer>> adj,int V,boolean[] vis){
        Queue<Integer> q=new LinkedList<>();
        q.add(x);
        vis[x]=true;
        while(!q.isEmpty()){
            Integer node=q.poll();
            
            for(Integer i:adj.get(node)){
                if(vis[i]==false){
                    vis[i]=true;
                    q.add(i);
                }
            }
        }
    }

    public static void dfs(int x, ArrayList<ArrayList<Integer>> adj, boolean[] vis) {
        vis[node] = true;
        for (Integer neighbor : adj.get(node)) {
            if (!vis[neighbor]) {
                dfs(neighbor, adj, vis); 
            }
        }
    }
};
