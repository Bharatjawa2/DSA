class Solution {
    static int[] findOrder(int n, int m, ArrayList<ArrayList<Integer>> prerequisites) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();  
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        
        int[] inDegree = new int[n];  

        for (ArrayList<Integer> pair : prerequisites) {
            int course = pair.get(0);
            int prereq = pair.get(1);
            adj.get(prereq).add(course);
            inDegree[course]++;
        }
        
        
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }

        int[] topoOrder = new int[n];
        int index = 0;  
        
        while (!queue.isEmpty()) {
            int course = queue.poll();
            topoOrder[index++] = course;
            
            for (int neighbor : adj.get(course)) {
                inDegree[neighbor]--;
                if (inDegree[neighbor] == 0) {
                    queue.add(neighbor);
                }
            }
        }
        
        if (index == n) {
            return topoOrder;
        }
        
        return new int[0];
    }
}
