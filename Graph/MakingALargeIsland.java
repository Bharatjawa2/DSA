class DisjointSet{
    int[] parent;
    int[] size;
    DisjointSet(int n){
        parent=new int[n];
        size=new int[n];
        for(int i=0;i<n;i++) parent[i]=i;
        for(int i=0;i<n;i++) size[i]=1;
    }
    int find(int x){
        if(parent[x]!=x){
            parent[x]=find(parent[x]);
        }
        return parent[x];
    }
    void union(int a,int b){
        int x=find(a);
        int y=find(b);
        if(x==y) return;
        if(size[x]<size[y]){
            parent[x]=y;
            size[y]+=size[x];
        }else{
            parent[y]=x;
            size[x]+=size[y];
        }
    }
}
class Solution {
    public int largestIsland(int[][] grid) {
        int n=grid.length;
        DisjointSet ds=new DisjointSet(n*n);
        int[] dr={0,0,1,-1};
        int[] dc={1,-1,0,0};
        for(int row=0;row<n;row++){
            for(int col=0;col<n;col++){
                if(grid[row][col]==0) continue;
                int node=row*n+col;
                for(int i=0;i<4;i++){
                    int nrow=row+dr[i];
                    int ncol=col+dc[i];
                    if(nrow>=0 && nrow<n && ncol>=0 && ncol<n && grid[nrow][ncol]==1){
                        int anode=nrow*n+ncol;
                        ds.union(node,anode);
                    }
                }
            }
        }

        int max=0;
        for(int row=0;row<n;row++){
            for(int col=0;col<n;col++){
                if(grid[row][col]==1) continue;
                HashSet<Integer> set=new HashSet<>();
                int node=row*n+col;
                for(int i=0;i<4;i++){
                    int nrow=row+dr[i];
                    int ncol=col+dc[i];
                    if(nrow>=0 && nrow<n && ncol>=0 && ncol<n && grid[nrow][ncol]==1){
                        set.add(ds.find(nrow*n+ncol));
                    }
                }
                int cnt=0;
                for(int k:set){
                    cnt+=ds.size[k];
                }
                max=Math.max(max,cnt+1);
            }
        }
        for(int i=0;i<n*n;i++){
            max=Math.max(max,ds.size[i]);
        }
        return max;
    }
}
