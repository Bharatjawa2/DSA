class Solution {
    public int minDistance(String word1, String word2) {
        int n=word1.length();
        int m=word2.length();
        int size=n+m;
        return size-2*lcs(word1,word2);
    }
    int lcs(String a,String b){
        int n=a.length();
        int m=b.length();
        int[][] dp=new int[n+1][m+1];

        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(a.charAt(i-1)==b.charAt(j-1)){
                    dp[i][j]=1+dp[i-1][j-1];
                }else{
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[n][m];
    }
}
