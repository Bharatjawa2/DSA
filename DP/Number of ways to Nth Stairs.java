import java.util.* ;
import java.io.*; 
public class Solution {

	public static long countDistinctWayToClimbStair(int nStairs) {
		// Write your code here.
		int MOD=1000000007;
		int n=nStairs;
		long[] dp=new long[n+1];
		if(n<=1){
			return 1;
		}
		dp[0]=1;
		dp[1]=1;
		for(int i=2;i<=n;i++){
			dp[i]=(dp[i-1]+dp[i-2])%MOD;
		}
		return dp[n];
	}
}
