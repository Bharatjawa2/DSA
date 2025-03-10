import java.util.*;
class Pair{
    double first;
    int second;
    Pair(double first,int second){
        this.first=first;
        this.second=second;
    }
}
public class Solution {
    public static double MinimiseMaxDistance(int []arr, int K){
        int n=arr.length;
        int[] cnt=new int[n-1]; 
        PriorityQueue<Pair> pq=new PriorityQueue<>((a,b)->Double.compare(b.first,a.first));
        for(int i=0;i<n-1;i++){
            pq.add(new Pair((double)arr[i+1]-arr[i],i));
        }
        for(int i=0;i<K;i++){
            Pair top=pq.poll();
            int ind=top.second;
            cnt[ind]++;

            double inidiff=(double)arr[ind+1]-arr[ind];
            double len=inidiff/(cnt[ind]+1);
            pq.add(new Pair(len,ind));
        }
        return pq.peek().first;
    }
}
