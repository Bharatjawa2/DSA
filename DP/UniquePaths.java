class Solution {
    public int uniquePaths(int m, int n) {
        Integer[][] dp=new Integer[m][n];
        return solve(0,0,m,n,dp);
    }
    int solve(int row,int col,int m,int n,Integer[][] dp){
        if(row==m-1 && col==n-1) return 1;
        if(row>=m || col>=n) return 0;

        if(dp[row][col]!=null) return dp[row][col];

        int right=solve(row,col+1,m,n,dp);
        int down=solve(row+1,col,m,n,dp);
        return dp[row][col]=right+down;
    }
}
