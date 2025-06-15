class Solution {
    public ArrayList<Integer> getLIS(int arr[]) {
        ArrayList<Integer> ans=new ArrayList<>();
        int n=arr.length;
        int[] dp=new int[n];
        int[] parent=new int[n];
        Arrays.fill(dp,1);
        Arrays.fill(parent,-1);
        int max=0,last=0;
        
        for(int i=0;i<n;i++){
            for(int j=0;j<i;j++){
                if(arr[i]>arr[j] && dp[i]<dp[j]+1){
                    dp[i]=dp[j]+1;
                    parent[i]=j;
                }
            }
            if(dp[i]>max){
                max=dp[i];
                last=i;
            }
        }
        
        while(last!=-1){
            ans.add(arr[last]);
            last=parent[last];
        }
        Collections.reverse(ans);
        return ans;
    }
}
