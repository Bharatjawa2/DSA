class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int n=text1.length();
        int m=text2.length();
        Integer[][] dp=new Integer[n][m]; // For Memo
        return solve(0,0,text1,text2,dp); // For Memo
        int[][] dp=new int[n+1][m+1];   // For Tabulation

        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(text1.charAt(i-1)==text2.charAt(j-1)){
                    dp[i][j]=1+dp[i-1][j-1];
                }else{
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[n][m];
    }
    int solve(int i,int j,String a,String b,Integer[][] dp){
        if(i==a.length() || j==b.length()) return 0;
        if(dp[i][j]!=null) return dp[i][j];
        int take=0;
        int not=0;
        if(a.charAt(i)==b.charAt(j)){
            take=1+solve(i+1,j+1,a,b,dp);
        }else{
            not=Math.max(solve(i+1,j,a,b,dp),solve(i,j+1,a,b,dp));
        }

        return dp[i][j]=Math.max(take,not);

    }
}
