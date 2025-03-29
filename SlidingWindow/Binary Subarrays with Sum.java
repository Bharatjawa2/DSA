class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        return sum(nums,goal)-sum(nums,goal-1);
    }
    int sum(int[] arr,int target){
        if(target<0) return 0;
        int n=arr.length;
        int left=0;
        int sum=0;
        int count=0;

        for(int right=0;right<n;right++){
            sum+=arr[right];
            while(sum>target){
                sum=sum-arr[left];
                left++;
            }
            count+=(right-left+1);
        }
        return count;
    }
}
