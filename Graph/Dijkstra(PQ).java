class Pair {
        int distance;
        int node;
        Pair(int distance, int node) {
            this.distance = distance;
            this.node = node;
        }
    }
class Solution
{
    static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S)
    {
        PriorityQueue<Pair> pq=new PriorityQueue<Pair>((x,y)-> x.distance-y.distance);
        int[] dist=new int[V];
        for(int i=0;i<V;i++) dist[i]=(int)(1e9);
        
        dist[S]=0;
        pq.add(new Pair(0,S));
        
        while(pq.size()!=0){
            int dis=pq.peek().distance;
            int node=pq.peek().node;
            pq.remove();
            
            for (int i = 0; i < adj.get(node).size(); i++) {
                int nextNode = adj.get(node).get(i).get(0);
                int edgeWeight = adj.get(node).get(i).get(1);
                
                if (dis + edgeWeight < dist[nextNode]) {
                    dist[nextNode] = dis + edgeWeight; 
                    pq.add(new Pair(dist[nextNode], nextNode));  
                }
            }
        }
        return dist;
    }
}

