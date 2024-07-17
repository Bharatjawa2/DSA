import java.util.* ;
import java.io.*; 

// Memorization
public class Solution {
    public static int frogJump(int n, int heights[]) {
        int[] dp=new int[n+1];
        Arrays.fill(dp,-1);
        return solve(n-1,heights,dp);
    }

    static int solve(int n,int[] heights,int[] dp){
        if(n==0){
            return 0;
        }
        if(dp[n]!=-1){
            return dp[n];
        }
        int one=solve(n-1,heights,dp) + Math.abs(heights[n]-heights[n-1]);
        int two=Integer.MAX_VALUE;
        if(n>1){
            two=solve(n-2,heights,dp) + Math.abs(heights[n]-heights[n-2]);
        }
        dp[n]=Math.min(one,two);
        return dp[n];
    }

}


// Tabulation
public class Solution {
    public static int frogJump(int n, int heights[]) {
        int[] dp=new int[n];
        Arrays.fill(dp,0);
        dp[0]=0;
        for(int i=1;i<n;i++){
            int one=dp[i-1] + Math.abs(heights[i]-heights[i-1]);
            int two=Integer.MAX_VALUE;
            if(i>1){
                two=dp[i-2] + Math.abs(heights[i]-heights[i-2]);
            }
            dp[i]=Math.min(one,two);
        }
        return dp[n-1];
    }
}


// Space Optimization
public class Solution {
    public static int frogJump(int n, int heights[]) {
        int prev=0;
        int prev2=0;
        for(int i=1;i<n;i++){
            int one=prev + Math.abs(heights[i]-heights[i-1]);
            int two=Integer.MAX_VALUE;
            if(i>1){
                two=prev2 + Math.abs(heights[i]-heights[i-2]);
            }
            int curr=Math.min(one,two);
            prev2=prev;
            prev=curr;
        }
        return prev;
    }
}
