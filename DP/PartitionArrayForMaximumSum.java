class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n=arr.length;
        Integer[] dp=new Integer[n+1];
        return solve(0,k,n,arr,dp);
    }
    int solve(int index,int k,int n,int[] arr,Integer[] dp){
        if(index>=n) return 0;
        if(dp[index]!=null) return dp[index];

        int length=0;
        int max=-1,ans=-1;
        for(int j=index;j<Math.min(n,index+k);j++){
            length++;
            max=Math.max(max,arr[j]);
            int sum=length*max+solve(j+1,k,n,arr,dp);
            ans=Math.max(ans,sum);
        }
        return dp[index]=ans;
    }
}
