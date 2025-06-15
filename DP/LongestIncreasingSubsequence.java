class Solution {
    public int lengthOfLIS(int[] nums) {
        int n=nums.length;
        // Integer[][] dp=new Integer[n][n+1];
        // return solve(0,-1,n,nums,dp);
        int[] dp=new int[n+1];
        Arrays.fill(dp,1);

        for(int i=0;i<n;i++){
            for(int j=0;j<i;j++){
                if(nums[i]>nums[j] && dp[i]<dp[j]+1){
                    dp[i]=dp[j]+1;
                }
            }
        }

        int max=0;
        for(int i:dp){
            max=Math.max(max,i);
        }
        return max;
    }
    int solve(int index,int prev,int n,int[] nums,Integer[][] dp){
        if(index>=n) return 0;
        if(dp[index][prev+1]!=null) return dp[index][prev+1];
        int take=0;
        if(prev==-1 || nums[prev]<nums[index]){
            take=1+solve(index+1,index,n,nums,dp);
        }   
        int not=solve(index+1,prev,n,nums,dp);

        return dp[index][prev+1]=Math.max(take,not);
    }
}
