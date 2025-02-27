class Solution {
    public int lenLongestFibSubseq(int[] arr) {
        int n=arr.length;
        Integer[][] dp=new Integer[n][n];
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<n;i++){
            map.put(arr[i],i);
        }
        int ans=0;
        for(int i=0;i<n-1;i++){
            for(int j=i+1;j<n;j++){
                ans=Math.max(ans,solve(i,j,arr,dp,map)+2);
            }
        }
        return ans>=3?ans:0;
    }
    int solve(int i,int j,int[] arr,Integer[][] dp,HashMap<Integer,Integer> map){
        if(j>=arr.length) return 0;
        if(dp[i][j]!=null) return dp[i][j];

        int take=0;
        int val=arr[i]+arr[j];

        if(map.containsKey(val)){
            int index=map.get(val);
            take=1+solve(j,index,arr,dp,map);
        }
        return dp[i][j]=take;
    }
}
