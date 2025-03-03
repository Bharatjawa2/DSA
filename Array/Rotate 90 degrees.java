 class Solution {
    public void rotate(int[][] matrix) {
        int n=matrix.length;
        int m=matrix[0].length;
        transpose(matrix,n,m);
        reverseRow(matrix,n,m);
    }
    void transpose(int[][] matrix,int n,int m){
        for(int i=0;i<n;i++){
            for(int j=i;j<m;j++){
                int temp=matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i]=temp;
            }
        }
    }
    void reverseRow(int[][] matrix,int n,int m){
        for(int i=0;i<n;i++){
            int l=0;
            int r=m-1;
            while(l<r){
                int temp=matrix[i][l];
                matrix[i][l]=matrix[i][r];
                matrix[i][r]=temp;
                l++;
                r--;
            }
        }
    } 
}
