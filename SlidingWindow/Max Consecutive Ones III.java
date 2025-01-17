class Solution {
    public int longestOnes(int[] nums, int k) {
        int n=nums.length;
        int count=0;
        int left=0,right=0,max=0;
        
        while(right<n){
            if(nums[right]==0){
                count++;
            }

            while(count>k){
                if(nums[left]==0) count--;
                left++;
            }

            max=Math.max(max,right-left+1);
            right++;
        }
        return max;
    }
}
