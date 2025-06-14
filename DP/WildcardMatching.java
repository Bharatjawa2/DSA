class Solution {
    public boolean isMatch(String s, String p) {
        int n=s.length();
        int m=p.length();
        // Boolean[][] dp=new Boolean[n][m];
        boolean[][] dp=new boolean[n+1][m+1];

        dp[0][0]=true;

        for(int j=1;j<=m;j++){
            if(p.charAt(j-1)== '*') {
                dp[0][j]=dp[0][j-1];
            }
        }

        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if( (s.charAt(i-1)==p.charAt(j-1)) || p.charAt(j-1)=='?'){
                    dp[i][j]=dp[i-1][j-1];
                }else if(p.charAt(j-1)=='*'){
                    dp[i][j]=dp[i-1][j] || dp[i][j-1];
                }else{
                    dp[i][j]=false;
                }
            }
        }
        return dp[n][m];
        // return solve(s,p,n-1,m-1,dp);
    }
    boolean solve(String s,String p,int i,int j,Boolean[][] dp){
        if(i<0 && j<0) return true;
        if(j>=0 && i<0){
            return AllStars(p,j);
        }
        if(i<0 || j<0) return false;

        if(dp[i][j]!=null) return dp[i][j];
        
        if(s.charAt(i)==p.charAt(j)) return dp[i][j]=solve(s,p,i-1,j-1,dp);
        else if(p.charAt(j)=='?') return dp[i][j]=solve(s,p,i-1,j-1,dp);
        else if(p.charAt(j)=='*') return dp[i][j]=solve(s,p,i,j-1,dp) || solve(s,p,i-1,j,dp);

        return dp[i][j]=false;
    }
    boolean AllStars(String p,int j){
        for(int i=0;i<=j;i++){
            if(p.charAt(i)!='*') return false;
        }
        return true;
    }
}
