class Solution {
    public String findOrder(String[] dict, int n, int k) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < n - 1; i++) {
            String s1 = dict[i];
            String s2 = dict[i + 1];
            int len = Math.min(s1.length(), s2.length());
            for (int ptr = 0; ptr < len; ptr++) {
                if (s1.charAt(ptr) != s2.charAt(ptr)) {
                    adj.get(s1.charAt(ptr) - 'a').add(s2.charAt(ptr) - 'a');
                    break;
                }
            }
        }
        
        String order = topoSort(k, adj);
        return order.isEmpty() ? "" : order;
    }
    
    private String topoSort(int V, List<List<Integer>> adj) {
        int[] indegree = new int[V];
        for (int i = 0; i < V; i++) {
            for (int it : adj.get(i)) {
                indegree[it]++;
            }
        }
        
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < V; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }
        
        StringBuilder topo = new StringBuilder();
        int visitedCount = 0;
        while (!q.isEmpty()) {
            int node = q.poll();
            topo.append((char)(node + 'a'));
            visitedCount++;
            for (int i : adj.get(node)) {
                indegree[i]--;
                if (indegree[i] == 0) q.add(i);
            }
        }
        
        if (visitedCount != V) {
            return "";  
        }
        
        return topo.toString();
    }
}
