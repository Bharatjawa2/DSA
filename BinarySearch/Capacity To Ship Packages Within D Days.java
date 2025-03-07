class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int n=weights.length;
        int low=0;
        int high=0;
        for(int i:weights){
            low=Math.max(low,i);
            high+=i;
        }
        int ans=high;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(solve(weights,mid,days)){
                ans=mid;
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return ans;
    }

    boolean solve(int[] arr,int mid,int days){
        int c=0,d=1;
        for(int i:arr){
            if(c+i>mid){
                c=0;
                d++; 
            }
            c+=i;
        }
        return days>=d;
    }
}
