class Solution {
    public int cutRod(int[] price) {
        int n=price.length;
        Integer[][] dp=new Integer[n][n+1];
        return solve(n-1,n,price,dp);
    }
    
    int solve(int index,int n,int[] price,Integer[][] dp){
        if(index==0){
            return n*price[0];
        }
        
        if(dp[index][n] != null) return dp[index][n];
        
        int not=solve(index-1,n,price,dp);
        int take=Integer.MIN_VALUE;
        int rodL=index+1;
        if(rodL<=n){
            take=solve(index,n-rodL,price,dp)+price[index];
        }
        
        return dp[index][n]=Math.max(take,not);
    }
}
