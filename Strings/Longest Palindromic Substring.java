class Solution {
    public String longestPalindrome(String s) {
        int n=s.length();
        Boolean[][] dp=new Boolean[n][n];
        int max=0;
        int start=-1;
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                if(solve(s,i,j,dp)==true){
                    if(j-i+1>max){
                        max=j-i+1;
                        start=i;
                    }
                }
            }
        }
        return s.substring(start,start+max);
    }
    boolean solve(String s,int i,int j,Boolean[][] dp){
        if(i>=j) return true;
        if(dp[i][j]!=null) return dp[i][j];
        if(s.charAt(i)==s.charAt(j)){
            return dp[i][j]=solve(s,i+1,j-1,dp);
        }
        return dp[i][j]=false;
    }
}
