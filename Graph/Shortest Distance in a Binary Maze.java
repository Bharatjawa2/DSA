class tuple{
    int first,second,third;
    tuple(int first,int second,int third){
        this.first=first;
        this.second=second;
        this.third=third;
    }
}
class Solution {

    int shortestPath(int[][] grid, int[] source, int[] destination) {
        if(source[0]==destination[0] && source[1]==destination[1]) return 0;
        Queue<tuple> q=new LinkedList<>();
        int n=grid.length;
        int m=grid[0].length;
        int[][] dist=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                dist[i][j]=(int)(1e9);
            }
        }
        dist[source[0]][source[1]]=0;
        q.add(new tuple(0,source[0],source[1]));
        
        int[] delrow={0,0,1,-1};
        int[] delcol={1,-1,0,0};
        while(!q.isEmpty()){
            int dis=q.peek().first;
            int row=q.peek().second;
            int col=q.peek().third;
            q.remove();
            
            for(int i=0;i<4;i++){
                int nrow=row+delrow[i];
                int ncol=col+delcol[i];
                if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && grid[nrow][ncol]==1 && dis+1<dist[nrow][ncol]){
                    dist[nrow][ncol]=dis+1;
                    if(nrow==destination[0] && ncol==destination[1]) return 1+dis;
                    q.add(new tuple(dis+1,nrow,ncol));
                }
            }
        }
        return -1;
    }
}
