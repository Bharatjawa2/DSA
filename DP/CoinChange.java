class Solution {
    public int coinChange(int[] coins, int amount) {
        int n=coins.length;
        Integer[][] dp=new Integer[n][amount+1];
        int ans=solve(0,n,coins,amount,dp);
        if(ans==Integer.MAX_VALUE) return -1;
        else return ans;
    }
    int solve(int index,int n,int[] coins,int amount,Integer[][] dp){
        if(index==n-1){
            if(amount%coins[index]==0) return amount/coins[index];
            else return Integer.MAX_VALUE;
        }
        if(dp[index][amount]!=null) return dp[index][amount];

        int not=solve(index+1,n,coins,amount,dp);
        int take=Integer.MAX_VALUE;
        if(amount-coins[index]>=0){
            take=solve(index,n,coins,amount-coins[index],dp);
        }
        if(take!=Integer.MAX_VALUE) take++;
        return dp[index][amount]=Math.min(not,take);
    }
}
