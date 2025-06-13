class Solution {
    public int rob(int[] nums) {
        int n=nums.length;
        if(n==1) return nums[0];
        Integer[] dp1=new Integer[n];
        Integer[] dp2=new Integer[n];
        int a=solve(0,n-1,nums,dp1);
        int b=solve(1,n,nums,dp2);
        return Math.max(a,b);
    }
    int solve(int index,int n,int[]nums,Integer[] dp){
        if(index>=n) return 0;
        if(dp[index]!=null) return dp[index];

        int take=solve(index+2,n,nums,dp)+nums[index];
        int not=solve(index+1,n,nums,dp);
        return dp[index]=Math.max(take,not);
    }
}
