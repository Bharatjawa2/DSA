class DisjointSet{
    int[] parent;
    int[] rank;
    DisjointSet(int n){
        parent=new int[n];
        rank=new int[n];
        for(int i=0;i<n;i++) parent[i]=i;
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
        if(rank[x]<rank[y]) parent[x]=y;
        else if(rank[x]>rank[y]) parent[y]=x;
        else{
            parent[y]=x;
            rank[x]++;
        }
    }
}
class Solution {
    public List<Integer> numOfIslands(int rows, int cols, int[][] operators) {
        int n=operators.length;
        DisjointSet ds=new DisjointSet(rows*cols);
        List<Integer> ans=new ArrayList<>();
        int[][] vis=new int[rows][cols];
        int count=0;
        int[] dr={0,0,1,-1};
        int[] dc={1,-1,0,0};
        for(int i=0;i<n;i++){
            int row=operators[i][0];
            int col=operators[i][1];
            if(vis[row][col]==1){
                ans.add(count);
                continue;
            }
            count++;
            vis[row][col]=1;
            for(int j=0;j<4;j++){
                int nrow=row+dr[i];
                int ncol=col+dc[i];
                if(nrow>=0 && nrow<rows && ncol>=0 && ncol<cols && vis[nrow][ncol]==1){
                    int nodeNo=row*cols+col;
                    int AdjNodeNo=nrow*cols+ncol;
                    if(ds.find(nodeNo)!=ds.find(AdjNodeNo)){
                        count--;
                        ds.union(nodeNo,AdjNodeNo);
                    }
                }
            }
            ans.add(count);
        }
        return ans;
    }
}
