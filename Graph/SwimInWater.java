class Pair{
    int first;
    int second;
    int time;
    Pair(int first,int second,int time){
        this.first=first;
        this.second=second;
        this.time=time;
    }
}
class Solution {
    public int swimInWater(int[][] grid) {
        int n=grid.length;
        boolean[][] vis=new boolean[n][n];
        PriorityQueue<Pair> pq=new PriorityQueue<>((a,b)->a.time-b.time);
        pq.add(new Pair(0,0,grid[0][0]));
        vis[0][0]=true;

        int[] dr={0,0,-1,1};
        int[] dc={1,-1,0,0};

        while(!pq.isEmpty()){
            int row=pq.peek().first;
            int col=pq.peek().second;
            int time=pq.peek().time;
            pq.remove();
            if(row==n-1 && col==n-1)return time;
            for(int i=0;i<4;i++){
                int nrow=row+dr[i];
                int ncol=col+dc[i];
                if(nrow>=0 && nrow<n && ncol>=0 && ncol<n && !vis[nrow][ncol]){
                    vis[nrow][ncol]=true;
                    int t=Math.max(time,grid[nrow][ncol]);
                    pq.add(new Pair(nrow,ncol,t));
                }
            }
        }
        return -1;
    }
}
