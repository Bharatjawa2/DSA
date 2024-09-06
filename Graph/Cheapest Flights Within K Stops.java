class Pair{
    int first;
    int second;
    Pair(int first,int second){
        this.first=first;
        this.second=second;
    }
}
class tuple{
    int first;
    int second;
    int third;
    tuple(int first,int second,int third){
        this.first=first;
        this.second=second;
        this.third=third;
    }
}
class Solution {
    public int CheapestFLight(int n,int flights[][],int src,int dst,int k) {
       int n1=flights.length;
       int m=flights[0].length;
       ArrayList<ArrayList<Pair>> adj=new ArrayList<>();
       for(int i=0;i<n;i++){
           adj.add(new ArrayList<>());
       }
       for(int i=0;i<n1;i++){
           adj.get(flights[i][0]).add(new Pair(flights[i][1] , flights[i][2]));
       }
       
       int[] dist=new int[n];
       for(int i=0;i<n;i++) dist[i]=(int)(1e9);
       
       PriorityQueue<tuple> pq=new PriorityQueue<tuple>((x,y)->x.first-y.first);
       dist[src]=0;
       pq.add(new tuple(0,src,0));
       
       while(pq.size()!=0){
           int stop=pq.peek().first;
           int x=pq.peek().second;
           int y=pq.peek().third;
           pq.remove();
           if(stop>k) continue;
           for(Pair it:adj.get(x)){
               int t=it.first;
               int w=it.second;
               if(w+y<dist[t] && stop<=k){
                   dist[t]=w+y;
                   pq.add(new tuple(stop+1,t,dist[t]));
               }
           }
       }
       for(int i=0;i<n;i++){
           if(dist[i]==(int)(1e9)) dist[i]=-1;
       }
       return dist[dst];
    }
}
