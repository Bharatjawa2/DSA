class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low=1;
        int high=Integer.MIN_VALUE;
        for(int i:piles){
            high=Math.max(i,high);
        }
        int ans=high;
        while(low<high){   // We dont want to skip correct answer when low and high are very close.
            int mid=low+(high-low)/2;
            if(solve(piles,mid,h)){
                ans=mid;
                high=mid;
            }else{
                low=mid+1;
            }
        }
        return ans;
    }
    boolean solve(int[] piles,int mid,int h){
        int k=0;
        for(int i=0;i<piles.length;i++){
            int x=piles[i]/mid;
            if(piles[i]%mid!=0) x++;
            k+=x;
        }
        return h>=k;
    }
}
