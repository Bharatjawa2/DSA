class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n==1){
            return nums[0];
        }
        int[] dp1 = new int[n];
        int[] dp2 = new int[n];
        Arrays.fill(dp1, -1);
        Arrays.fill(dp2, -1);

        int case1 = solve(0, nums, dp1, 0, n - 2);
        int case2 = solve(1, nums, dp2, 1, n - 1);
        return Math.max(case1, case2);
    }

    private int solve(int i, int[] nums, int[] dp, int start, int end) {
        if (i > end) {
            return 0;
        }
        if (dp[i] != -1) {
            return dp[i];
        }
        int robCurrent = nums[i] + solve(i + 2, nums, dp, start, end);
        int skipCurrent = solve(i + 1, nums, dp, start, end);
        dp[i] = Math.max(robCurrent, skipCurrent);

        return dp[i];
    }
}
