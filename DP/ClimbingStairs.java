class Solution {
    public int climbStairs(int n) {
        int[] dp=new int[n];
        return solve(0,n,dp);
    }
    int solve(int index,int n,int[] dp){
        if(index==n) return 1;
        if(index>n) return 0;
        if(dp[index]!=0) return dp[index];
        int one=solve(index+1,n,dp);
        int two=solve(index+2,n,dp);
        return dp[index]=one+two;
    }
}
