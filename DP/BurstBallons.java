class Solution {
    public int maxCoins(int[] nums) {
        int n=nums.length;
        int[] arr=new int[n+2];
        arr[0]=1;
        for(int i=1;i<=n;i++){
            arr[i]=nums[i-1];
        }
        arr[n+1]=1;
        Integer[][] dp=new Integer[n+2][n+2];
        return solve(1,n,arr,dp);
    }
    int solve(int i,int j,int[] arr,Integer[][] dp){
        if(i>j) return 0;
        if(dp[i][j]!=null) return dp[i][j];
        int max=Integer.MIN_VALUE;
        for(int k=i;k<=j;k++){
            int cost=arr[i-1]*arr[k]*arr[j+1] + solve(i,k-1,arr,dp) + solve(k+1,j,arr,dp);
            max=Math.max(max,cost);
        }
        return dp[i][j]=max;
    }
}
