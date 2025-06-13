class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n=matrix.length;
        int ans=Integer.MAX_VALUE;
        Integer[][] dp=new Integer[n][n];
        for(int i=0;i<n;i++){
            ans=Math.min(ans,solve(0,i,matrix,n,dp));
        }
        return ans;
    }
    int solve(int row,int col,int[][] mat,int n,Integer[][] dp){
        if(row<0 || col<0 || row>=n || col>=n) return Integer.MAX_VALUE;
        if(row==n-1) return mat[row][col];

        if(dp[row][col]!=null) return dp[row][col];

        int x=solve(row+1,col,mat,n,dp);
        int y=solve(row+1,col+1,mat,n,dp);
        int z=solve(row+1,col-1,mat,n,dp);

        return dp[row][col]=Math.min(x,Math.min(y,z))+mat[row][col];
    }
}
