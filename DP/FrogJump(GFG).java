
class Solution {
    int minCost(int[] height) {
        int n=height.length;
        int[] dp=new int[n];
        Arrays.fill(dp,-1);
        return solve(0,n,height,dp);
    }
    int solve(int index,int n,int[] height,int[] dp){
        if(index==n-1) return 0;
        if(dp[index]!=-1) return dp[index];
        
        int one=Integer.MAX_VALUE;
        if(index+1<n)
            one=solve(index+1,n,height,dp)+Math.abs(height[index]-height[index+1]);
        int two=Integer.MAX_VALUE;
        if(index+2<n)
            two=solve(index+2,n,height,dp)+Math.abs(height[index]-height[index+2]);
        
        return dp[index]=Math.min(one,two);
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
