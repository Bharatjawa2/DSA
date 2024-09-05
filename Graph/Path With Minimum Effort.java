class tuple{
    int distance;
    int first;
    int second;
    tuple(int distance,int first,int second){
        this.distance=distance;
        this.first=first;
        this.second=second;
    }
}
class Solution {
    public static int MinimumEffort(int rows, int columns, int[][] heights) {
        PriorityQueue<tuple> pq=new PriorityQueue<tuple>((x,y)-> x.distance-y.distance);
        int[][] dist=new int[rows][columns];
        for(int i=0;i<rows;i++){
            for(int j=0;j<columns;j++){
                dist[i][j]=(int)(1e9);
            }
        }
        dist[0][0]=0;
        pq.add(new tuple(0,0,0));
        int[] delrow={0,0,1,-1};
        int[] delcol={1,-1,0,0};
        
        while(pq.size()!=0){
            int d=pq.peek().distance;
            int r=pq.peek().first;
            int c=pq.peek().second;
            pq.remove();
            if(r==rows-1 && c==columns-1) return d;
            for(int i=0;i<4;i++){
                int nrow=r+delrow[i];
                int ncol=c+delcol[i];
                if(nrow>=0 && nrow<rows && ncol>=0 && ncol<columns){
                    int effort=Math.max(Math.abs(heights[r][c]-heights[nrow][ncol]),d);
                    if(effort<dist[nrow][ncol]){
                        dist[nrow][ncol]=effort;
                        pq.add(new tuple(effort,nrow,ncol));
                    }
                }
            }
        }
        return 0;
    }
}
