class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int low=1;
        int high=Integer.MIN_VALUE;
        for(int i:nums) high=Math.max(i,high);

        int ans=high;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(solve(nums,mid,threshold)){
                ans=mid;
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return ans;
    }

    boolean solve(int[] arr,int mid,int t){
        int ans=0;
        for(int i=0;i<arr.length;i++){
            ans+=Math.ceil( (double)arr[i]/(double)mid );
        }
        return t>=ans;
    }
}
