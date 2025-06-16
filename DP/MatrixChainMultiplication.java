class Solution {
    static int matrixMultiplication(int arr[]) {
        int n=arr.length;
        // Integer[][] dp=new Integer[n][n];
        // return solve(1,n-1,arr,dp);
        int[][] dp=new int[n][n];
        for(int i=0;i<n;i++) dp[i][i]=0;
        
        for(int i=n-1;i>=1;i--){
            for(int j=i+1;j<n;j++){
                int min=Integer.MAX_VALUE;
                for(int k=i;k<j;k++){
                    int step=arr[i-1]*arr[k]*arr[j] + dp[i][k] + dp[k+1][j];
                    min=Math.min(min,step);
                }
                dp[i][j]=min;
            }
        }
        return dp[1][n-1];
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
