class Solution {
    public int[] findPeakGrid(int[][] mat) {
        int n=mat.length;
        int m=mat[0].length;
        int low=0,high=m-1;

        while(low<=high){
            int mid=low+(high-low)/2;
            int maxRow=solve(mat,n,mid);
            int left=mid-1>=0 ? mat[maxRow][mid-1] : -1;
            int right=mid+1<m ? mat[maxRow][mid+1] : -1;
            if(mat[maxRow][mid]>left && mat[maxRow][mid]>right){
                return new int[]{maxRow,mid};
            }
            else if(mat[maxRow][mid]<left){
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return new int[]{-1,-1};
    }
    int solve(int[][] mat,int n,int mid){
        int max=Integer.MIN_VALUE;
        int ans=0;
        for(int i=0;i<n;i++){
            if(mat[i][mid]>max){
                ans=i;
                max=mat[i][mid];
            }
        }
        return ans;
    }
}
