class Solution
{
    //Function to find whether a path exists from the source to destination.
    public boolean is_Possible(int[][] grid)
    {
        // Code here
        int n=grid.length;
        int strow=0,stcol=0;
        int m=grid[0].length;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1){
                    strow=i;
                    stcol=j;
                    break;
                }
            }
        }
        
        return solve(strow,stcol,grid);
    }
    
    boolean solve(int strow,int stcol,int[][] grid){
        
        int n=grid.length;
        int m=grid[0].length;
        if(grid[strow][stcol]==2) return true;
        grid[strow][stcol]=-1;
        int[] delrow={0,0,1,-1};
        int[] delcol={1,-1,0,0};
        for(int i=0;i<4;i++){
            int row=strow+delrow[i];
            int col=stcol+delcol[i];
            if(row>=0 && row<n && col>=0 && col<m && grid[row][col]!=0 && grid[row][col]!=-1){
                if(solve(row,col,grid)) return true;
            }
        }

        return false;
    }
}
