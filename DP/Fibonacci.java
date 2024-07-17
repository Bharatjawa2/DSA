
class Solution {
    public static final int MOD=1000000007;
    static long topDown(int n) {
        long[] dp=new long[n+1];
        Arrays.fill(dp,-1);
        return solve(dp,n);
    }

    static long solve(long[] dp,int n){
        if(n<=1){
            return n;
        }
        if(dp[n]!=-1){
            return dp[n];
        }
        dp[n]=(solve(dp,n-1) + solve(dp,n-2))%MOD;
        long ans=dp[n];
        return ans;
    }
    
    static long bottomUp(int n) {
        int[] dp=new int[n+1];
        dp[0]=0;
        dp[1]=1;
        for(int i=2;i<=n;i++){
            dp[i]=(dp[i-1] + dp[i-2])%MOD;
        }
        return dp[n];
    }
}
