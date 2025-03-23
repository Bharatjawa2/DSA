class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n=s.length();
        Boolean[] dp=new Boolean[n];
        HashSet<String> ans=new HashSet<>(wordDict);
        return solve(s,0,n-1,ans,dp);
    }
    boolean solve(String s,int start,int end,Set<String> ans,Boolean[] dp){
        if(end<0) return true;

        if(dp[end]!=null) return dp[end];

        for(int i=start;i<=end;i++){
            if(ans.contains(s.substring(i,end+1)) && solve(s,start,i-1,ans,dp)){
                return dp[end]=true;
            }
        }
        return dp[end]=false;
    }
}
