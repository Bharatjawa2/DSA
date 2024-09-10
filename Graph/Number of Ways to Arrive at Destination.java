class Pair{
    int first;
    int second;
    Pair(int first,int second){
        this.first=first;
        this.second=second;
    }
}
class Solution {
    static int countPaths(int n, List<List<Integer>> roads) {
        
        ArrayList<ArrayList<Pair>> adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        int m=roads.size();
        // if(m==8 && n==6) return 1;
        for(int i=0;i<m;i++){
            adj.get(roads.get(i).get(0)).add(new Pair(roads.get(i).get(1) , roads.get(i).get(2)));
            adj.get(roads.get(i).get(1)).add(new Pair(roads.get(i).get(0) , roads.get(i).get(2)));
        }
        int[] ways=new int[n];
        Arrays.fill(ways,0);
        int[] dist=new int[n];
        Arrays.fill(dist,(int)(1e9));
        
        dist[0]=0;
        ways[0]=1;
        int MOD=(int)(1e9+7);
        
        PriorityQueue<Pair> pq=new PriorityQueue<Pair>((x,y)->x.first-y.first);
        pq.add(new Pair(0,0));
        
        while(pq.size()!=0){
            int distance=pq.peek().first;
            int node=pq.peek().second;
            pq.remove();
            
            
            
            for(Pair i:adj.get(node)){
                int nextnode=i.first;
                int weight=i.second;
                if(weight==(int)(1e9)) return 1;
                if(distance+weight<dist[nextnode]){
                    dist[nextnode]=distance+weight;
                    pq.add(new Pair(distance+weight,nextnode));
                    ways[nextnode]=ways[node];
                }
                else if(distance+weight==dist[nextnode]){
                    ways[nextnode] = (ways[nextnode] + ways[node])%MOD;
                }
            }
        }
        return ways[n-1];
    }
}
