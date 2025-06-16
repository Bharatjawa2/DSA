class Solution {
    public int minCost(int n, int[] cuts) {
        Arrays.sort(cuts);
        int[] arr=new int[cuts.length+2];
        arr[0]=0;
        for(int i=1;i<=cuts.length;i++){
            arr[i]=cuts[i-1];
        }
        arr[cuts.length+1]=n;
        Integer[][] dp=new Integer[cuts.length+2][cuts.length+2];
        return solve(1,cuts.length,arr,dp);
    }
    int solve(int i,int j,int[] arr,Integer[][] dp){
        if(i>j) return 0;
        if(dp[i][j]!=null) return dp[i][j];
        int min=Integer.MAX_VALUE;
        for(int k=i;k<=j;k++){
            int cost=arr[j+1]-arr[i-1]+solve(k+1,j,arr,dp)+solve(i,k-1,arr,dp);
            min=Math.min(min,cost);
        }
        return dp[i][j]=min;
    }
}
