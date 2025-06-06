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
    public int makeConnected(int n, int[][] connections) {
        int wire=connections.length;
        if(wire<n-1) return -1;
        int computer=n;
        DisjointSet ds=new DisjointSet(n);
        for(int i=0;i<wire;i++){
            if(ds.union(connections[i][0],connections[i][1])){
                computer--;
            }
        }        
        return computer-1;
    }
}
