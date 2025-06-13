class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int n=nums.length;
        int sum=0;
        for(int i:nums) sum+=i;
        if(target>sum || target<-sum || (sum+target)%2!=0) return 0;
        int k=(sum+target)/2;
        Integer[][] dp=new Integer[n][k+1];
        return solve(0,k,nums,dp);
    }
    int solve(int index,int k,int[] nums,Integer[][] dp){
        if(index==nums.length){
            return (k==0)?1:0;
        }
        if(dp[index][k]!=null) return dp[index][k];
        int take=0;
        if(k>=nums[index])
            take=solve(index+1,k-nums[index],nums,dp);
        int not=solve(index+1,k,nums,dp);

        return dp[index][k]=take+not;
    }
}
