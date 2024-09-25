class Solution {
      int findCity(int n, int m, int[][] edges,int distanceThreshold)
      {
        int[][] dist=new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                dist[i][j]=Integer.MAX_VALUE;
                if(i==j) dist[i][j]=0;
            }
        }
        
        for(int i=0;i<m;i++){
            int u=edges[i][0];
            int v=edges[i][1];
            int wt=edges[i][2];
            dist[u][v]=wt;
            dist[v][u]=wt;
        }
        
        for(int k=0;k<n;k++){
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    if(dist[i][k] == Integer.MAX_VALUE || dist[k][j]==Integer.MAX_VALUE) continue;
                    dist[i][j]=Math.min(dist[i][j],dist[i][k]+dist[k][j]);
                }
            }
        }
        
        int c=n;
        int l=-1;
        for(int i=0;i<n;i++){
            int ans=0;
            for(int j=0;j<n;j++){
                if(dist[i][j]<=distanceThreshold){
                    ans++;
                }
            }
                if(ans<=c){
                    c=ans;
                    l=i;
            }
        }
        return l;
      }
}
