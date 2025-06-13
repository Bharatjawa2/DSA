class Solution {
    static int knapSack(int val[], int wt[], int capacity) {
        int n=val.length;
        Integer[][] dp=new Integer[n][capacity+1];
        return solve(0,capacity,val,wt,dp);
    }
    static int solve(int index,int cap,int[] val,int[] wt,Integer[][] dp){
        if(index==val.length-1){
            if(cap-wt[val.length-1]>=0) return val[val.length-1]*(cap/wt[val.length-1]);
            else return 0;
        }
        if(dp[index][cap]!=null) return dp[index][cap];
        int take=0;
        if(cap-wt[index]>=0){
            take=val[index]+solve(index,cap-wt[index],val,wt,dp);
        }
        int not=solve(index+1,cap,val,wt,dp);
        return dp[index][cap]=Math.max(take,not);
    }
}
