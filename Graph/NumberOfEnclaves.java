class Solution {

    int numberOfEnclaves(int[][] grid) {

        // Your code here
        int c=0;
        int n=grid.length;
        int m=grid[0].length;
        
        for(int i=0;i<m;i++){
            if(grid[0][i]==1) solve(0,i,grid);
            if(grid[n-1][i]==1) solve(n-1,i,grid);
        }
        for(int i=0;i<n;i++){
            if(grid[i][0]==1) solve(i,0,grid);
            if(grid[i][m-1]==1) solve(i,m-1,grid);
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1) c++;
            }
        }
        return c;
        
    }
    
    static void solve(int row,int col,int[][] grid){
        int delrow[]={0,0,1,-1};
        int delcol[]={1,-1,0,0};
        int n=grid.length;
        int m=grid[0].length;
        grid[row][col]=0;
        for(int i=0;i<4;i++){
            int nrow=row+delrow[i];
            int ncol=col+delcol[i];
            if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && grid[nrow][ncol]==1){
                solve(nrow,ncol,grid);
            }
        }
    }
}
