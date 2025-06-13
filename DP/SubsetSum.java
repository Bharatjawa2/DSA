class Solution {
    static Boolean isSubsetSum(int arr[], int sum) {
        int n=arr.length;
        Boolean[][] dp=new Boolean[n][sum+1];
        return solve(0,sum,arr,dp);
    }
    static boolean solve(int index,int sum,int[] arr,Boolean[][] dp){
        if(sum==0) return true;
        if(index>=arr.length) return false;
        if(sum<0) return false;
        
        if(dp[index][sum]!=null) return dp[index][sum];
        
        boolean not=solve(index+1,sum,arr,dp);
        boolean take=solve(index+1,sum-arr[index],arr,dp);
        
        return dp[index][sum]=not|take;
    }
}
