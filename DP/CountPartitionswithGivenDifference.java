class Solution {
    int countPartitions(int[] arr, int d) {
        int n=arr.length;
        int sum=0;
        for(int i:arr) sum+=i;
        if((sum+d)%2!=0) return 0;
        int target=(sum+d)/2;
        Integer[][] dp=new Integer[n][target+1];
        return solve(0,n,arr,target,dp);
    }
    int solve(int index,int n,int[] arr,int target,Integer[][] dp){
        if(index==n){
            if(target==0) return 1;
            else return 0;
        }
        
        if(dp[index][target]!=null) return dp[index][target];
        
        int take=0;
        if(target>=arr[index])
            take=solve(index+1,n,arr,target-arr[index],dp);
        int not=solve(index+1,n,arr,target,dp);
        
        return dp[index][target]=take+not;
    }
}
