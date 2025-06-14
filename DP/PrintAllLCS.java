

// User function Template for Java

class Solution {
    public List<String> all_longest_common_subsequences(String s, String t) {
        List<String> ans=new ArrayList<>();
        int m=s.length();
        int n=t.length();
        int[][] dp=new int[m+1][n+1];
        
        
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(s.charAt(i-1)==t.charAt(j-1)){
                    dp[i][j]=1+dp[i-1][j-1];
                }else{
                    dp[i][j]=Math.max(dp[i-1][j] , dp[i][j-1]);
                }
            }
        }
        
        solve(s,t,m,n,"",dp,ans,new HashSet<>());
        Collections.sort(ans);
        return ans;
    }
    
    void solve(String s,String t,int m,int n,String curr,int[][] dp,List<String> ans,Set<String> set){
        if(m==0 || n==0){
            String a=new StringBuilder(curr).reverse().toString();
            if(!set.contains(a)){
                set.add(a);
                ans.add(a);
            }
            return;
        }
        
        if(s.charAt(m-1)==t.charAt(n-1)){
            solve(s,t,m-1,n-1,curr+s.charAt(m-1),dp,ans,set);
        }else{
            if(dp[m-1][n]==dp[m][n-1]){
                solve(s,t,m-1,n,curr,dp,ans,set);
                solve(s,t,m,n-1,curr,dp,ans,set);
            }else if(dp[m-1][n]>dp[m][n-1]){
                solve(s,t,m-1,n,curr,dp,ans,set);
            }else{
                solve(s,t,m,n-1,curr,dp,ans,set);
            }
        }
    }
}
