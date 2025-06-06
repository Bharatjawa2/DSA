class Edge{
    int u;
    int v;
    int wt;
    Edge(int u,int v,int wt){
        this.u=u;
        this.v=v;
        this.wt=wt;
    }
}

class DisjointSet{
    int[] parent;
    int[] rank;
    DisjointSet(int n){
        parent=new int[n];
        rank=new int[n];
        for(int i=0;i<n;i++){
            parent[i]=i;
        }
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
    static int spanningTree(int V, int E, List<List<int[]>> adj) {
        List<Edge> list=new ArrayList<>();
        for(int i=0;i<V;i++){
            for(int[] neigh:adj.get(i)){
                int v=neigh[0];
                int w=neigh[1];
                if(i<v){
                    list.add(new Edge(i,v,w));
                }
            }
        }
        
        list.sort((a,b)->a.wt-b.wt);
        int sum=0;
        
        DisjointSet ds=new DisjointSet(V);
        
        for(Edge e:list){
            if(ds.union(e.u,e.v)){
                sum+=e.wt;
            }
        }
        return sum;
    }
}
