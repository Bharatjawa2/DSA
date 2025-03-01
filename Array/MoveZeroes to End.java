class Solution {
    public void moveZeroes(int[] nums) {
        int n=nums.length;
        int c=0;
        for(int i=0;i<n;i++){
            if(nums[i]==0) continue;
            else nums[c++]=nums[i];
        }
        for(int i=c;i<n;i++) nums[i]=0;
    }
}
