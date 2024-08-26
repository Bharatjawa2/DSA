class Solution{
    static char[][] fill(int n, int m, char a[][])
    {
       char[][] ans=new char[n][m];
       for(int i=0;i<n;i++){
           for(int j=0;j<m;j++){
               ans[i][j]='X';
           }
       }
       for(int i=0;i<m;i++){
           if(a[0][i]=='O') solve(0,i,a,ans);
           if(a[n-1][i]=='O') solve(n-1,i,a,ans);
       }
       for(int i=0;i<n;i++){
           if(a[i][0]=='O') solve(i,0,a,ans);
           if(a[i][m-1]=='O') solve(i,m-1,a,ans);
       }
       return ans;
    }
    
    static void solve(int row,int col,char[][] ini,char[][] ans){
        int n=ini.length;
        int m=ini[0].length;
        ans[row][col]='O';
        int delrow[]={1,0,0,-1};
        int delcol[]={0,1,-1,0};
        for(int i=0;i<4;i++){
            int nrow=row+delrow[i];
            int ncol=col+delcol[i];
            if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && ini[nrow][ncol]=='O' && ans[nrow][ncol] != 'O'){
                solve(nrow,ncol,ini,ans);
            }
        }
    }
}
