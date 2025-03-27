class Solution {
    public int longestOnes(int[] nums, int k) {
        int n=nums.length;
        int left=0;
        int max=0;
        int count=0;

        for(int right=0;right<n;right++){
            if(nums[right]==0) count++;
            while(count>k){
                if(nums[left]==0) count--;
                left++;
            }
            max=Math.max(max,right-left+1);
        }
        return max;
    }
}
