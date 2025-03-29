class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        return sum(nums,k)-sum(nums,k-1);
    }
    int sum(int[] arr,int target){
        if(target<0) return 0;
        int n=arr.length;
        int left=0;
        int sum=0;
        int count=0;

        for(int right=0;right<n;right++){
            sum=sum+(arr[right]%2==0 ? 0:1);
            while(sum>target){
                sum=sum-(arr[left]%2==0 ? 0:1);
                left++;
            }
            count+=(right-left+1);
        }
        return count;
    }
}
