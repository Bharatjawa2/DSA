class Solution {
    public int nthRoot(int n, int m) {
        int low=1;
        int high=m;
        
        while(low<=high){
            int mid=low+(high-low)/2;
            if(solve(mid,n)==m) return mid;
            else if(solve(mid,n)>m){
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return -1;
    }
    int solve(int mid,int n){
        return (int)Math.pow(mid,n);
    }
}
