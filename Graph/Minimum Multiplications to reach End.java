class Solution {
    int minimumMultiplications(int[] arr, int start, int end) {
        if(start==end) return 0;
        int MOD=100000;
        int[] dist=new int[MOD];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[start]=0;
        
        Queue<Integer> q=new LinkedList<>();
        q.add(start);
        
        while(!q.isEmpty()){
            int curr=q.peek();
            q.remove();
            
            for(int i:arr){
                int value=(i*curr)%MOD;
                
                if(dist[value]>dist[curr]+1){
                    dist[value]=dist[curr]+1;
                    q.add(value);
                    
                }
                if(value==end){
                    return dist[value];
                }
            }
        }
        return -1;
    }
}
