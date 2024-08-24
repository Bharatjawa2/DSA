class Solution
{
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor)
    {
       int ini=image[sr][sc];
       int[][] ans=image;
       solve(sr,sc,ans,image,ini,newColor);
       return ans;
    }
    
    void solve(int r,int c,int[][] ans,int[][] image,int ini,int newColor){
        int delrow[]={0,1,0,-1};
        int delcol[]={1,0,-1,0};
        int n=image.length;
        ans[r][c]=newColor;
        int m=image[0].length;
        for(int i=0;i<4;i++){
            int nrow=r+delrow[i];
            int ncol=c+delcol[i];
            if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && image[nrow][ncol]==ini && ans[nrow][ncol]!=newColor){
                solve(nrow,ncol,ans,image,ini,newColor);
            }
        }
    }
}
