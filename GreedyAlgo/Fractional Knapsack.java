class Pair{
    int first;
    int second;
    Pair(int first,int second){
        this.first=first;
        this.second=second;
    }
}
class Solution {
    double fractionalKnapsack(List<Integer> val, List<Integer> wt, int capacity) {
        int n=val.size();
        PriorityQueue<Pair> pq=new PriorityQueue<>((a,b)->Double.compare((double)b.first/b.second,(double)a.first/a.second));
        for(int i=0;i<n;i++){
            pq.add(new Pair(val.get(i),wt.get(i)));
        }
        double ans=0.0;
        while(capacity>0 && !pq.isEmpty()){
            int x=pq.peek().first;
            int y=pq.peek().second;
            pq.remove();
            if(capacity-y>=0){
                ans+=x;
                capacity-=y;
            }else{
                ans+=((double)x/y)*capacity;
                capacity=0;
            }
        }
        return Math.round(ans*1e6)/1e6;
    }
}
