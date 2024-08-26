class Pair{
    int first;
    int second;
    int third;
    Pair(int first,int second,int third){
        this.first=first;
        this.second=second;
        this.third=third;
    }
}
class Solution
{
    //Function to find distance of nearest 1 in the grid for each cell.
    public int[][] nearest(int[][] grid)
    {
        int n=grid.length;
        int m=grid[0].length;
        Queue<Pair> q=new LinkedList<Pair>();
        int[][] ans=new int[n][m];
        int[][] vis=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1){
                    ans[i][j]=0;
                    q.add(new Pair(i,j,0));
                    vis[i][j]=1;
                }
                else vis[i][j]=0;
            }
        }
        
        int delrow[]={1,0,0,-1};
        int delcol[]={0,1,-1,0};
        while(!q.isEmpty()){
            int x=q.peek().first;
            int y=q.peek().second;
            int steps=q.peek().third;
            q.remove();
            ans[x][y]=steps;
            for(int i=0;i<4;i++){
                int nrow=x+delrow[i];
                int ncol=y+delcol[i];
                if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && vis[nrow][ncol]==0){
                    vis[nrow][ncol]=1;
                    q.add(new Pair(nrow,ncol,steps+1));
                }
            }
        }
        return ans;
    }
}
