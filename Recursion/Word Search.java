class Pair{
    int first;
    int second;
    Pair(int first,int second){
        this.first=first;
        this.second=second;
    }
}
class Solution {
    public boolean exist(char[][] board, String word) {
        int n=board.length;
        int m=board[0].length;
        char source=word.charAt(0);

        boolean[][] vis=new boolean[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(board[i][j]==source){
                    if(dfs(i,j,board,word,0,vis)){
                        return true;
                    }
                }
            }
        } 
        return false;
    }
    boolean dfs(int row,int col,char[][] board,String word,int index,boolean[][] vis){
        if(index==word.length()) return true;
        if(row<0 || row>=board.length || col<0 || col>=board[0].length || vis[row][col]==true || board[row][col]!=word.charAt(index)) return false;
        vis[row][col]=true;
        int[] dr={0,0,1,-1};
        int[] dc={1,-1,0,0};
        for(int i=0;i<4;i++){
            int nrow=row+dr[i];
            int ncol=col+dc[i];
            if(dfs(nrow,ncol,board,word,index+1,vis)) return true;
        }

        vis[row][col]=false;
        return false;
    }
}
