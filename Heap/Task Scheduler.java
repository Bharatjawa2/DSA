class Solution {
    public int leastInterval(char[] tasks, int n) {
        PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
        int[] freq=new int[26];
        for(char c:tasks){
            freq[c-'A']++;
        }
        for(int i=0;i<26;i++){
            if(freq[i]>0) pq.add(freq[i]);
        }
        int time=0;

        while(!pq.isEmpty()){
            List<Integer> list=new ArrayList<>();
            for(int i=0;i<=n;i++){
                if(!pq.isEmpty()){
                    int node=pq.poll();
                    node--;
                    list.add(node);
                }
            }
            for(int i:list){
                if(i>0) pq.add(i);
            }
            if(pq.isEmpty()) time+=list.size();
            else time+=n+1;
        }
        return time;
    }
}
