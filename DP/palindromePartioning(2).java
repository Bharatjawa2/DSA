class Solution {
    public int minCut(String s) {
        int n=s.length();
        Integer[][] dp=new Integer[n+1][n+1];
        return solve(1,n,s,dp);
    }
    int solve(int i,int j,String s,Integer[][] dp){
        if(i>=j) return 0;
        if(valid(s,i,j)) return 0;
        if(dp[i][j]!=null) return dp[i][j];
        int min=Integer.MAX_VALUE;
        for(int k=i;k<=j;k++){
            if(valid(s,i,k)){
                int cut=1+solve(k+1,j,s,dp);
                min=Math.min(min,cut);
            }
        }
        return dp[i][j]=min;
    }
    boolean valid(String s,int start,int end){
        while(start<end){
            if(s.charAt(start-1)!=s.charAt(end-1)) return false;
            start++;
            end--;
        }
        return true;
    }
}
