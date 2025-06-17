class Solution {
    public boolean isInterLeave(String s1, String s2, String s3) {
        int n=s1.length();
        int m=s2.length();
        int size=s3.length();
        if((n+m)!=size) return false;
        Boolean[][] dp=new Boolean[n+1][m+1];
        return solve(0,0,n,m,s1,s2,s3,dp);
    }
    boolean solve(int i,int j,int n,int m,String s1,String s2,String s3,Boolean[][] dp){
        if(i==n && j==m) return true;
        if(dp[i][j]!=null) return dp[i][j];
        boolean res=false;
        if(i<n && s1.charAt(i)==s3.charAt(i+j)){
            res=solve(i+1,j,n,m,s1,s2,s3,dp);
        }
        if(!res && j<m && s2.charAt(j)==s3.charAt(i+j)){
            res=solve(i,j+1,n,m,s1,s2,s3,dp);
        }
        return dp[i][j]=res;
    }
}
