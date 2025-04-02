class Pair{
    int first;
    int second;
    Pair(int first,int second){
        this.first=first;
        this.second=second;
    }
}
class Solution {
    public int maxMeetings(int start[], int end[]) {
        int n=start.length;
        PriorityQueue<Pair> pq=new PriorityQueue<>((a,b)->a.second-b.second);
        for(int i=0;i<n;i++){
            pq.add(new Pair(start[i],end[i]));
        }
        int left=-1;
        int count=0;
        while(!pq.isEmpty()){
            int x=pq.peek().first;
            int y=pq.peek().second;
            pq.remove();
            if(x>left){
                count++;
                left=y;
            }
        }
        return count;
    }
}
