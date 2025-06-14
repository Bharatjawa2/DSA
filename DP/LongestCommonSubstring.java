class Solution {
    int max=0;
    public int longestCommonSubstr(String s1, String s2) {
        int n=s1.length();
        int m=s2.length();
        Integer[][] dp=new Integer[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                solve(i,j,s1,s2,dp);
            }
        }
        return max;
    }
    int solve(int i,int j,String a,String b,Integer[][] dp){
        if(i>=a.length() || j>=b.length()) return 0;
        if(dp[i][j]!=null) return dp[i][j];
        int take=0;
        if(a.charAt(i)==b.charAt(j)){
            take=1+solve(i+1,j+1,a,b,dp);
        }
        max=Math.max(max,take);
        return dp[i][j]=take;
    }
}
