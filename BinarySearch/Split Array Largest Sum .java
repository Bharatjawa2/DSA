class Solution {
    public int splitArray(int[] nums, int k) {
        int n=nums.length;
        if(k>n) return -1;
        int low=0,high=0;
        for(int i:nums){
            low=Math.max(i,low);
            high+=i;
        }
        int ans=high;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(solve(nums,mid,k)){
                ans=mid;
                high=mid-1;
            }else{
                low=mid+1; 
            }
        }
        return ans;
    }
    boolean solve(int[] arr,int mid,int k){
        int x=1;
        int sum=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]+sum>mid){
                sum=arr[i];
                x++;
                if(x>k) return false;
            }
            else sum+=arr[i];
        }
        return true;
    }
}Split Array Largest Sum
