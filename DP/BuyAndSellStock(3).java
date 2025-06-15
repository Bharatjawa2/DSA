class Solution {
    public int maxProfit(int[] prices) {
        int n=prices.length;
        Integer[][][] dp=new Integer[n][2][4];
        return solve(0,1,0,n,prices,dp);
    }
    int solve(int index,int buy,int trans,int n,int[] prices,Integer[][][] dp){
        if(index==n) return 0;
        if(trans==4) return 0;
        if(dp[index][buy][trans]!=null) return dp[index][buy][trans];
        int not=solve(index+1,buy,trans,n,prices,dp);
        int take=0,sell=0;
        if(buy==1){
            take=solve(index+1,0,trans+1,n,prices,dp)-prices[index];
        }else{
            sell=solve(index+1,1,trans+1,n,prices,dp)+prices[index];
        }
        return dp[index][buy][trans]=Math.max(take,Math.max(sell,not));
    }
}
