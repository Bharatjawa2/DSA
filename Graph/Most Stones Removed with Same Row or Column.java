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
    public int removeStones(int[][] stones) {
        int n=stones.length;
        int maxRow=0;
        int maxCol=0;
        for(int i=0;i<n;i++){
            maxRow=Math.max(maxRow,stones[i][0]);
            maxCol=Math.max(maxCol,stones[i][1]);
        }
        DisjointSet ds=new DisjointSet(maxRow+maxCol+2);
        Set<Integer> set=new HashSet<>();
        for(int i=0;i<n;i++){
            int row=stones[i][0];
            int col=stones[i][1]+maxRow+1;
            ds.union(row,col);
            set.add(row);
            set.add(col);
        }
        int c=0;
        for(int i:set){
            if(ds.find(i)==i) c++;
        }
        return n-c;
    }
}
