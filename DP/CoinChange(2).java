class Solution {
    public int change(int amount, int[] coins) {
        int n=coins.length;
        Integer[][] dp=new Integer[n][amount+1];
        return solve(0,n,coins,amount,dp);
    }
    int solve(int index,int n,int[] coins,int amount,Integer[][] dp){
        if(index==n){
            if(amount==0) return 1;
            else return 0;
        }
        if(dp[index][amount]!=null) return dp[index][amount];

        int take=0;
        if(amount-coins[index]>=0){
            take=solve(index,n,coins,amount-coins[index],dp);
        }
        int not=solve(index+1,n,coins,amount,dp);
        return dp[index][amount]=take+not;
    }
}
