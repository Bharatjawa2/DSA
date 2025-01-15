class Solution {
    public int rob(int[] nums) {
        int n=nums.length;
        int[] dp=new int[n];
        Arrays.fill(dp,-1);
        return solve(n-1,nums,dp);
    }

    int solve(int index,int[] nums,int[] dp){
        if(index==0) return nums[0];
        if(index<0) return 0;

        if(dp[index]!=-1) return dp[index];

        int take=nums[index] + solve(index-2,nums,dp);
        int not=0+solve(index-1,nums,dp);

        return dp[index]=Math.max(take,not);
    }
}
