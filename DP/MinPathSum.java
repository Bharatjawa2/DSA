class Solution {
    public int minPathSum(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        Integer[][] dp=new Integer[m][n];
        return solve(0,0,m,n,grid,dp);
    }
    int solve(int row,int col,int m,int n,int[][] grid,Integer[][] dp){
        if(row==m-1 && col==n-1) return grid[row][col];
        if(row>=m || col>=n) return Integer.MAX_VALUE;

        if(dp[row][col]!=null) return dp[row][col];

        int down=solve(row+1,col,m,n,grid,dp);
        int right=solve(row,col+1,m,n,grid,dp);

        return dp[row][col]=Math.min(down,right)+grid[row][col];
    }
}
