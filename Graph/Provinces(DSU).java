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

    boolean union(int a,int b){
        int x=find(a);
        int y=find(b);
        if(x==y) return false;
        if(rank[x]<rank[y]) parent[x]=y;
        else if(rank[x]>rank[y]) parent[y]=x;
        else{
            parent[y]=x;
            rank[x]++;
        }
        return true;
    }
}
class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n=isConnected.length;
        DisjointSet ds=new DisjointSet(n);
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i!=j && isConnected[i][j]==1){
                    ds.union(i,j);
                }
            }
        }
        int ans=0;
        for(int i=0;i<n;i++){
            if(ds.parent[i]==i) ans++;
        }
        return ans;
    }
}
