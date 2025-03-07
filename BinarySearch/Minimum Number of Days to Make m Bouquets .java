class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int low=Integer.MAX_VALUE;
        int high=Integer.MIN_VALUE;
        for(int i:bloomDay){
            low=Math.min(low,i);
            high=Math.max(high,i);
        }
        if((long)m*k>bloomDay.length) return -1;
        int ans=high;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(solve(bloomDay,m,k,mid)){
                ans=mid;
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return ans;
    }

    boolean solve(int[] arr,int m,int k,int mid){
        int cnt=0,ans=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]<=mid) cnt++;
            else{
                ans+=cnt/k;
                cnt=0;
            }
        }
        ans+=cnt/k;
        return ans>=m;
    }
}
