class Solution {
    public boolean canPartition(int[] nums) {
        int sum=0;
        int n=nums.length;
        for(int i=0;i<n;i++) sum+=nums[i];
        if(sum%2!=0) return false;
        int target=sum/2;
        Boolean[][] dp=new Boolean[n][target+1];
        return solve(0,target,nums,dp);
    }
    boolean solve(int index,int target,int[] nums,Boolean[][] dp){
        if(index>=nums.length) return false; 
        if(target==0) return true;
        if(target<0) return false;
        
        if(dp[index][target]!=null) return dp[index][target];

        boolean take=solve(index+1,target-nums[index],nums,dp);
        boolean not=solve(index+1,target,nums,dp);

        return dp[index][target]=take|not;
    }
}
