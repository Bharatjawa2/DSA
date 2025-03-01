class Solution {
    public int pairWithMaxSum(List<Integer> arr) {
        int n=arr.size();
        int ans=Integer.MIN_VALUE;
        if(n<2) return 0;
        
        for(int i=0;i<n-1;i++){
            int x=arr.get(i)+arr.get(i+1);
            ans=Math.max(ans,x);
        }
        return ans;
    }
}
