class Solution {
    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {

        ArrayList<Integer> bfs=new ArrayList<>();
        boolean[] vis=new boolean[V];
        Queue<Integer> q=new LinkedList<>();
        
        q.add(0);
        vis[0]=true;
        
        while(!q.isEmpty()){
            Integer node=q.poll();
            bfs.add(node);
            
            for(Integer i:adj.get(node)){
                if(vis[i]==false){
                    vis[i]=true;
                    q.add(i);
                }
            }
        }
        return bfs;
    }
}
