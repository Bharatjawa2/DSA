class Solution {
    public int maxProfit(int[] prices, int fee) {
        int n=prices.length;
        Integer[][] dp=new Integer[n][2];
        return solve(0,1,n,fee,prices,dp);
    }
    int solve(int index,int buy,int n,int fee,int[] prices,Integer[][] dp){
        if(index>=n) return 0;
        if(dp[index][buy]!=null) return dp[index][buy];
        int not=solve(index+1,buy,n,fee,prices,dp);
        int take=0,sell=0;
        if(buy==1){
            take=solve(index+1,0,n,fee,prices,dp)-prices[index];
        }else{
            sell=solve(index+1,1,n,fee,prices,dp)-fee+prices[index];
        }

        return dp[index][buy]=Math.max(take,Math.max(sell,not));
    }
}
