class Solution {
    static int matrixMultiplication(int arr[]) {
        int n=arr.length;
        Integer[][] dp=new Integer[n][n];
        return solve(1,n-1,arr,dp);
    }
    static int solve(int i,int j,int[] arr,Integer[][] dp){
        if(i==j) return 0;
        int min=Integer.MAX_VALUE;
        if(dp[i][j]!=null) return dp[i][j];
        for(int k=i;k<j;k++){
            int step=arr[i-1]*arr[k]*arr[j] +solve(i,k,arr,dp)+solve(k+1,j,arr,dp);
            min=Math.min(min,step);
        }
        return dp[i][j]=min;
    }
}
