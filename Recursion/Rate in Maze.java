class Solution {
    public ArrayList<String> findPath(ArrayList<ArrayList<Integer>> mat) {
        ArrayList<String> ans=new ArrayList<>();
        int n=mat.size();
        if(n==0 || mat.get(0).get(0)==0 || mat.get(n-1).get(n-1)==0) return ans;
        boolean[][] vis=new boolean[n][n];        
        solve(0,0,vis,n,ans,mat,new StringBuilder());
        return ans;
    }
    void solve(int row,int col,boolean[][] vis,int m,ArrayList<String> ans,ArrayList<ArrayList<Integer>> mat,StringBuilder sb){
        if(row==m-1 && col==m-1){
            ans.add(sb.toString());
            return;
        }
        
        char[] dir={'D','L','R','U'};
        int[] dr={1,0,0,-1};
        int[] dc={0,-1,1,0};
        
        vis[row][col]=true;
        
        for(int i=0;i<4;i++){
            int nrow=row+dr[i];
            int ncol=col+dc[i];
            if(nrow>=0 && nrow<m && ncol>=0 && ncol<m && mat.get(nrow).get(ncol)==1 && vis[nrow][ncol]==false){
                sb.append(dir[i]);
                solve(nrow,ncol,vis,m,ans,mat,sb);
                sb.deleteCharAt(sb.length()-1);
            }
        }
        vis[row][col]=false;
    }
}
