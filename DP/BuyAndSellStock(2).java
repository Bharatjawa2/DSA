class Solution {
    public int maxProfit(int[] prices) {
        int n=prices.length;
        Integer[][] dp=new Integer[n][2];
        return solve(0,1,n,prices,dp);
    }
    int solve(int index,int buy,int n,int[] prices,Integer[][] dp){
        if(index==n) return 0;
        if(dp[index][buy]!=null) return dp[index][buy];
        int take=0,sell=0;
        int not=solve(index+1,buy,n,prices,dp);
        if(buy==1)
            take=solve(index+1,0,n,prices,dp)-prices[index];
        else
            sell=solve(index+1,1,n,prices,dp)+prices[index];
        return dp[index][buy]=Math.max(take,Math.max(sell,not));
    }
}
