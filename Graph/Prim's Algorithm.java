class Pair {
    int distance;
    int node;
    
    Pair(int distance, int node) {
        this.distance = distance;
        this.node = node;
    }
}

class Solution {
    static int spanningTree(int V, int E, List<List<int[]>> adj) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((x, y) -> x.distance - y.distance);
        int[] vis = new int[V];
        pq.add(new Pair(0, 0));
        
        
        int sum = 0;
        
        while (!pq.isEmpty()) {
            int edw = pq.peek().distance;
            int adjnode = pq.peek().node;
            pq.remove();
            
            if (vis[adjnode] == 1) continue;
            
            vis[adjnode] = 1;
            sum += edw;
            for (int[] neighbor : adj.get(adjnode)) {
                int newDistance = neighbor[1];
                int newNode = neighbor[0];
                System.out.println();
                if (vis[newNode] == 0) {
                    pq.add(new Pair(newDistance, newNode));
                }
            }
        }
        
        return sum;
    }
}
