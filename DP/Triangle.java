class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n=triangle.size();
        Integer[][] dp=new Integer[n][n];
        return solve(0,0,triangle,n,dp);
    }
    int solve(int i,int j,List<List<Integer>> triangle,int n,Integer[][] dp){
        if(i==n-1) return triangle.get(i).get(j);
        if(dp[i][j]!=null) return dp[i][j];

        int take=solve(i+1,j,triangle,n,dp);
        int not=solve(i+1,j+1,triangle,n,dp);

        return dp[i][j]=Math.min(take,not)+triangle.get(i).get(j);
    }
}
