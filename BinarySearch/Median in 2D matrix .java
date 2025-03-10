class Solution {
    int median(int mat[][]) {
        int n=mat.length;
        int m=mat[0].length;
        int target=n*m/2;
        
        int low=Integer.MAX_VALUE;
        int high=Integer.MIN_VALUE;
        
        for(int i=0;i<n;i++){
            low=Math.min(low,mat[i][0]);
            high=Math.max(high,mat[i][m-1]);
        }
        int ans=high;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(solve(mat,mid,n,m)>target){
                ans=mid;
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return ans;
    }
    
    int solve(int[][] mat,int midd,int n,int m){
        int count=0;
        for(int i=0;i<n;i++){
            int low=0;
            int high=m-1;
            while(low<=high){
                int mid=low+(high-low)/2;
                if(mat[i][mid]<=midd){
                    low=mid+1;
                }else{
                    high=mid-1;
                }
            }
            count+=low;
        }
        return count;
    }
}
