class Pair{
    int first;
    int second;
    public Pair(int first,int second){
        this.first=first;
        this.second=second;
    }
}
class Solution {
    // Function to find the number of islands.
    public int numIslands(char[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int[][] vis=new int[n][m];
        int c=0;
        for(int row=0;row<n;row++){
            for(int col=0;col<m;col++){
                if(vis[row][col]==0 && grid[row][col]=='1'){
                    c++;
                    bfs(row,col,vis,grid);
                }
            }
        }
        return c;
    }
    
    void bfs(int row,int col,int[][] vis,char[][]grid){
        int n=grid.length;
        int m=grid[0].length;
        Queue<Pair> q=new LinkedList<Pair>();
        q.add(new Pair(row,col));
        vis[row][col]=1;
        
        while(!q.isEmpty()){
            int x=q.peek().first;
            int y=q.peek().second;
            q.remove();
            
            for(int delrow=-1;delrow<=1;delrow++){
                for(int delcol=-1;delcol<=1;delcol++){
                    int nrow=delrow+x;
                    int ncol=delcol+y;
                    if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && grid[nrow][ncol]=='1' && vis[nrow][ncol]==0){
                        vis[nrow][ncol]=1;
                        q.add(new Pair(nrow,ncol));
                    }
                }
            }
        }
    }
}
