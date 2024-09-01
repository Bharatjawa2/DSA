
class Solution {

    List<Integer> eventualSafeNodes(int V, List<List<Integer>> adj) {

        List<List<Integer>> rev=new ArrayList<>();
        for(int i=0;i<V;i++){
            rev.add(new ArrayList<>());
        }
        int[] indegree=new int[V];
        for(int i=0;i<V;i++){
            for(int it:adj.get(i)){
                rev.get(it).add(i);
                indegree[i]++;
            }
        }
        
        Queue<Integer> q=new LinkedList<>();
        List<Integer> ans=new ArrayList<>();
        
        for(int i=0;i<V;i++){
            if(indegree[i]==0) q.add(i);
        }
        
        while(!q.isEmpty()){
            int node=q.peek();
            q.remove();
            ans.add(node);
            for(int i:rev.get(node)){
                indegree[i]--;
                if(indegree[i]==0) q.add(i);
            }
        }
        Collections.sort(ans);
        return ans;
    }
}
