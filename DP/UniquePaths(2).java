class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m=obstacleGrid.length;
        int n=obstacleGrid[0].length;
        Integer[][] dp=new Integer[m][n];
        if(obstacleGrid[m-1][n-1]==1) return 0;
        return solve(0,0,m,n,obstacleGrid,dp);
    }
    int solve(int row,int col,int m,int n,int[][] arr,Integer[][] dp){
        if(row==m-1 && col==n-1) return 1;
        if(row>=m || col>=n) return 0;

        if(dp[row][col]!=null) return dp[row][col];
        if(arr[row][col]==1) return 0;


        int down=solve(row+1,col,m,n,arr,dp);
        int right=solve(row,col+1,m,n,arr,dp);

        return dp[row][col]=down+right;
    }
}
