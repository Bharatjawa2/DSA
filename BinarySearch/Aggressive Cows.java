class Solution {
    public static int aggressiveCows(int[] stalls, int k) {
        int n=stalls.length;
        if(k>n) return -1;
        Arrays.sort(stalls);
        int low=1;
        int high=stalls[n-1]-stalls[0];
        int ans=1;    
        
        while(low<=high){
            int mid=low+(high-low)/2;
            if(solve(stalls,mid,k)){
                ans=mid;
                low=mid+1;
            }else{
                high=mid-1;
            }
        }
        return ans;
    }
    
    public static boolean solve(int[] stalls,int mid,int k){
        int cow=1;
        int last=stalls[0];
        for(int i=1;i<stalls.length;i++){
            int diff=stalls[i]-last;
            if(diff>=mid){
                cow++;
                last=stalls[i];
            }
            if(cow==k) return true;
        }
        return false;
    }
}
