class Solution {
    public int maxProfit(int k, int[] prices) {
        int n=prices.length;
        Integer[][][] dp=new Integer[n][2][2*k];
        return solve(0,1,0,n,k,prices,dp);
    }
    int solve(int index,int buy,int trans,int n,int k,int[] prices,Integer[][][] dp){
        if(index==n) return 0;
        if(trans==2*k) return 0;
        if(dp[index][buy][trans]!=null) return dp[index][buy][trans];
        
        int not=solve(index+1,buy,trans,n,k,prices,dp);
        int take=0,sell=0;
        if(buy==1){
            take=solve(index+1,0,trans+1,n,k,prices,dp)-prices[index];
        }else{
            sell=solve(index+1,1,trans+1,n,k,prices,dp)+prices[index];
        }
        return dp[index][buy][trans]=Math.max(take,Math.max(not,sell));
    }
}
