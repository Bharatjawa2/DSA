class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int n=text1.length();
        int m=text2.length();
        Integer[][] dp=new Integer[n][m];
        return solve(0,0,text1,text2,dp);
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
