class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        List<Integer> ans=new ArrayList<>();
        int n=nums.length;
        int[] dp=new int[n];
        int[] parent=new int[n];
        Arrays.fill(dp,1);
        Arrays.fill(parent,-1);
        int max=0,last=0;

        for(int i=0;i<n;i++){
            for(int j=0;j<i;j++){
                if(nums[i]%nums[j]==0 && dp[j]+1>dp[i]){
                    dp[i]=1+dp[j];
                    parent[i]=j;
                }
            }
            if(dp[i]>max){
                max=dp[i];
                last=i;
            }
        }

        while(last!=-1){
            ans.add(nums[last]);
            last=parent[last];
        }
        Collections.reverse(ans);
        return ans;
    }
}
