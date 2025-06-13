class Solution {
    public int perfectSum(int[] nums, int target) {
        int n=nums.length;
        Integer[][] dp=new Integer[n][target+1];
        return solve(0,target,n,nums,dp);
    }
    int solve(int index,int target,int n,int[] nums,Integer[][] dp){
        if(index==n){
            if(target==0) return 1;
            else return 0;
        }

        if(dp[index][target]!=null) return dp[index][target];
        
        int take=0;
        if(target>=nums[index])
            take=solve(index+1,target-nums[index],n,nums,dp);
        int not=solve(index+1,target,n,nums,dp);
        
        return dp[index][target]=take+not;
    }
}
