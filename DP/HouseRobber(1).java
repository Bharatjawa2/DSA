class Solution {
    public int rob(int[] nums) {
        int n=nums.length;
        Integer[] dp=new Integer[n];
        return solve(0,n,nums,dp);
    }
    int solve(int index,int n,int[]nums,Integer[]dp){
        if(index>=n) return 0;
        if(dp[index]!=null) return dp[index];

        int take=solve(index+2,n,nums,dp)+nums[index];
        int not=solve(index+1,n,nums,dp);
        
        return dp[index]= Math.max(take,not);
    }
}
