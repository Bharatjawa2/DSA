class Solution {
    public int mySqrt(int n){
        if(n==0) return 0;
        if(n==1) return 1;
        int low=0;
        int high=n;
        int ans=1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(mid==n/mid) return mid;
            else if(mid<n/mid){
                ans=mid;
                low=mid+1;
            }else{
                high=mid-1;
            }
        }
        return ans;
    }
}
