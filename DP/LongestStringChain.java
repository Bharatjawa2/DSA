class Solution {
    public int longestStrChain(String[] words) {
        int n=words.length;
        Arrays.sort(words,(a,b)->a.length()-b.length());
        int[] dp=new int[n];
        Arrays.fill(dp,1);
        int max=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<i;j++){
                if(valid(words[i],words[j]) && dp[j]+1>dp[i]){
                    dp[i]=1+dp[j];
                }
            }
        }
        for(int i:dp) max=Math.max(max,i);
        return max;
    }
    boolean valid(String a,String b){
        int n=a.length();
        int m=b.length();
        if(n!=m+1) return false;

        int i=0,j=0;
        boolean flag=false;
        while(i<n && j<m){
            if(a.charAt(i)==b.charAt(j)){
                i++;
                j++;
            }else{
                if(flag) return false;
                flag=true;
                i++;
            }
        }
        return true;
    }
}
